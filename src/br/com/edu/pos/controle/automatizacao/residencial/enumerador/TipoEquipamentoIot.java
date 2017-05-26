package br.com.edu.pos.controle.automatizacao.residencial.enumerador;

public enum TipoEquipamentoIot {
	
	ACESSO(1,"Acesso",true),LEITURA(2,"Leitura",true),AUTOMATIZADOR(3,"Controle",true);
	
	private final Integer valor;
	private final String descricao;
	private final Boolean mostrar; 
	
	TipoEquipamentoIot(Integer valor,String descricao,Boolean mostrar){
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
		TipoEquipamentoIot[] elementos = values();
        for (TipoEquipamentoIot enumTipoEquipamentoIot: elementos) {
            if (enumTipoEquipamentoIot.getValor().equals(valor)) {
                return enumTipoEquipamentoIot.getDescricao();
            }
        }
        return "";
    }

    public static Integer getValor(String descricao) {
    	TipoEquipamentoIot[] elementos = values();
        for (TipoEquipamentoIot enumTipoEquipamentoIot : elementos) {
            if (enumTipoEquipamentoIot.getDescricao().equals(descricao)) {
                return enumTipoEquipamentoIot.getValor();
            }
        }
        return null;

    }
	public Boolean getMostrar() {
		return mostrar;
	}

}
