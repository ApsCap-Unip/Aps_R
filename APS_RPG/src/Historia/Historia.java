package Historia;

import java.util.InputMismatchException;
import java.util.Scanner;
import D20.D20;

import Personagem.Personagem;

public class Historia {
	private D20 dado = new D20();
    private Personagem personagem;
    private Scanner scanner;
    private int vezesDeCarro = 0;

    public Historia(Personagem personagem) {
        this.personagem = personagem;
        this.scanner = new Scanner(System.in);
    }

    public void iniciarDia(int dia) {
        if (dia == 1) {
            System.out.println("Digite seu nome:");
            personagem.setNome(scanner.nextLine());
            System.out.println("Bom dia, " + personagem.getNome() + "! O alarme toca e você acorda com dificuldade.");
            System.out.println("Você olha para o relógio: 7h15. Tem tempo, mas só se for rápido.");
        } else {
            System.out.println("\nO segundo dia começa. Você sente o peso das escolhas de ontem.");
            System.out.println("O relógio marca 7h10. Ainda dá tempo de se organizar.");
        }
        cenaHigiene(dia);
    }

    public void cenaHigiene(int dia) {
    	int escolha;
    	int resultado;
        while (true) {
            try {
                System.out.println("\nVocê se dirige ao banheiro para escovar os dentes.");
                System.out.println("Enquanto escova, você pensa: \"Deixo a torneira aberta ou não?\"");
                System.out.println("1 - Fechar a torneira para economizar água");
                System.out.println("2 - Deixar a torneira aberta para poupar tempo");
                
                escolha = scanner.nextInt();
                resultado = dado.rolarD20();
                
                if (escolha == 1 && resultado >= 10 && resultado <= 15) {
                	System.out.println("\n🎲 Você rolou um D20 para pontencialiazar sua escolha... Resultado: " + resultado);
                    personagem.adicionarEscolhaAmbientalExtra(1); 
                    System.out.println("Você fecha a torneira, consciente da importância de economizar água.");
                    break;
                } else if (escolha == 1 && resultado > 15) {
                	System.out.println("\n🎲 Você rolou um D20 para pontencialiazar sua escolha... Resultado: " + resultado);
                	personagem.adicionarEscolhaAmbientalExtra(3); 
                	personagem.adicionarTempoEconomizado(2);
                    System.out.println("Você fecha a torneira com excelência, consciente da importância de economizar água. Conseguiu economizar tempo por causa de sua maestria");
                    break;
                } else if (escolha == 1 && resultado < 10) {
                	personagem.adicionarTempoEconomizado(-2);
                	System.out.println("\n🎲 Você rolou um D20 para pontencialiazar sua escolha... Resultado: " + resultado);
                	System.out.println("Você falha em fechar a torneira e ela se quebra em sua mão inundando o banheiro. Você perde tempo consertando a torneira.");
                	break;
                } else if (escolha == 2) {
                    personagem.adicionarEscolhaNaoEcologica();
                    personagem.adicionarTempoEconomizado(2);
                    System.out.println("Você deixa a torneira aberta para ganhar alguns minutos. A água corre desnecessariamente.");
                    break;
               
                }
                 else {
                    System.out.println("Escolha uma opção válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite um número válido.");
                scanner.nextInt();
            }
        }
        cenaCafe(dia);
    }

    public void cenaCafe(int dia) {
    	int escolha;
    	int resultado;
        while (true) {
            try {
                System.out.println("\nNa cozinha, sua mãe pergunta: \"Vai tomar café hoje, " + personagem.getNome() + "?\"");
                System.out.println("1 - Sim, café da manhã completo.");
                System.out.println("2 - Não, estou atrasado.");
                
                escolha = scanner.nextInt();
            	resultado = dado.rolarD20();
              
                
                
                if (escolha == 1  && resultado >= 10 && resultado <= 15) {
                	System.out.println("\n🎲 Você rolou um D20 para pontencialiazar sua escolha... Resultado: " + resultado);
                    personagem.tomarCafe(dia);
                    System.out.println("Você se senta e saboreia um café nutritivo.");
                    break;
                } else if (escolha == 1 && resultado > 15) {
                	System.out.println("\n🎲 Você rolou um D20 para pontencialiazar sua escolha... Resultado: " + resultado);
                	personagem.tomarCafe(dia);
                	System.out.println("Você se senta e saboreia um café nutritivo. Você se sente cheio de energia e compreende como é bom cuidar do próprio corpo.");
                	break;
                } else if(escolha == 1 && resultado < 10) {
                	System.out.println("\n🎲 Você rolou um D20 para pontencialiazar sua escolha... Resultado: " + resultado);
                	personagem.adicionarTempoEconomizado(5);
                	System.out.println("Você queima a sua boca enquanto tomava um café recém coado. Você desiste de tomar café.");
                	break;
                }
                else if (escolha == 2) {
                    personagem.adicionarTempoEconomizado(5);
                    System.out.println("Você sai às pressas, sem se alimentar.");
                    break;
                } 
                 else {
                    System.out.println("Escolha uma opção válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite um número válido.");
                scanner.nextInt();
            }
        }
        cenaEnergia(dia);
    }
    
    public void cenaEnergia(int dia) {
        while (true) {
            try {
                System.out.println("\nAntes de sair de casa, você percebe os aparelhos eletrônicos ligados.");
                System.out.println("1 - Desligar tudo da tomada (consciência ambiental)");
                System.out.println("2 - Deixar em stand-by para ser mais rápido");
                int escolha = scanner.nextInt();
                if (escolha == 1) {
                    personagem.adicionarEscolhaAmbientalExtra(1); 
                    System.out.println("Você desliga tudo, lembrando da importância de economizar energia.");
                    break;
                } else if (escolha == 2) {
                    personagem.adicionarEscolhaNaoEcologica();
                    personagem.adicionarTempoEconomizado(3);
                    System.out.println("Você escolhe a praticidade e deixa tudo em stand-by.");
                    break;
                } else {
                    System.out.println("Escolha uma opção válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite um número válido.");
                scanner.nextInt();
            }
        }
        cenaTransporte(dia);
    }

    
    public void cenaTransporte(int dia) {
    	int escolha;
    	int resultado;
        while (true) {
            try {
                System.out.println("\nNa porta de casa, você pensa em como ir ao trabalho hoje.");
                System.out.println("1 - De carro (mais rápido, mas poluente)");
                System.out.println("2 - Bicicleta ou metrô (mais ecológico)");
                
                escolha = scanner.nextInt();
                resultado = dado.rolarD20();
                
                if (escolha == 1) {
                    personagem.adicionarEscolhaNaoEcologica();
                    personagem.adicionarTempoEconomizado(10);
                    vezesDeCarro++;
                    System.out.println("Você entra no carro e encara o trânsito, mesmo sabendo do impacto ambiental. \nO rádio toca uma notícia sobre mudanças climáticas. Você se sende mal por contribuir com a poluição no meio ambiente.");
                    break;
                } else if (escolha == 2 && resultado >= 10 && resultado <= 15) {
                	System.out.println("\n🎲 Você rolou um D20 para pontencialiazar sua escolha... Resultado: " + resultado);
                    personagem.setEscolhaAmbiental(dia);
                    System.out.println("Você escolhe uma opção sustentável e sente-se bem com isso.");
                    break;
                } else if (escolha == 2 && resultado > 15) {
                	System.out.println("\n🎲 Você rolou um D20 para pontencialiazar sua escolha... Resultado: " + resultado);
                	personagem.adicionarTempoEconomizado(10);
                	personagem.setEscolhaAmbiental(dia);
                	System.out.println("Você escolhe uma opção sustentável e sente-se bem com isso. Você olha em volta e vê o trânsito na cidade e pens: \"Que bom que não fui de carro hoje\"");
                	System.out.println("Você sente o vento no rosto e vê a cidade com outros olhos.");
                	break;
                } else if (escolha == 2 && resultado < 10) {
                	System.out.println("\n🎲 Você rolou um D20 para pontencialiazar sua escolha... Resultado: " + resultado);
                	personagem.adicionarTempoEconomizado(-5);
                	personagem.setEscolhaAmbiental(dia);
                	System.out.println("Você escolhe uma opção sustentável e sente-se bem com isso, mas antes de sair acaba tropeçando e caindo. você perdeu tempo tendo que troca de roupa.");
                	break;
                }
                else {
                    System.out.println("Escolha uma opção válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite um número válido.");
                scanner.nextInt();
            }
        }
        cenaPlastico(dia);
    }
    
    public void cenaPlastico(int dia) {
        while (true) {
            try {
                System.out.println("\nNo caminho, você precisa se hidratar.");
                System.out.println("1 - Usar sua garrafa reutilizável");
                System.out.println("2 - Comprar uma garrafa plástica descartável");
                int escolha = scanner.nextInt();
                if (escolha == 1) {
                    personagem.adicionarEscolhaAmbientalExtra(1); 
                    System.out.println("Você utiliza sua garrafa reutilizável, evitando desperdícios.");
                    break;
                } else if (escolha == 2) {
                    personagem.adicionarEscolhaNaoEcologica();
                    personagem.adicionarTempoEconomizado(2);
                    System.out.println("Você compra uma garrafinha plástica, optando pela conveniência.");
                    break;
                } else {
                    System.out.println("Escolha uma opção válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite um número válido.");
                scanner.nextInt();
            }
        }
        cenaAlmoco(dia);
    }

    public void cenaAlmoco(int dia) {
        while (true) {
            try {
                System.out.println("\nNa hora do almoço, surge a dúvida:");
                System.out.println("1 - Levar marmita de casa (saudável e sustentável)");
                System.out.println("2 - Comprar fast food (rápido, mas nada saudável)");
                System.out.println("3 - Comprar comida local (apoiar o comércio da região)");
                int escolha = scanner.nextInt();
                if (escolha == 1) {
                    personagem.setEscolhaAmbiental(dia);
                    personagem.tomarCafe(dia);
                    System.out.println("Sua marmita te faz sentir-se bem física e ecologicamente.");
                    break;
                } else if (escolha == 2) {
                    personagem.adicionarEscolhaNaoEcologica();
                    personagem.adicionarTempoEconomizado(10);
                    System.out.println("Você opta pelo fast food pela praticidade, deixando de lado a saúde e o meio ambiente.");
                    break;
                } else if (escolha == 3) {
                    personagem.setEscolhaAmbiental(dia);
                    System.out.println("Você apoia pequenos produtores com sua escolha consciente.");
                    break;
                } else {
                    System.out.println("Escolha uma opção válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite um número válido.");
                scanner.nextInt();
            }
        }
        cenaTrabalho(dia);
    }



    public void cenaTrabalho(int dia) {
    	while(true) {
    		try {
    			System.out.println("\nNo escritório, seus colegas conversam sobre iniciativas ambientais.");
		        System.out.println("Colega: \"Ei, " + personagem.getNome() + ", vamos ter uma reunião sobre novas práticas sustentáveis. Vem com a gente?\"");
		        System.out.println("1 - Participar e dar ideias");
		        System.out.println("2 - Ignorar e continuar trabalhando");
		        int escolha = scanner.nextInt();
		        if (escolha == 1) {
		            personagem.setEscolhaAmbiental(dia);
		            System.out.println("Você compartilha ideias sobre coleta seletiva e economia de energia.");
		            System.out.println("Chefe: \"Muito bom! Podemos incluir isso nas metas trimestrais.\"");
		            break;
		        } else if(escolha == 2) {
		            System.out.println("Você finge estar ocupado. Mais tarde ouve comentários sobre a importância da reunião\n. Você pensa: \"Eu deveria me empenhar mais...\"");
		            System.out.println("Você escuta, refletindo sobre suas próprias atitudes.");
		            break;
		        } else {
		        	System.out.println("Digite um número entre as opções.");
		        	continue;
		        }
    		}catch(InputMismatchException e) {
    			System.out.println("Digite um número entre as opções. Erro: " + e);
    		}
    	}
        if(dia == 1) {
        	iniciarDia(2);
        } else {
        	 eventoFinal();
	         finalizar();
        }
       
    }

    public void eventoFinal() {
        if (vezesDeCarro == 2) {
            System.out.println("\nAviso: Devido ao uso frequente do carro, a pintura foi corroída por chuva ácida.");
        }
        System.out.println("\nNo fim do segundo dia, há uma grande reunião com todos os setores.");
        if (!personagem.tomouCafe(1) && !personagem.tomouCafe(2)) {
        	 System.out.println("Durante a reunião, você começa a suar frio. Sua visão escurece e você desmaia.");
             System.out.println("Mais tarde, no ambulatório, o médico diz: \"Seu corpo está cobrando a falta de cuidados. Precisa se alimentar melhor.\"");
             System.out.println("Seu chefe fica descontente e diz: \"Você deveria se cuidar mais, espero que esse ocorrido não venha a se repetir./");
         } else {
        	 System.out.println("Você acompanha a reunião com atenção.");
             System.out.println("Quando mencionam projetos ambientais, você é lembrado por sua participação.");
        }
    }

    public void finalizar() {
        System.out.println("\n=== Resultado Final ===");
        System.out.println("Você fez " + personagem.getEscolhasNaoEcologicas() + " escolhas não ecológicas.");
        System.out.println("No total, você poupou " + personagem.getTempoEconomizado() + " minutos.");

        int scoreAmb = personagem.getPontuacaoAmbiental();
        int scoreSaude = personagem.getPontuacaoSaude();

        if (scoreAmb >= 6 && scoreSaude >= 2) {
            System.out.println("Final Excelente: Sua rotina é um exemplo de responsabilidade.");
        } else if (scoreAmb >= 2 && scoreSaude >= 1) {
            System.out.println("Final Razoável: Você teve boas atitudes, mas há espaço para melhorar.");
        } else {
            System.out.println("Final Ruim: Suas escolhas diárias impactaram negativamente o meio ambiente e sua saúde.");
        }

        scanner.close();
    }
}