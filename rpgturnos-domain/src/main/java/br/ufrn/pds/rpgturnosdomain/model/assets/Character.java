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

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Character.name = name;
	}
}
