package br.com.edu.pos.controle.automatizacao.residencial.controller;
//Marcelo dos Santos Mariano
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.edu.pos.controle.automatizacao.residencial.dto.AcessoDTO;
import br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao.AcessoDAO;

public class AcessoController {
	
	public void copiaDTODAO(AcessoDTO dados,AcessoDAO acesso){
		acesso.setInicioAcesso(dados.getInicioAcesso());
		acesso.setFimAcesso(dados.getFimAcesso());
		acesso.setTipoAcesso(dados.getTipoAcesso());
		acesso.setRepetido(dados.getRepetido());
		acesso.setQtdeVezes(dados.getQtdeVezes());	
		acesso.setUsuarioAcessoId(dados.getUsuarioAcessoId());
		acesso.setEquipamentoAcesso(dados.getEquipamentoAcessoId());
		acesso.setId(dados.getId());
		
	}
	

	
	public void incluir(AcessoDTO dados){
		AcessoDAO acesso = new AcessoDAO();
		copiaDTODAO(dados,acesso);
		acesso.salvar();
	}
	
	public void excluir(AcessoDTO dados){
		AcessoDAO acesso = new AcessoDAO();
		copiaDTODAO(dados,acesso);
		acesso.deletar();
	}
	
	public void alterar(AcessoDTO dados){
		AcessoDAO acesso = new AcessoDAO();	
		copiaDTODAO(dados,acesso);
		acesso.modificar();
	}
	
	public List<AcessoDTO> consultar(AcessoDTO dados) throws ParseException{
		List<AcessoDTO> acessos = new ArrayList<AcessoDTO>();
		AcessoDAO acesso = new AcessoDAO();
		copiaDTODAO(dados,acesso);
		acesso.consultar();
		
		List<AcessoDAO> acessosDAO = acesso.getListaAcessos();
		for (AcessoDAO acessoDAO : acessosDAO) {
			AcessoDTO acessoDTO = new AcessoDTO();
			
			acessoDTO.setInicioAcesso(acessoDAO.getInicioAcesso());
			acessoDTO.setFimAcesso(acessoDAO.getFimAcesso());
			acessoDTO.setTipoAcesso(acessoDAO.getTipoAcesso());
			acessoDTO.setRepetido(acessoDAO.getRepetido());
			acessoDTO.setQtdeVezes(acessoDAO.getQtdeVezes());		
			acessoDTO.setId(acessoDAO.getId());		
			acessoDTO.getUsuarioAcessoId().setId(acessoDAO.getUsuarioAcessoId().getId());
			acessoDTO.getEquipamentoAcessoId().setId(acessoDAO.getEquipamentoAcesso().getId());
			
			acessos.add(acessoDTO);
		}
		
		return acessos;
	}
	
}
