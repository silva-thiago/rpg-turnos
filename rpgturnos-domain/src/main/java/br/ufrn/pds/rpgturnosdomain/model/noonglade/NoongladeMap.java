package br.ufrn.pds.rpgturnosdomain.model.noonglade;

import br.ufrn.pds.rpgturnosdomain.model.assets.Character;

import java.util.Scanner;

public class NoongladeMap {
	private static final Scanner scan = new Scanner(System.in);
	private static int xAxisPosition = 4;
	private static int yAxisPosition = 3;
	private static int top = 7;
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
		String move = scan.nextLine();
		NoongladeMap.getMove(move);
	}

	public static void printMap() {
		System.out.println("===============================");

		for (int aKey = 0; aKey < top; ++aKey) {
			System.out.println(map[aKey]);
		}

		System.out.print(map[top].substring(0, xAxisPosition));
		System.out.print(Character.printSymbol());
		System.out.println(map[top].substring(xAxisPosition + 1, map[top].length()));

		for (int dKey = 0; dKey < top + yAxisPosition; ++dKey) {
			System.out.println(map[dKey + 1]);
		}

		System.out.println("===============================");
		System.out.println(
			"\nLife: " + Character.getLife() + "/" + Character.getMaxLife() +
			"\t\tX: " + xAxisPosition +
			"\tY: " + yAxisPosition
		);
	}
}
