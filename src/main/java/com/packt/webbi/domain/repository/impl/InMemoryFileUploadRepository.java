package com.packt.webbi.domain.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.packt.webbi.domain.repository.FileUploadRepository;

@Repository
public class InMemoryFileUploadRepository implements FileUploadRepository {
	
/*	@Autowired
	private NamedParameterJdbcTemplate jdbcTempleateNamedParameter;*/

	@Autowired
	private JdbcTemplate jdbcTempleate;

	@Override
	public void createMySQLTable(String userName, String tableName, String[] csvHeader) {
		dropTable(userName, tableName);

		StringBuilder sbMySQL = new StringBuilder("CREATE TABLE ");
		sbMySQL.append(userName).append("_").append(tableName).append(" (");
		for (String element : csvHeader) {
			sbMySQL.append(element.replaceAll(" ", "_"));
			sbMySQL.append(" VARCHAR(50), ");
		}
		sbMySQL.setLength(sbMySQL.length() - 2);
		sbMySQL.append(")");

		String queryString = sbMySQL.toString();
		System.out.println("Query string: " + queryString);

		jdbcTempleate.execute(queryString);
	}

	@Override
	public void dropTable(String userName, String tableName) {
		StringBuilder sbMySQL = new StringBuilder("DROP TABLE IF EXISTS ");
		sbMySQL.append(userName).append("_").append(tableName);
		jdbcTempleate.execute(sbMySQL.toString());
	}

	@Override
	public void loadCsvFileToDB(String userName, String tableName, String filePath, String[] csvHeader) {
		filePath = filePath.replaceAll("\\\\", "/");
		try {
			StringBuilder sbMySQL = new StringBuilder("LOAD DATA LOCAL INFILE '");
			sbMySQL.append(filePath).append("' INTO TABLE ").append(userName).append("_").append(tableName);
			sbMySQL.append(" FIELDS TERMINATED BY ','");
			sbMySQL.append(" LINES TERMINATED BY '\\n' IGNORE 1 LINES (");

			for (String element : csvHeader) {
				sbMySQL.append(element.replaceAll(" ", "_"));
				sbMySQL.append(", ");
			}
			sbMySQL.setLength(sbMySQL.length() - 2);
			sbMySQL.append(")");

			String loadQuery = sbMySQL.toString();
			System.out.println(loadQuery);
			jdbcTempleate.execute(loadQuery);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
