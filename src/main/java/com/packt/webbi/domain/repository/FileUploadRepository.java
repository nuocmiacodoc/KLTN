package com.packt.webbi.domain.repository;


public interface FileUploadRepository {

	public void createMySQLTable (String userName ,String tableName, String[] csvHeader);
	
	public void dropTable(String userName, String tableName);
	
	public void loadCsvFileToDB(String userName, String tableName, String filePath, String[] csvHeader);
}
