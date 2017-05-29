package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;
//Marcelo dos Santos Mariano
public class SqlGenerico extends JdbcDaoFactory{
	public IncluirGenerico inclusao = new IncluirGenerico();
	public ExcluirGenerico exclusao = new ExcluirGenerico();
	public AlterarGenerico alteracao  = new AlterarGenerico();
	public ConsultarGenerico consulta = new ConsultarGenerico();

}
