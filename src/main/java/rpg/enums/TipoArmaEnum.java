package rpg.enums;

import lombok.Getter;

@Getter
public enum TipoArmaEnum {
	MACHADO("Fúria de Sungjae", 12), ESPADA("Espada de Heimdall", 9), ADAGA("Estripador", 8), ARCO("Arco Recurvo", 10), VARINHA("Varinha da Ordem Nefalem", 11),
	CAJADO("Cajado do Mentor", 13);

	private final String nomeArma;
	private final int danoArma;

	TipoArmaEnum(String nomeArma, int danoArma) {
		this.nomeArma = nomeArma;
		this.danoArma = danoArma;
	}
}
