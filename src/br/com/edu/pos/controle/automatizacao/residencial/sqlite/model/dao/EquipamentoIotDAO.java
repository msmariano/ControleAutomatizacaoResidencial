package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;

import br.com.edu.pos.controle.automatizacao.residencial.enumerador.TipoEquipamentoIot;

public class EquipamentoIotDAO  extends SqlGenerico implements Sql{
	private String nome;
	private String descricao;
	private String ip;
	private String codigo;
	private String id;
	TipoEquipamentoIot tipoEquipamento;
	
	public EquipamentoIotDAO(){
		inclusao.setObj(this);
		exclusao.setObj(this);
		alteracao.setObj(this);
		consulta.setObj(this);
		
	}
	
	@Override
	public String toString() {
		
		if(tipoEquipamento == null){
			return "EquipamentoIot [nome=" + nome + ", descricao=" + descricao + ", ip=" + ip + ", codigo=" + codigo
					+ ", id=" + id + ", tipoEquipamento=null ]";
		}
		
		return "EquipamentoIot [nome=" + nome + ", descricao=" + descricao + ", ip=" + ip + ", codigo=" + codigo
				+ ", id=" + id + ", tipoEquipamento=" + tipoEquipamento + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipoEquipamento == null) ? 0 : tipoEquipamento.hashCode());
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
		EquipamentoIotDAO other = (EquipamentoIotDAO) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipoEquipamento != other.tipoEquipamento)
			return false;
		return true;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public TipoEquipamentoIot getTipoEquipamento() {
		return tipoEquipamento;
	}
	public void setTipoEquipamento(TipoEquipamentoIot tipoEquipamento) {
		this.tipoEquipamento = tipoEquipamento;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void modificar() {
		alteracao.alterar();
		
	}
	

}
