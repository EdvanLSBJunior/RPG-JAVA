package rpg.classes;

import rpg.enums.TipoInimigoEnum;
import rpg.enums.TipoNivelEnum;

public class PersonagemNaoJogavel extends Personagem {

	public PersonagemNaoJogavel(TipoInimigoEnum personagem) {
		this.nome = personagem.getNome();
		this.sexo = personagem.getSexo();
		this.pontosDeVida = personagem.getPontosDeVida();
		this.danoArma = personagem.getTipoArmaEnum().getDanoArma();
		this.pontosDeArmadura = personagem.getPontosDeArmadura();
		this.danoAtaque = personagem.getDanoAtaque();
		this.danoTotal = this.danoArma + this.danoAtaque;
	}

	@Override
	public void atacar(Combate combate) {
		double modificadorDano = 1;
		if (Logica.nivel == TipoNivelEnum.FACIL) {
			modificadorDano = 0.8;
		}

		PersonagemNaoJogavel atacante = combate.getInimigo();
		PersonagemJogavel defensor = combate.getJogador();

		int rolagemDados = Logica.rolarDado(20);
		if (rolagemDados == 1) {
			System.out.println("O inimigo errou o ataque! Você não sofreu dano.");
			return;
		}
		String mensagem = null;
		if (rolagemDados == 20) {
			int danoTotal = (int) ((rolagemDados + atacante.danoTotal) * modificadorDano);
			defensor.diminuirVida(danoTotal);
			mensagem = "O inimigo acertou um ataque crítico! Você sofreu " + danoTotal + " e agora possui "
					+ defensor.getPontosDeVida() + " pontos de vida.";
		}

		if (rolagemDados < 20) {
			danoTotal = (int) Math.floor((danoTotal - defensor.getPontosDeArmadura()) * modificadorDano);
			defensor.diminuirVida(danoTotal);
			mensagem = "O inimigo atacou! Você sofreu " + danoTotal + " de dano e agora possui "
					+ defensor.getPontosDeVida() + " pontos de vida.";
		}

		if (danoTotal < defensor.getPontosDeArmadura()) {
			System.out.println("O golpe do inimigo não foi o sufuciente para passar pela sua armadura!");
			return;
		}

		defensor.diminuirVida(danoTotal);

		if (!defensor.estaVivo()) {
			System.out.println("Você não estava preparado para a força do inimigo. \n"
					+ defensor.getTipoMotivacao().getMensagemMorte());
			System.exit(0);
		}

		System.out.println(mensagem);
	}
}
