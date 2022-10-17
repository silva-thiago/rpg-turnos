package br.ufrn.pds.rpgturnosdomain.model.noonglade;

import java.util.Scanner;

public class NoongladeMap {
	private static final Scanner scan = new Scanner(System.in);
	private static String move;
	private static final int top = 7;
	private static final String[] map = {
		"^^^^^^^^^^        ≈≈≈≈≈≈≈  ^^^^",
		"^^^^^  ♛     ^^^    ≈≈≈     ^^^",
		"^^^         ^^^^       ^^     ^",
		"^      ≈≈≈    ^^^     ^♝^^     ",
		"     ≈≈≈≈≈≈         ^^^^^^     ",
		"      ≈≈≈≈            ^^       ",
		"               ^^^             ",
		"    ♝        ^^^^^^         ≈≈≈",
		"               ^^^^     ♜ ≈≈≈≈≈",
		"^^^^^         ^^^      ≈≈≈≈≈≈≈≈",
		"^^^^^^^              ≈≈≈≈≈≈≈≈≈≈"
	};

	public static void move() {
		System.out.println("\n- Use as teclas W, A, S e D para andar no mapa.");

		NoongladeMap.printMap();
		move = scan.nextLine();
	}

	public static void printMap() {
		System.out.println("===============================");

		System.out.println("===============================");
	}
}
