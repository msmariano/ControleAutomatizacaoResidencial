package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;

import java.text.ParseException;

public interface Sql {
	void salvar();
	void deletar();
	void consultar() throws ParseException;
	void modificar();

}
