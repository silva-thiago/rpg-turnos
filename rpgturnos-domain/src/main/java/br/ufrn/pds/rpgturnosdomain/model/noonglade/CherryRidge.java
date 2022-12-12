package br.ufrn.pds.rpgturnosdomain.model.noonglade;

import br.ufrn.pds.rpgturnosdomain.model.assets.Character;

import java.util.Scanner;

public class CherryRidge {
	private static final Scanner scan = new Scanner(System.in);
	private static int choice;

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
			System.out.println("\n\"O Reino do Norte de Cherry Ridge é enorme.\nCentenas de casas se alinham nas ruas e um grande palácio fica no centro de tudo.\nMercados lotados podem ser encontrados por toda a cidade.\"");
			CherryRidge.cherryRidge();
		}

		if (choice == 2) {
			System.out.println("\n\"Você caminha até o mercado movimentado.\"");
			System.out.println("\nTODO: implementar mercado");
		}

		if (choice == 3) {
			System.out.println("\n\"Você visita a Silver Cat, uma das muitas pousadas localizadas em Cherry Ridge.\"");
			System.out.println("\nTODO: implementar pousada");
		}

		if (choice == 4) {
			System.out.println("\n\"Você visita o palácio colossal em Cherry Ridge, localizado no coração da cidade.\"");
			System.out.println("\nTODO: implementar palácio");
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
}
