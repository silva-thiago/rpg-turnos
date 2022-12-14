package br.ufrn.pds.rpgturnosdomain.model.micherost;

import br.ufrn.pds.rpgturnosdomain.model.assets.Battle;
import br.ufrn.pds.rpgturnosdomain.model.assets.Character;

import br.ufrn.pds.rpgturnosdomain.model.designpatterns.TemplateMethod;

import java.util.Random;
import java.util.Scanner;

public class KalldiridMap extends TemplateMethod {
	private static final Scanner scan = new Scanner(System.in);
	private static final Random rand = new Random();
	private static int xAxisPosition = 4;
	private static int yAxisPosition = 3;
	private static int top = 7;
	private static final String[] kalldiridMap = {
		"   ^^^^^^^   ✠  ^^^^^^^^^^^^^^^",
		" ♜   ^^^^^^^  ^^^^^ ^^^^^  ^^^^",
		"^       ^^^^^^^^^     ^^   ♛  ^",
		"^^^        ^^^^^             ≈≈",
		"  ^^                       ≈≈≈≈",
		"≈≈≈ ^         ^^            ≈≈≈",
		"≈≈≈≈≈≈≈ ♝    ^^^    ^^   ^^    ",
		"≈≈≈≈≈≈≈≈≈≈         ^^^^^  ^^^^ ",
		"≈≈≈≈≈≈≈≈≈≈≈≈≈       ^^^^^^^^♝^^",
		"≈≈≈≈≈≈≈≈≈≈≈≈≈≈    ^^ ^^^^^≈≈≈≈^",
		"≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈       ^^^^≈≈≈≈"
	};

	public static void move() {
		boolean walking = true;

		System.out.println("\nUse as teclas W, A, S e D para andar no mapa.");

		while (walking) {
			TemplateMethod templateMethod = new KalldiridMap();
			templateMethod.printMap();

			String move = scan.nextLine();
			templateMethod.getMove(move);

			if(xAxisPosition == 8 && yAxisPosition == 4) {
				System.out.println("\nVocê chega na modesta cidade portuária de Winsorin.");

				Winsorin.winsorin();

				break;
			} /*else if(xAxisPosition == 1 && yAxisPosition == 9) {
				System.out.println("\nVocê chega à fortaleza militar de Hanawyn.");

				Hanawyn.hanawyn();

				break;
			}*/ else if(xAxisPosition == 28 && yAxisPosition == 2) {
				System.out.println("\nVocê chega na cidade florestal de Gladehollow.");

				Gladehollow.gladehollow();

				break;
			} else if(xAxisPosition == 27 && yAxisPosition == 8) {
				System.out.println("\nVocê chega na Cidade Imperial de Kalldirid.");

				KalldiridCity.kalldiridCity();

				break;
			} /*else if(xAxisPosition == 13 && yAxisPosition == 10) {
				System.out.println("\nVocê chega a uma torre antiga e abandonada.");

				OldTower.oldTower();
			}*/ else if (kalldiridMap[top].substring(xAxisPosition, (xAxisPosition + 1)).equals("^")) {
				Battle.randEncounter();
			} else if (kalldiridMap[top].substring(xAxisPosition, (xAxisPosition + 1)).equals("≈")) {
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

		if (xAxisPosition > kalldiridMap[0].length() - 1) {
			xAxisPosition = kalldiridMap[0].length() - 1;
		}

		if (xAxisPosition < 0) {
			xAxisPosition = 0;
		}

		if (top > kalldiridMap.length - 1) {
			top = kalldiridMap.length - 1;
			yAxisPosition = 0;
		}

		if (yAxisPosition > kalldiridMap.length - 1) {
			top = 0;
			yAxisPosition = kalldiridMap.length - 1;
		}
	}

	@Override
	public void printMap() {
		System.out.println("===============================");

		for (int aKey = 0; aKey < top; ++aKey) {
			System.out.println(kalldiridMap[aKey]);
		}

		System.out.print(kalldiridMap[top].substring(0, xAxisPosition));
		System.out.print(Character.printSymbol());
		System.out.print(kalldiridMap[top].substring(xAxisPosition + 1, kalldiridMap[top].length()));
		System.out.println();

		for (int dKey = 0; dKey < top + yAxisPosition; ++dKey) {
			System.out.println(kalldiridMap[dKey + 1]);
		}

		System.out.println("===============================");
		System.out.println(
			"\nLife: " + Character.getLife() + "/" + Character.getMaxLife() + "\t\t\t\t" +
				"\tX: " + xAxisPosition +
				"\tY: " + yAxisPosition
		);
	}
}
