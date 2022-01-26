package rpg.classes;

import lombok.Getter;
//import rpg.enums.TipoNivelEnum;

@Getter
public class Combate {
	public PersonagemJogavel jogador;
	public PersonagemNaoJogavel inimigo;

	public Combate(PersonagemJogavel jogador, PersonagemNaoJogavel inimigo) {
		this.jogador = jogador;
		this.inimigo = inimigo;
	}

	public void acoesJogadorCombate() {
		Logica.linhaSeparadora();

		int escolha;
		int confirmacao;
		do {
			System.out.println("""
					O que você deseja fazer?
					1. ATACAR
					2. FUGIR""");
			try {
				escolha = Integer.parseInt(Logica.input.nextLine());
			} catch (Exception e) {
				escolha = 3;
			}

			if (escolha > 2 || escolha < 1) {
				System.out.println("A opção escolhida é inválida!");
				confirmacao = 2;
			} else {
				String acao = escolha == 1 ? "ATACAR" : "FUGIR";
				System.out.println("Você irá " + acao
						+ "? Aperte 1 para confirmar sua ação ou qualquer digito para escolher novamente.");
				confirmacao = Logica.confirmaEscolha();
			}
		} while (confirmacao != 1);

		if (escolha == 2) {
			Logica.linhaSeparadora();
			jogador.fugir();
			return;
		}

		Logica.linhaSeparadora();
		jogador.atacar(this);
		Logica.linhaSeparadora();
	}

	public void iniciarCombate() {
		boolean jogadorComecaPrimeiro = jogadorComecaPrimeiro();
		do {
			if (jogadorComecaPrimeiro) {
				acoesJogadorCombate();
				inimigo.atacar(this);
			} else {
				inimigo.atacar(this);
				acoesJogadorCombate();
			}
		} while (inimigo.estaVivo());
	}

	public boolean jogadorComecaPrimeiro() {
		int iniciativaJogador = Logica.rolarDado(20);
		int iniciativaInimigo = Logica.rolarDado(20);

		return iniciativaJogador > iniciativaInimigo;
	}
}
