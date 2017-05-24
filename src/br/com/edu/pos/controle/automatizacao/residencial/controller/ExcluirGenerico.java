package br.com.edu.pos.controle.automatizacao.residencial.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao.JdbcDaoFactory;

public  class ExcluirGenerico extends JdbcDaoFactory {
	
	private String nomeTabela = "";
	private String nomeChave = "";
	private String valorChave = "";
	
	
	public ExcluirGenerico(String nomeTabela,String nomeChave,String valorChave) throws ClassNotFoundException, SQLException{
		
		setNomeTabela(nomeTabela);
		setValorChave(valorChave);
		setNomeChave(nomeChave);
		setNomeDatabase("ctrlautres.db");
	}
	
	public String getNomeChave() {
		return nomeChave;
	}

	public void setNomeChave(String nomeChave) {
		this.nomeChave = nomeChave;
	}

	public void execute(){
		String sql = "DELETE FROM "+getNomeTabela()+" WHERE "+ getNomeChave() + " = "+getValorChave();
		Statement stmt = null;
		try {
			connection.setAutoCommit(false);
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			connection.commit();
			connection.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String getNomeTabela() {
		return nomeTabela;
	}

	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}

	public String getValorChave() {
		return valorChave;
	}

	public void setValorChave(String valorChave) {
		this.valorChave = valorChave;
	}

}
