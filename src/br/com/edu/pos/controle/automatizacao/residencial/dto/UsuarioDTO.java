package br.com.edu.pos.controle.automatizacao.residencial.dto;
//Marcelo dos Santos Mariano
import java.util.ArrayList;
import java.util.List;

import br.com.edu.pos.controle.automatizacao.residencial.enumerador.TipoUsuario;
import br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao.UsuarioDAO;

public class UsuarioDTO {
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String telefone;
	private String id;
	List<UsuarioDAO> listaUsuarios = new ArrayList<>();
	TipoUsuario tipoUsuario;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<UsuarioDAO> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(List<UsuarioDAO> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
