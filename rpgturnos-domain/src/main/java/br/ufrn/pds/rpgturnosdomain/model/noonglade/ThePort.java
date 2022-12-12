package br.ufrn.pds.rpgturnosdomain.model.noonglade;

import br.ufrn.pds.rpgturnosdomain.model.assets.Character;
import br.ufrn.pds.rpgturnosdomain.model.assets.Shop;
import br.ufrn.pds.rpgturnosdomain.model.micherost.Winsorin;

import java.util.Scanner;

public class ThePort {
	private static final Scanner scan = new Scanner(System.in);
	private static int choice;
	private static boolean hasBoat = false;

	public static void thePort() {
		System.out.println(
			"\n\t1. Olhar em volta" +
			"\n\t2. Visitar o mercado" +
			"\n\t3. Visitar a pousada" +
			"\n\t4. Embarque em um barco" +
			"\n\t5. Sair"
		);
		System.out.print("\nO que desejas fazer? ");
		choice = scan.nextInt();

		if (choice == 1) {
			System.out.println("\nBem-vindo à cidade de The Port, " + Character.getName() + "\"");
			System.out.println(
				"\nVocê dá uma olhada em The Port. Metade dela é uma cidade residencial e a outra metade é um porto industrial." +
				"\nDezenas de navios são abordados nas docas, embora muitos deles pareçam estar transportando mercadorias."
			);

			ThePort.thePort();
		} else if (choice == 2) {
			System.out.println("\nVocê visita o grande mercado de The Port nas docas.");

			Shop.thePortShop();
		} else if (choice == 3) {
			System.out.println("\nVocê visita o Golden Fish, uma pousada localizada no enorme porto.");

			ThePort.inn();
		} else if (choice == 4) {
			if (!hasBoat) {
				System.out.println(
					"\nVocê vai ao porto, mas não encontra nenhum barco aberto ao público em geral." +
					"\nVocê finalmente encontra um homem encapuzado que diz que pode alugar seu barco pelo preço de 5.000 ouros.."
				);

				ThePort.port();
			} else {
				System.out.println("\nVocê partiu em direção ao continente através do mar. Você chega na modesta cidade portuária de Winsorin.");

				Winsorin.winsorin();
			}
		} else if (choice == 5) {
			System.out.println("\nVocê sai da cidade portuária de The Port.");

			NoongladeMap.move();
		} else {
			ThePort.thePort();
		}
	}

	public static void inn() {
		System.out.println(
			"\n\t1. Fale com o estalajadeiro" +
			"\n\t2. Verificar status" +
			"\n\t3. Descansar - 5 Gold" +
			"\n\t4. Sair"
		);
		System.out.print("\nChegastes na pousada. O que queres? ");
		choice = scan.nextInt();

		if (choice == 1) {
			System.out.println("\nVocê fala com um homem alto que você supõe ser o estalajadeiro. Ele se senta lá estoicamente, mas acena com a cabeça.");

			ThePort.inn();
		} else if (choice == 2) {
			Character.status();
			ThePort.inn();
		} else if (choice == 3) {
			if (Shop.getGold() >= 5) {
				Shop.changeGold(-5);
				Character.heal();

				System.out.println("\nVocê aluga um quarto e descansa lá por um tempo, restaurando sua vida.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}

			ThePort.inn();
		} else if (choice == 4) {
			System.out.println("\nVocê sai do Peixe Dourado.");

			ThePort.thePort();
		} else {
			ThePort.inn();
		}
	}

	public static void port() {
		System.out.println(
			"\n\t1. Aceitar" +
			"\n\t2. Recusar"
		);
		System.out.print("\nO que me diz? ");
		choice = scan.nextInt();

		if (choice == 1) {
			if (Shop.getGold() >= 5000) {
				Shop.changeGold(-5000);

				System.out.println("\nVocê aceita a oferta. Você obteve um barco!");

				hasBoat = true;

				ThePort.thePort();
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");

				ThePort.port();
			}
		} else if (choice == 2) {
			System.out.println("\nVocê recusa a oferta.");

			ThePort.thePort();
		} else {
			ThePort.port();
		}
	}
}
