package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DaoFactory {
	
	Connection connection;
	
	abstract Connection getConnection() throws ClassNotFoundException, SQLException;

}
