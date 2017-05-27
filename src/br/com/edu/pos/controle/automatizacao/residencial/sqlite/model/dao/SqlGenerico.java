package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;

import br.com.edu.pos.controle.automatizacao.residencial.controller.AlterarGenerico;
import br.com.edu.pos.controle.automatizacao.residencial.controller.ConsultarGenerico;
import br.com.edu.pos.controle.automatizacao.residencial.controller.ExcluirGenerico;
import br.com.edu.pos.controle.automatizacao.residencial.controller.IncluirGenerico;

public class SqlGenerico extends JdbcDaoFactory{
	public IncluirGenerico inclusao = new IncluirGenerico();
	public ExcluirGenerico exclusao = new ExcluirGenerico();
	public AlterarGenerico alteracao  = new AlterarGenerico();
	public ConsultarGenerico consulta = new ConsultarGenerico();

}
