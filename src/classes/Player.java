package classes;

import java.util.Scanner;

public class Player {

	private int points ; //initialize in the main function
	private int cardnbr = 0 ;
	
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
	public String getName() {
		return this.name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public int getPoint() {
		return points;
	}
	
	public void setPoints(int newPoints) {
		this.points = newPoints;
	}
	
	public void damage(int dmg) {
		this.points -= dmg;
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
	
	public void setFieldCard(Card newCard) {
		this.field = newCard;
	}
	
	//add card and display methods
	
	public void addCard(Card newCard){
		if(newCard instanceof Monster) {
			Monster isMon = (Monster) newCard;
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
	
	//summon method
	public void summon() {
		displayCards();
		
		int choosingCard ;
		do {

			do {
				System.out.printf("%s choose a Card to summon (enter the Card number):" , this.name);
			 	choosingCard = scanner.nextInt();
			} while(choosingCard > cardnbr || choosingCard <= 0);
			
		} while(hand[choosingCard - 1] instanceof Monster == false);
		
		setFieldCard(hand[choosingCard - 1]);
		 
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
