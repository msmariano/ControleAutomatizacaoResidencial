package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;

import java.util.Date;

import br.com.edu.pos.controle.automatizacao.residencial.enumerador.TipoAcesso;

public class AcessoDAO {
	private Date inicioAcesso;
	public Date getInicioAcesso() {
		return inicioAcesso;
	}
	public void setInicioAcesso(Date inicioAcesso) {
		this.inicioAcesso = inicioAcesso;
	}
	public Date getFimAcesso() {
		return fimAcesso;
	}
	public void setFimAcesso(Date fimAcesso) {
		this.fimAcesso = fimAcesso;
	}
	public TipoAcesso getTipAcesso() {
		return tipAcesso;
	}
	public void setTipAcesso(TipoAcesso tipAcesso) {
		this.tipAcesso = tipAcesso;
	}
	public Boolean getRepetido() {
		return repetido;
	}
	public void setRepetido(Boolean repetido) {
		this.repetido = repetido;
	}
	public Integer getQtdeVezes() {
		return qtdeVezes;
	}
	public void setQtdeVezes(Integer qtdeVezes) {
		this.qtdeVezes = qtdeVezes;
	}
	public EquipamentoIotDAO getEquipamentoAcesso() {
		return equipamentoAcesso;
	}
	public void setEquipamentoAcesso(EquipamentoIotDAO equipamentoAcesso) {
		this.equipamentoAcesso = equipamentoAcesso;
	}
	private Date fimAcesso;
	private TipoAcesso tipAcesso;
	private Boolean repetido;
	private Integer qtdeVezes;
	private EquipamentoIotDAO equipamentoAcesso;
	
	public String toString(){
		return "";
		
	}

}
