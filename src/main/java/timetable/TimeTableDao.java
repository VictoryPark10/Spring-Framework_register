package timetable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import timetable.TimeTable;

public class TimeTableDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<TimeTable> timeTable(String std_id) {
		List<TimeTable> results = jdbcTemplate.query(
				"select km_day, left(km_time,1) as starttime, right(km_time,1) as endtime, km_nm, km_prof_nm, km_isu from bombombom.subject where KM_CODE IN (select REG_KM_CODE from bombombom.reg where REG_STU_ID = ?)",
				new RowMapper<TimeTable>() {
					@Override
					public TimeTable mapRow(ResultSet rs, int rowNum) throws SQLException {
						TimeTable cls = new TimeTable(rs.getString("km_day"),
								Integer.parseInt(rs.getString("starttime")), Integer.parseInt(rs.getString("endtime")),
								rs.getString("km_nm"), rs.getString("km_prof_nm"), rs.getString("km_isu"));
						return cls;
					}
				}, std_id);
		return results.isEmpty() ? null : results;
	}

	public List<TimeTable> baskettimeTable(String std_id) {
		List<TimeTable> results = jdbcTemplate.query(
				"select km_day, left(km_time,1) as starttime, right(km_time,1) as endtime, km_nm, km_prof_nm, km_isu from bombombom.subject where KM_CODE IN (select SUBBASKET_KM_CODE from bombombom.subbasket where SUBBASKET_STU_ID = ?)",
				new RowMapper<TimeTable>() {
					@Override
					public TimeTable mapRow(ResultSet rs, int rowNum) throws SQLException {
						TimeTable cls = new TimeTable(rs.getString("km_day"),
								Integer.parseInt(rs.getString("starttime")), Integer.parseInt(rs.getString("endtime")),
								rs.getString("km_nm"), rs.getString("km_prof_nm"), rs.getString("km_isu"));
						return cls;
					}
				}, std_id);
		return results.isEmpty() ? null : results;
	}
}
