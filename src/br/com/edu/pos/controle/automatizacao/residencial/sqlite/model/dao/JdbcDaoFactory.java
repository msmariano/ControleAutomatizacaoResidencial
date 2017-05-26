package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcDaoFactory extends DaoFactory {
	
	List<String> campo = new ArrayList<String>();
	List<String> valor = new ArrayList<String>();
	private Object obj;
	private String tabela = "";
	private String valores="";
	private String campos="";
	private String id = "";
	
	
	public String getValores() {
		return valores;
	}

	public void setValores(String valores) {
		this.valores = valores;
	}

	public String getCampos() {
		return campos;
	}

	public void setCampos(String campos) {
		this.campos = campos;
	}

	public List<String> getCampo() {
		return campo;
	}

	public void setCampo(List<String> campo) {
		this.campo = campo;
	}

	public List<String> getValor() {
		return valor;
	}

	public void setValor(List<String> valor) {
		this.valor = valor;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getTabela() {
		return tabela;
	}

	public void setTabela(String tabela) {
		this.tabela = tabela;
	}

	public boolean isConnectado() {
		return connectado;
	}

	public void setConnectado(boolean connectado) {
		this.connectado = connectado;
	}
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
	

	public void executa(String query) {
		try {
		System.out.println(query);
			getConnectionDataBase();
			Statement stmt = connection.createStatement();
			stmt.execute(query);
			if(stmt != null)
				stmt.close();
			finalizarConnecao();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
	public void ExtraiCamposValoresObj(){
		setNomeDatabase("ctrlautres.db");
		String ret = obj.toString();
		String[] par1 = ret.split("\\[");
		setTabela(par1[0]);
		String[] par2 = par1[1].split("\\]");
		String[] par3 = par2[0].split(",");	
		
		for (String expressao : par3) {
			String chave[] = expressao.split("=");
			campo.add(chave[0]);
			valor.add(chave[1]);
		}
		
		if((campo.size() > 0 && valor.size() >0 ) && (campo.size() == valor.size())){
			
			
			for (int i = 0; i < valor.size();i++) {
				String s = valor.get(i);
				if (s.equals("null")){
					s = "";
				}
				
				if(i == valor.size()-1)
					valores = valores+"\""+s+"\"";
				else
					valores = valores+"\""+s+"\",";
			}
			
			for (int i = 0; i < campo.size();i++) {
				String s = campo.get(i);
				
				
				
				if (s.equals("null")){
					s = "";
				}
				
				if(i == campo.size()-1)
					campos = campos+s;
				else
					campos = campos+s+",";
			}
		}
	}

	public String getId() {
		String id ="";
		int i = 0;
		if(campo.size() == valor.size()){
			for (String string : campo) {
				if(string.equals("id")){
					id = valor.get(i);
					break;
				}
				i++;
			}
		}
		setId(id);
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
