package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;

public class AlterarGenerico extends JdbcDaoFactory {
	
	public String alterar(){
		ExtraiCamposValoresObj();	
		String sql = "UPDATE "+getTabela()+" SET ";
		String setElementos = "";
	
		
		for (int i = 0; i < getCampo().size();i++) {
			
			
			if(i == (getCampo().size()-1))
				setElementos = setElementos + getCampo().get(i)+"=\""+getValor().get(i)+"\"";
			else
				setElementos = setElementos+ getCampo().get(i)+"=\""+getValor().get(i)+"\",";
			
		}
		sql = sql+setElementos+" WHERE id ="+getId();
		
		executa(sql);
		return sql;
		
	}
	

}
