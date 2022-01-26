package rpg.enums;

import lombok.Getter;

@Getter
public enum TipoNivelEnum {
	FACIL(1), MEDIO(2), DIFICIL(3);

	private final int nivel;

	TipoNivelEnum(int nivel) {
		this.nivel = nivel;
	}
}
