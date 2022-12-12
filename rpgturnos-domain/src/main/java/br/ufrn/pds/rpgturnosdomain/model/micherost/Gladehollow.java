package br.ufrn.pds.rpgturnosdomain.model.micherost;

import br.ufrn.pds.rpgturnosdomain.model.assets.Battle;
import br.ufrn.pds.rpgturnosdomain.model.assets.Character;
import br.ufrn.pds.rpgturnosdomain.model.assets.Shop;

import java.util.Scanner;

public class Gladehollow {
	private static final Scanner scan = new Scanner(System.in);
	private static int choice;

	public static void gladehollow() {
		System.out.println(
			"\n\t1. Olhar em volta" +
			"\n\t2. Visitar a loja" +
			"\n\t3. Visitar a pousada" +
			"\n\t4. Explorar a floresta" +
			"\n\t5. Sair"
		);
		System.out.print("\nO que desejas fazer? ");
		choice = scan.nextInt();

		if (choice == 1) {
			System.out.println("\nBem-vindo à cidade de Gladehollow, " + Character.getName() + "\"");
			System.out.println(
				"\nVocê olha ao redor de Gladehollow. Os edifícios e o ambiente estão integrados." +
				"\nTodos os residentes são tranquilos, mas relaxados e amigáveis em sua maior parte." +
				"\nUma densa floresta faz fronteira com a cidade por todos os lados, e um lago pode ser encontrado ao sul."
			);

			Gladehollow.gladehollow();
		} else if (choice == 2) {
			Shop.gladehollowShop();
		} else if (choice == 3) {
			System.out.println("\nVocê visita a Gray Wolf, uma pousada esculpida no tronco de uma árvore gigante.");

			Gladehollow.inn();
		} else if (choice == 4) {
			System.out.println("\nVocê entra na vasta floresta localizada por Gladehollow.");

			Gladehollow.forest();
		} else if (choice == 5) {
			System.out.println("\nVocê deixa a cidade-floresta de Gladehollow.");

			KalldiridMap.move();
		} else {
			Gladehollow.gladehollow();
		}
	}

	public static void inn() {
		System.out.println(
			"\n\t1. Verificar status" +
			"\n\t2. Descansar - 5 Gold" +
			"\n\t3. Sair"
		);
		System.out.print("\nChegastes na pousada. O que queres? ");
		choice = scan.nextInt();

		if (choice == 1) {
			Character.status();
			Gladehollow.inn();
		} else if (choice == 2) {
			if (Shop.getGold() >= 5) {
				Shop.changeGold(-5);
				Character.heal();
				System.out.println("\nVocê aluga um quarto e descansa lá por um tempo, restaurando sua vida.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Gladehollow.inn();
		} else if (choice == 3) {
			System.out.println("\nVocie sai da Gray Wolf.");
			Gladehollow.gladehollow();
		} else {
			Gladehollow.inn();
		}
	}

	public static void forest() {
		if (!KalldiridCity.lupineKnightSlain()) {
			System.out.println("\nVocê ouve o uivo ameaçador de um lobo.");
		}

		System.out.println(
			"\n\t1. Olhar em volta" +
			"\n\t2. Sair"
		);
		System.out.print("\nE aí, tá com medo? ");
		choice = scan.nextInt();

		if (choice == 1) {
			if (!KalldiridCity.lupineKnightSlain()) {
				System.out.println("\nAo olhar ao redor da floresta, você encontra o Cavaleiro Lupino.");

				Battle.lupineKnightBattle();
			} else {
				System.out.println(
					"\nVocê anda pela floresta. Você vê uma variedade de belas árvores e flores, junto com um monte de animais interessantes." +
					"\nVocê caminha de volta para Gladehollow antes de se perder."
				);

				Gladehollow.gladehollow();
			}
		} else if (choice == 2) {
			System.out.println("\nVocê sai da floresta.");

			Gladehollow.gladehollow();
		} else {
			Gladehollow.forest();
		}
	}
}
