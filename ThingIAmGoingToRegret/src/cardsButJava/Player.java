package cardsButJava;

import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import cardsButJava.Deck;

public class Player {
	Random rand = new Random();
	Deck d;
	public Player (String name, Deck d) {
		this.name = name;
		this.d = d;
	}
	String name;
	int coins = 3;
	
	List<Integer> hand = new ArrayList<Integer>();{hand.add(7);hand.add(12);}
	
	List<Boolean> lms = new ArrayList<Boolean>();{lms.add(false);lms.add(false);lms.add(false);lms.add(false);lms.add(false);lms.add(false);lms.add(false);}
	
	public int roll(int dice) {
		if(dice==2&&lms.get(3)) {
			machiKoro.type("Rolling two dice");
			return rand.nextInt(11)+1;
		}else {
			machiKoro.type("Rolling one die");
			return rand.nextInt(5)+1;
		}
	}
	
	public void randDeal() {
		d.addRCard(this.hand);
	}
	
	public void buy(int marketSlot) {
		int card = d.market.get(marketSlot);
		if(d.price(card)<=this.coins) {
			d.addCard(hand, card);
			this.coins -= d.price(card);
			d.removeCard(marketSlot);
			d.addRCard(d.market);
		}
	}
	
	public void flip(int landmark) {
		if((!lms.get(landmark))&&(d.price(landmark)<=this.coins)) {
			lms.set(landmark, true);
		}
	}
	
	public List<Integer> checkHand(int roll) {
		List<Integer> yeses = new ArrayList<Integer>();
		for (int x : hand) {
			if(d.rollCheck(x, roll)) {
				yeses.add(x);
			}
		}
		return yeses;
	}
	
	public boolean checkWin() {
		if(lms.get(0)&&lms.get(1)&&lms.get(2)&&lms.get(3)&&lms.get(4)&&lms.get(5)&&lms.get(6)) {
			return true;
		}
		return false;
	}
}
