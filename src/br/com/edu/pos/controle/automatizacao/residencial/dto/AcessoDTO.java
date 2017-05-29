package br.com.edu.pos.controle.automatizacao.residencial.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.edu.pos.controle.automatizacao.residencial.enumerador.TipoAcesso;
import br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao.EquipamentoIotDAO;
import br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao.UsuarioDAO;

public class AcessoDTO {
	private Date inicioAcesso;
	private Date fimAcesso;
	private TipoAcesso tipoAcesso;
	private Boolean repetido;
	private Integer qtdeVezes;
	private EquipamentoIotDAO equipamentoAcessoId = new EquipamentoIotDAO();
	private UsuarioDAO usuarioAcesso;
	private String id;
	private UsuarioDAO usuarioAcessoId = new UsuarioDAO();
	
	List<AcessoDTO> listaAcesso = new ArrayList<>();
	
	public List<AcessoDTO> getListaAcesso() {
		return listaAcesso;
	}
	public void setListaAcesso(List<AcessoDTO> listaAcesso) {
		this.listaAcesso = listaAcesso;
	}
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
	public TipoAcesso getTipoAcesso() {
		return tipoAcesso;
	}
	public void setTipoAcesso(TipoAcesso tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
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

	public EquipamentoIotDAO getEquipamentoAcessoId() {
		return equipamentoAcessoId;
	}
	public void setEquipamentoAcessoId(EquipamentoIotDAO equipamentoAcessoId) {
		this.equipamentoAcessoId = equipamentoAcessoId;
	}
	public UsuarioDAO getUsuarioAcessoId() {
		return usuarioAcessoId;
	}
	public void setUsuarioAcessoId(UsuarioDAO usuarioAcessoId) {
		this.usuarioAcessoId = usuarioAcessoId;
	}
	public UsuarioDAO getUsuarioAcesso() {
		return usuarioAcesso;
	}
	public void setUsuarioAcesso(UsuarioDAO usuarioAcesso) {
		this.usuarioAcesso = usuarioAcesso;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
