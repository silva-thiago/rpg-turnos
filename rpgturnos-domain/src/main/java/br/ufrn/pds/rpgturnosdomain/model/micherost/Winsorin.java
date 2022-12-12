package br.ufrn.pds.rpgturnosdomain.model.micherost;

import br.ufrn.pds.rpgturnosdomain.model.assets.Character;
import br.ufrn.pds.rpgturnosdomain.model.assets.Shop;
import br.ufrn.pds.rpgturnosdomain.model.noonglade.ThePort;

import java.util.Scanner;

public class Winsorin {
	private static final Scanner scan = new Scanner(System.in);
	private static int choice;

	public static void winsorin() {
		System.out.println(
			"\n\t1. Olhar em volta" +
			"\n\t2. Visitar a loja" +
			"\n\t3. Visitar a pousada" +
			"\n\t4. Embarque em um barco" +
			"\n\t5. Sair"
		);
		System.out.print("\nO que desejas fazer? ");
		choice = scan.nextInt();

		if(choice == 1) {
			System.out.println("\nBem-vindo à cidade de Winsorin, " + Character.getName() + "\"");
			System.out.println(
				"\nVocê dá uma olhada em Winsorin. É semelhante ao Porto, apenas muito menor, mas as pessoas que residem aqui são muito mais amigáveis." +
				"\nHá uma estátua de um velho rei na praça da cidade."
			);

			Winsorin.winsorin();
		}
		else if(choice == 2) {
			System.out.println("\nVocê vai à loja excêntrica de Winsorin.");

			Shop.winsorinShop();
		}
		else if(choice == 3) {
			System.out.println("\nVocê visita a Blue Crab, uma pousada à beira-mar.");

			Winsorin.inn();
		}
		else if(choice == 4) {
			System.out.println("\nVocê embarca em seu barco e volta para The Port.");

			ThePort.thePort();
		}
		else if(choice == 5) {
			System.out.println("\nVocê deixa a cidade de Winsorin.");

			KalldiridMap.move();
		}
		else {
			Winsorin.winsorin();
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

		if(choice == 1) {
			Character.status();
			Winsorin.inn();
		}
		else if(choice == 2) {
			if(Shop.getGold() >= 5) {
				Shop.changeGold(-5);
				Character.heal();

				System.out.println("\nVocê aluga um quarto e descansa lá por um tempo, restaurando sua vida.");
			}
			else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Winsorin.inn();
		}
		else if(choice == 3) {
			System.out.println("\nVocê deixa a Blue Crab.");

			Winsorin.winsorin();
		}
		else {
			Winsorin.inn();
		}
	}
}
