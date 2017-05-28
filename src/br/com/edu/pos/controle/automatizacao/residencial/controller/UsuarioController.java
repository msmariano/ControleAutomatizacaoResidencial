package br.com.edu.pos.controle.automatizacao.residencial.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.edu.pos.controle.automatizacao.residencial.dto.UsuarioDTO;
import br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao.UsuarioDAO;

public class UsuarioController {
		
	public void excluir(UsuarioDTO dados){
		UsuarioDAO usuario = new UsuarioDAO();
		usuario.setId(dados.getId());
		usuario.deletar();
	}
	
	public void alterar(UsuarioDTO dados){
		UsuarioDAO usuario = new UsuarioDAO();
		usuario.setNome(dados.getNome());
		usuario.setCpf(dados.getCpf());
		usuario.setEndereco(dados.getEndereco());
		usuario.setEmail(dados.getEmail());
		usuario.setTipoUsuario(dados.getTipoUsuario());
		usuario.setTelefone(dados.getTelefone());
		usuario.setId(dados.getId());
		usuario.modificar();
	}
	
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
	
	public List<UsuarioDTO> consultar(UsuarioDTO dados){
		List<UsuarioDTO> usuarios = new  ArrayList<UsuarioDTO>();
		UsuarioDAO usuario = new UsuarioDAO();
		usuario.setNome(dados.getNome());
		usuario.setCpf(dados.getCpf());
		usuario.setEndereco(dados.getEndereco());
		usuario.setEmail(dados.getEmail());
		usuario.setTipoUsuario(dados.getTipoUsuario());
		usuario.setTelefone(dados.getTelefone());
		usuario.setId(dados.getId());
		usuario.consultar();
		List<UsuarioDAO> usuariosDAO =  usuario.getListaUsuarios();
		for (UsuarioDAO usuarioDAO : usuariosDAO) {
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setNome(usuarioDAO.getNome());
			usuarioDTO.setCpf(usuarioDAO.getCpf());
			usuarioDTO.setEndereco(usuarioDAO.getEndereco());
			usuarioDTO.setTelefone(usuarioDAO.getTelefone());
			usuarioDTO.setTipoUsuario(usuarioDAO.getTipoUsuario());
			usuarioDTO.setId(usuarioDAO.getId());
			usuarioDTO.setEmail(usuarioDAO.getEmail());
			usuarios.add(usuarioDTO);
			
		}
		
		return usuarios;
	}


}
