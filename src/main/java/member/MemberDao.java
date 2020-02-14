package member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
		
	private String id;
	private String password;
	private String name;
	
	/*public MemberDao(JdbcTemplate dataSource) {
		this.jdbcTemplate = dataSource;
	}*/
	
	public MemberDao() {
		
	}
	
	public Member selectById(String id) {
		List<Member> results = jdbcTemplate.query(
				"select * from bombombom.student where STU_ID = ?",
				new RowMapper<Member>() {
					@Override
					public Member mapRow(ResultSet rs, int rowNum)
						throws SQLException{
						Member member = new Member(rs.getString("STU_ID"),
								rs.getString("STU_PASSWORD"),
								rs.getString("STU_NM"));
						member.setId(rs.getString("STU_ID"));
						return member;
					}
				},id);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public StudentInfo stdInfo(String id) {
		List<StudentInfo> results = jdbcTemplate.query(
				"select STU_DP_NM, STU_GRADE, STU_BAN, STU_NM from bombombom.student where STU_ID = ?",
				new RowMapper<StudentInfo>() {
					@Override
					public StudentInfo mapRow(ResultSet rs, int rowNum)
						throws SQLException{
						StudentInfo member = new StudentInfo(rs.getString("STU_DP_NM"),
								rs.getInt("STU_GRADE"),
								rs.getString("STU_BAN"),
								rs.getString("STU_NM"));
						return member;
					}
				},id);
		return results.isEmpty() ? null : results.get(0);
	}
	
	/*public List<Class> classList() {
		List<Class> results = jdbcTemplate.query(
				"select * from logintest.CLASS",
				new RowMapper<Class>() {
					@Override
					public Class mapRow(ResultSet rs, int rowNum)
						throws SQLException{
						Class cls = new Class(rs.getString("id"),
								rs.getString("name"),
								rs.getInt("hak"),
								rs.getString("class"),
								rs.getString("time"),
								rs.getString("professor"),
								countReg(rs.getString("id")),
								rs.getInt("full_std"),
								rs.getString("isu"),
								rs.getInt("grade"));
						return cls;
					}
				});
		return results.isEmpty() ? null : results;
	}
	
	public List<Class> regList(String std_id) {
		List<Class> results = jdbcTemplate.query(
				"select * from logintest.CLASS where id IN (select class_id from logintest.reg where std_id = ?)",
				new RowMapper<Class>() {
					@Override
					public Class mapRow(ResultSet rs, int rowNum)
						throws SQLException{
						Class cls = new Class(rs.getString("id"),
								rs.getString("name"),
								rs.getInt("hak"),
								rs.getString("class"),
								rs.getString("time"),
								rs.getString("professor"),
								countReg(rs.getString("id")),
								rs.getInt("full_std"),
								rs.getString("isu"),
								rs.getInt("grade"));
						return cls;
					}
				}, std_id);
		return results.isEmpty() ? null : results;
	}
	
	public void insertReg(String std_id, String class_id) {
		jdbcTemplate.update("insert into logintest.reg(std_id, class_id) select ?, ? from dual where not exists(select * from logintest.reg where std_id=? and class_id=?)",std_id, class_id, std_id, class_id);
		
	}
	
	public void deleteReg(String std_id, String class_id) {
		jdbcTemplate.update("delete from logintest.reg where std_id = ? and class_id = ?", std_id, class_id);
	}
	
	public int countReg(String class_id) {
		return jdbcTemplate.queryForObject("select count(*) from logintest.reg where class_id = ?", Integer.class, class_id);
	}*/
	
	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public Member selectById(String id) {
		Member member = new Member(id, password, name);
		return member;
	}*/
}
