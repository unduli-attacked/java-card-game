package cardsButJava;

import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

class machiKoro{
	//objects
	static Scanner scan = new Scanner(System.in);
	
	//players
	static Player p1;
	static Player p2;
	static Player p3;
	static Player p4;
	static Player p5;
	static Player p6;
	static Player winner = p1; //winner of the game
	static Deck deck; //the deck for the game
	
	static boolean win = false; //defines the end of the game
	
	public static void turn(Object player) {
		
	}
	public static void main (String [] args) {
		
		//intro
		type("Welcome to Machi Koro! This is a multiplayer game that will be played on one device because I'm too lazy to do it online.");
		type("How many players do you have? (2-6)");
		int players = Integer.valueOf(scan.nextLine());
		deck = new Deck(players);
		
		List<String> names = new ArrayList<String>();
		//Generate a new set of players
		for(int i=1; i<=players; i++) {
			type("Player "+Integer.valueOf(i)+", what is your name?");
			String name = scan.nextLine();
			names.add(name);
		}
		
		p1 = new Player(names.get(0), deck);
		p2 = new Player(names.get(1), deck);
		//dear god there has to be a better way to do this
		if(players>2) {
			p3 = new Player(names.get(2), deck);
			if(players>3) {
				p4 = new Player(names.get(3),deck);
				if(players>4) {
					p5 = new Player(names.get(4), deck);
					if(players>5) {
						p6 = new Player(names.get(5),deck);
					}
				}
			}
		}
		
	System.out.println(p1.checkHand(1)); //function check TODO delete
		for(int x=0; x<deck.cards.size(); x++) {
			System.out.print(x);
			System.out.println(deck.cards.get(x));
		}
		
		//gameplay
		while (!win) {
			turn(p1);
			turn(p2);
			turn(p3);
			turn(p4);
			turn(p5);
			turn(p6);
			win=true;
		}
	}
	
	//make word pretty
	public static void type(String input){
		char[] letters = input.toCharArray();
		for (char x : letters){
			System.out.print(x);
			try{
				Thread.sleep(45);
			}catch(Exception e){
				System.out.print("o fuk it broke");
			}
		}
		try{
				Thread.sleep(300);
			}catch(Exception e){
				System.out.print("o fuk it broke");
			}
		System.out.print("\n");
	}
}