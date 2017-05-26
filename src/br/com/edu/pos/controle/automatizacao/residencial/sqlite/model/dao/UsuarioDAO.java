package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;

import br.com.edu.pos.controle.automatizacao.residencial.enumerador.TipoUsuario;

public class UsuarioDAO {
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String telefone;
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
	

}
