package br.ufrn.pds.rpgturnosdomain.model.assets;

import br.ufrn.pds.rpgturnosdomain.model.micherost.Gladehollow;
import br.ufrn.pds.rpgturnosdomain.model.micherost.KalldiridCity;
import br.ufrn.pds.rpgturnosdomain.model.micherost.KalldiridMap;
import br.ufrn.pds.rpgturnosdomain.model.noonglade.WindHeath;

import java.util.Random;
import java.util.Scanner;

public class Battle {
	private static final Scanner scan = new Scanner(System.in);
	private static final Random rand = new Random();
	private static final String[] enemies = {
		"Soldado morto-vivo",
		"Javali selvagem",
		"Lobo Raivoso",
		"Ladrão",
		"Fantasma",
		"Duende Hostil",
		"Elfo negro",
		"Pequeno Drake",
		"Aranha Gigante",
		"Abutre de Ossos",
		"Dia de Fogo",
		"Grifo",
		"Vampiro",
		"Lobisomem",
		"Assassino",
		"Macaco",
		"Planta carnívora",
		"Orc Furioso",
		"Troll da Rocha",
		"Kobold",
		"Guerreiro Esqueleto",
		"Crocodilo",
		"Minotauro",
		"Harpia"
	};
	private static final String[] advancedEnemies = { "Mago Corrompido", "Cavaleiro da Morte", "Cão da Praga", "Demônio Abissal" };
	private static String action;
	private static int level = 1;
	private static int numPots = 1;
	private static int potMinHeal = 4;
	private static int potMaxHeal = 6;
	private static int damage;
	private static String enemy;
	private static int enemyLife;
	private static int enemyMinDamage;
	private static int enemyMaxDamage;
	private static int enemySpeed;
	private static int minDamageChange;
	private static int maxDamageChange;
	private static int speedChange;
	private static int goldGain;
	private static boolean flee = false;

	public static void battle() {
		flee = false;

		while (Character.getLife() > 0 && enemyLife > 0) {
			System.out.println("\nVida: " + Character.getLife() + "/" + Character.getMaxLife() + "\n\n" + enemy + " Vida: " + enemyLife);

			if (Character.getSpeed() > enemySpeed) {
				Battle.action();

				if (Character.getLife() <= 0 || enemyLife <= 0) {
					break;
				}

				if (flee) {
					break;
				}

				Battle.enemyAttack();
			} else if (Character.getSpeed() < enemySpeed) {
				Battle.enemyAttack();

				if (Character.getLife() <= 0 || enemyLife <= 0) {
					break;
				}

				Battle.action();

				if (flee) {
					break;
				}
			} else {
				Battle.enemyAttack();

				if (Character.getLife() <= 0 || enemyLife <= 0) {
					break;
				}
				Battle.action();

				if (flee) {
					break;
				}
			}
		}

		Battle.resetStats();
		Battle.levelUp();

		if (Character.getLife() < 1) {
			Character.gameOver("Eles foram mortos pelo " + enemy + ".");
		} else if (enemyLife < 1 && enemy.equals("Dragão Carmesim")) {
			Battle.dragonVictory();
		} else if (enemyLife < 1 && enemy.equals("Cavaleiro Lupino")) {
			Battle.lupineKnightVictory();
		} else if (enemyLife < 1 && enemy.equals("Cavaleiro Leonino")) {
			Battle.leonineKnightVictory();
		} else if (enemyLife < 1 && enemy.equals("Arquiinimigo Thoxallimus")) {
			Battle.thoxallimusVictory();
		} else if (enemyLife < 1) {
			Battle.victory();
		}
	}

	public static void randEncounter() {
		enemy = enemies[rand.nextInt(enemies.length)];
		enemyLife = getRandInt((3 * level), (9 * level));
		enemySpeed = getRandInt((level), (6 * level));
		enemyMinDamage = level;
		enemyMaxDamage = 4 * level;

		System.out.println("\n" + enemy + " se aproxima!");

		Battle.battle();
	}

	public static void advancedEncounter() {
		enemy = advancedEnemies[rand.nextInt(advancedEnemies.length)];
		enemyLife = getRandInt((5 * level), (10 * level));
		enemySpeed = getRandInt((3 * level), (6 * level));
		enemyMinDamage = 2 * level;
		enemyMaxDamage = 4 * level;

		System.out.println("\n" + enemy + " se aproxima!");

		Battle.battle();
	}

	public static void dragonBattle() {
		enemy = "Dragão Carmesim";
		enemyLife = 25;
		enemySpeed = 8;
		enemyMinDamage = 3;
		enemyMaxDamage = 6;

		System.out.println("\nVocê confronta " + enemy + "!");

		Battle.battle();
	}

