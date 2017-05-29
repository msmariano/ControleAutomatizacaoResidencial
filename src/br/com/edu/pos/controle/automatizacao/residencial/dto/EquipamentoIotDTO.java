package br.com.edu.pos.controle.automatizacao.residencial.dto;
//Marcelo dos Santos Mariano
import java.util.ArrayList;
import java.util.List;

import br.com.edu.pos.controle.automatizacao.residencial.enumerador.TipoEquipamentoIot;
import br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao.EquipamentoIotDAO;
import br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao.UsuarioDAO;

public class EquipamentoIotDTO {
	
	private String nome;
	private String descricao;
	private String ip;
	private String codigo;
	private String id;
	TipoEquipamentoIot tipoEquipamento;
	
	List<EquipamentoIotDAO> listaEquipamentos = new ArrayList<>();
	
	public List<EquipamentoIotDAO> getListaEquipamentos() {
		return listaEquipamentos;
	}
	public void setListaEquipamentos(List<EquipamentoIotDAO> listaEquipamentos) {
		this.listaEquipamentos = listaEquipamentos;
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

}
