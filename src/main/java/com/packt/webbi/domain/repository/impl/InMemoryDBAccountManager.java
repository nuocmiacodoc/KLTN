package com.packt.webbi.domain.repository.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.packt.webbi.domain.repository.DataBaseAccountManager;

@Repository
public class InMemoryDBAccountManager implements DataBaseAccountManager {

	@Autowired
	private JdbcTemplate jdbcTempleate;
	
	@Override
	public void deleteTable(String userName, String tableName) {
		StringBuilder sbMySQL = new StringBuilder("DROP TABLE IF EXISTS ");
		sbMySQL.append(userName).append("_").append(tableName);
		jdbcTempleate.execute(sbMySQL.toString());
	}

	@Override
	public List<Map<String,Object>> queryByString(String userName, String tableName, String queryString) {
		return jdbcTempleate.queryForList(queryString);
	}

	@Override
	public List<String> countTableColumn(String userName, String tableName) {
		StringBuilder sbMySQL = new StringBuilder("SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE table_name = '");
		sbMySQL.append(userName).append("_").append(tableName).append("'");
		return(jdbcTempleate.queryForList(sbMySQL.toString(), String.class));
	}

	@Override
	public List<String> countUserTable(String userName) {
		StringBuilder sbMySQL = new StringBuilder("SELECT table_name FROM information_schema.tables where table_schema='webbi_database' and table_name like '%");
		sbMySQL.append(userName).append("%'");
		return(jdbcTempleate.queryForList(sbMySQL.toString(), String.class));
	}

}
