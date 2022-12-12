package br.ufrn.pds.rpgturnosdomain.model.noonglade;

import br.ufrn.pds.rpgturnosdomain.model.assets.Battle;
import br.ufrn.pds.rpgturnosdomain.model.assets.Character;
import br.ufrn.pds.rpgturnosdomain.model.assets.Shop;

import java.util.Scanner;

public class WindHeath {
	private static final Scanner scan = new Scanner(System.in);
	private static int choice;
	private static boolean dragonSlain = false;

	public static void windHeath() {
		if (!dragonSlain) {
			System.out.println("\nVocê ouve o rugido distante de um dragão e os gritos de civis.");
		}
		System.out.println(
			"\n\t1. Olhar em volta" +
			"\n\t2. Visitar a loja" +
			"\n\t3. Visitar a pousada" +
			"\n\t4. Deixar Var Wind Heath"
		);
		System.out.print("\nO que desejas fazer? ");
		choice = scan.nextInt();

		if (choice == 1) {
			System.out.println("\nBem-vindo à cidade de Wind Heath, " + Character.getName() + "\"");

			if (!dragonSlain) {
				WindHeath.dragon();
			} else {
				System.out.println(
					"\nVocê olha ao redor de Var Wind Heath. A cidade ainda está parcialmente danificada, mas parece estar prosperando independentemente." +
					"\nEnquanto você caminha, alguns dos cidadãos agradecem por matar o Dragão."
				);

				WindHeath.windHeath();
			}
		} else if (choice == 2) {
			if (!dragonSlain) {
				System.out.println("\nA loja está fechada.");

				WindHeath.windHeath();
			} else {
				System.out.println("\nVocê vai para a pequena, mas movimentada loja de Var Wind Heath.");

				Shop.windHeathShop();
			}
		} else if (choice == 3) {
			if (!dragonSlain) {
				System.out.println("\nA pousada está fechada.");

				WindHeath.windHeath();
			} else {
				System.out.println("\nVocê visita o Green Fox, a única pousada de Var Wind Heath.");

				WindHeath.inn();
			}
		} else if (choice == 4) {
			System.out.println("\nVocê deixa Var Wind Heath.");

			NoongladeMap.move();
		} else {
			WindHeath.windHeath();
		}
	}

	public static void dragon() {
		System.out.println(
			"\nVocê dá uma olhada ao redor. Algumas casas estão danificadas, enquanto outras estão quebradas em pedaços." +
			"\nAo se aproximar do centro da cidade, você vê um Dragão Carmesim vagando vorazmente por aí."
		);
		System.out.println(
			"\n\t1. Lute contra o dragão" +
			"\n\t2. Fugir"
		);
		System.out.print("\nE aí, vai encarar? ");
		choice = scan.nextInt();

		if (choice == 1) {
			Battle.dragonBattle();
		} else if (choice == 2) {
			WindHeath.windHeath();
		} else {
			WindHeath.dragon();
		}
	}

	public static void inn() {
		System.out.println(
			"\n\t1. Verificar status" +
			"\n\t2. Descansar - 5 Gold" +
			"\n\t3. Sair"
		);
		System.out.print("\nO que queres? ");
		choice = scan.nextInt();

		if (choice == 1) {
			Character.status();
			WindHeath.inn();
		} else if (choice == 2) {
			if (Shop.getGold() >= 5) {
				Shop.changeGold(-5);
				Character.heal();

				System.out.println("\nVocê aluga um quarto e descansa lá por um tempo, restaurando sua vida.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}

			WindHeath.inn();
		} else if (choice == 3) {
			System.out.println("\nVocê sai da Green Fox.");

			WindHeath.windHeath();
		} else {
			WindHeath.inn();
		}
	}

	public static void slayDragon() {
		dragonSlain = true;
	}

	public static boolean dragonSlain() {
		return dragonSlain;
	}
}
