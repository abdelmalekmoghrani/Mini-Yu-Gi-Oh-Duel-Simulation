package classes;

import java.util.Scanner;

public class Player {
	//initialize in the main function
	private int points ; 
	
	private int cardnbr = 0 ;
	private int lifepoints=4000;
	private boolean isActive = false ;
	
	private String name ;
	
	private Card field ;
	private Card[] hand = new Card[6] ;
	
	Scanner scanner = new Scanner(System.in);
	
	//constructor function	
	public Player(String name ){
		this.name = name ;
	}
	
	//setters and getters
	public int getPoint() {
		return points;
	}
	
	public void setPoints(int newpoints) {
		this.points = newpoints;
	}
	
	public boolean getisActive() {
		return isActive;
	}
	
	public void setisActive(boolean newActive) {
		this.isActive = newActive;
	}
	
	public Card getFieldCard() {
		return field;
	} // field can be null
	
	
	
	
	public void addCard(Card newcard){
		if(newcard instanceof Monster) {
			Monster isMon = (Monster) newcard;
			if(cardnbr < 6) {
				hand[cardnbr] = new Monster(isMon.getAtk() , isMon.getDef() , isMon.getName() , isMon.getDiscription());
				cardnbr += 1 ;
			}
		}
	}
	
	public void displayCards() {
		for(int i = 0 ; i < cardnbr; i++) {
			System.out.printf("Card nbr %d\n" , i+1);
			System.out.println(hand[i]);
		}
	}
	
	
	}
	public void summon() {
		displayCards();
		
		int choosingCard ;
		do {
   
			do {
				System.out.println("choose a Card (enter the Card number):");
			 	choosingCard = scanner.nextInt();
			} while(choosingCard > cardnbr || choosingCard <= 0);
			
		} while(hand[choosingCard - 1] instanceof Monster == false);
		
		if (hand[choosingCard - 1] instanceof Monster) {
			 Monster isMon = (Monster) hand[choosingCard - 1];
			 field = new Monster(isMon.getAtk() , isMon.getDef() , isMon.getName() , isMon.getDiscription());
		 }	 
		 
		 for(int i = 0 ; i < cardnbr ; i++) {
			 if(choosingCard-1 == i) {
				 for(int j = choosingCard ; j <cardnbr ; j++) {
					 hand[j] = hand[j+1];
				 }
				 cardnbr -= 1 ;
				 break;
			 }
		 }
		   
	}
	
} 
