package br.com.edu.pos.controle.automatizacao.residencial.controller;

import br.com.edu.pos.controle.automatizacao.residencial.dto.EquipamentoIotDTO;
import br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao.EquipamentoIotDAO;

public class EquipamentoController {
	
	public void inserir(EquipamentoIotDTO equipamento){
		EquipamentoIotDAO equipamentoIotDAO = new EquipamentoIotDAO();
		equipamentoIotDAO.setNome(equipamento.getNome());
		equipamentoIotDAO.setDescricao(equipamento.getDescricao());
		equipamentoIotDAO.setIp(equipamento.getIp());
		equipamentoIotDAO.setCodigo(equipamento.getCodigo());
		equipamentoIotDAO.salvar();
	}

}
