package br.com.edu.pos.controle.automatizacao.residencial.controller;

import br.com.edu.pos.controle.automatizacao.residencial.dto.UsuarioDTO;
import br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao.UsuarioDAO;

public class UsuarioController {
		
	
	public void inserir(UsuarioDTO dados){
		UsuarioDAO usuario = new UsuarioDAO();
		usuario.setNome(dados.getNome());
		usuario.setCpf(dados.getCpf());
		usuario.setEndereco(dados.getEndereco());
		usuario.setEmail(dados.getEmail());
		usuario.setTipoUsuario(dados.getTipoUsuario());
		usuario.setTelefone(dados.getTelefone());
		usuario.salvar();
	}


}
