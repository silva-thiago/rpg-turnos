package br.ufrn.pds.rpgturnosdomain.model.assets;

import java.util.Scanner;

public class Character {
	private static final Scanner scan = new Scanner(System.in);
	private static String role;
	private static String symbol;
	private static String name;
	private static int life;
	private static int maxLife;
	private static int maxDamage;
	private static int minDamage;
	private static int magic;
	private static int intelligence;
	private static int speed;

	private static void status() {
		System.out.println(
			"\nPersona: " + role +
			"\nNome: " + name +
			"\nVida: " + life + "/" + maxLife +
			"\nForça: " + minDamage + "-" + maxDamage +
			"\nPoder: " + magic +
			"\nInteligência: " + intelligence +
			"\nAgilidade: " + speed +
			"\nPorção: --" +
			"\nOuro: --"
		);
	}

	public static void gameOver(String death) {
		System.out.println(death + " VOCÊ MORREU!\"\n- A sua história, " + name + ", chegou ao fim.");
		System.out.println("\n======== FIM DE JOGO! =========");
	}

	public static void heal() {
		life = maxLife;
	}

	public static void setRole() {
		System.out.println(
			"\n\t1. Cavaleiro" +
			"\n\t2. Guerreiro" +
			"\n\t3. Arqueiro" +
			"\n\t4. Clérigo" +
			"\n\t5. Mago"
		);
		System.out.print("\n- Quem você é das opções acima? ");

		int choice = scan.nextInt();

		if (choice == 1) {
			role = "Cavaleiro";
			symbol = "Ⰰ";
			maxLife = 18;
			maxDamage = 5;
			minDamage = 1;
			magic = 0;
			intelligence = 8;
			speed = 9;

			System.out.println("- Você é um nobre cavaleiro.");

			Character.heal();
		}

		if (choice == 2) {
			role = "Guerreiro";
			symbol = "Ⱈ";
			maxLife = 15;
			maxDamage = 8;
			minDamage = 1;
			magic = 0;
			intelligence = 7;
			speed = 7;

			System.out.println("- Você é um forte guerreiro.");

			Character.heal();
		}

		if (choice == 3) {
			role = "Arqueiro";
			symbol = "Ⱝ";
			maxLife = 14;
			maxDamage = 6;
			minDamage = 4;
			magic = 0;
			intelligence = 6;
			speed = 5;

			System.out.println("- Você é um furtivo arqueiro.");

			Character.heal();
		}

		if (choice == 4) {
			role = "Clérigo";
			symbol = "Ⰺ";
			maxLife = 12;
			maxDamage = 5;
			minDamage = 3;
			magic = 2;
			intelligence = 5;
			speed = 4;

			System.out.println("- Você é um devoto clérigo.");

			Character.heal();
		}

		if (choice == 5) {
			role = "Mago";
			symbol = "Ⰼ";
			maxLife = 20;
			maxDamage = 3;
			minDamage = 4;
			magic = 10;
			intelligence = 9;
			speed = 6;

			System.out.println("- Você é um impressionante mago.");

			Character.heal();
		}

		if (choice <= 0 || choice > 5) {
			role = "Plebeu";
			symbol = "Ⱓ";
			maxLife = 10;
			maxDamage = 2;
			minDamage = 1;
			magic = 0;
			intelligence = 3;
			speed = 2;

			System.out.println("\n- Já que não se decidiu, você está fadado a ser um mero plebeu!");

			Character.heal();
		}
	}

	public static String printSymbol() {
		return symbol;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Character.name = name;
	}

	public static int getLife() {
		return life;
	}

	public static void loseLife(int loseLife) {
		Character.life -= loseLife;
	}

	public static int getMaxLife() {
		return maxLife;
	}
}
