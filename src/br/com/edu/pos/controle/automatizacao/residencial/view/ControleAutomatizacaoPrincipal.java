package br.com.edu.pos.controle.automatizacao.residencial.view;

import java.util.List;

import br.com.edu.pos.controle.automatizacao.residencial.controller.InicializarSistema;
import br.com.edu.pos.controle.automatizacao.residencial.enumerador.TipoUsuario;
import br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao.UsuarioDAO;


public class ControleAutomatizacaoPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inicializando sistema...");
		InicializarSistema iniciar = new InicializarSistema();
		iniciar.executarInicializacao();
		
		UsuarioDAO usuario = new UsuarioDAO();
		//usuario.setCpf("");
		//usuario.setNome("Marcelo dos Santos Mariano");
		//usuario.setEndereco("");
		//usuario.setTelefone("");
		//usuario.setTipoUsuario(TipoUsuario.MORADOR);
		//usuario.setEmail("");
		//usuario.setId("");
		//usuario.deletar();
		//usuario.salvar();
		//usuario.modificar();
		System.out.println(usuario.toString());
		usuario.consultar();
		
		for (UsuarioDAO user : usuario.getListaUsuarios()) {
			
			System.out.println(user);
		}
		
		
		
		

	}

}
