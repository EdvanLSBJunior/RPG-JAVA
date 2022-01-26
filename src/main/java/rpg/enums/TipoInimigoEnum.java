package rpg.enums;

import lombok.Getter;

@Getter
public enum TipoInimigoEnum {
	ARMEIRO("ORQUE ARMEIRO", TipoSexoEnum.MASCULINO, 90, 15, 10, TipoArmaEnum.ESPADA),
	ALQUIMISTA("ORQUE ALQUIMISTA", TipoSexoEnum.MASCULINO, 70, 10, 10, TipoArmaEnum.CAJADO),
	LIDER("ORQUE LIDER", TipoSexoEnum.MASCULINO, 100, 15, 12, TipoArmaEnum.MACHADO);

	private final String nome;
	private final TipoSexoEnum sexo;
	private final int pontosDeVida;
	private final int pontosDeArmadura;
	private final int danoAtaque;
	private final TipoArmaEnum tipoArmaEnum;

	TipoInimigoEnum(String nome, TipoSexoEnum sexo, int pontosDeVida, int pontosDeArmadura, int danoAtaque,
			TipoArmaEnum tipoArmaEnum) {
		this.nome = nome;
		this.sexo = sexo;
		this.pontosDeVida = pontosDeVida;
		this.pontosDeArmadura = pontosDeArmadura;
		this.danoAtaque = danoAtaque;
		this.tipoArmaEnum = tipoArmaEnum;
	}
}
