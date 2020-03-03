package model;

import java.util.Collections;
import java.util.List;

import model.card.Card;

public class Player implements Comparable<Player>{
	private String name;
	private List<Card> cards;
	//Sum of number of cards
	private int sumOfCardsNum;
	//Highest card a player has (Based on number then on House)
	private Card maxValCard;
	
	public Player(String name) {
		this.name = name;
	}
	
	//Give cards to player
	public void addCards(List<Card> cards) {
		this.cards = cards;
		sumOfCardsNum = getSumOfCardsNum(cards);
		Collections.sort(cards);
		maxValCard = cards.get(0);
	}
	
	public String getName() {
		return name;
	}
	
	//Print cards a player possess at any time
	public void printCards() {
		System.out.println("\n"+this.getName());
		for(Card card : cards)
			System.out.println(card);
	}
	
	//Sums the card numbers
	private int getSumOfCardsNum(List<Card> cards) {
		int sum = 0;
		for(Card card : cards)
			sum+=card.getNumber().getOrd();
		return sum;
	}
	
	//Player return cards to deck
	public List<Card> returnCards(){
		return cards;
	}

	//Logic for ranking players
	@Override
	public int compareTo(Player p2) {
		if(this.sumOfCardsNum == p2.sumOfCardsNum) {
			return this.maxValCard.compareTo(p2.maxValCard);
		}
		return p2.sumOfCardsNum - this.sumOfCardsNum;
	}
	
	public String toString() {
		return this.name + " - " + cards;
	}
}
