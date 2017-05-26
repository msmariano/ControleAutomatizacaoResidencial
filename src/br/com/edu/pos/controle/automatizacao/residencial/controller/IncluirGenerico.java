package br.com.edu.pos.controle.automatizacao.residencial.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao.JdbcDaoFactory;

public class IncluirGenerico extends JdbcDaoFactory {
	

	public String inserir(){
		ExtraiCamposValoresObj();	
		String sql = "INSERT INTO "+getTabela()+"("+getCampos()+")VALUES("+getValores()+")";
		executa(sql);
		return sql;
	}
	

}
