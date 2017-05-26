package br.com.edu.pos.controle.automatizacao.residencial.view;

import br.com.edu.pos.controle.automatizacao.residencial.controller.IncluirGenerico;
import br.com.edu.pos.controle.automatizacao.residencial.controller.InicializarSistema;
import br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao.UsuarioDAO;


public class ControleAutomatizacaoPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inicializando sistema...");
		InicializarSistema iniciar = new InicializarSistema();
		iniciar.executarInicializacao();
		
		UsuarioDAO usuario = new UsuarioDAO();
		usuario.setCpf("87522020972");
		usuario.setNome("Marcelo dos Santos Mariano");
		usuario.setEndereco("Rua Cyro Vellozo 56");
		usuario.setTelefone("41985064115");
		usuario.setEmail("marcelodossantosmariano@gmail.com");
		usuario.setId("20");
		//usuario.deletar();
		//usuario.salvar();
		usuario.modificar();
		
		
		
		

	}

}
