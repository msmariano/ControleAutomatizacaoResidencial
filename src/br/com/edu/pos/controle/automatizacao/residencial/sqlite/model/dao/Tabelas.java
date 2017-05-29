package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;
//Marcelo dos Santos Mariano
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Tabelas extends JdbcDaoFactory {

	private List<String> tabelas = new ArrayList<>();
	String[] bancoTabelas = { "Usuario", "EquipamentoIOT", "Acesso"};

	public Tabelas(String nomeDatabase) {
		setNomeDatabase(nomeDatabase);
		listarTabelas();
	}


	public void gerar() {
		for (String tabela : bancoTabelas) {
			if (!verificaTabela(tabela)) {
				if(tabela.equals("Usuario")){
					executa("CREATE TABLE Usuario(nome TEXT,cpf TEXT,endereco TEXT,email TEXT,telefone TEXT,tipousuario NUMERIC,id INTEGER PRIMARY KEY)");
					executa("CREATE UNIQUE INDEX idusuario ON Usuario(id ASC)");
				}
				else if(tabela.equals("EquipamentoIOT")){
					executa("CREATE TABLE EquipamentoIOT(nome TEXT,descricao TEXT,codigo TEXT,ip TEXT,tipoequipamento NUMERIC,id INTEGER PRIMARY KEY)");
					executa("CREATE UNIQUE INDEX ideqtoiot ON EquipamentoIOT(id ASC)");
				}
				else if(tabela.equals("Acesso")){
					executa("CREATE TABLE Acesso(inicioacesso TEXT,fimacesso TEXT,repetido TEXT,qtdevezes NUMERIC,tipoacesso NUMERIC,equipamentoAcessoId TEXT,id INTEGER PRIMARY KEY,usuarioAcessoId)");
					executa("CREATE UNIQUE INDEX idacesso ON Acesso(id ASC)");
				}
			}
		}
	}

	public Tabelas() {
		listarTabelas();
	}

	public List<String> getTabelas() {
		return tabelas;
	}

	public void setTabelas(List<String> tabelas) {
		this.tabelas = tabelas;
	}

	public Boolean verificaTabela(String nomeTabela) {
		try {
			Boolean ret = false;
			getConnectionDataBase();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name = '" + nomeTabela + "'");
			tabelas.clear();
			if (rs.next()) {
				ret = true;
			}
			stmt.close();
			finalizarConnecao();
			return ret;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void listarTabelas() {
		try {

			getConnectionDataBase();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type='table'");
			tabelas.clear();
			while (rs.next()) {
				tabelas.add(rs.getString("name"));
			}
			stmt.close();
			finalizarConnecao();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	boolean isTabelaExiste(String nomeTabela) {
		return tabelas.contains(nomeTabela);

	}

}
