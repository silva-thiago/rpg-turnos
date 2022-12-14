package br.ufrn.pds.rpgturnosdomain.model.noonglade;

import br.ufrn.pds.rpgturnosdomain.model.assets.Battle;
import br.ufrn.pds.rpgturnosdomain.model.assets.Character;
import br.ufrn.pds.rpgturnosdomain.model.designpatterns.TemplateMethod;

import java.util.Random;
import java.util.Scanner;

public class NoongladeMap {
	private static final Scanner scan = new Scanner(System.in);
	private static final Random rand = new Random();
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
		boolean walking = true;

		System.out.println("\nUse as teclas W, A, S e D para andar no mapa.");

		while (walking) {
			NoongladeMap.printMap();
			String move = scan.nextLine();
			NoongladeMap.getMove(move);

			if (xAxisPosition == 4 && yAxisPosition == 3) {
				System.out.println("\nVocê chega à sua cidade natal Noonglade.");

				NoongladeCity.noongladeCity();

				break;
			} else if (xAxisPosition == 7 && yAxisPosition == 9) {
				System.out.println("\nVocê chega ao Reino do Norte de Cherry Ridge.");

				CherryRidge.cherryRidge();

				break;
			} else if (xAxisPosition == 23 && yAxisPosition == 7) {
				System.out.println("\nVocê chega à cidade montanhosa de Wind Heath.");

				WindHeath.windHeath();

				break;
			} else if (xAxisPosition == 24 && yAxisPosition == 2) {
				System.out.println("\nVocê chega à cidade portuária de Port.");

				ThePort.thePort();

				break;
			} else if (map[top].substring(xAxisPosition, (xAxisPosition + 1)).equals("^")) {
				Battle.randEncounter();
			} else if (map[top].substring(xAxisPosition, (xAxisPosition + 1)).equals("≈")) {
				System.out.println("\nVocês não sabem nadar!");

				Character.loseLife(3);

				if (Character.getLife() < 1) {
					Character.gameOver("\n\"Vocês engoliram muita água e se afogaram…");
				}
			} else {
				int randEncounter = rand.nextInt(8);

				if (randEncounter == 0) {
					Battle.randEncounter();
				}
			}
		}
	}

	private static void getMove(String move) {
		if (move.equals("w") || move.equals("W")) {
			top--;
			yAxisPosition++;
		}

		if (move.equals("a") || move.equals("A")) {
			xAxisPosition--;
		}

		if (move.equals("s") || move.equals("S")) {
			top++;
			yAxisPosition--;
		}

		if (move.equals("d") || move.equals("D")) {
			xAxisPosition++;
		}

		if (xAxisPosition > map[0].length() - 1) {
			xAxisPosition = map[0].length() - 1;
		}

		if (xAxisPosition < 0) {
			xAxisPosition = 0;
		}

		if (top > map.length - 1) {
			top = map.length - 1;
			yAxisPosition = 0;
		}

		if (yAxisPosition > map.length - 1) {
			top = 0;
			yAxisPosition = map.length - 1;
		}
	}

	public static void printMap() {
		System.out.println("===============================");

		for (int aKey = 0; aKey < top; ++aKey) {
			System.out.println(map[aKey]);
		}

		System.out.print(map[top].substring(0, xAxisPosition));
		System.out.print(Character.printSymbol());
		System.out.print(map[top].substring(xAxisPosition + 1, map[top].length()));
		System.out.println();

		for (int dKey = 0; dKey < top + yAxisPosition; ++dKey) {
			System.out.println(map[dKey + 1]);
		}

		System.out.println("===============================");
		System.out.println(
			"\nLife: " + Character.getLife() + "/" + Character.getMaxLife() + "\t\t" +
			"\tX: " + xAxisPosition +
			"\tY: " + yAxisPosition
		);
	}
}
