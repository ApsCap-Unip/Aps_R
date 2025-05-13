package Historia;

import java.util.Scanner;

import Personagem.Personagem;

public class Historia {
	private Personagem personagem;
    private Scanner scanner;

    public Historia(Personagem personagem) {
        this.personagem = personagem;
        this.scanner = new Scanner(System.in);
    }

    public void iniciarDia(int dia) {
        if (dia == 1) {
        	System.out.println("Digite seu nome:");
        	personagem.setNome(scanner.next());
            System.out.println("Bom dia, "+ personagem.getNome() +"! O alarme toca e você acorda com dificuldade.");
            System.out.println("Você olha para o relógio: 7h15. Tem tempo, mas só se for rápido.");
        } else {
            System.out.println("\nO segundo dia começa. Você sente o peso das escolhas de ontem.");
            System.out.println("O relógio marca 7h10. Ainda dá tempo de se organizar.");
        }
        cenaCafe(dia);
    }

    public void cenaCafe(int dia) {
    	boolean controlador = true;
    	while (controlador) {
    		try {
				System.out.println("\nVocê vai até a cozinha. Tem pão, café fresco e frutas.");
		        System.out.println("Sua mãe pergunta: \"Vai tomar café hoje, " + personagem.getNome() + "?\"");
		        System.out.println("1 - Sim, café da manhã completo.");
		        System.out.println("2 - Não, estou atrasado.");
		        int escolha = scanner.nextInt();
		        if (escolha == 1) {
		            personagem.tomarCafe(dia);
		            System.out.println("Você se senta e aproveita um café nutritivo. Isso deve ajudar no foco.");
		            controlador = false;
		        } else if(escolha == 2) {
		            System.out.println("Você sai com o estômago vazio. Espera aguentar até o almoço.");
		            controlador = false;
		        } else {
		        	System.out.println("Digite um número entre as opções.");
		        	continue;
		        }
		        cenaTransporte(dia);
    		} catch (NumberFormatException e) {
				System.out.println("Digite um número entre as opções. Erro: " + e);
			}
    	}
       
    }

    public void cenaTransporte(int dia) {
    	boolean controlador = true;
    	while (controlador) {
    		try {
    			System.out.println("\nNa porta de casa, você pensa em como ir ao trabalho hoje.");
    	        System.out.println("1 - De carro (mais rápido, mas poluente)");
    	        System.out.println("2 - Bicicleta ou metrô (mais ecológico)");
    	        int escolha = scanner.nextInt();
    	        if (escolha == 2) {
    	            personagem.setEscolhaAmbiental(dia);
    	            System.out.println("Você sente o vento no rosto e vê a cidade com outros olhos.");
    	            if (dia == 2) {
    	                System.out.println("Uma colega comenta: \"Vi que você veio de bike hoje. Inspirador!\"");
    	            }
    	            controlador = false;
    	        } else if (escolha == 1){
    	            System.out.println("Você entra no carro e pega trânsito intenso.");
    	            System.out.println("O rádio toca uma notícia sobre mudanças climáticas. Você se sende mal por contribuir com a poluição no meio ambiente.");
    	            controlador = false;
    	        } else {
    	        	System.out.println("Digite um número entre as opções.");
		        	continue;
    	        }
    	        cenaTrabalho(dia);
    		} catch (NumberFormatException e) {
    			System.out.println("Digite um número entre as opções. Erro: " + e);
			}
    	}
        
    }

    public void cenaTrabalho(int dia) {
    	boolean controlador = true;
    	while(controlador) {
    		try {
    			System.out.println("\nNo escritório, você encontra seus colegas conversando.");
		        System.out.println("Colega: \"Ei, " + personagem.getNome() + ", vamos ter uma reunião sobre novas práticas sustentáveis. Vem com a gente?\"");
		        System.out.println("1 - Participar e dar ideias");
		        System.out.println("2 - Ignorar e continuar trabalhando");
		        int escolha = scanner.nextInt();
		        if (escolha == 1) {
		            personagem.setEscolhaAmbiental(dia);
		            System.out.println("Você compartilha ideias sobre coleta seletiva e economia de energia.");
		            System.out.println("Chefe: \"Muito bom! Podemos incluir isso nas metas trimestrais.\"");
		            controlador = false;
		        } else if(escolha == 2) {
		            System.out.println("Você finge estar ocupado. Mais tarde ouve comentários sobre a importância da reunião. Você pensa: (Eu deveria me empenhar mais...)");
		            controlador = false;
		        } else {
		        	System.out.println("Digite um número entre as opções.");
		        	continue;
		        }
		        if (dia == 1) {
		            iniciarDia(2);
		        } else {
		            eventoFinal();
		            finalizar();
		        }
    		}catch(NumberFormatException e) {
    			System.out.println("Digite um número entre as opções. Erro: " + e);
    		}
    	}
       
    }

    public void eventoFinal() {
        System.out.println("\nNo fim do segundo dia, há uma grande reunião com todos os setores.");
        if (!personagem.tomouCafe(1) && !personagem.tomouCafe(2)) {
            System.out.println("Durante a reunião, você começa a suar frio. Sua visão escurece e você desmaia.");
            System.out.println("Mais tarde, no ambulatório, o médico diz: \"Seu corpo está cobrando a falta de cuidados. Precisa se alimentar melhor.\"");
        } else {
            System.out.println("Você acompanha a reunião com atenção.");
            System.out.println("Quando mencionam projetos ambientais, você é lembrado por sua participação.");
        }
    }

    public void finalizar() {
        int scoreAmb = personagem.getPontuacaoAmbiental();
        int scoreSaude = personagem.getPontuacaoSaude();

        System.out.println("\n=== Final da História ===");

        if (scoreAmb == 2 && scoreSaude == 2) {
            System.out.println("Final Bom: Você se destacou no trabalho, lidera o projeto ambiental e sente-se bem consigo mesmo.");
        } else if (scoreAmb >= 1 && scoreSaude >= 1) {
            System.out.println("Final Neutro: Sua semana foi razoável, com altos e baixos, mas você está no caminho certo.");
        } else {
            System.out.println("Final Ruim: Você foi desligado da empresa e se sente cansado e desconectado. Talvez seja hora de rever suas escolhas.");
        }
    }
}
