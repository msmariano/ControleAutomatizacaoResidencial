package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public  class ExcluirGenerico extends JdbcDaoFactory {
	
	public String excluir(){
		ExtraiCamposValoresObj();	
		String sql = "DELETE FROM "+getTabela()+" WHERE id = "+getId();
		executa(sql);
		return sql;
		
	}
	

}
