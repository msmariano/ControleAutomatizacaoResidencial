package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;
//Marcelo dos Santos Mariano
import java.text.ParseException;

public interface Sql {
	void salvar();
	void deletar();
	void consultar() throws ParseException;
	void modificar();

}
