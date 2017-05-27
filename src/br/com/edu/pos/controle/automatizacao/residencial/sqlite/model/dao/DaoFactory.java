package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DaoFactory {
	
	public  Connection connection = null;
	
	public Connection getConnection(String nomeDataBase)  {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:"+nomeDataBase);	    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return connection;		
	}

	abstract void getConnectionDataBase() throws ClassNotFoundException, SQLException;


}
