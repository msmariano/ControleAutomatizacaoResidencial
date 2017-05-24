package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Tabelas extends JdbcDaoFactory{

	private List<String> tabelas = new ArrayList<>();
	String[] banco = {"","","",""};
	
	public Tabelas(String nomeDatabase){
		setNomeDatabase(nomeDatabase);
		listarTabelas();
	}
	
	void insereTabela(String nomeTabela){
		
	}
	public void gerar(){
		
	}
	
	public Tabelas(){
		listarTabelas();
	}
	public List<String> getTabelas() {
		return tabelas;
	}

	public void setTabelas(List<String> tabelas) {
		this.tabelas = tabelas;
	}

	public void listarTabelas(){
		try {
				
				getConnectionDataBase();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery( "SELECT name FROM sqlite_master WHERE type='table'" );
				tabelas.clear();
				while ( rs.next() ) {
					tabelas.add(rs.getString("name"));
				}
				stmt.close();
				finalizarConnecao();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	boolean isTabelaExiste(String nomeTabela){
		return tabelas.contains(nomeTabela);
		 
	}

}
