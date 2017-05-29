package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;
//Marcelo dos Santos Mariano
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.edu.pos.controle.automatizacao.residencial.enumerador.TipoEquipamentoIot;
import br.com.edu.pos.controle.automatizacao.residencial.enumerador.TipoUsuario;

public class EquipamentoIotDAO extends SqlGenerico implements Sql {
	private String nome;
	private String descricao;
	private String ip;
	private String codigo;
	private String id;
	TipoEquipamentoIot tipoEquipamento;
	List<EquipamentoIotDAO> listaEquipamentoIot = new ArrayList<>();

	public List<EquipamentoIotDAO> getListaEquipamentoIot() {
		return listaEquipamentoIot;
	}

	public void setListaEquipamentoIot(List<EquipamentoIotDAO> listaEquipamentoIot) {
		this.listaEquipamentoIot = listaEquipamentoIot;
	}

	public EquipamentoIotDAO() {
		inclusao.setObj(this);
		exclusao.setObj(this);
		alteracao.setObj(this);
		consulta.setObj(this);

	}

	@Override
	public String toString() {

		if (tipoEquipamento == null) {
			return "EquipamentoIot [nome=" + nome + ", descricao=" + descricao + ", ip=" + ip + ", codigo=" + codigo
					+ ", id=" + id + ", tipoEquipamento=null ]";
		}

		return "EquipamentoIot [nome=" + nome + ", descricao=" + descricao + ", ip=" + ip + ", codigo=" + codigo
				+ ", id=" + id + ", tipoEquipamento=" + tipoEquipamento.getValor() + "]";
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

		consulta.consultar();
		Collection<Object> res = consulta.getResultadoLinha();
		if (res.size() == 1) {
			for (Object object : res) {
				List<String> lista = (List<String>) object;
				this.setNome(lista.get(0));
				this.setDescricao(lista.get(1));
				this.setIp(lista.get(2));
				this.setCodigo(lista.get(3));
				this.setId(lista.get(4));
				TipoEquipamentoIot tipoEquipamentoIot;
				try {
					switch (Integer.parseInt(lista.get(5))) {
					case 1:
						tipoEquipamentoIot = TipoEquipamentoIot.ACESSO;
						break;
					case 2:
						tipoEquipamentoIot = TipoEquipamentoIot.LEITURA;
						break;
					case 3:
						tipoEquipamentoIot = TipoEquipamentoIot.AUTOMATIZADOR;
						break;

					default:
						tipoEquipamentoIot = TipoEquipamentoIot.NENHUM;
						break;
					}
				} catch (Exception e) {
					tipoEquipamentoIot = TipoEquipamentoIot.NENHUM;
				}

				this.setTipoEquipamento(tipoEquipamentoIot);

			}
			listaEquipamentoIot.add(this);
		} else {

			for (Object object : res) {
				EquipamentoIotDAO equipamentoIotDAO = new EquipamentoIotDAO();
				List<String> lista = (List<String>) object;
				equipamentoIotDAO.setNome(lista.get(0));
				equipamentoIotDAO.setDescricao(lista.get(1));
				equipamentoIotDAO.setIp(lista.get(2));
				equipamentoIotDAO.setCodigo(lista.get(3));
				equipamentoIotDAO.setId(lista.get(4));
				TipoEquipamentoIot tipoEquipamentoIot;
				try {
					switch (Integer.parseInt(lista.get(5))) {
					case 1:
						tipoEquipamentoIot = TipoEquipamentoIot.ACESSO;
						break;
					case 2:
						tipoEquipamentoIot = TipoEquipamentoIot.LEITURA;
						break;
					case 3:
						tipoEquipamentoIot = TipoEquipamentoIot.AUTOMATIZADOR;
						break;

					default:
						tipoEquipamentoIot = TipoEquipamentoIot.NENHUM;
						break;
					}
				} catch (Exception e) {
					tipoEquipamentoIot = TipoEquipamentoIot.NENHUM;
				}

				equipamentoIotDAO.setTipoEquipamento(tipoEquipamentoIot);
				listaEquipamentoIot.add(equipamentoIotDAO);
			}

		}

	}

	@Override
	public void modificar() {
		alteracao.alterar();

	}

}
