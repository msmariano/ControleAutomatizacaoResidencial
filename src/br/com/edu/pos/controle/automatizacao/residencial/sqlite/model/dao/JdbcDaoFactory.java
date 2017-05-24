package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDaoFactory extends DaoFactory {

	
	private String nomeDatabase;
	private boolean connectado = false;
	
	public String getNomeDatabase() {
		return nomeDatabase;
	}

	public void setNomeDatabase(String nomeDatabase) {
		this.nomeDatabase = nomeDatabase;
	}

	public JdbcDaoFactory(){
		setNomeDatabase("CtrlAut");
		
	}
	void finalizarConnecao() throws SQLException{
		if(connectado){
			connection.close();
		}
	}

	public void getConnectionDataBase() throws ClassNotFoundException, SQLException {
		if(getConnection(getNomeDatabase()) != null)
			connectado = true;
	}
	

}