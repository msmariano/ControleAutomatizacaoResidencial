package br.com.edu.pos.controle.automatizacao.residencial.view;

import java.sql.SQLException;

import br.com.edu.pos.controle.automatizacao.residencial.controller.ExcluirGenerico;
import br.com.edu.pos.controle.automatizacao.residencial.controller.InicializarSistema;


public class ControleAutomatizacaoPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inicializando sistema...");
		InicializarSistema iniciar = new InicializarSistema();
		iniciar.executarInicializacao();
		
		

	}

}
