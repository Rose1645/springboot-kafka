package com.rose.kafka.util;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuzhikai
 *
 */
public class HomepageConfig {

	JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringUtil.getBean("jdbcTemplate");
	private static Map<String, String> config = null;
	
	//基于内部类的单例模式 优点:  Lazy  线程安全
	private static class HomepageConfigHolder{
		//单例变量
		private static HomepageConfig instance = new HomepageConfig();
	}
	
	//初始化配置
	private HomepageConfig() {
		String sql = "select code,value from s_parameter where code='XNZM_FBS_SJKBS'";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, new Object[]{}, new int[]{});
		config = new HashMap<String, String>();
		for (Map<String, Object> m : list) {
			config.put((String)m.get("CODE"), (String)m.get("VALUE"));
		}
	}

	public static HomepageConfig getInstance() {
		return HomepageConfigHolder.instance;
	}
	
	public String getValue(String key) {
		return config.get(key);
	}
	
	public static void setValue(String key, String value) {
		config.put(key, value);
	}

}

