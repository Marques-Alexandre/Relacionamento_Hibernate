package org.libertas.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoJdbc {
	Connection con;
	
	public ConexaoJdbc() {
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/libertas2021?user=root&password=123");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConexao() {
		return con;
	}
	
	public void desconecta() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
