package setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class SettingDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void changeSetting(String setting) {
		jdbcTemplate.update("update bombombom.setting set SET_MODE = ? where SET_ID = '������û�ý���'", setting);

	}

	public String loadSetting() {
		return jdbcTemplate.queryForObject("select SET_MODE from bombombom.setting where SET_ID = '������û�ý���'",
				String.class);
	}
}
