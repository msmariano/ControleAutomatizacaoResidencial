package br.com.edu.pos.controle.automatizacao.residencial.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao.JdbcDaoFactory;

public class IncluirGenerico extends JdbcDaoFactory {
	
	List<String> campo = new ArrayList<String>();
	List<String> valor = new ArrayList<String>();
	private Object Obj;
	public Object getObj() {
		return Obj;
	}
	public void setObj(Object obj) {
		Obj = obj;
	}
	private String tabela = "";
	public IncluirGenerico(){
		
		
	}
	public String inserir(){
		setNomeDatabase("ctrlautres.db");
		String ret = Obj.toString();
		String[] par1 = ret.split("\\[");
		setTabela(par1[0]);
		String[] par2 = par1[1].split("\\]");
		String[] par3 = par2[0].split(",");	
		
		for (String expressao : par3) {
			String chave[] = expressao.split("=");
			campo.add(chave[0]);
			valor.add(chave[1]);
		}
		String sql = "";
		if((campo.size() > 0 && valor.size() >0 ) && (campo.size() == valor.size())){
			
			String valores="";
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
			String campos="";
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
			
			
			sql = "INSERT INTO "+tabela+"("+campos+")VALUES("+valores+")";
			executa(sql);
		}
		return sql;
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
	public String getTabela() {
		return tabela;
	}
	public void setTabela(String tabela) {
		this.tabela = tabela;
	}

}
