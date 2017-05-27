package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;

import br.com.edu.pos.controle.automatizacao.residencial.enumerador.TipoEquipamentoIot;

public class EquipamentoIotDAO {
	private String nome;
	private String descricao;
	private String ip;
	private String codigo;
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
	TipoEquipamentoIot tipoEquipamento;

}
