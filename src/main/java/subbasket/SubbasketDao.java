package subbasket;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import subbasket.Subbasket;

public class SubbasketDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Subbasket> subjectList() {
		List<Subbasket> results = jdbcTemplate.query("select * from bombombom.subject", new RowMapper<Subbasket>() {
			@Override
			public Subbasket mapRow(ResultSet rs, int rowNum) throws SQLException {
				Subbasket cls = new Subbasket(rs.getString("KM_CODE"), rs.getString("KM_NM"), rs.getInt("KM_HJ"),
						rs.getString("KM_BAN"), rs.getString("KM_DAY"), rs.getInt("KM_TIME"),
						rs.getString("KM_PROF_NM"), countRegBasket(rs.getString("KM_CODE")), rs.getInt("KM_LIMIT"),
						rs.getString("KM_ISU"), rs.getInt("KM_GRADE"));
				return cls;
			}
		});
		return results.isEmpty() ? null : results;
	}

	public List<Subbasket> basketList(String std_id) {
		List<Subbasket> results = jdbcTemplate.query(
				"select * from bombombom.subject where KM_CODE IN (select SUBBASKET_KM_CODE from bombombom.subbasket where SUBBASKET_STU_ID = ?)",
				new RowMapper<Subbasket>() {
					@Override
					public Subbasket mapRow(ResultSet rs, int rowNum) throws SQLException {
						Subbasket cls = new Subbasket(rs.getString("KM_CODE"), rs.getString("KM_NM"),
								rs.getInt("KM_HJ"), rs.getString("KM_BAN"), rs.getString("KM_DAY"),
								rs.getInt("KM_TIME"), rs.getString("KM_PROF_NM"),
								countRegBasket(rs.getString("KM_CODE")), rs.getInt("KM_LIMIT"), rs.getString("KM_ISU"),
								rs.getInt("KM_GRADE"));
						return cls;
					}
				}, std_id);
		return results.isEmpty() ? null : results;
	}

	public void insertBasket(String std_id, String class_id) {
		jdbcTemplate.update(
				"insert into bombombom.subbasket(SUBBASKET_STU_ID, SUBBASKET_KM_CODE) select ?, ? from dual where not exists(select * from bombombom.subbasket where SUBBASKET_STU_ID=? and SUBBASKET_KM_CODE=?)",
				std_id, class_id, std_id, class_id);

	}

	public void deleteBasket(String std_id, String class_id) {
		jdbcTemplate.update("delete from bombombom.subbasket where SUBBASKET_STU_ID = ? and SUBBASKET_KM_CODE = ?",
				std_id, class_id);
	}

	public int countRegBasket(String class_id) {
		return jdbcTemplate.queryForObject("select count(*) from bombombom.subbasket where SUBBASKET_KM_CODE = ?",
				Integer.class, class_id);
	}

}
