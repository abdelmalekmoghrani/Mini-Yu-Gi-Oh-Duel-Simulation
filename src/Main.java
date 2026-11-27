import java.util.Scanner;

import classes.Card;
import classes.Monster;
import classes.Player;
	

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean gameRuns = true ;
		
		//creating the Players
		Player player1 = new Player("player1");
        Player player2 = new Player("player2");
		
		//creating 12 Monsters
		Monster[] cards = new Monster[12];
        cards[0]  = new Monster(2000, 1500, "Shadow Mage", "Dark magic");
        cards[1]  = new Monster(2000, 1500, "Void Warlock", "Abyss magic");
        cards[2]  = new Monster(3000, 2500, "Storm Wyrm", "Thunder dragon");
        cards[3]  = new Monster(3000, 2500, "Tempest Drake", "Wind dragon");
        cards[4]  = new Monster(1500, 1200, "Iron Raider", "Melee fighter");
        cards[5]  = new Monster(1500, 1200, "Steel Bruiser", "Frontline fighter");
        cards[6]  = new Monster(1800, 1000, "Dawn Warden", "Castle guard");
        cards[7]  = new Monster(1800, 1000, "Sun Sentinel", "Royal guard");
        cards[8]  = new Monster(1000, 2000, "Moss Tortoise", "Armored shell");
        cards[9]  = new Monster(1000, 2000, "Stone Shell", "Rock defender");
        cards[10] = new Monster(2500, 1800, "Magma Fiend", "Lava creature");
        cards[11] = new Monster(2500, 1800, "Cinder Demon", "Fire creature");
		
		//card distribution
		for(int i = 0 ; i < 5 ; i++) {
			player1.addCard(cards[i]);
			player2.addCards(cards[i+1]);
		}
		
		//choosing the active player or who goes first
		Random rand = new Random();
        if (rand.nextInt(2) == 0) {
            player1.setisActive(true);
            player2.setisActive(false);
        } else {
            player1.setisActive(false);
            player2.setisActive(true);
        }
		
		while(gameRuns == true) {
			
			//call summon function starting by the active player then the second
			if(player1.isActive) {
				
				if(player1.cardnbr > 0) {
					player1.summon();	
				}
				if(player2.cardnbr > 0) {
					player2.summon();	
				}
				
			} else{
				
				if(player2.cardnbr > 0) {
					player2.summon();	
				}
				if(player1.cardnbr > 0) {
					player1.summon();	
				}
				
			}
		
			//initiate the battle by the active player (question)
			char respond;
			do {
				System.out.println("start the battle ? (click y)");
				respond = scanner.next();
			} while(respond == 'y');
		
			//battle runs
			if(player1.isActive == true) {
				battle(player1 , player2);
			} else {
				battle(player2 , player1);
			}
			
			//display life points and the field state
			status(player1);
			status(player2);
			
			//check the winner
			if(checkWinner()){
				gameRuns = false;
			} else {
				//changing the turn
				if(player1.isActive) {
					if((player1.cardnbr > 0 && player2.cardnbr > 0) || (player1.cardnbr == 0 && player2.cardnbr > 0)) {
						player1.setisActive(false);
						player2.setisActive(true);
					} else if(player1.cardnbr > 0 && player2.cardnbr == 0 ) {
						player1.setisActive(true);
						player2.setisActive(false));
					}
				} else {
					if((player2.cardnbr > 0 && player1.cardnbr > 0) || (player2.cardnbr == 0 && player1.cardnbr > 0)) {
						player1.setisActive(true);
						player2.setisActive(false);
					} else if(player2.cardnbr > 0 && player1.cardnbr == 0 ) {
						player1.setisActive(true);
						player2.setisActive(false));
					}
				}	
			}
			
	}
}
		
	
		
		
		
	static void battle(Player attacker, Player defender) {
		Monster atker = (Monster) attacker.getFieldCard();
		Monster defer = (Monster) defender.getFieldCard();
		System.out.println(atker.getName() + "Atk " + atker.getAtk() + "attacks"+ defer.getName() + "Atk " + defer.getAtk());

		if (atker.getAtk() == defer.getAtk()) {
			attacker.setFieldCard(null);
			defender.setFieldCard(null);
			System.out.println("both monsters are destroyed");
		} else if (atker.getAtk() > defer.getAtk()) {
			defender.setFieldCard(null);
			System.out.println("defender is destroyed");
		} else {
			attacker.setFieldCard(null);
			System.out.println("attacker is destroyed");
			attacker.damage(800);
		}
	}

	static void status(Player ply) {
		System.out.printf("%s life points = \n" + ply.getPoint() , ply.getName());
		
		if (ply.getFieldCard() == null) {
			System.out.println("Filed is empty");
		} else {
			System.out.printf("the Card that in %s Filed is: \n" , ply.getName());
			System.out.println(ply.getFieldCard());
		}
	}
	
	public void checkWinner() {
		if (player1.getPoint() <= 0) {
			System.out.println(player2.getName() + " wins!");
		} else if (player2.getPoint() <= 0) {
			System.out.println(player1.getName() + " wins!");
		} else if (player1.cardnbr == 0 && player2.cardnbr == 0 && player1.getFieldCard() == null && player2.getFieldCard() == null) {
			if (player1.getPoint() > player2.getPoint()) {
				System.out.println(player1.getName() + " wins!");
			} else if (player2.getPoint() > player1.getPoint()) {
				System.out.println(player2.getName() + " wins!");
			} else {
				System.out.println("Draw!");
			}
		}
	}

}	
		
	}

}
