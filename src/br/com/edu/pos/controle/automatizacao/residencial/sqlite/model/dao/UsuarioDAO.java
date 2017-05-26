package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;

import br.com.edu.pos.controle.automatizacao.residencial.enumerador.TipoUsuario;

public class UsuarioDAO extends SqlGenerico implements Sql {
	private String nome;
	private String cpf;
	private String endereco;
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	private String email;
	private String telefone;
	private String id;
	TipoUsuario tipoUsuario;
	
	public UsuarioDAO(){
		inclusao.setObj(this);
		exclusao.setObj(this);
		alteracao.setObj(this);
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Usuario[nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", email=" + email
				+ ", telefone=" + telefone + ", tipoUsuario=" + tipoUsuario + ",id="+id+"]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((tipoUsuario == null) ? 0 : tipoUsuario.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDAO other = (UsuarioDAO) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (tipoUsuario != other.tipoUsuario)
			return false;
		return true;
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


	@Override
	public void salvar() {
		// TODO Auto-generated method stub
		inclusao.inserir();
	}


	@Override
	public void deletar() {
		// TODO Auto-generated method stub
		exclusao.excluir();
	}


	@Override
	public void consultar() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void modificar() {
		// TODO Auto-generated method stub
		alteracao.alterar();
	}
	

}
