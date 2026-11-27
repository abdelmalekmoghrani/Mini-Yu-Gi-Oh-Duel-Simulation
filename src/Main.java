import java.util.Scanner;

import classes.Card;
import classes.Monster;
import classes.Player;
	

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean gameRuns = true ;
		
		//creating the Players
		
		
		//creating 12 Monsters
		
		
		//card distribution
		for(int i = 0 ; i < 5 ; i++) {
			player1.addCard(cards[i]);
			player2.addCards(cards[i+1]);
		}
		
		//choosing the active player or who goes first
		
		
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
		
		
	}

}
