package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import timeoverlap.TimeOverlap;
import timeoverlap.TimeOverlapDao;

public class TimeOverlapService {
	@Autowired
	private TimeOverlapDao timeoverlapDao;

	public boolean timeoverlapService(String stu_id, String km_code) {
		List<TimeOverlap> timeList = timeoverlapDao.timeList(km_code, stu_id);
		int starttime = Integer.parseInt(timeoverlapDao.starttime(km_code));
		int endtime = Integer.parseInt(timeoverlapDao.endtime(km_code));
		if (timeList == null)
			return true;
		for (int i = 0; i < timeList.size(); i++) {
			for (int a = timeList.get(i).getStartTime(); a <= timeList.get(i).getEndTime(); a++) {
				for (int b = starttime; b <= endtime; b++) {
					if (a == b) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
