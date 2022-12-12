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
	private static int speed;

	public Character() {}

	public static void status() {
		System.out.println(
			"\nPersona: " + role +
			"\nNome: " + name +
			"\nVida: " + life + "/" + maxLife +
			"\nForça: " + minDamage + "-" + maxDamage +
			"\nPoder: " + magic +
			"\nAgilidade: " + speed +
			"\nPorção: Battle.getNumPots()" +
			"\nOuro: Shop.getGold()"
		);
	}

	public static void gameOver(String death) {
		System.out.println(death + " VOCÊ MORREU!\"\nA sua história, " + name + ", chegou ao fim.");
		System.out.println("\n======== FIM DE JOGO! =========");
	}

	public static void gameWon() {
		System.out.println(
			"\nVocê volta ao Imperador Kalahan e diz a ele que derrotou o mal que assola a terra de Zariadon." +
			"\nEle está muito satisfeito e tem uma cerimônia em toda a cidade de Kalldirid em homenagem a você."
		);
		System.out.println("\n\"Salve o intrépido " + name + "!\"");
		System.out.println("\n\n\nVocê ganhou! Obrigado por jogar!\n");
	}

		public static void heal() {
		life = maxLife;
	}

	public static int getRole() {
		if (role.equals("Cavaleiro")) { return 1; }
		if (role.equals("Guerreiro")) { return 2; }
		if (role.equals("Arqueiro")) { return 3; }
		if (role.equals("Clérigo")) { return 4; }
		if (role.equals("Mago")) { return 5; }
		if (role.equals("Plebeu")) { return 6; }

		return 0;
	}

	public static void setRole() {
		System.out.println(
			"\n\t1. Cavaleiro" +
			"\n\t2. Guerreiro" +
			"\n\t3. Arqueiro" +
			"\n\t4. Clérigo" +
			"\n\t5. Mago"
		);
		System.out.print("\nQuem você é das opções acima? ");

		int choice = scan.nextInt();

		if (choice == 1) {
			role = "Cavaleiro";
			symbol = "Ⰰ";
			maxLife = 18;
			maxDamage = 5;
			minDamage = 1;
			magic = 0;
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
			speed = 2;

			System.out.println("\nJá que não se decidiu, você está fadado a ser um mero plebeu!");

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

	public static void gainLife(int gainLife) {
		Character.life += gainLife;
	}

	public static void loseLife(int loseLife) {
		Character.life -= loseLife;
	}

	public static int getMaxLife() {
		return maxLife;
	}

	public static void changeMaxLife(int maxLife) {
		Character.maxLife += maxLife;
	}

	public static int getMaxDamage() {
		return maxDamage;
	}

	public static void gainMaxDamage(int maxDamage) {
		Character.maxDamage += maxDamage;
	}

	public static void loseMaxDamage(int maxDamage) {
		Character.maxDamage -= maxDamage;
	}

	public static int getMinDamage() {
		return minDamage;
	}

	public static void gainMinDamage(int minDamage) {
		Character.minDamage += minDamage;
	}

	public static void loseMinDamage(int minDamage) {
		Character.minDamage -= minDamage;
	}

	public static int getMagic() {
		return magic;
	}

	public static void changeMagic(int magic) {
		Character.magic += magic;
	}

	public static int getSpeed() {
		return speed;
	}

	public static void gainSpeed(int speed) {
		Character.speed += speed;
	}

	public static void loseSpeed(int speed) {
		Character.speed -= speed;
	}

	public static int getTotalStats() {
		return maxLife + ((minDamage + maxDamage) / 2) + magic + speed;
	}
}
