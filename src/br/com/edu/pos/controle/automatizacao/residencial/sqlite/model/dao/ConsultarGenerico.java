package br.com.edu.pos.controle.automatizacao.residencial.sqlite.model.dao;
//Marcelo dos Santos Mariano
import java.util.Collection;
import java.util.List;

public class ConsultarGenerico  extends JdbcDaoFactory {
	
	private Collection<Object> resultadoLinha;
	public String consultar(){
		
		ExtraiCamposValoresObj();	
		String filtro = " WHERE 1=1 ";
		
		for(int i=0;i<getCampo().size();i++){
			String valor = getValor().get(i);
			if(!valor.trim().equals("") &&  !valor.trim().equals("null") ){
				filtro = filtro +" AND "+  getCampo().get(i)+ " = \"" +valor+"\"";
			}
		}	
		
		String sql = "SELECT "+getCampos()+" FROM "+getTabela()+filtro;
		setResultadoLinha(executaConsulta(sql,getCampo()));
		
		return sql;		
	}
	public Collection<Object> getResultadoLinha() {
		return resultadoLinha;
	}
	public void setResultadoLinha(Collection<Object> resultadoLinha) {
		this.resultadoLinha = resultadoLinha;
	}

}
