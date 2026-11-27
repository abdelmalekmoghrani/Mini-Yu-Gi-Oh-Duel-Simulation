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
			if(player1.isActive == true) {
				player1.summon();
				player2.summon();
			} else{
				player2.summon();
				player1.summon();
			}
		
			//initiate the battle by the active player (question)
			char respond;
			do {
				System.out.println("start the battle ? (click y)");
				respond = scanner.next();
			while(respond == 'y');
		
			//battle runs
			
			
			//display life points and the field state
			
			
			//check the winner
			
		
		}
		
		
		
	}
	
	public void checkWinner() {
		
		
	}

}
