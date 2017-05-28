package br.com.edu.pos.controle.automatizacao.residencial.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.edu.pos.controle.automatizacao.residencial.dto.EquipamentoIotDTO;
import br.com.edu.pos.controle.automatizacao.residencial.dto.UsuarioDTO;
import br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao.EquipamentoIotDAO;
import br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao.UsuarioDAO;

public class EquipamentoController {
	
	
	public void excluir(EquipamentoIotDTO dados){
		EquipamentoIotDAO equipamentoIotDAO = new EquipamentoIotDAO();
		equipamentoIotDAO.setId(dados.getId());
		equipamentoIotDAO.deletar();
	}
	
	public void alterar(EquipamentoIotDTO dados){
		EquipamentoIotDAO equipamentoIotDAO = new EquipamentoIotDAO();
		equipamentoIotDAO.setNome(dados.getNome());
		equipamentoIotDAO.setDescricao(dados.getDescricao());
		equipamentoIotDAO.setIp(dados.getIp());
		equipamentoIotDAO.setCodigo(dados.getCodigo());
		equipamentoIotDAO.setTipoEquipamento(dados.getTipoEquipamento());
		equipamentoIotDAO.setId(dados.getId());
		
		equipamentoIotDAO.modificar();
	}
	
	
	public void inserir(EquipamentoIotDTO equipamento){
		EquipamentoIotDAO equipamentoIotDAO = new EquipamentoIotDAO();
		equipamentoIotDAO.setNome(equipamento.getNome());
		equipamentoIotDAO.setDescricao(equipamento.getDescricao());
		equipamentoIotDAO.setIp(equipamento.getIp());
		equipamentoIotDAO.setCodigo(equipamento.getCodigo());
		equipamentoIotDAO.salvar();
	}
	
	public List<EquipamentoIotDTO> consultar(EquipamentoIotDTO dados){
		List<EquipamentoIotDTO> equipamentos = new  ArrayList<EquipamentoIotDTO>();
		EquipamentoIotDAO equipamentoIotDAO = new EquipamentoIotDAO();
		equipamentoIotDAO.setNome(dados.getNome());
		equipamentoIotDAO.setDescricao(dados.getDescricao());
		equipamentoIotDAO.setIp(dados.getIp());
		equipamentoIotDAO.setCodigo(dados.getCodigo());
		equipamentoIotDAO.setTipoEquipamento(dados.getTipoEquipamento());
		equipamentoIotDAO.setId(dados.getId());
		equipamentoIotDAO.consultar();
		
		
		
		List<EquipamentoIotDAO> equipamentosIotDAO =  equipamentoIotDAO.getListaEquipamentoIot();
		for (EquipamentoIotDAO equipt : equipamentosIotDAO) {
			EquipamentoIotDTO equiptDTO = new EquipamentoIotDTO();
			
			
			equiptDTO.setNome(equipt.getNome());
			equiptDTO.setDescricao(equipt.getDescricao());
			equiptDTO.setId(equipt.getId());
			equiptDTO.setIp(equipt.getIp());
			equiptDTO.setTipoEquipamento(equipt.getTipoEquipamento());			
			equiptDTO.setCodigo(equipt.getCodigo());
			equipamentos.add(equiptDTO);
			
		}
		
		return equipamentos;
	}

}
