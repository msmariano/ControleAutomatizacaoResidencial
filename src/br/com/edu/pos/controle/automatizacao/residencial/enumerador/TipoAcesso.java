package br.com.edu.pos.controle.automatizacao.residencial.enumerador;
//Marcelo dos Santos Mariano
public enum TipoAcesso {
	SOCIAL(1,"Social",true),PERMANENTE(2,"Permanente",true),SERVICO(3,"Servico",true),NENHUM(4,"Nenhum",true);
	
	private final Integer valor;
	private final String descricao;
	private final Boolean mostrar; 
	
	TipoAcesso(Integer valor,String descricao,Boolean mostrar){
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
		TipoAcesso[] elementos = values();
        for (TipoAcesso enumTipoAcesso: elementos) {
            if (enumTipoAcesso.getValor().equals(valor)) {
                return enumTipoAcesso.getDescricao();
            }
        }
        return "";
    }

    public static Integer getValor(String descricao) {
    	TipoAcesso[] elementos = values();
        for (TipoAcesso enumTipoAcesso : elementos) {
            if (enumTipoAcesso.getDescricao().equals(descricao)) {
                return enumTipoAcesso.getValor();
            }
        }
        return null;

    }
    
    public static TipoAcesso getTipo(String descricao) {
    	TipoAcesso[] elementos = values();
        for (TipoAcesso enumTipoUsuario : elementos) {
            if (enumTipoUsuario.getDescricao().equals(descricao)) {
            	
            	switch (enumTipoUsuario.getValor())
            	{
            	case 1:
            		return TipoAcesso.SOCIAL;
            	case 2:
            		return TipoAcesso.PERMANENTE;
            	case 3:
            		return TipoAcesso.SERVICO;
            	default:
            		return TipoAcesso.NENHUM;
            	}
            }
        }
        return null;

    }
    
    
	public Boolean getMostrar() {
		return mostrar;
	}
}
