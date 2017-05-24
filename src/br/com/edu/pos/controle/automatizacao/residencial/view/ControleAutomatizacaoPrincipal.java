package br.com.edu.pos.controle.automatizacao.residencial.view;

import java.util.List;

import br.com.edu.pos.controle.automatizacao.residencial.sqlite.dao.Tabelas;


public class ControleAutomatizacaoPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inicializando sistema...");
		
		//Teste
		Tabelas Tabelas = new Tabelas("test.db");
		List<String> l = Tabelas.getTabelas();
		
		for (String tabela : l) {
			System.out.println(tabela);
		}	

	}

}
