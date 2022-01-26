package rpg.classes;

import rpg.enums.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Logica {
	static Scanner input = new Scanner(System.in);
	static TipoNivelEnum nivel;
	static PersonagemJogavel jogador;
	static Random random = new Random();

	public static String getJogador() {
		return jogador.toString();
	}

	public static int rolarDado(int facesDados) {
		return random.nextInt(facesDados) + 1;
	}

	public static void continuar() {
		System.out.println("Pressione ENTER para continuar...");
		input.nextLine();
	}

	public static void limpaConsole() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}

	public static int confirmaEscolha() {
		int confirmacao;
		try {
			confirmacao = Integer.parseInt(input.nextLine());
		} catch (Exception e) {
			confirmacao = 2;
			System.out.println("Por favor, digite um némero inteiro!");
		}
		return confirmacao;
	}

	public static void linhaSeparadora() {
		for (int i = 0; i < 100; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public static void criacaoPersonagem() {
		String nome = getNomePersonagem();
		TipoSexoEnum tipoSexo = getSexoPersonagem();
		TipoClasseEnum tipoClasse = getClassePersonagem();
		TipoArmaEnum tipoArma = getTipoArmaPersonagem(tipoClasse);
		TipoNivelEnum tipoNivel = getTipoNivelJogo();

		jogador = new PersonagemJogavel(nome, tipoSexo, tipoClasse, tipoArma);
		Logica.nivel = tipoNivel;
		System.out.println(jogador);
		continuar();
	}

	private static TipoNivelEnum getTipoNivelJogo() {
		int confirmacao;
		int nivel;
		TipoNivelEnum tipoNivel = null;
		do {
			System.out.println("Qual a dificuldade do jogo?");
			for (TipoNivelEnum nivelEnum : TipoNivelEnum.values()) {
				System.out.println(nivelEnum.ordinal() + ". " + nivelEnum);
			}
			try {
				nivel = Integer.parseInt(input.nextLine());
			} catch (Exception e) {
				nivel = TipoNivelEnum.values().length;
			}
			if (nivel >= TipoNivelEnum.values().length) {
				System.out.println("A opção escolhida é inválida!");
				confirmacao = 2;
			} else {
				tipoNivel = TipoNivelEnum.values()[nivel];
				System.out.println("A dificuldade do jogo é \"" + tipoNivel
						+ "\"? Aperte 1 para confirmar ou qualquer digito para escolher novamente.");
				confirmacao = confirmaEscolha();
			}
		} while (confirmacao != 1);
		return tipoNivel;
	}

	public static TipoArmaEnum getTipoArmaPersonagem(TipoClasseEnum tipoClasse) {
		int confirmacao;
		int arma;
		ArrayList<TipoArmaEnum> armasClasse = tipoClasse.getTipoArmaEnums();
		TipoArmaEnum tipoArma = null;
		do {
			System.out.println("Qual a arma do seu personagem?");
			for (TipoArmaEnum armaEnum : armasClasse) {
				System.out.println(armasClasse.indexOf(armaEnum) + ". " + armaEnum);
			}
			try {
				arma = Integer.parseInt(input.nextLine());
			} catch (Exception e) {
				arma = armasClasse.size();
			}
			if (arma >= armasClasse.size()) {
				System.out.println("A opção escolhida é inválida!");
				confirmacao = 2;
			} else {
				tipoArma = armasClasse.get(arma);
				System.out.println("A arma do seu personagem é \"" + tipoArma
						+ "\"? Aperte 1 para confirmar ou qualquer digito para escolher novamente.");
				confirmacao = confirmaEscolha();
			}
		} while (confirmacao != 1);
		return tipoArma;
	}

	public static TipoClasseEnum getClassePersonagem() {
		int confirmacao;
		int classe;
		TipoClasseEnum tipoClasse = null;
		do {
			System.out.println("Qual a classe do seu personagem?");
			for (TipoClasseEnum classeEnum : TipoClasseEnum.values()) {
				System.out.println(classeEnum.ordinal() + ". " + classeEnum);
			}
			try {
				classe = Integer.parseInt(input.nextLine());
			} catch (Exception e) {
				classe = TipoClasseEnum.values().length;
			}
			if (classe >= TipoClasseEnum.values().length) {
				System.out.println("A A opção escolhida é inválida!");
				confirmacao = 2;
			} else {
				tipoClasse = TipoClasseEnum.values()[classe];
				System.out.println("A classe do seu personagem é \"" + tipoClasse
						+ "\"? Aperte 1 para confirmar ou qualquer digito para escolher novamente.");
				confirmacao = confirmaEscolha();
			}
		} while (confirmacao != 1);
		return tipoClasse;
	}

	public static TipoSexoEnum getSexoPersonagem() {
		int confirmacao;
		int sexo = 0;
		TipoSexoEnum tipoSexo = null;
		do {
			System.out.println("Qual o sexo do seu personagem?");
			for (TipoSexoEnum sexoEnum : TipoSexoEnum.values()) {
				System.out.println(sexoEnum.ordinal() + ". " + sexoEnum);
			}
			try {
				sexo = Integer.parseInt(input.nextLine());
			} catch (Exception e) {
				sexo = TipoSexoEnum.values().length;
			}
			if (sexo >= TipoSexoEnum.values().length) {
				System.out.println("A opção escolhida é inválida!");
				confirmacao = 2;
			} else {
				tipoSexo = TipoSexoEnum.values()[sexo];
				System.out.println("O sexo do seu personagem é \"" + tipoSexo
						+ "\"? Aperte 1 para confirmar ou qualquer digito para escolher novamente.");
				confirmacao = confirmaEscolha();
			}
		} while (confirmacao != 1);

		return tipoSexo;
	}

	public static String getNomePersonagem() {
		int confirmacao;
		String nome;
		do {
			System.out.println("Qual o nome do seu personagem?");
			nome = input.nextLine();
			System.out.println("O nome do seu personagem é \"" + nome
					+ "\"? Aperte 1 para confirmar ou 2 para digitar um novo nome.");
			confirmacao = confirmaEscolha();
		} while (confirmacao != 1);
		return nome;
	}

	public static String getMotivacaoPersonagem() {
		int confirmacao;
		int motivacao;
		TipoMotivacaoEnum tipoMotivacao = null;
		do {
			System.out.println("Qual a motivação do seu personagem?");
			for (TipoMotivacaoEnum motivacaoEnum : TipoMotivacaoEnum.values()) {
				System.out.println(motivacaoEnum.ordinal() + ". " + motivacaoEnum.getMotivacao());
			}
			try {
				motivacao = Integer.parseInt(input.nextLine());
			} catch (Exception e) {
				motivacao = TipoMotivacaoEnum.values().length;
			}
			if (motivacao >= TipoMotivacaoEnum.values().length) {
				System.out.println("A Qual o nome do seu personagem?");
				confirmacao = 2;
			} else {
				tipoMotivacao = TipoMotivacaoEnum.values()[motivacao];
				System.out.println("A motivação do seu personagem é \"" + tipoMotivacao
						+ "\"? Aperte 1 para confirmar ou qualquer digito para escolher novamente.");
				confirmacao = confirmaEscolha();
			}
		} while (confirmacao != 1);
		jogador.setTipoMotivacao(tipoMotivacao);
		linhaSeparadora();
		return tipoMotivacao.getTextoMotivacao();
	}

	public static void atoTresSeguirOuDesistir() {
		int escolha;
		int confirmacao;
		do {
			Logica.linhaSeparadora();
			System.out.println("""
					O que você irá fazer?
					1. DESISTIR
					2. SEGUIR EM FRENTE""");

			try {
				escolha = Integer.parseInt(input.nextLine());
			} catch (Exception e) {
				escolha = 3;
			}

			if (escolha > 2 || escolha < 1) {
				System.out.println("A opção escolhida é inválida!");
				confirmacao = 2;
			} else {
				String acao = escolha == 1 ? "DESISTIR" : "SEGUIR EM FRENTE";
				System.out.println("você irá " + acao
						+ "? Aperte 1 para confirmar sua opção ou qualquer digito para escolher novamente.");
				confirmacao = confirmaEscolha();
			}
		} while (confirmacao != 1);

		if (escolha == 1) {
			Logica.linhaSeparadora();
			System.out.println(""
					+ "O medo invade o seu coração e você sente que ainda não está à altura do desafio. você se volta \n"
					+ "para a noite lá fora e corre em direção a segurança.");
			System.exit(0);
			return;
		}

		Logica.linhaSeparadora();
		System.out.println(""
				+ "você caminha, atento a todos os seus sentidos, por vários metros, até visualizar a frente uma fonte \n"
				+ "de luz, que você imagina ser a chama de uma tocha, vindo de dentro de uma porta aberta.");
	}

	public static void atoTresSaltarAndarOuCorrer() {
		int escolha;
		int confirmacao;
		do {
			System.out.println("""
					Como você irá passar pela porta?
					1. SALTANDO
					2. ANDANDO
					3. CORRENDO""");

			try {
				escolha = Integer.parseInt(input.nextLine());
			} catch (Exception e) {
				escolha = 4;
			}

			if (escolha > 3 || escolha < 1) {
				System.out.println("A opção escolhida é inválida!");
				confirmacao = 2;
			} else {
				System.out.println("Aperte 1 para confirmar sua opção ou qualquer digito para escolher novamente.");
				confirmacao = confirmaEscolha();
			}
		} while (confirmacao != 1);

		if (escolha == 1) {
			Logica.linhaSeparadora();
			System.out.println("""
					Você se concentra e pula em direção à luz, saltando de antes da porta até o interior da sala.""");
			return;
		}

		if (escolha == 2) {
			Logica.linhaSeparadora();
			System.out.println("""
					Você toma cuidado e vai caminhando vagarosamente em direção é luz. Quando você pisa exatamente
					embaixo da porta, você sente o chão ceder levemente, como se tivesse pisado em uma pedra solta.
					Você ouve um ruído de mecanismos se movimentando, e uma escotilha se abre no teto atrés de você,
					no corredor. Flechas voam da escotilha em sua direção, e você salta para dentro da sala, porém uma
					delas te acerta na perna.""");
			int danoRecebido = Logica.rolarDado(10);
			jogador.diminuirVida(danoRecebido);
			Logica.linhaSeparadora();
			System.out.println("você recebeu " + danoRecebido + " de dano!\n" + "Sua vida atual é de "
					+ jogador.getPontosDeVida() + " pontos de vida.");
			return;
		}

		Logica.linhaSeparadora();
		System.out.println(
				"""
						      você respira fundo e desata a correr em direção é sala. Quando passa pela porta, sente que pisou em uma
						      pedra solta, mas não dá muita importância e segue para dentro da sala, olhando ao redor à procura de inimigos.
							  não tem ninguém, mas você ouve sons de flechas batendo na pedra atrás de você, e quando se vira, vê várias flechas
						      no chão. Espiando pela porta, você entende que pisou em uma armadilha que soltou flechas de uma escotilha aberta no
						      teto, mas por sorte você entrou correndo e conseguiu escapar desse ataque surpresa.""");
	}

	public static void atoQuatroCombateArmeiro() {
		Combate combate = new Combate(Logica.jogador, new PersonagemNaoJogavel(TipoInimigoEnum.ARMEIRO));
		combate.iniciarCombate();
		System.out.println("""
				após derrotar o Armeiro, você percebe que seus equipamentos estão muito danificados, e olha
				em volta, encarando todas aquelas peças de armaduras resistentes e em ótimo estado.""");
		int confirmacao;
		int escolha;
		do {
			linhaSeparadora();
			System.out.println("""
					O que você desejar fazer?
					1. USAR ARMADURA DO INIMIGO
					2. SEGUIR EM FRENTE""");
			try {
				escolha = Integer.parseInt(input.nextLine());
			} catch (Exception e) {
				escolha = 3;
			}
			if (escolha > 2) {
				System.out.println("A opção escolhida é inválida!");
				confirmacao = 2;
			} else {
				String tipoEscolha = escolha == 1 ? "USAR ARMADURA DO INIMIGO" : "SEGUIR EM FRENTE";
				System.out.println("você irá \"" + tipoEscolha
						+ "\"? Aperte 1 para confirmar ou qualquer digito para escolher novamente.");
				confirmacao = confirmaEscolha();
			}
		} while (confirmacao != 1);
		linhaSeparadora();
		if (escolha == 1) {
			System.out.println("""
					você resolve usar os equipamentos do inimigo contra ele, e trocar algumas peças suas, que estavam\s
					danificadas, pelas peças de armaduras existentes na sala. De armadura nova, você se sente mais\s
					protegido para os desafios é sua frente.""");

			int pontosDeArmaduraAntes = jogador.getPontosDeArmadura();
			jogador.setPontosDeArmadura(pontosDeArmaduraAntes + 5);
			int pontosDeArmaduraDepois = jogador.getPontosDeArmadura();
			linhaSeparadora();
			System.out.println("Seus pontos de armadura subiram de " + pontosDeArmaduraAntes + " pontos para "
					+ pontosDeArmaduraDepois + " pontos!");
			linhaSeparadora();
			continuar();
			return;
		}

		System.out.println("você decide que não precisa utilizar nada que venha das mãos do inimigo.");
		linhaSeparadora();
		continuar();
	}

	public static void atoCincoCombateAlquimista() {
		Combate combate = new Combate(Logica.jogador, new PersonagemNaoJogavel(TipoInimigoEnum.ALQUIMISTA));
		combate.iniciarCombate();
		System.out.println(
				"""
						Após derrotar o Alquimista, você olha em volta, tentando reconhecer alguma poção do estoque do inimigo.\s
						Em uma mesa, você reconhece uma pequena garrafa de vidro contendo um líquido levemente rosado, pega a\s
						garrafa e pondera se deve beber um gole.""");
		int confirmacao;
		int escolha;
		do {
			linhaSeparadora();
			System.out.println("""
					O que você desejar fazer?
					1. BEBER A POÇÃO
					2. NÃO BEBER A POÇÃO E SEGUIR EM FRENTE""");
			try {
				escolha = Integer.parseInt(input.nextLine());
			} catch (Exception e) {
				escolha = 3;
			}
			if (escolha > 2) {
				System.out.println("A opção escolhida é inválida!");
				confirmacao = 2;
			} else {
				String tipoEscolha = escolha == 1 ? "BEBER A POÇÃO" : "não BEBER A POÇÃO E SEGUIR EM FRENTE";
				System.out.println("você irá \"" + tipoEscolha
						+ "\"? Aperte 1 para confirmar ou qualquer digito para escolher novamente.");
				confirmacao = confirmaEscolha();
			}
		} while (confirmacao != 1);
		linhaSeparadora();
		if (escolha == 1) {
			System.out.println("""
					Você se sente revigorado para seguir adiante!""");
			int pontosDeVidaAntes = jogador.getPontosDeVida();
			int pontosDeVidaClasse = jogador.getClasse().getPontosDeVida();
			jogador.setPontosDeVida(pontosDeVidaClasse);
			linhaSeparadora();
			System.out.println("Seus pontos de vida subiram de " + pontosDeVidaAntes + " pontos para "
					+ pontosDeVidaClasse + " pontos!");
			linhaSeparadora();
			continuar();
			return;
		}

		System.out.println("você fica receoso de beber algo produzido pelo inimigo.");
		linhaSeparadora();
		continuar();
	}

	public static void atoSeisCombateLider() {
		int confirmacao;
		int escolha;
		do {
			linhaSeparadora();
			System.out.println("""
					O que você desejar fazer?
					1. ESPERAR
					2. ATACAR""");
			try {
				escolha = Integer.parseInt(input.nextLine());
			} catch (Exception e) {
				escolha = 3;
			}
			if (escolha > 2) {
				System.out.println("A opção escolhida é inválida!");
				confirmacao = 2;
			} else {
				String tipoEscolha = escolha == 1 ? "ESPERAR" : "ATACAR";
				System.out.println("você irá \"" + tipoEscolha
						+ "\"? Aperte 1 para confirmar ou qualquer digito para escolher novamente.");
				confirmacao = confirmaEscolha();
			}
		} while (confirmacao != 1 || escolha == 1);

		Combate combate = new Combate(Logica.jogador, new PersonagemNaoJogavel(TipoInimigoEnum.LIDER));
		combate.iniciarCombate();
		continuar();
	}
}
