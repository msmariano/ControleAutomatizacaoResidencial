package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;

import java.util.ArrayList;
import java.util.List;

public class IncluirGenerico extends JdbcDaoFactory {
	

	public String inserir(){
		ExtraiCamposValoresObj();	
		String camposInserir = "";
		String valoresInserir="";
		
		for(int i =0; i < getCampo().size();i++){
			if(!getCampo().get(i).trim().equals("id")){
				
				String s = getValor().get(i);
				
				if (s.equals("null")){
					s = "";
				}
				
				
				camposInserir = camposInserir + getCampo().get(i)+",";
				valoresInserir = valoresInserir+"\""+s+"\",";
			}
		}
		String virgula = valoresInserir.substring(valoresInserir.length()-1, valoresInserir.length());
		
		if(virgula.equals(",")){
			valoresInserir = valoresInserir.substring(0,valoresInserir.length()-1);
		}
        
		virgula = camposInserir.substring(camposInserir.length()-1, camposInserir.length());
		
		if(virgula.equals(",")){
			camposInserir = camposInserir.substring(0,camposInserir.length()-1);
		}
		
		String sql = "INSERT INTO "+getTabela()+"("+camposInserir+")VALUES("+valoresInserir+")";
		executa(sql);
		return sql;
	}
	

}
