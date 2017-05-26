package br.com.edu.pos.controle.automatizacao.residencial.enumerador;

public enum TipoUsuario {
	VISITANTE(1,"Visitante",true),EQUIPAMENTOIOT(2,"EquipamentoIot",true),ACESSO(3,"Acesso",true),MORADOR(4,"Morador",true) ;
	
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
            if (enumTipoUsuario.getDescricao().equals(descricao)) {
                return enumTipoUsuario.getValor();
            }
        }
        return null;

    }
	public Boolean getMostrar() {
		return mostrar;
	}
	
}
