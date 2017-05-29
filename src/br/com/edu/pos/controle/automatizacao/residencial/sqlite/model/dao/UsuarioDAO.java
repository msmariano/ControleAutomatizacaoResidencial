package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;
//Marcelo dos Santos Mariano
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.edu.pos.controle.automatizacao.residencial.enumerador.TipoUsuario;

public class UsuarioDAO extends SqlGenerico implements Sql {
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String telefone;
	private String id;
	List<UsuarioDAO> listaUsuarios = new ArrayList<>();
	TipoUsuario tipoUsuario;
	
	public List<UsuarioDAO> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<UsuarioDAO> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	
	
	public UsuarioDAO(){
		inclusao.setObj(this);
		exclusao.setObj(this);
		alteracao.setObj(this);
		consulta.setObj(this);
	}	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
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
	public String toString() {
		
		if (tipoUsuario == null){
			return "Usuario[nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", email=" + email
					+ ", telefone=" + telefone + ", tipoUsuario=null,id="+id+"]";
		}
		
		return "Usuario[nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", email=" + email
				+ ", telefone=" + telefone + ", tipoUsuario=" + tipoUsuario.getValor() + ",id="+id+"]";
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
	
	@Override
	public void salvar() {
		inclusao.inserir();
	}

	@Override
	public void deletar() {
		exclusao.excluir();
	}
	

	@Override
	public void consultar() {
		
		
		consulta.consultar();
		Collection<Object> res = consulta.getResultadoLinha();
		if(res.size() == 1){
			for (Object object : res) {
				List<String> lista = (List<String>) object;
				this.setNome(lista.get(0));
				this.setCpf(lista.get(1));
				this.setEndereco(lista.get(2));
				this.setEmail(lista.get(3));
				this.setTelefone(lista.get(4));
				TipoUsuario tipoUsuario;
				try
				{
					switch(Integer.parseInt(lista.get(5))){
					case 1:
						tipoUsuario = TipoUsuario.VISITANTE;
						break;
					case 2:
						tipoUsuario = TipoUsuario.EQUIPAMENTOIOT;
						break;
					case 3:
						tipoUsuario = TipoUsuario.ACESSO;
						break;
					case 4:	
						tipoUsuario = TipoUsuario.MORADOR;
						break;
					default:
						tipoUsuario = TipoUsuario.NENHUM;
						break;
					}
				}
				catch(Exception e){
					tipoUsuario = TipoUsuario.NENHUM;
				}
				
				this.setTipoUsuario(tipoUsuario);
				this.setId(lista.get(6));
			}
			listaUsuarios.add(this);
		}
		else{
			
			for (Object object : res) {
				UsuarioDAO usuario = new UsuarioDAO();
				List<String> lista = (List<String>) object;
				usuario.setNome(lista.get(0));
				usuario.setCpf(lista.get(1));
				usuario.setEndereco(lista.get(2));
				usuario.setEmail(lista.get(3));
				usuario.setTelefone(lista.get(4));
				TipoUsuario tipoUsuario;
				try
				{
					
					switch(Integer.parseInt(lista.get(5))){
					case 1:
						tipoUsuario = TipoUsuario.VISITANTE;
						break;
					case 2:
						tipoUsuario = TipoUsuario.EQUIPAMENTOIOT;
						break;
					case 3:
						tipoUsuario = TipoUsuario.ACESSO;
						break;
					case 4:	
						tipoUsuario = TipoUsuario.MORADOR;
						break;
					default:
						tipoUsuario = TipoUsuario.NENHUM;
						break;
					}
				}
				catch(Exception e){
					tipoUsuario = TipoUsuario.NENHUM;
				}
				
				usuario.setTipoUsuario(tipoUsuario);
				usuario.setId(lista.get(6));
				listaUsuarios.add(usuario);
			}
			
			
		}
		
		
	}

	@Override
	public void modificar() {
		alteracao.alterar();
	}
	

}
