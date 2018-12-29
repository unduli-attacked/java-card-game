/*TO CREATE A DECK:
	1. Deck deck = new Deck(numPlayers);
	2. deck.popSupply();
	3. deck.createMarket();
*/
package cardsButJava;

import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Deck {
	Random rand = new Random();
	public Deck (int players) {
		this.slots = players*2;
	}
	int slots;
	
	//lists
		//card names
		List<String> cards = Arrays.asList("City Hall","Harbor","Train Station","Shopping Mall","Amusement Park","Radio Tower","Airport","Wheat Field","Ranch","Forest",
			"Mine","Apple Orchard","Bakery","Convenience Store", "Cheese Factory","Furniture Factory","Fruit & Vegetable Market","Cafe","Family Restaurant","Stadium",
			"TV Station","Business Center","Flower Orchard","Mackerel Boat","Tuna Boat","Flower Shop","Food Warehouse","Sushi Bar","Pizza Joint","Hamburger Stand",
			"Publisher","Tax Office","Corn Field","Vineyard","General Store","Moving Company","Winery","Demolition Company","Soda Bottling Plant","French Restaurant",
			"Park","Renovation Company","International Exhibit Hall");
	
		//activation numbers
		List<Integer> ones = Arrays.asList(7,27);
		List<Integer> twos = Arrays.asList(8,34,12);
		List<Integer> threes = Arrays.asList(17,12,32);
		List<Integer> fours = Arrays.asList(22,13,37,32);
		List<Integer> fives = Arrays.asList(39,9);
		List<Integer> sixes = Arrays.asList(19,20,21,25);
		List<Integer> sevens = Arrays.asList(33,28,14,30);
		List<Integer> eights = Arrays.asList(23,29,15,41,31);
		List<Integer> nines = Arrays.asList(36,10,31,18,35);
		List<Integer> tens = Arrays.asList(11,42,18,35);
		List<Integer> elevens = Arrays.asList(38,16,40);
		List<Integer> twelves = Arrays.asList(12,16,40,26,24);
		List<Integer> thirteens = Arrays.asList(12,40,26);
		List<Integer> fourteens = Arrays.asList(12,24);
		
		//colors
		List<Integer> lands = Arrays.asList(0,1,2,3,4,5,6); //also used for type
		List<Integer> blues = Arrays.asList(7,8,9,10,11,22,23,24,32,33);
		List<Integer> greens = Arrays.asList(12,13,14,15,16,25,26,34,35,36,37,38);
		List<Integer> reds = Arrays.asList(17,18,27,28,29,39);
		List<Integer> purples = Arrays.asList(19,20,21,30,31,40,41,42); //also used for type
		
		//types
		List<Integer> ags = Arrays.asList(7,11,22,32,33); //wheat
		List<Integer> shops = Arrays.asList(12,13,25,34); //bread thingy
		List<Integer> cups = Arrays.asList(17,18,27,28,29,39); //cup
		List<Integer> meats = Arrays.asList(8); //cow
		List<Integer> raws = Arrays.asList(9,10); //gear wheel
		List<Integer> indus = Arrays.asList(14,15,26,36,38); //factory
		List<Integer> fruit = Arrays.asList(16); //fruit
		List<Integer> boats = Arrays.asList(23,24); //harbor-specific
		List<Integer> suits = Arrays.asList(35,37); //briefcase
		
		//prices
		List<Integer> free = Arrays.asList(34,0);
		List<Integer> one = Arrays.asList(7,8,25,28,29,12);
		List<Integer> two = Arrays.asList(17,22,13,37,23,32,35,16,26,1);
		List<Integer> three = Arrays.asList(39,9,33,15,36,11,18,40);
		List<Integer> four = Arrays.asList(27,41,31,2);
		List<Integer> five = Arrays.asList(14,30,38,24);
		List<Integer> six = Arrays.asList(19,10);
		List<Integer> seven = Arrays.asList(20,42);
		List<Integer> eight = Arrays.asList(21);
		List<Integer> ten = Arrays.asList(3);
		List<Integer> sixteen = Arrays.asList(4);
		List<Integer> twentyTwo = Arrays.asList(5);
		List<Integer> thirty = Arrays.asList(6);
		
		List<Integer> supply = new ArrayList<Integer>();//don't know why{
		
		public void popSupply() {
			int i = 0;
			while(i<42) {
				if(purples.contains(i)) {
					supply.add(slots/2);
				}else if(lands.contains(i)) {
					supply.add(0);
				}else {
					supply.add(6);
				}
				i++;
			}
		}
		
	//market methods
	List<Integer> market = new ArrayList<Integer>();
	
	//create market
	public void createMarket() {
		for(int i=0; i>=slots; i++) {
			addRCard(market);
		}
	}
	
	//deal new card
	public void addRCard(List<Integer> list) {
		Integer card = rand.nextInt(42-7)+7; //have to add 7 so it doesn't pick a landmark //have to subtract 7 so it doesn't pick a nonexistent card you dumbfuck
		while(supply.get(card)<1) { //bad things we don't want
			card = rand.nextInt(42-7)+7;
		}
		
	}
	
	public void addCard(List<Integer> list, int card) {
		list.add(card);
		supply.set(card, supply.get(card)-1);
	}
	
	//remove card
	public void removeCard(int slot) {
		market.remove(slot);
		addRCard(market);
	}
	
	//sweep market
	public void sweep() {
		market.removeAll(market);
		createMarket();
	}
	
	
	//card-related methods

	
	//id card
	public int id (String card) {
		switch (card) {
		case "City Hall":
			return 0;
		case "Harbor":
			return 1;
		case "Train Station":
			return 2;
		case "Shopping Mall":
			return 3;
		case "Amusement Park":
			return 4;
		case "Radio Tower":
			return 5;
		case "Airport":
			return 6;
		case "Wheat Field":
			return 7;
		case "Ranch":
			return 8;
		case "Forest":
			return 9;
		case "Mine":
			return 10;
		case "Apple Orchard":
			return 11;
		case "Bakery":
			return 12;
		case "Convenience Store":
			return 13;
		case "Cheese Factory":
			return 14;
		case "Furniture Factory":
			return 15;
		case "Fruit & Vegetable Market":
			return 16;
		case "Cafe":
			return 17;
		case "Family Restaurant":
			return 18;
		case "Stadium":
			return 19;
		case "TV Station":
			return 20;
		case "Business Center":
			return 21;
		case "Flower Orchard":
			return 22;
		case "Mackerel Boat":
			return 23;
		case "Tuna Boat":
			return 24;
		case "Flower Shop":
			return 25;
		case "Food Warehouse":
			return 26;
		case "Sushi Bar":
			return 27;
		case "Pizza Joint":
			return 28;
		case "Hamburger Stand":
			return 29;
		case "Publisher":
			return 30;
		case "Tax Office":
			return 31;
		case "Corn Field":
			return 32;
		case "Vineyard":
			return 33;
		case "General Store":
			return 34;
		case "Moving Company":
			return 35;
		case "Winery":
			return 36;
		case "Demolition Company":
			return 37;
		case "Soda Bottling Plant":
			return 38;
		case "French Restaurant":
			return 39;
		case "Park":
			return 40;
		case "Renovation Company":
			return 41;
		case "International Exhibit Hall":
			return 42;
		
		}
		return 0;
	}
	
	//get card price
	public int price(int id) {
		if(free.contains(id)) {
			return 0;
		}else if(one.contains(id)) {
			return 1;
		}else if(two.contains(id)) {
			return 2;
		}else if(three.contains(id)) {
			return 3;
		}else if(four.contains(id)) {
			return 4;
		}else if(five.contains(id)) {
			return 5;
		}else if(six.contains(id)) {
			return 6;
		}else if(seven.contains(id)) {
			return 7;
		}else if(eight.contains(id)) {
			return 8;
		}else if(ten.contains(id)) {
			return 10;
		}else if(sixteen.contains(id)) {
			return 16;
		}else if(twentyTwo.contains(id)) {
			return 22;
		}else if(thirty.contains(id)) {
			return 30;
		}
		return 0;
	}
	
	//die number
	public boolean rollCheck(int id, int die) {
		if ((die==1&&ones.contains(id))
				|| (die==2&&twos.contains(id))
				|| (die==3&&threes.contains(id))
				|| (die==4&&fours.contains(id))
				|| (die==5&&fives.contains(id))
				|| (die==6&&sixes.contains(id))
				|| (die==7&&sevens.contains(id))
				|| (die==8&&eights.contains(id))
				|| (die==9&&nines.contains(id))
				|| (die==10&&tens.contains(id))
				|| (die==11&&elevens.contains(id))
				|| (die==12&&twelves.contains(id))
				|| (die==13&&thirteens.contains(id))
				|| (die==14&&fourteens.contains(id))) {
			return true;
		}
		return false;
	}
	
	
	/*int payout(int id, int die, boolean mall) {
		int pay=0;
		if(simplePayout.contains(id)) {
			if(roll(id, die)) {
				
			}
			if(mall&&shops.contains(id)) {
				pay++;
			}
		}
		return pay;
	}*/
}