	public static void soldierTraining() {
		enemy = "Soldado de Treinamento";
		enemyLife = getRandInt((3 * level), (9 * level));
		enemySpeed = getRandInt((2 * level), (6 * level));
		enemyMinDamage = 2 * level;
		enemyMaxDamage = 3 * level;

		System.out.println("\n" + enemy + " te desafia para uma luta prática!");

		Battle.battle();
	}

	public static void lupineKnightBattle() {
		enemy = "Cavaleiro Lupino";
		enemyLife = 35;
		enemySpeed = 9;
		enemyMinDamage = 5;
		enemyMaxDamage = 7;

		System.out.println("\nVocê duela com " + enemy + "!");

		Battle.battle();
	}

	public static void leonineKnightBattle() {
		enemy = "Cavaleiro Leonine";
		enemyLife = 31;
		enemySpeed = 12;
		enemyMinDamage = 7;
		enemyMaxDamage = 7;

		System.out.println("\nVocê duela com " + enemy + "!");

		Battle.battle();
	}

	public static void thoxallimusBattle() {
		enemy = "Arquiinimigo Thoxallimus";
		enemyLife = 55;
		enemySpeed = 100;
		enemyMinDamage = 6;
		enemyMaxDamage = 12;

		System.out.println("\nA batalha final contra " + enemy + " está diante de você!");

		Battle.battle();
	}

	public static void action() {
		System.out.println(
			"\n\t1. Ataque" +
			"\n\t2. Magia" +
			"\n\t3. Usar poção" +
			"\n\t4. Fugir"
		);

		action = scan.nextLine();

		switch (action) {
			case "1":
				Battle.attack();
				break;
			case "2":
				Battle.magic();
				break;
			case "3":
				Battle.usePotion();
				break;
			case "4":
				Battle.flee();
				break;
			default:
				Battle.action();
				break;
		}
	}

	public static void attack() {
		damage = getRandInt(Character.getMinDamage(), Character.getMaxDamage());
		enemyLife -= damage;

		System.out.println("\nVocê ataca " + enemy + " para " + damage + " causar dano!");
	}

	public static void enemyAttack() {
		int enemyDamage = getRandInt(enemyMinDamage, enemyMaxDamage);

		System.out.println("\n" + enemy + " te ataca para " + enemyDamage + " causar dano!");

		Character.loseLife(enemyDamage);
	}

	public static void magic() {
		if (Character.getRole() == 1) {
			System.out.println(
				"\n\t1. Condicionamento" +
				"\n\t2. Regenerado"
			);

			action = scan.nextLine();

			if (action.equals("1")) {
				minDamageChange += Character.getMagic() / 2;
				maxDamageChange += Character.getMagic() / 2;
				speedChange += Character.getMagic();

				Character.gainMinDamage(Character.getMagic() / 2);
				Character.gainMaxDamage(Character.getMagic() / 2);
				Character.gainSpeed(Character.getMagic());

				System.out.println("\nVocê aprimora suas habilidades de batalha, aumentando suas estatísticas de dano em " + Character.getMagic() / 2 + " e aumentando sua velocidade " + Character.getMagic() + ".");
			} else if (action.equals("2")) {
				Character.gainLife(Character.getMagic());

				if (Character.getLife() > Character.getMaxLife()) {
					Character.heal();
				}
				System.out.println("\nVocê lança um feitiço rejuvenescedor, restaurando " + Character.getMagic() + " de vida.");
			} else {
				Battle.magic();
			}
		} else if (Character.getRole() == 2) {
			System.out.println(
				"\n\t1. Aposta do herói" +
				"\n\t2. Preparação"
			);

			action = scan.nextLine();

			if (action.equals("1")) {
				damage = getRandInt(1, (Character.getMagic() * 3));
				enemyLife -= damage;

				System.out.println("\nVocê lança um feitiço poderoso, mas arriscado, lidando com " + damage + " de dano.");
			} else if (action.equals("2")) {
				minDamageChange += Character.getMagic() / 2;
				maxDamageChange += Character.getMagic() / 2;

				Character.gainMinDamage(Character.getMagic() / 2);
				Character.gainMaxDamage(Character.getMagic() / 2);
				Character.gainLife(Character.getMagic() / 2);

				if (Character.getLife() > Character.getMaxLife()) {
					Character.heal();
				}

				System.out.println("\nVocê se prepara para o combate, aumentando suas estatísticas de dano em " + Character.getMagic() / 2 + " e restaurando " + Character.getMagic() / 2 + " de vida.");
			} else {
				Battle.magic();
			}
		} else if (Character.getRole() == 3) {
			System.out.println(
				"\n\t1. Feitiço Vampírico" +
				"\n\t2. Pequeno furto"
			);

			action = scan.nextLine();

			if (action.equals("1")) {
				damage = Character.getMagic();

				Character.gainLife(Character.getMagic() / 2);

				if (Character.getLife() > Character.getMaxLife()) {
					Character.heal();
				}
				enemyLife -= damage;

				System.out.println("\nVocê lança um feitiço de sucção de vida, lidando " + damage + " de dano e curando-se por " + (damage / 2) + " de vida.");
			} else if (action.equals("2")) {
				damage = Character.getMagic() / 2;
				goldGain = getRandInt((Character.getMagic() / 2), Character.getMagic());
				enemyLife -= damage;

				System.out.println("\nVocê rouba do inimigo, lidando " + damage + " de dano e ganho " + goldGain + " de ouro.");
			} else {
				Battle.magic();
			}
		}
	}

