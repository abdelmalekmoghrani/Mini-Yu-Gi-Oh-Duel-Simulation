package classes;

import java.util.Scanner;

public class Player {

	int points = 4000 ;
	int cardnbr = 0 ;
	
	String name ;
	
	Card field ;
	Card[] hand = new Card[3] ;
	
	Scanner scanner = new Scanner(System.in);
	
	Player(String name){
		this.name = name ;
	}
	
	void addCard(Monster newcard){
		if(cardnbr < 3) {
			hand[cardnbr] = new Monster(newcard.Atk , newcard.Def , newcrd.name , newcard,description);
			cardnbr += 1 ;
		}
	}
	
	void displayCards() {
		for(int i = 0 ; i < cardnbr; i++) {
			System.out.printf("Card nbr %d\n" , i+1);
			System.out.println(hand[i].name);
			System.out.println(hand[i].description);
			System.out.printf("ATK = %d" , hand[i].Atk));
			System.out.printf("DEF = %d\n" , hand[i].Def));
		}
	}
	
	void summon() {
		displayCards();
		
		int choosingCard ;
		do {

			do {
				System.out.println("choose a Card (enter the Card number):");
			 	choosingCard = new scanner.nextInt();
			} while(choosingCard > 3 && choosingCard <= 0);
			
		} while(hand[choosingCard-1] instanceof Monster == false);
		 
		 for(int i = 0 ; i < cardnbr ; i++) {
			 if(choosingCard-1 == i) {
				 for(int j = choosingCard ; j <cardnbr ; j++) {
					 hand[j] = hand[j+1];
				 }
				 cardnbr -= 1 ;
				 break
			 }
		 }
		  
		 field = new Monster(hand[choosingCard-1].Atk , hand[choosingCard-1].Def , hand[choosingCard-1].name , hand[choosingCard-1],description);
		
	}
	
}
