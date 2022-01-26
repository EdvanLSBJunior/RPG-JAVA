package rpg.enums;

import lombok.Getter;

@Getter
public enum TipoMotivacaoEnum {
    VINGANCA("VINGANÇA",
            """
                    Imagens daquela noite trágica invadem sua mente. você nem precisa se esfor�ar para lembrar,
                     pois essas memórias estão sempre presentes, mesmo que de pano de fundo, quando você tem outros
                     pensamentos em foco, elas nunca o deixaram. Elas são o combust�vel que te fizeram chegar até aqui.
                     E você sabe que não irá desistir até ter vingado a morte daqueles que foram - e pra sempre serão
                     - sua fonte de amor e desejo de continuar vivo. O maldito líder finalmente pagará por tanto mal
                     causado na vida de tantos (e principalmente na sua).""",
            "não foi possível concluir sua vingança, e agora resta saber se alguém se vingará por você.",
            "você obteve sua vingança. você se ajoelha e cai no choro, invadido por uma sensação de alívio e\n" +
                    "felicidade. você se vingou, tudo que sempre quis, estão feito. Agora você pode seguir sua vida."),

    GLORIA("GLÓRIA",
            """
                    você já consegue visualizar na sua mente o povo da cidade te recebendo de braços abertos,
                    bardos criando canções sobre seus feitos heróicos, nobres te presenteando com jáias e
                    diversas riquezas, taberneiros se recusando a cobrar por suas bebedeiras e comilan�as.
                    Desde já, você sente o amor do público, te louvando a cada passo que dá pelas ruas,
                    depois de destruir o vilão que tanto assombrou a paz de todos. Porém, você sabe que
                    ainda falta o último ato dessa história. você se concentra na missão. A glória o
                    aguarda, mas não antes da última batalha.""",
            "A glória que buscavas não será sua, e a cidade aguarda por seu(sua) próximo(a) herói(na).",
            "O êxtase em que você se encontra não cabe dentro de si. você se ajoelha e grita de alegria. A glória o aguarda, você a conquistou.");

    private final String motivacao;
    private final String textoMotivacao;
    private final String mensagemMorte;
    private final String mensagemVitoria;


    TipoMotivacaoEnum(String motivacao, String textoMotivacao, String mensagemMorte, String mensagemVitoria) {
        this.motivacao = motivacao;
        this.textoMotivacao = textoMotivacao;
        this.mensagemMorte = mensagemMorte;
        this.mensagemVitoria = mensagemVitoria;
    }


	public String getTextoMotivacao() {
		return this.textoMotivacao;
	}


}
