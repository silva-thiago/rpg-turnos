package br.ufrn.pds.rpgturnosdomain.model.noonglade;

import br.ufrn.pds.rpgturnosdomain.model.assets.Character;
import br.ufrn.pds.rpgturnosdomain.model.assets.Shop;

import java.util.Scanner;

public class CherryRidge {
	private static final Scanner scan = new Scanner(System.in);
	private static int choice;
	private static boolean kingSpokenTo = false;
	private static boolean rewardReceived = false;

	public static void cherryRidge() {
		System.out.println("\n\t1. Olhar em volta" +
			"\n\t2. Visitar o mercado" +
			"\n\t3. Visitar a pousada" +
			"\n\t4. Visitar o palácio" +
			"\n\t5. Sair da cidade de Cherry Ridge");
		System.out.print("\nO que desejas fazer agora? ");
		choice = scan.nextInt();

		if (choice == 1) {
			System.out.println("\n\"Bem-vindo à cidade de Cherry Ridge, " + Character.getName() + "\"");
			System.out.println(
				"\n\"O Reino do Norte de Cherry Ridge é enorme." +
				"\nCentenas de casas se alinham nas ruas e um grande palácio fica no centro de tudo." +
				"\nMercados lotados podem ser encontrados por toda a cidade.\""
			);

			CherryRidge.cherryRidge();
		}

		if (choice == 2) {
			System.out.println("\n\"Você caminha até o mercado movimentado.\"");

			Shop.cherryRidgeShop();
		}

		if (choice == 3) {
			System.out.println("\n\"Você visita a Silver Cat, uma das muitas pousadas localizadas em Cherry Ridge.\"");

			CherryRidge.inn();
		}

		if (choice == 4) {
			System.out.println("\n\"Você visita o palácio colossal em Cherry Ridge, localizado no coração da cidade.\"");

			CherryRidge.palace();
		}

		if (choice == 5) {
			System.out.println("\n\"Você deixa o Reino do Norte de Cherry Ridge…\"");

			NoongladeMap.move();
		}

		if (choice <= 0 || choice > 5) {
			System.out.println("\nSe estiver cansado, você pode ir até sua casa…");

			CherryRidge.cherryRidge();
		}
	}

	public static void inn() {
		System.out.println(
			"\n\t1. Fale com o estalajadeiro" +
			"\n\t2. Verificar status" +
			"\n\t3. Descanso - 5 Ouros" +
			"\n\t4. Sair"
		);
		System.out.print("\nChegastes na pousada. O que queres? ");
		choice = scan.nextInt();

		if (choice == 1) {
			System.out.println("\nVocê fala com um anão, que você acredita ser o estalajadeiro. Ele o cumprimenta calorosamente e diz que você pode voltar a qualquer momento.");

			CherryRidge.inn();
		} else if (choice == 2) {
			Character.status();
			CherryRidge.inn();
		} else if (choice == 3) {
			if (Shop.getGold() >= 5) {
				Shop.changeGold(-5);
				Character.heal();

				System.out.println("\nVocê aluga um quarto e descansa lá por um tempo, restaurando sua vida.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}

			CherryRidge.inn();
		} else if (choice == 4) {
			System.out.println("\nVocê sai da Silver Cat.");

			CherryRidge.cherryRidge();
		} else {
			CherryRidge.inn();
		}
	}

	public static void palace() {
		System.out.println(
			"\n\t1. Explorar o palácio" +
			"\n\t2. Fale com o Rei" +
			"\n\t3. Sair"
		);
		System.out.print("\nO que queres fazer? ");
		choice = scan.nextInt();

		if (choice == 1) {
			System.out.println("" +
				"\nVocê dá uma olhada ao redor do palácio. Você vê tapetes vermelhos, pilares de mármore e pinturas complexas nas paredes." +
				"\nOnde quer que você vá, guardas e visitantes estão correndo."
			);

			CherryRidge.palace();
		} else if (choice == 2) {
			if (WindHeath.dragonSlain() && !rewardReceived && kingSpokenTo) {
				System.out.println(
					"\n\"Será que o dragão que aterrorizava Var Wind Heath foi morto? você fez bem, " + Character.getName() + "!" +
					"\nEu o recompensarei com ouro e glória! Você deve usar esse ouro para comprar um barco na cidade de The Port, que fica a sudeste de CherryRidge.\""
				);

				Shop.changeGold(5000);

				System.out.println("\nVocê ganhou 5.000 ouros!");

				rewardReceived = true;

				CherryRidge.palace();
			} else if (WindHeath.dragonSlain() && rewardReceived && kingSpokenTo) {
				System.out.println("\n\"Já pensou em visitar o Porto? Fica ao sul de Var Wind Heath, perto do mar.\"");

				CherryRidge.palace();
			} else if (kingSpokenTo) {
				System.out.println("\n\"Você já matou o Dragão? Var Wind Heath pode ser encontrado a leste de Cherry Ridge.\"");

				CherryRidge.palace();
			} else {
				System.out.println("\nInfelizmente, você conhece o rei Valik. Vocês se cumprimentam, e então ele lhe dá um olhar sério e ordena que você se sente e o ouça.");

				if (Character.getRole() == 1) {
					System.out.print("\n\"Nobre " + Character.getName() + ", eu tenho um pedido a você.");
				} else if (Character.getRole() == 2) {
					System.out.print("\n\"Corajoso(a) " + Character.getName() + ", Eu sei que você é apenas um aventureiro, mas espero que ouça meu apelo.");
				} else if (Character.getRole() == 3) {
					System.out.print("\n\"Misterioso(a) " + Character.getName() + ", Eu normalmente não recorro à contratação de malandros como você, mas isso é urgente.");
				}

				System.out.print(
					"\nUm dragão vil causou estragos na cidade vizinha de Var Wind Heath." +
					"\nEles são um importante aliado da Cherry Ridge. Se você conseguir derrotar este Dragão, eu lhe darei uma grande recompensa.\"\n"
				);

				kingSpokenTo = true;

				CherryRidge.palace();
			}
		} else if (choice == 3) {
			System.out.println("\nVocê deixa o palácio.");

			CherryRidge.cherryRidge();
		} else {
			CherryRidge.palace();
		}
	}
}
