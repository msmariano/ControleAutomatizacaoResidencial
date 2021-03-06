package br.com.edu.pos.controle.automatizacao.residencial.enumerador;
//Marcelo dos Santos Mariano
public enum TipoUsuario  {
	VISITANTE(1,"Visitante",true),EQUIPAMENTOIOT(2,"EquipamentoIot",true),ACESSO(3,"Acesso",true),MORADOR(4,"Morador",true),NENHUM(-1,"Nenhum",true) ;
	
	private final Integer valor;
	private final String descricao;
	private final Boolean mostrar; 
	
	TipoUsuario(Integer valor,String descricao,Boolean mostrar){
		this.descricao = descricao;
		this.valor = valor;
		this.mostrar = mostrar;
	}
	
	public Integer getValor() {
        return valor;
    }

    public String getDescricao() {
        return this.descricao;
    }
    
     	
	public static String getNome(Integer valor) {
		TipoUsuario[] elementos = values();
        for (TipoUsuario enumTipoUsuario: elementos) {
            if (enumTipoUsuario.getValor().equals(valor)) {
                return enumTipoUsuario.getDescricao();
            }
        }
        return "";
    }
	
	public static Integer getValor(String descricao) {
    	TipoUsuario[] elementos = values();
        for (TipoUsuario enumTipoUsuario : elementos) {
            if (enumTipoUsuario.getDescricao().toLowerCase().equals(descricao.toLowerCase())) {
                return enumTipoUsuario.getValor();
            }
        }
        return null;

    }

    public static TipoUsuario getTipo(String descricao) {
    	TipoUsuario[] elementos = values();
        for (TipoUsuario enumTipoUsuario : elementos) {
            if (enumTipoUsuario.getDescricao().equals(descricao)) {
            	
            	switch (enumTipoUsuario.getValor())
            	{
            	case 1:
            		return TipoUsuario.VISITANTE;
            	case 2:
            		return TipoUsuario.EQUIPAMENTOIOT;
            	case 3:
            		return TipoUsuario.ACESSO;
            	case 4:
            		return TipoUsuario.MORADOR;
            	default:
            		return TipoUsuario.NENHUM;
            	}
            }
        }
        return null;

    }
	public Boolean getMostrar() {
		return mostrar;
	}
	
}
