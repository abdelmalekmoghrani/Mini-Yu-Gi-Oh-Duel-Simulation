import classes.Card;
import classes.Monster;
import classes.Player;
public class Main {
	//battle runs
	static void battle(Player attacker, Player defender) {
		Monster ateck = (Monster)attacker.getFieldCard() ;
		Monster defen =(Monster) defender.getFieldCard();
		System.out.println(ateck.getName() +"Atk "+ ateck.getAtk() +"attacks"  +
				defen.getName() +"Atk "+ defen.getAtk()  );
		  
		if(ateck.getAtk()==defen.getAtk()) {
			attacker.setField(null);
			defender.setField(null);
			System.out.println("the both monsters is destroyed");
			
          }
		else if(ateck.getAtk() > defen.getAtk()) {
			defender.setField(null);
			System.out.println("defender is destroyed");
			
		 }
		else {
			int diferenc= defen.getAtk()-ateck.getAtk();
		 attacker.setField(null);
		 System.out.println("attacker is destroyed");
		 attacker.damage(diferenc);
			
		}
	}
		static void position (Player p) {
			System.out.println ("player : " );
			System.out.println("life points of player :" + p.getPoint());
			if(p.getFieldCard()==null) {
				System.out.println("Filed is empty");
				
			}
			
			else {
				System.out.println("the Filed is:" + p.getFieldCard().getName());
				
				
			}
		}
		
		
		
		
		
	
	
	
	

	public static void main(String[] args) {
<<<<<<< HEAD
		
		boolean gameRuns = true ;
		
		//creating the Players
		
		
		//creating 12 Monsters
		
		
		//card distribution
		
		
		//choosing the active player or who goes first
		
		
		while(gameRuns == true) {
		//call summon function starting by the active player then the second
		
		
		//initiate the battle by the active player (question)
		
			
		
			
			
					
			
		//check the winner
			
		
		}
		
		
		
	}
	
	public void checkWinner() {
		
		
=======
		// TODO Auto-generated method 
>>>>>>> b2300d66777dda87b4b5b60d065c0a32f9139bb3
	}

}
