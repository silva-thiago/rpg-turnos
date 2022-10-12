package br.ufrn.pds.rpgturnosdomain.model.noonglade;

import br.ufrn.pds.rpgturnosdomain.model.assets.Character;

import java.util.Scanner;

public class NoongladeCity {
	private static final Scanner scan = new Scanner(System.in);

	public static void beginning() {
		System.out.println("\nSeus olhos se abrem e você rola para fora de sua cama de lençol. A luz do sol está brilhando em seu quarto.\nSua mente ainda está nebulosa, então você deve se lembrar qual é o seu nome.");
		System.out.print("\nDigite o seu nome: ");
		String name = scan.nextLine();
		Character.setName(name);
		System.out.println("\nAh, isso mesmo! Seu nome é " + Character.getName() + ".");
		System.out.println("\nVocê boceja e depois sai. Está um lindo dia em sua cidade natal de Noonglade.\nAs pessoas já estão lá fora se misturando e os pássaros estão cantando.");
	}
}
