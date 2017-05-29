package br.com.edu.pos.controle.automatizacao.residencial.controller;
//Marcelo dos Santos Mariano
import br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao.Tabelas;

public class InicializarSistema {
	
	public void executarInicializacao(){
		Tabelas tabelas = new Tabelas("ctrlautres.db");
		System.out.println("Gerando tabelas...");
		tabelas.gerar();
	}
	

}
