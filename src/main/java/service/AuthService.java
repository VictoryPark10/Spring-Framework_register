package service;

import org.springframework.beans.factory.annotation.Autowired;

import member.Member;
import member.MemberDao;

public class AuthService {
	@Autowired
	private MemberDao memberDao;

	public AuthService() {

	}

	public AuthInfo authenticate(String id, String password) {
		Member member = memberDao.selectById(id);
		if (member == null) {
			throw new IdPasswordNotMatchingException();
		}
		if (!member.matchPassword(password)) {
			throw new IdPasswordNotMatchingException();
		}
		return new AuthInfo(member.getId(), member.getName());
	}
}
