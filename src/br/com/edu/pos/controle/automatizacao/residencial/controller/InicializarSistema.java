package br.com.edu.pos.controle.automatizacao.residencial.controller;

import br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao.Tabelas;

public class InicializarSistema {
	
	public void executarInicializacao(){
		Tabelas Tabelas = new Tabelas("ctrlautres.db");
		
	}
	

}
