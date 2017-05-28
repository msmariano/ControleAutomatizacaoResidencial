package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;

import java.util.Date;

import br.com.edu.pos.controle.automatizacao.residencial.enumerador.TipoAcesso;

public class AcessoDAO  extends SqlGenerico implements Sql {
	private Date inicioAcesso;
	private Date fimAcesso;
	private TipoAcesso tipoAcesso;
	private Boolean repetido;
	private Integer qtdeVezes;
	private EquipamentoIotDAO equipamentoAcesso;
	private UsuarioDAO usuarioAcesso;
	private Integer id;
	
	public AcessoDAO(){
		inclusao.setObj(this);
		exclusao.setObj(this);
		alteracao.setObj(this);
		consulta.setObj(this);
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
	public TipoAcesso getTipAcesso() {
		return tipoAcesso;
	}
	public void setTipAcesso(TipoAcesso tipAcesso) {
		this.tipoAcesso = tipAcesso;
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
	
	
	@Override
	public String toString() {
		
		if(tipoAcesso == null){
			return "Acesso [inicioAcesso=" + inicioAcesso + ", fimAcesso=" + fimAcesso + ", tipoAcesso=null"
					+ ", repetido=" + repetido + ", qtdeVezes=" + qtdeVezes + ", equipamentoAcesso=" + equipamentoAcesso
					+  ",id="+id+ "]";
		}
		
		return "Acesso [inicioAcesso=" + inicioAcesso + ", fimAcesso=" + fimAcesso + ", tipoAcesso=" + tipoAcesso
				+ ", repetido=" + repetido + ", qtdeVezes=" + qtdeVezes + ", equipamentoAcesso=" + equipamentoAcesso
				+  ",id="+id+ "]";
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


	public UsuarioDAO getUsuarioAcesso() {
		return usuarioAcesso;
	}


	public void setUsuarioAcesso(UsuarioDAO usuarioAcesso) {
		this.usuarioAcesso = usuarioAcesso;
	}

}
