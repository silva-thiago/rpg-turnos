package br.ufrn.pds.rpgturnosdomain.model.noonglade;

import br.ufrn.pds.rpgturnosdomain.model.assets.Character;
import br.ufrn.pds.rpgturnosdomain.model.assets.Shop;

import java.util.Scanner;

public class NoongladeCity {
	private static final Scanner scan = new Scanner(System.in);
	private static int choice;

	public static void beginning() {
		System.out.println("\n\"Seus olhos se abrem e você rola para fora de sua cama de lençol. A luz do sol está brilhando em seu quarto.\nSua mente ainda está nebulosa, então você deve se lembrar qual é o seu nome…\"");
		System.out.print("\nDiga-me, como é o seu nome?");
		System.out.print("\nEu me chamo… ");

		String name = scan.nextLine();
		Character.setName(name);

		System.out.println("- Ah, isso mesmo! Seu nome é " + Character.getName() + ".");

		Character.setRole();

		System.out.println("\n\"Você boceja e depois sai. Está um lindo dia em sua cidade natal, Noonglade.\nAs pessoas já estão lá fora se misturando e os pássaros estão cantando.\"");

		NoongladeCity.noongladeCity();
	}

	public static void noongladeCity() {
		System.out.println(
			"\n\t1. Olhar em volta" +
			"\n\t2. Visitar a loja" +
			"\n\t3. Ir para sua casa" +
			"\n\t4. Andar pela cidade de Noonglade"
		);
		System.out.print("\nO que desejas fazer agora? ");
		choice = scan.nextInt();

		if (choice == 1) {
			System.out.println("\n\"Bem-vindo à cidade de Noonglade, " + Character.getName() + "\"");
			System.out.println("\n\"Você olha em volta, conversa com alguns velhos amigos ao longo do caminho.\nNada muito interessante parece estar acontecendo.\"");

			NoongladeCity.noongladeCity();
		}

		if (choice == 2) {
			System.out.println("\n\"Você vai para a loja localizada no coração da cidade de Noonglade.\"");

			Shop.noongladeShop();
		}

		if (choice == 3) {
			System.out.println("\n\"Você retorna para sua humilde morada.\"");

			NoongladeCity.yourHouse();
		}

		if (choice == 4) {
			System.out.println("\n\"Você se despede de seus amigos e viaja pela cidade de Noonglade.\"");

			NoongladeMap.move();
		}

		if (choice <= 0 || choice > 4) {
			System.out.println("\nSe estiver cansado, você pode ir até sua casa…");

			NoongladeCity.noongladeCity();
		}
	}

	public static void yourHouse() {
		System.out.println(
			"\n\t1. Olhar em volta" +
			"\n\t2. Verificar status" +
			"\n\t3. Descansar" +
			"\n\t4. Sair"
		);
		System.out.print("\nChegastes em casa, o que vais fazer? ");
		choice = scan.nextInt();

		if (choice == 1) {
			System.out.println("\n\"Sua casa está do jeito que você deixou.\nSua cama de lençol em um canto e a mesa no outro.\"");

			NoongladeCity.yourHouse();
		}

		if (choice == 2) {
			Character.status();
			NoongladeCity.yourHouse();
		}

		if (choice == 3) {
			Character.heal();

			System.out.println("\n\"Você fecha os olhos um pouco…\"");
			System.out.println("\nSua vida foi restaurada.");

			NoongladeCity.yourHouse();
		}

		if (choice == 4) {
			System.out.println("\n\"Você deixa sua casa.\"");

			NoongladeCity.noongladeCity();
		}

		if (choice <= 0 || choice > 4) {
			System.out.println("\nTá em dúvida? Que tal descansar um pouco?");
			NoongladeCity.yourHouse();
		}
	}
}
