package br.ufrn.pds.rpgturnosdomain.model.micherost;

import br.ufrn.pds.rpgturnosdomain.model.assets.Character;
import br.ufrn.pds.rpgturnosdomain.model.assets.Shop;

import java.util.Scanner;

public class KalldiridCity {
	private static final Scanner scan = new Scanner(System.in);
	private static int choice;
	private static boolean emperorSpokenTo = false;
	private static boolean lupineKnightSlain = false;
	private static boolean leonineKnightSlain = false;
	private static boolean hasLetter = false;

	public static void kalldiridCity() {
		System.out.println(
			"\n\t1. Olhar em volta" +
			"\n\t2. Visite a forja" +
			"\n\t3. Visite a magia" +
			"\n\t4. Visite a alquimia" +
			"\n\t5. Visitar a pousada" +
			"\n\t6. Visitar o palácio" +
			"\n\t7. Sair"
		);
		System.out.print("\nO que desejas fazer? ");
		choice = scan.nextInt();

		if (choice == 1) {
			System.out.println("\nBem-vindo à cidade de Kalldirid, " + Character.getName() + "\"");
			System.out.println(
				"\nVocê olha ao redor do Império de Kalldirid." +
				"\nDezenas de milhares de pessoas, desde o povo comum até elfos, cavaleiros e magos, estão vagando pelas ruas.." +
				"\nO mercado é diversificado, oferecendo uma forja, uma magia e uma alquimia. Um palácio colossal serve como a principal vista da cidade."
			);

			KalldiridCity.kalldiridCity();
		} else if (choice == 2) {
			Shop.kalldiridForge();
		} else if (choice == 3) {
			Shop.kalldiridWizardry();
		} else if (choice == 4) {
			Shop.kalldiridAlchemy();
		} else if (choice == 5) {
			System.out.println("\nVocê visita o Golden Lion, a pousada mais famosa localizada em Kalldirid.");

			KalldiridCity.inn();
		} else if (choice == 6) {
			System.out.println("\nVocê visita o espetacular palácio nos arredores de Kalldirid.");

			KalldiridCity.palace();
		} else if (choice == 7) {
			System.out.println("\nVocê sai da Cidade Imperial de Kalldirid.");

			KalldiridMap.move();
		} else {
			KalldiridCity.kalldiridCity();
		}
	}

	public static void inn() {
		System.out.println(
			"\n\t1. Fale com o estalajadeiro" +
			"\n\t2. Verificar status" +
			"\n\t3. Descansar - 7 Gold" +
			"\n\t4. Sair"
		);
		System.out.print("\nChegastes na pousada. O que queres? ");
		choice = scan.nextInt();

		if (choice == 1) {
			System.out.println("\nVocê fala com um homem que aparece");

			KalldiridCity.inn();
		} else if (choice == 2) {
			Character.status();

			KalldiridCity.inn();
		} else if (choice == 3) {
			if (Shop.getGold() >= 7) {
				Shop.changeGold(-7);
				Character.heal();

				System.out.println("\nVocê aluga um quarto e descansa lá por um tempo, restaurando sua vida.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			KalldiridCity.inn();
		} else if (choice == 4) {
			System.out.println("\nVocê sai do Golden Lion.");

			KalldiridCity.kalldiridCity();
		} else {
			KalldiridCity.inn();
		}
	}

	public static void palace() {
		System.out.println(
			"\n\t1. Olhar em volta" +
			"\n\t2. Fale com o Imperador" +
			"\n\t3. Sair"
		);
		System.out.print("\nChegastes na pousada. O que queres? ");
		choice = scan.nextInt();

		if (choice == 1) {
			System.out.println(
				"\nVocê faz um tour pelo palácio de Kalldirid. O palácio funciona como uma casa para o imperador e um ponto de encontro para membros da realeza e oficiais." +
				"\nTodos que você vê estão vestindo trajes luxuosos, com exceção de alguns soldados revestidos de armadura."
			);

			KalldiridCity.palace();
		} else if (choice == 2) {
			if (lupineKnightSlain && leonineKnightSlain && !hasLetter && emperorSpokenTo) {
				System.out.println(
					"\n\"Finalmente, aqueles cavaleiros malévolos foram detidos para sempre. Pegue este pingente real como um sinal de gratidão." +
					"\nNo entanto, tenho outro pedido a você. Por favor, ouça-me, " + Character.getName() + ", pois sua recompensa será maior do que qualquer coisa que você possa imaginar." +
					"\nNa terra perdida de Zariadon, há um grande mal em ascensão. Os poucos soldados que enviei para lá para investigar nunca mais voltaram." +
					"\nSe você estiver disposto, leve esta carta aos guardas de Hanawyn e eles o levarão a Zariadon.\""
				);
				System.out.println("\nVocê recebeu o Pingente Real! Todas as suas estatísticas aumentaram.");

				Character.changeMaxLife(2);
				Character.gainMinDamage(1);
				Character.gainMaxDamage(1);
				Character.changeMagic(1);
				Character.gainSpeed(1);

				System.out.println("\nVocê recebeu a Carta do Imperador!");

				hasLetter = true;

				KalldiridCity.palace();
			} else if (lupineKnightSlain && leonineKnightSlain && hasLetter && emperorSpokenTo) {
				System.out.println("\n\"Investigue a presença maligna dentro de Zariadon. Eu sei que você é corajoso o suficiente para enfrentá-lo, " + Character.getName() + ".\"");

				KalldiridCity.palace();
			} else if (emperorSpokenTo) {
				System.out.println("\n\"Por favor, " + Character.getName() + ", vá livrar esta terra desses cavaleiros maliciosos.\"");

				KalldiridCity.palace();
			} else {
				System.out.println("\nVocê entra na câmara real e fala com o Imperador Kalahan, governante desta terra.");

				if (Character.getRole() == 1) {
					System.out.print("\n\n\"Cavaleiro(a) ");
				} else if (Character.getRole() == 2) {
					System.out.print("\n\"Aventureiro(a) ");
				} else if (Character.getRole() == 3) {
					System.out.print("\n\"Vampiro(a) ");
				}

				System.out.println(
					Character.getName() + ", Eu ouvi rumores sobre você. E eu, Imperador Kalahan, tenho um pedido a você. Não se preocupe, pois você receberá uma grande recompensa." +
					"\nDois cavaleiros sombrios - um com rosto de lobo e outro com rosto de leão - incutiram medo nos corações dos civis desta terra." +
					"\nUm pode ser encontrado ao sul de Kalldirid, nas florestas de Gladehollow. O outro pode ser encontrado a noroeste de Kalldirid, em uma torre em ruínas de outrora." +
					"\nEspero que isso seja informação suficiente para você rastreá-los e matá-los. boa sorte, " + Character.getName() + ".\""
				);

				emperorSpokenTo = true;

				KalldiridCity.palace();
			}
		} else if (choice == 3) {
			System.out.println("\nVocê deixa o palácio.");

			KalldiridCity.kalldiridCity();
		} else {
			KalldiridCity.palace();
		}
	}

	public static void slayLupineKnight() {
		lupineKnightSlain = true;
	}

	public static void slayLeonineKnight() {
		leonineKnightSlain = true;
	}

	public static boolean lupineKnightSlain() {
		return lupineKnightSlain;
	}

	public static boolean leonineKnightSlain() {
		return leonineKnightSlain;
	}

	public static boolean hasLetter() {
		return hasLetter;
	}
}
