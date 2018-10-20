package com.packt.webbi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.packt.webbi.service.DataBaseAccountManagerService;

@RestController
@RequestMapping(value = "account/database/manager")
public class DBAccountManagerRestController {
	@Autowired
	private DataBaseAccountManagerService dataBaseAccountManagerService;

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public List<Map<String, Object>> readProductByCategory(@PathVariable(value = "username") String userName,
			@RequestParam(value = "tablename", required = true) String tableName,
			@RequestParam(value = "querystring", required = true) String queryString) {
		return dataBaseAccountManagerService.queryByString(userName, tableName, queryString);
	}

	@RequestMapping(value = "/delete/{username}", method = RequestMethod.GET)
	public void deleteTable(@PathVariable(value = "username") String userName,
			@RequestParam(value = "tablename", required = true) String tableName) {
		dataBaseAccountManagerService.deleteTable(userName, tableName);
	}

	@RequestMapping(value = "/showTableColumn/{username}", method = RequestMethod.GET)
	public List<String> showTableColumn(@PathVariable(value = "username") String userName,
			@RequestParam(value = "tablename", required = true) String tableName) {
		return dataBaseAccountManagerService.countTableColumn(userName, tableName);
	}

	@RequestMapping(value = "/showUserTable/{username}", method = RequestMethod.GET)
	public List<String> showUserTable(@PathVariable(value = "username") String userName) {
		return dataBaseAccountManagerService.countUserTable(userName);
	}
}
