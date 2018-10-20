package com.packt.webbi.domain.repository;

import java.util.List;
import java.util.Map;

public interface DataBaseAccountManager {

	public void deleteTable(String userName, String tableName);
	
	public List<Map<String,Object>> queryByString(String userName, String tableName, String queryString);
	
	public List<String> countTableColumn (String username, String tableName);
	
	public List<String> countUserTable (String username);
}
