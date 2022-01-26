package rpg.classes;

import lombok.Getter;
import lombok.Setter;
import rpg.enums.*;

public class PersonagemJogavel extends Personagem {
	@Setter
	@Getter
	private TipoMotivacaoEnum tipoMotivacao;

	public PersonagemJogavel(String nome, TipoSexoEnum sexo, TipoClasseEnum classe, TipoArmaEnum arma) {
		this.nome = nome;
		this.sexo = sexo;
		this.pontosDeArmadura = classe.getPontosDeArmadura();
		this.pontosDeVida = classe.getPontosDeVida();
		this.danoAtaque = classe.getDanoAtaque();
		this.nomeArma = arma.getNomeArma();
		this.danoArma = arma.getDanoArma();
		this.classe = classe;
		this.arma = arma;
		this.danoTotal = this.danoArma + this.danoAtaque;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\nSexo: " + sexo + "\nClasse: " + classe + "\nPonto de Armadura: " + pontosDeArmadura
				+ "\nPonto de Vida: " + pontosDeVida + "\nDano de Ataque Classe: " + danoAtaque + "\nArma: " + arma
				+ "\nNome da Arma: " + nomeArma + "\nDano da Arma: " + danoArma + "\nDano Total: " + danoTotal;
	}

	public void fugir() {
		Logica.limpaConsole();
		System.out.println(""
				+ "Você não estava preparado para a força do inimigo, e decide fugir para que possa tentar novamente em uma próxima vez.");
		System.exit(0);
	}

	@Override
	public void atacar(Combate combate) {
		double modificadorDano = 1;
		if (Logica.nivel == TipoNivelEnum.DIFICIL) {
			modificadorDano = 0.9;
		}
		PersonagemJogavel atacante = combate.getJogador();
		PersonagemNaoJogavel defensor = combate.getInimigo();

		int rolagemDados = Logica.rolarDado(20);
		if (rolagemDados == 1) {
			System.out.println("Você errou seu ataque! O inimigo não sofreu dano algum.");
			return;
		}

		int danoTotal = (int) Math.round((rolagemDados + atacante.danoTotal) * modificadorDano);

		String mensagem = "Você acertou um ataque crítico! Você atacou com " + atacante.getNomeArma() + " e causou "
				+ danoTotal + " de dano ao inimigo!";

		if (rolagemDados < 20) {
			danoTotal = (int) Math.round((danoTotal - defensor.getPontosDeArmadura()) * modificadorDano);
			mensagem = "Você atacou com " + atacante.getNomeArma() + " e causou " + danoTotal + " de dano ao inimigo!";
		}

		if (danoTotal < defensor.getPontosDeArmadura()) {
			System.out.println("O seu golpe não foi suficiente para passar pela armadura do inimigo!");
			return;
		}

		defensor.diminuirVida(danoTotal);

		if (!defensor.estaVivo()) {
			mensagem = "O inimigo não é páreo para o seu heroísmo, e jaz imóvel aos seus pés.";
		}

		System.out.println(mensagem);
	}
}
