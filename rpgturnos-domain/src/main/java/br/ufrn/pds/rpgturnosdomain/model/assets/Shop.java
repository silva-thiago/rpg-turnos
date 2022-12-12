package br.ufrn.pds.rpgturnosdomain.model.assets;

import br.ufrn.pds.rpgturnosdomain.model.micherost.Gladehollow;
import br.ufrn.pds.rpgturnosdomain.model.micherost.KalldiridCity;
import br.ufrn.pds.rpgturnosdomain.model.micherost.Winsorin;
import br.ufrn.pds.rpgturnosdomain.model.noonglade.CherryRidge;
import br.ufrn.pds.rpgturnosdomain.model.noonglade.NoongladeCity;
import br.ufrn.pds.rpgturnosdomain.model.noonglade.ThePort;
import br.ufrn.pds.rpgturnosdomain.model.noonglade.WindHeath;

import java.util.Scanner;

public class Shop {
	private static final Scanner scan = new Scanner(System.in);
	private static int choice;
	private static int gold = 3;

	public static void changeGold(int i) {
		gold += i;
	}

	public static int getGold() {
		return gold;
	}

	public static void noongladeShop() {
		System.out.println("\nBem-vindo à loja de Tallimore!");
		System.out.println("\nVocê possui " + gold + " ouro(s).");
		System.out.println(
			"\n\t1. Poção - 3 ouros" +
			"\n\t2. Punhal - 5 ouros" +
			"\n\t3. Tornozeleira - 5 ouros" +
			"\n\t4. Elixir Forte - 30 ouros" +
			"\n\t5. Sair"
		);
		System.out.print("\nQual desses itens você quer? ");
		choice = scan.nextInt();

		if (choice == 1) {
			if (gold >= 3) {
				gold -= 3;
				Battle.changeNumPots(1);
				System.out.println("\nVocê comprou a Poção! Use-o para curar-se na batalha.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.noongladeShop();
		} else if (choice == 2) {
			if (gold >= 5) {
				gold -= 5;
				Character.gainMinDamage(1);
				Character.gainMaxDamage(1);
				System.out.println("\nVocê comprou a Adaga! Seu poder de dano aumentou.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.noongladeShop();
		} else if (choice == 3) {
			if (gold >= 5) {
				gold -= 5;
				Character.gainSpeed(1);
				System.out.println("\nVocê comprou a Tornozeleira! Sua velocidade aumentou.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.noongladeShop();
		} else if (choice == 4) {
			if (gold >= 30) {
				gold -= 30;
				Battle.changePotHeal(2, 2);
				System.out.println("\nVocê comprou o Elixir Forte! A força de suas poções aumentou.");
				Shop.noongladeShop();
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
				Shop.noongladeShop();
			}
		} else if (choice == 5) {
			System.out.println("\nVocê saiu da loja de Tallimore.");
			NoongladeCity.noongladeCity();
		} else {
			Shop.noongladeShop();
		}
	}

	public static void cherryRidgeShop() {
		System.out.println("\nBem-vindo ao famoso Mercado de Cherry Ridge!");
		System.out.println("\nVocê possui " + gold + " ouro(s).");
		System.out.println(
			"\n\t1. Poção - 3 ouros" +
			"\n\t2. Armadura de cota de malha - 10 ouros" +
			"\n\t3. Espada de aço - 10 ouros" +
			"\n\t4. Tomo místico - 10 ouros" +
			"\n\t5. Sair"
		);
		System.out.print("\nQual desses itens você quer? ");
		choice = scan.nextInt();

		if (choice == 1) {
			if (gold >= 3) {
				gold -= 3;
				Battle.changeNumPots(1);
				System.out.println("\nVocê comprou a Poção! Use-o para curar-se na batalha.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.cherryRidgeShop();
		} else if (choice == 2) {
			if (gold >= 10) {
				gold -= 10;
				Character.changeMaxLife(3);
				System.out.println("\nVocê comprou a armadura de cota de malha! Sua vida máxima aumentou.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.cherryRidgeShop();
		} else if (choice == 3) {
			if (gold >= 10) {
				gold -= 10;
				Character.gainMinDamage(1);
				Character.gainMaxDamage(2);
				System.out.println("\nVocê comprou a Espada de Aço! Seu poder de dano aumentou.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.cherryRidgeShop();
		} else if (choice == 4) {
			if (gold >= 10) {
				gold -= 10;
				Character.changeMagic(1);
				System.out.println("\nVocê comprou o Tomo Místico! Sua magia aumentou.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.cherryRidgeShop();
		} else if (choice == 5) {
			System.out.println("\nVocê saiu do mercado.");
			CherryRidge.cherryRidge();
		} else {
			Shop.cherryRidgeShop();
		}
	}

	public static void windHeathShop() {
		System.out.println("\nBem-vindo à loja de Var Wind Heath!");
		System.out.println("\nVocê possui " + gold + " ouro(s).");
		System.out.println(
			"\n\t1. Poção" +
			"\n\t2. Capa de Destreza - 10 ouros" +
			"\n\t3. Feitiço do Mago - 15 ouros" +
			"\n\t4. Equipamento de Guerreiro - 20 ouros" +
			"\n\t5. Sair"
		);
		System.out.print("\nQual desses itens você quer? ");
		choice = scan.nextInt();

		if (choice == 1) {
			if (gold >= 3) {
				gold -= 3;
				Battle.changeNumPots(1);
				System.out.println("\nVocê comprou a Poção! Use-o para curar-se na batalha.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.windHeathShop();
		} else if (choice == 2) {
			if (gold >= 10) {
				gold -= 10;
				Character.gainSpeed(2);
				System.out.println("\nVocê comprou a Capa de Destreza! Sua velocidade aumentou.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.windHeathShop();
		} else if (choice == 3) {
			if (gold >= 15) {
				gold -= 15;
				Character.changeMagic(2);
				System.out.println("\nVocê comprou o Feitiço do Mago! Sua magia aumentou.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.windHeathShop();
		} else if (choice == 4) {
			if (gold >= 20) {
				gold -= 20;
				Character.changeMaxLife(2);
				Character.gainMinDamage(2);
				Character.gainMaxDamage(2);
				System.out.println("\nVocê comprou o Equipamento de Guerreiro! Sua vida máxima e dano aumentaram.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.windHeathShop();
		} else if (choice == 5) {
			System.out.println("\nVocê saiu da loja.");
			WindHeath.windHeath();
		} else {
			Shop.windHeathShop();
		}
	}

	public static void thePortShop() {
		System.out.println("\nBem-vindo ao Mercado do Porto!");
		System.out.println("\nVocê possui " + gold + " ouro(s).");
		System.out.println(
			"\n\t1. Poção - 3 ouros" +
			"\n\t2. Cajado Encantado - 15 Gold " +
			"\n\t3. Botas Aladas - 15 ouros" +
			"\n\t4. Equipamento do Feiticeiro - 20 ouros" +
			"\n\t5. Sair"
		);
		System.out.print("\nQual desses itens você quer? ");
		choice = scan.nextInt();

		if (choice == 1) {
			if (gold >= 3) {
				gold -= 3;
				Battle.changeNumPots(1);
				System.out.println("\nVocê comprou a Poção! Use-o para curar-se na batalha.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.thePortShop();
		} else if (choice == 2) {
			if (gold >= 15) {
				gold -= 15;
				Character.gainMinDamage(1);
				Character.gainMaxDamage(2);
				Character.changeMagic(1);
				System.out.println("\nVocê comprou o Cajado Encantado! Seu poder de dano e magia aumentaram.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.thePortShop();
		} else if (choice == 3) {
			if (gold >= 15) {
				gold -= 15;
				Character.changeMaxLife(2);
				Character.gainSpeed(2);
				System.out.println("\nVocê comprou as Botas Aladas! Sua vida máxima e velocidade aumentaram.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.thePortShop();
		} else if (choice == 4) {
			if (gold >= 20) {
				gold -= 20;
				Character.changeMaxLife(2);
				Character.changeMagic(2);
				Character.gainSpeed(1);
				System.out.println("\nVocê comprou o Equipamento do Feiticeiro! Sua vida máxima, magia e velocidade aumentaram.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.thePortShop();
		} else if (choice == 5) {
			System.out.println("\nVocê saiu do mercado.");
			ThePort.thePort();
		} else {
			Shop.thePortShop();
		}
	}

	public static void winsorinShop() {
		System.out.println("\nBem-vindo à loja de Winsorin!");
		System.out.println("\nVocê possui " + gold + " ouro(s).");
		System.out.println(
			"\n\t1. Poção - 3 ouros" +
			"\n\t2. Espada Relíquia - 20 ouros" +
			"\n\t3. Ídolo Ancião - 25 ouros" +
			"\n\t4. Sair"
		);
		System.out.print("\nQual desses itens você quer? ");
		choice = scan.nextInt();

		if (choice == 1) {
			if (gold >= 3) {
				gold -= 3;
				Battle.changeNumPots(1);
				System.out.println("\nVocê comprou a Poção! Use-o para curar-se na batalha.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.winsorinShop();
		} else if (choice == 2) {
			if (gold >= 20) {
				gold -= 20;
				Character.gainMinDamage(3);
				Character.gainMaxDamage(4);
				System.out.println("\nVocê comprou a Espada Relíquia! Seu poder de dano aumentado.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.winsorinShop();
		} else if (choice == 3) {
			if (gold >= 25) {
				gold -= 25;
				Character.changeMagic(3);
				System.out.println("\nVocê comprou o Ídolo Ancião! Sua magia aumentou.");
			} else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.winsorinShop();
		} else if (choice == 4) {
			System.out.println("\nVocê saiu da loja.");
			Winsorin.winsorin();
		} else {
			Shop.winsorinShop();
		}
	}

	public static void kalldiridForge() {
		System.out.println("\nBem-vindo à forja de Kalldirid!");
		System.out.println("\nVocê possui " + gold + " ouro(s).");
		System.out.println(
			"\n\t1. Armadura de Crista Kalldirid - 25 ouros" +
			"\n\t2. Espada de Prata - 25 ouros" +
			"\n\t3. Equipamento do Cavaleiro Branco - 40 ouros" +
			"\n\t4. Sair"
		);
		System.out.print("\nQual desses itens você quer? ");
		choice = scan.nextInt();

		if(choice == 1) {
			if(gold >= 25) {
				gold -= 25;
				Character.changeMaxLife(7);
				System.out.println("\nVocê comprou a Armadura de Crista Kalldirid! Sua vida máxima aumentou.");
			}
			else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.kalldiridForge();
		}
		else if(choice == 2) {
			if(gold >= 25) {
				gold -= 25;
				Character.gainMinDamage(4);
				Character.gainMaxDamage(4);
				System.out.println("\nVocê comprou a Espada de Prata! Seu poder de dano aumentou.");
			}
			else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.kalldiridForge();
		}
		else if(choice == 3) {
			if(gold >= 40) {
				gold -= 40;
				Character.changeMaxLife(6);
				Character.gainMinDamage(2);
				Character.gainMaxDamage(3);
				Character.gainSpeed(3);
				System.out.println("\nVocê comprou o Equipamento do Cavaleiro Branco! Sua vida máxima, dano e velocidade aumentaram.");
			}
			else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.kalldiridForge();
		}
		else if(choice == 4) {
			System.out.println("\nVocê saiu da forja.");
			KalldiridCity.kalldiridCity();
		}
		else {
			Shop.kalldiridForge();
		}
	}

	public static void kalldiridWizardry() {
		System.out.println("\nBem-vindo à Magia de Kalldirid!");
		System.out.println("\nVocê possui " + gold + " ouro(s).");
		System.out.println(
			"\n\t1. Amplifying Amulet - 30 ouros" +
			"\n\t2. Bottled Cyclone - 30 ouros" +
			"\n\t3. Concealing Robe - 35 ouros" +
			"\n\t4. Sair"
		);
		System.out.print("\nQual desses itens você quer? ");
		choice = scan.nextInt();

		if(choice == 1) {
			if(gold >= 30) {
				gold -= 30;
				Character.changeMagic(4);
				System.out.println("\nYou purchased the Amplifying Amulet! Your magic has increased.");
			}
			else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.kalldiridWizardry();
		}
		else if(choice == 2) {
			if(gold >= 30) {
				gold -= 30;
				Character.changeMagic(2);
				Character.gainSpeed(3);
				System.out.println("\nYou purchased the Bottle Cyclone! Your magic and speed have increased.");
			}
			else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.kalldiridWizardry();
		}
		else if(choice == 3) {
			if(gold >= 35) {
				gold -= 35;
				Character.changeMaxLife(6);
				Character.changeMagic(2);
				System.out.println("\nYou purchased the Concealing Robe! Your max life and magic have increased.");
			}
			else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.kalldiridWizardry();
		}
		else if(choice == 4) {
			System.out.println("\nVocê saiu da Magia de Kalldirid");
			KalldiridCity.kalldiridCity();
		}
		else {
			Shop.kalldiridWizardry();
		}
	}

	public static void kalldiridAlchemy() {
		System.out.println("\nBem-vindo à Alquimia de Kalldirid!");
		System.out.println("\nVocê possui " + gold + " ouro(s).");
		System.out.println(
			"\n\t1. Poção - 3 ouros" +
			"\n\t2. Elixir Forte - 25 ouros" +
			"\n\t3. Tônico Revitalizante - 35 ouros" +
			"\n\t4. Sair"
		);
		System.out.print("\nQual desses itens você quer? ");
		choice = scan.nextInt();

		if(choice == 1) {
			if(gold >= 3) {
				gold -= 3;
				Battle.changeNumPots(1);
				System.out.println("\nVocê comprou a Poção! Use-o para curar-se na batalha.");
			}
			else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.kalldiridAlchemy();
		}
		else if(choice == 2) {
			if(gold >= 25) {
				gold -= 25;
				Battle.changePotHeal(2, 2);
				System.out.println("\nVocê comprou o Elixir Forte! A força de suas poções aumentou.");
			}
			else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.kalldiridAlchemy();
		}
		else if(choice == 3) {
			if(gold >= 35) {
				gold -= 35;
				Battle.changePotHeal(3, 4);
				System.out.println("\nVocê comprou o Tônico Revitalizante! A força de suas poções aumentou.");
			}
			else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.kalldiridAlchemy();
		}
		else if(choice == 4) {
			System.out.println("\nVocê saiu da Alquimia de Kalldirid.");
			KalldiridCity.kalldiridCity();
		}
		else {
			Shop.kalldiridAlchemy();
		}
	}

	public static void gladehollowShop() {
		System.out.println("\nBem-vindo à encantadora loja de Gladehallow!");
		System.out.println("\nVocê possui " + gold + " ouro(s).");
		System.out.println(
			"\n\t1. Coroa de Folhas - 15 ouros" +
			"\n\t2. Kit do Herbalista - 25 ouros" +
			"\n\t3. Sair"
		);
		System.out.print("\nQual desses itens você quer? ");
		choice = scan.nextInt();

		if(choice == 1) {
			if(gold >= 15) {
				gold -= 15;
				Character.changeMaxLife(1);
				Character.changeMagic(1);
				System.out.println("\nVocê compra a Coroa de Folhas. Sua vida máxima e magia aumentaram.");
			}
			else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.gladehollowShop();
		}
		else if(choice == 2) {
			if(gold >= 25) {
				gold -= 25;
				Battle.changeNumPots(5);
				Battle.changePotHeal(1, 1);
				System.out.println("Você comprou o Kit do Herbalista! Você ganhou 5 poções e a força de suas poções aumentou.");
			}
			else {
				System.out.println("\nVocê não possui ouro suficiente!");
			}
			Shop.gladehollowShop();
		}
		else if(choice == 3) {
			System.out.println("\nVocê saiu da loja de Gladehollow.");
			Gladehollow.gladehollow();
		}
		else {
			Shop.gladehollowShop();
		}
	}
}
