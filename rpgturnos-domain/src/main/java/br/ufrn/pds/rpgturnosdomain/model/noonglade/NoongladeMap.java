package br.ufrn.pds.rpgturnosdomain.model.noonglade;

import br.ufrn.pds.rpgturnosdomain.model.assets.Battle;
import br.ufrn.pds.rpgturnosdomain.model.assets.Character;

import br.ufrn.pds.rpgturnosdomain.model.designpatterns.TemplateMethod;

import java.util.Random;
import java.util.Scanner;

public class NoongladeMap extends TemplateMethod {
	private static final Scanner scan = new Scanner(System.in);
	private static final Random rand = new Random();
	private static int xAxisPosition = 4;
	private static int yAxisPosition = 3;
	private static int top = 7;
	private static final String[] noongladeMap = {
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
			TemplateMethod templateMethod = new NoongladeMap();
			templateMethod.printMap();

			String move = scan.nextLine();
			templateMethod.getMove(move);

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
				System.out.println("\nVocê chega à cidade portuária de The Port.");

				ThePort.thePort();

				break;
			} else if (noongladeMap[top].substring(xAxisPosition, (xAxisPosition + 1)).equals("^")) {
				Battle.randEncounter();
			} else if (noongladeMap[top].substring(xAxisPosition, (xAxisPosition + 1)).equals("≈")) {
				System.out.println("\nVocê não sabe nadar!");

				Character.loseLife(3);

				if (Character.getLife() < 1) {
					Character.gameOver("\n\"Você engoliu muita água e se afogou…");
				}
			} else {
				int randEncounter = rand.nextInt(8);

				if (randEncounter == 0) {
					Battle.randEncounter();
				}
			}
		}
	}

	@Override
	public void getMove(String move) {
		if (move.equals("w") || move.equals("W")) {
			top--;
			yAxisPosition++;
		} else if (move.equals("a") || move.equals("A")) {
			xAxisPosition--;
		} else if (move.equals("s") || move.equals("S")) {
			top++;
			yAxisPosition--;
		} else if (move.equals("d") || move.equals("D")) {
			xAxisPosition++;
		}

		if (xAxisPosition > noongladeMap[0].length() - 1) {
			xAxisPosition = noongladeMap[0].length() - 1;
		}

		if (xAxisPosition < 0) {
			xAxisPosition = 0;
		}

		if (top > noongladeMap.length - 1) {
			top = noongladeMap.length - 1;
			yAxisPosition = 0;
		}

		if (yAxisPosition > noongladeMap.length - 1) {
			top = 0;
			yAxisPosition = noongladeMap.length - 1;
		}
	}

	@Override
	public void printMap() {
		System.out.println("===============================");

		for (int aKey = 0; aKey < top; ++aKey) {
			System.out.println(noongladeMap[aKey]);
		}

		System.out.print(noongladeMap[top].substring(0, xAxisPosition));
		System.out.print(Character.printSymbol());
		System.out.print(noongladeMap[top].substring(xAxisPosition + 1, noongladeMap[top].length()));
		System.out.println();

		for (int dKey = 0; dKey < top + yAxisPosition; ++dKey) {
			System.out.println(noongladeMap[dKey + 1]);
		}

		System.out.println("===============================");
		System.out.println(
			"\nLife: " + Character.getLife() + "/" + Character.getMaxLife() + "\t\t" +
			"\tX: " + xAxisPosition +
			"\tY: " + yAxisPosition
		);
	}
}
