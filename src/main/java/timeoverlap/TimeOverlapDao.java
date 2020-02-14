package timeoverlap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import timeoverlap.TimeOverlap;

public class TimeOverlapDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<TimeOverlap> timeList(String km_code, String stu_id) {
		List<TimeOverlap> results = jdbcTemplate.query(
				"select left(km_time,1) as starttime, right(km_time,1) as endtime from bombombom.subject where km_code in "
						+ "(select reg_km_code from bombombom.reg where reg_km_code in (select km_code from bombombom.subject where km_day in "
						+ "(select km_day from bombombom.subject where km_code = ?)) and reg_stu_id = ?)",
				new RowMapper<TimeOverlap>() {
					@Override
					public TimeOverlap mapRow(ResultSet rs, int rowNum) throws SQLException {
						TimeOverlap cls = new TimeOverlap(rs.getString("starttime"), rs.getString("endtime"));
						return cls;
					}
				}, km_code, stu_id);
		return results.isEmpty() ? null : results;
	}

	public String starttime(String km_code) {
		return jdbcTemplate.queryForObject("select left(km_time,1) from bombombom.subject where km_code = ?",
				String.class, km_code);
	}

	public String endtime(String km_code) {
		return jdbcTemplate.queryForObject("select right(km_time,1) from bombombom.subject where km_code = ?",
				String.class, km_code);
	}

}
