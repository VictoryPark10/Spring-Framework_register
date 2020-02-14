package com.project.sfc;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.LoginCommand;
import member.MemberDao;
import member.StudentInfo;
import service.AuthInfo;
import service.AuthService;
import service.IdPasswordNotMatchingException;
import service.TimeOverlapService;
import setting.SettingDao;
import subbasket.SubbasketDao;
import subject.SubjectDao;
import timetable.TimeTableDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	public AuthService authService;
	@Autowired
	public MemberDao memberDao;
	@Autowired
	public SubjectDao subjectDao;
	@Autowired
	public SubbasketDao subbasketDao;
	@Autowired
	public SettingDao settingDao;
	@Autowired
	public TimeTableDao timetableDao;
	@Autowired
	public TimeOverlapService timeoverlapService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(LoginCommand loginCommand, HttpSession session) {
		return "redirect:login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet(LoginCommand loginCommand, HttpSession session) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(LoginCommand loginCommand, HttpSession session, HttpServletRequest request) {
		String setting = settingDao.loadSetting();
		try {
			AuthInfo authInfo = authService.authenticate(loginCommand.getId(), loginCommand.getPassword());
			session.setAttribute("memberId", loginCommand.getId());
			if (loginCommand.getId().equals("admin"))
				return "redirect:admin";
			else if (setting.equals("장바구니")) {
				return "redirect:subbasket";
			} else
				return "redirect:subreg";
		} catch (IdPasswordNotMatchingException e) {
			return "login";
		}
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminGet(Model model) {
		model.addAttribute("setting", settingDao.loadSetting());
		return "admin";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public String adminPost(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		settingDao.changeSetting(request.getParameter("setting"));
		return "redirect:admin";
	}

	@RequestMapping(value = "/subbasket", method = RequestMethod.GET)
	public String subbasketGet(HttpSession session, Model model) {
		List<subbasket.Subbasket> subjectList = subbasketDao.subjectList();
		List<subbasket.Subbasket> basketList = subbasketDao.basketList((String) session.getAttribute("memberId"));
		List<timetable.TimeTable> baskettimeTable = timetableDao
				.baskettimeTable((String) session.getAttribute("memberId"));
		StudentInfo stdInfo = memberDao.stdInfo((String) session.getAttribute("memberId"));
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("basketList", basketList);
		model.addAttribute("stdInfo", stdInfo);
		model.addAttribute("baskettimeTable", baskettimeTable);
		return "subbasket";
	}

	@RequestMapping(value = "/subbasket", method = RequestMethod.POST)
	public String subbasketPost(HttpSession session, HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String insertbasket = request.getParameter("insertbasket");
		String deletebasket = request.getParameter("deletebasket");
		String logout = request.getParameter("logout");
		if (logout != null)
			return "redirect:login";
		if (insertbasket != null)
			subbasketDao.insertBasket((String) session.getAttribute("memberId"), insertbasket);
		if (deletebasket != null)
			subbasketDao.deleteBasket((String) session.getAttribute("memberId"), deletebasket);
		insertbasket = null;
		deletebasket = null;
		logout = null;
		return "redirect:subbasket";
	}

	@RequestMapping(value = "/subreg", method = RequestMethod.GET)
	public String subregGet(HttpSession session, Model model, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		List<subject.Subject> subjectList = subjectDao.subjectList();
		List<subject.Subject> regList = subjectDao.regList((String) session.getAttribute("memberId"));
		List<subbasket.Subbasket> subbasketList = subbasketDao.basketList((String) session.getAttribute("memberId"));
		List<timetable.TimeTable> timeTable = timetableDao.timeTable((String) session.getAttribute("memberId"));
		StudentInfo stdInfo = memberDao.stdInfo((String) session.getAttribute("memberId"));
		model.addAttribute("subjectList", subjectList);
		model.addAttribute("regList", regList);
		model.addAttribute("stdInfo", stdInfo);
		model.addAttribute("subbasketList", subbasketList);
		model.addAttribute("timeTable", timeTable);
		return "subreg";
	}

	@RequestMapping(value = "/subreg", method = RequestMethod.POST)
	public String subregPost(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String insertclassId = request.getParameter("regname");
		String deleteclassId = request.getParameter("deleteclass");
		String logout = request.getParameter("logout");
		PrintWriter writer = response.getWriter();
		if (logout != null)
			return "redirect:login";
		if (insertclassId != null && (timeoverlapService.timeoverlapService((String) session.getAttribute("memberId"),
				insertclassId) == true)) {
			subjectDao.insertReg((String) session.getAttribute("memberId"), insertclassId);
		}
		if (deleteclassId != null)
			subjectDao.deleteReg((String) session.getAttribute("memberId"), deleteclassId);
		insertclassId = null;
		deleteclassId = null;
		logout = null;
		return "redirect:subreg";
	}
}
