package rpg.classes;

import lombok.Getter;
import lombok.Setter;
import rpg.enums.TipoArmaEnum;
import rpg.enums.TipoClasseEnum;
import rpg.enums.TipoSexoEnum;

@Getter
abstract public class Personagem {
	protected String nome;
	protected TipoSexoEnum sexo;
	protected TipoClasseEnum classe;
	@Setter
	protected int pontosDeVida;
	@Setter
	protected int pontosDeArmadura;
	protected int danoAtaque;
	protected TipoArmaEnum arma;
	protected String nomeArma;
	protected int danoArma;
	protected int danoTotal;

	public abstract void atacar(Combate combate);

	public void diminuirVida(int danoTotal) {
		this.pontosDeVida = pontosDeVida - danoTotal;
	}

	public boolean estaVivo() {
		return this.pontosDeVida > 0;
	}
}
