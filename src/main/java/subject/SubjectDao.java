package subject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class SubjectDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Subject> subjectList() {
		List<Subject> results = jdbcTemplate.query("select * from bombombom.subject", new RowMapper<Subject>() {
			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
				Subject cls = new Subject(rs.getString("KM_CODE"), rs.getString("KM_NM"), rs.getInt("KM_HJ"),
						rs.getString("KM_BAN"), rs.getString("KM_DAY"), rs.getInt("KM_TIME"),
						rs.getString("KM_PROF_NM"), countReg(rs.getString("KM_CODE")), rs.getInt("KM_LIMIT"),
						rs.getString("KM_ISU"), rs.getInt("KM_GRADE"));
				return cls;
			}
		});
		return results.isEmpty() ? null : results;
	}

	public List<Subject> regList(String std_id) {
		List<Subject> results = jdbcTemplate.query(
				"select * from bombombom.subject where KM_CODE IN (select REG_KM_CODE from bombombom.reg where REG_STU_ID = ?)",
				new RowMapper<Subject>() {
					@Override
					public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
						Subject cls = new Subject(rs.getString("KM_CODE"), rs.getString("KM_NM"), rs.getInt("KM_HJ"),
								rs.getString("KM_BAN"), rs.getString("KM_DAY"), rs.getInt("KM_TIME"),
								rs.getString("KM_PROF_NM"), countReg(rs.getString("KM_CODE")), rs.getInt("KM_LIMIT"),
								rs.getString("KM_ISU"), rs.getInt("KM_GRADE"));
						return cls;
					}
				}, std_id);
		return results.isEmpty() ? null : results;
	}

	public void insertReg(String std_id, String class_id) {
		jdbcTemplate.update(
				"insert into bombombom.reg(REG_STU_ID, REG_KM_CODE) select ?, ? from dual where not exists(select * from bombombom.reg where REG_STU_ID=? and REG_KM_CODE=?)",
				std_id, class_id, std_id, class_id);

	}

	public void deleteReg(String std_id, String class_id) {
		jdbcTemplate.update("delete from bombombom.reg where REG_STU_ID = ? and REG_KM_CODE = ?", std_id, class_id);
	}

	public int countReg(String class_id) {
		return jdbcTemplate.queryForObject("select count(*) from bombombom.reg where REG_KM_CODE = ?", Integer.class,
				class_id);
	}
}
