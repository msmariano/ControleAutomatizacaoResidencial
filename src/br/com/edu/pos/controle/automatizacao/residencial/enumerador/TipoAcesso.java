package br.com.edu.pos.controle.automatizacao.residencial.enumerador;

public enum TipoAcesso {
	SOCIAL(1,"Temporario",true),PERMANENTE(2,"Permanente",true),SERVICO(3,"Servico",true);
	
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
	public Boolean getMostrar() {
		return mostrar;
	}
}
