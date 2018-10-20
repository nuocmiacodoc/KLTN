package com.packt.webbi.service;

import java.util.List;
import java.util.Map;

public interface DataBaseAccountManagerService {
	public void deleteTable(String userName, String tableName);
	
	public List<Map<String,Object>> queryByString(String userName, String tableName, String queryString);
	
	public List<String> countTableColumn (String userName, String tableName);
	
	public List<String> countUserTable (String userName);
}
