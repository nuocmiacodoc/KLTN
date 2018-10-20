package com.packt.webbi.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webbi.domain.repository.DataBaseAccountManager;
import com.packt.webbi.service.DataBaseAccountManagerService;

@Service
public class DBAccountManagerServiceImpl implements DataBaseAccountManagerService{
	@Autowired
	DataBaseAccountManager dataBaseAccountManager;

	@Override
	public void deleteTable(String userName, String tableName) {
		dataBaseAccountManager.deleteTable(userName, tableName);
	}

	@Override
	public List<Map<String, Object>> queryByString(String userName, String tableName, String queryString) {
		return dataBaseAccountManager.queryByString(userName, tableName, queryString);
	}

	@Override
	public List<String> countTableColumn(String userName, String tableName) {
		return dataBaseAccountManager.countTableColumn(userName, tableName);
		
	}

	@Override
	public List<String> countUserTable(String userName) {
		return dataBaseAccountManager.countUserTable(userName);
		
	}

}
