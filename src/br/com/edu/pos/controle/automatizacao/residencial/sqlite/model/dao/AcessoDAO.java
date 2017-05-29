package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;
//Marcelo dos Santos Mariano
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import br.com.edu.pos.controle.automatizacao.residencial.enumerador.TipoAcesso;
import br.com.edu.pos.controle.automatizacao.residencial.enumerador.TipoEquipamentoIot;

public class AcessoDAO extends SqlGenerico implements Sql {
	private Date inicioAcesso;
	private Date fimAcesso;
	private TipoAcesso tipoAcesso;
	private Boolean repetido;
	private Integer qtdeVezes;
	private EquipamentoIotDAO equipamentoAcessoId;	
	private String id;
	private UsuarioDAO usuarioAcessoId;
	private 

	List<AcessoDAO> listaAcessos = new ArrayList<AcessoDAO>();

	public AcessoDAO() {
		inclusao.setObj(this);
		exclusao.setObj(this);
		alteracao.setObj(this);
		consulta.setObj(this);
	}

	public TipoAcesso getTipoAcesso() {
		return tipoAcesso;
	}

	public void setTipoAcesso(TipoAcesso tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<AcessoDAO> getListaAcessos() {
		return listaAcessos;
	}

	public void setListaAcessos(List<AcessoDAO> listaAcessos) {
		this.listaAcessos = listaAcessos;
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
		return equipamentoAcessoId;
	}

	public void setEquipamentoAcesso(EquipamentoIotDAO equipamentoAcesso) {
		this.equipamentoAcessoId = equipamentoAcesso;
	}

	public UsuarioDAO getUsuarioAcessoId() {
		return usuarioAcessoId;
	}

	public void setUsuarioAcessoId(UsuarioDAO usuarioAcessoId) {
		this.usuarioAcessoId = usuarioAcessoId;
	}

	@Override
	public String toString() {

		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		String dataInicio = "";
		String dataFim = "";
		
		if(inicioAcesso!=null)
			dataInicio = sd.format(inicioAcesso);
		if(fimAcesso!=null)
			dataFim = sd.format(fimAcesso);
		
		String idEquipamentoAcesso = "";
		String idUsuarioAcesso = "";
		
		if (equipamentoAcessoId != null)
			idEquipamentoAcesso = equipamentoAcessoId.getId();
		if(usuarioAcessoId != null)
			idUsuarioAcesso = usuarioAcessoId.getId();
		
		if (tipoAcesso == null) {
			return "Acesso [inicioAcesso=" + dataInicio + ", fimAcesso=" + dataFim + ", tipoAcesso=null"
					+ ", repetido=" + repetido + ", qtdeVezes=" + qtdeVezes + ", equipamentoAcessoId=" + idEquipamentoAcesso
					+ ",id=" + id + ",usuarioAcessoId="+ idUsuarioAcesso+  "]";
		}

		return "Acesso [inicioAcesso=" + dataInicio + ", fimAcesso=" + dataFim + ", tipoAcesso=" + tipoAcesso.getValor()
				+ ", repetido=" + repetido + ", qtdeVezes=" + qtdeVezes + ", equipamentoAcessoId=" + idEquipamentoAcesso
				+ ",id=" + id + ",usuarioAcessoId="+idUsuarioAcesso+ "]";
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
	public void consultar() throws ParseException {
		consulta.consultar();
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");

		/*
		 * inicioAcesso fimAcesso tipoAcesso repetido qtdeVezes
		 * equipamentoAcesso id
		 */

		Collection<Object> res = consulta.getResultadoLinha();
		if (res.size() == 1) {
			for (Object object : res) {
				List<String> lista = (List<String>) object;

				this.setInicioAcesso(sd.parse(lista.get(0)));
				this.setFimAcesso(sd.parse(lista.get(1)));
				TipoAcesso tipoAcesso;
				try {
					switch (Integer.parseInt(lista.get(2))) {
					case 1:
						tipoAcesso = TipoAcesso.SOCIAL;
						break;
					case 2:
						tipoAcesso = TipoAcesso.PERMANENTE;
						break;
					case 3:
						tipoAcesso = TipoAcesso.SERVICO;
						break;
					default:
						tipoAcesso = TipoAcesso.NENHUM;
					}

				} catch (Exception e) {
					tipoAcesso = TipoAcesso.NENHUM;
				}
				this.setTipoAcesso(tipoAcesso);

				this.setRepetido(Boolean.parseBoolean(lista.get(3)));
				this.setQtdeVezes(Integer.parseInt(lista.get(4)));
				
				if(lista.get(5).trim().length() > 0){
					this.equipamentoAcessoId.setId(lista.get(5));
				}
				
				
				this.setId(lista.get(6));
				
				if(lista.get(7).trim().length() > 0){
					this.usuarioAcessoId.setId(lista.get(7));
				}
				
				listaAcessos.add(this);
			}

		} else {
			for (Object object : res) {
				List<String> lista = (List<String>) object;
				AcessoDAO acessoDAO = new AcessoDAO();

				acessoDAO.setInicioAcesso(sd.parse(lista.get(0)));
				acessoDAO.setFimAcesso(sd.parse(lista.get(1)));
				TipoAcesso tipoAcesso;
				try {
					switch (Integer.parseInt(lista.get(2))) {
					case 1:
						tipoAcesso = TipoAcesso.SOCIAL;
						break;
					case 2:
						tipoAcesso = TipoAcesso.PERMANENTE;
						break;
					case 3:
						tipoAcesso = TipoAcesso.SERVICO;
						break;
					default:
						tipoAcesso = TipoAcesso.NENHUM;
					}

				} catch (Exception e) {
					tipoAcesso = TipoAcesso.NENHUM;
				}
				acessoDAO.setTipoAcesso(tipoAcesso);

				acessoDAO.setRepetido(Boolean.parseBoolean(lista.get(3)));
				acessoDAO.setQtdeVezes(Integer.parseInt(lista.get(4)));
				
				if(lista.get(5).trim().length() > 0){
					acessoDAO.equipamentoAcessoId.setId(lista.get(5));
				}
				
				
				this.setId(lista.get(6));
				
				if(lista.get(7).trim().length() > 0){
					acessoDAO.usuarioAcessoId.setId(lista.get(7));
				}
				
				
				listaAcessos.add(acessoDAO);
			}

		}

	}

	@Override
	public void modificar() {
		alteracao.alterar();

	}

	

}