	public static void resetStats() {
		Character.loseMinDamage(minDamageChange);
		Character.loseMaxDamage(maxDamageChange);
		Character.loseSpeed(speedChange);

		minDamageChange = 0;
		maxDamageChange = 0;
		speedChange = 0;
	}

	public static void usePotion() {
		if (numPots > 0) {
			int potHeal = getRandInt(potMinHeal, potMaxHeal);

			Character.gainLife(potHeal);

			if (Character.getLife() > Character.getMaxLife()) {
				Character.heal();
			}

			numPots--;

			System.out.println("\nVocê bebe uma poção, restaurando " + potHeal + " de vida.");
			System.out.println("\nVocê tem " + numPots + " poções restantes.");
		} else {
			System.out.println("\nVocê não tem nenhuma poção!");
		}
	}

	public static void flee() {
		if (Character.getSpeed() <= enemySpeed) {
			int fleeChance = 0;
		}

		System.out.println("\nVocê fugiu!");
		flee = true;
	}

	public static void victory() {
		System.out.println("\nVocê é vitorioso!");

		goldGain = getRandInt(2, 5);

		Shop.changeGold(goldGain);

		System.out.println("\nVocê ganhou " + goldGain + " ouro(s)!");

		Battle.passiveAbility();
	}

	public static void dragonVictory() {
		System.out.println("\nVocê matou " + enemy + "!");

		WindHeath.slayDragon();

		goldGain = 10;

		Shop.changeGold(goldGain);

		System.out.println("\nVocê ganhou " + goldGain + " ouro(s)!");

		Battle.passiveAbility();
		WindHeath.windHeath();
	}

	public static void lupineKnightVictory() {
		System.out.println("\nVocê acabou com " + enemy + "!");

		KalldiridCity.slayLupineKnight();

		goldGain = 15;

		Shop.changeGold(goldGain);

		System.out.println("\nVocê ganhou " + goldGain + " ouro(s)!");

		Battle.passiveAbility();
		Gladehollow.gladehollow();
	}

	public static void leonineKnightVictory() {
		System.out.println("\nVocê acabou com " + enemy + "!");

		KalldiridCity.slayLeonineKnight();

		goldGain = 15;

		Shop.changeGold(goldGain);

		System.out.println("\nVocê ganhou " + goldGain + " ouro(s)!");

		Battle.passiveAbility();
		KalldiridMap.move();
	}

	public static void thoxallimusVictory() {
		System.out.println("\n" + enemy + " foi enviado para seu descanso eterno!");

		Character.gameWon();
	}

	public static void passiveAbility() {
		if (Character.getRole() == 1) {
			int i = rand.nextInt(3);

			if (i == 0) {
				System.out.println("\nSeu valor cavalheiresco concede a você um bônus de vida máxima.");

				Character.changeMaxLife(1);
			}
		} else if (Character.getRole() == 2) {
			System.out.println("\nSua alma aventureira regenera um pouco da sua vida perdida.");

			Character.gainLife(getRandInt((level), (3 * level)));

			if (Character.getLife() > Character.getMaxLife()) {
				Character.heal();
			}
		} else if (Character.getRole() == 3) {
			int i = rand.nextInt(3);

			if (i == 0) {
				System.out.println("\nSeu instinto assassino lhe concede bônus de dano máximo.");

				Character.gainMaxDamage(1);
			}
		}
	}

	public static void levelUp() {
		if (Character.getTotalStats() >= (40 * level)) {
			level++;
		}
	}

	public static int getNumPots() {
		return numPots;
	}

	public static void changeNumPots(int i) {
		numPots += i;
	}

	public static void changePotHeal(int x, int y) {
		potMinHeal += x;
		potMaxHeal += y;
	}

	public static int getRandInt(int min, int max) {
		int spread = max - min;

		return new Random().nextInt(spread + 1) + min;
	}
}
