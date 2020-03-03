package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.card.CARD_NUMBER;
import model.card.CARD_TYPE;
import model.card.Card;

public class Deck {
	private List<Card> deck;
	//To keep track of removed cards
	private Set<Card> removedCards;
	
	public Deck() {
		deck = new ArrayList<Card>();
		removedCards = new HashSet<Card>();
		generateDeck();
	}
	
	public int remainingCards() {
		return deck.size();
	}

	//Populate Deck with 52 cards
	private void generateDeck() {
		for (CARD_TYPE type : CARD_TYPE.values()) {
			for (CARD_NUMBER number : CARD_NUMBER.values())
				deck.add(new Card(type, number));
		}
		shuffle();
	}

	//Shuffle the deck
	public void shuffle() {
		Collections.shuffle(deck);
	}

	//Return List of required number of cards
	public List<Card> getCards(int n) {
		if (n > deck.size())
			return null;
		List<Card> cards = new ArrayList<Card>();
		for (int i = 0; i < n; i++) {
			cards.add(deck.get(deck.size() - 1));
			removedCards.add(deck.get(deck.size() - 1));
			deck.remove(deck.size() - 1);
		}
		return cards;
	}

	//Add cards back to deck
	public void returnCardsToDeck(List<Card> cards) {
		for (Card card : cards) {
			deck.add(card);
		}
	}
	
	public void addRemovedCards() {
		for (Card card : removedCards) {
			deck.add(card);
		}
		removedCards.clear();
	}
	
	@Override
	public String toString() {
		System.out.println("\nPrinting Cards in Deck...");
		String deckToString = "";
		for (Card card : deck)
			deckToString += (card + ", ");
		return deckToString;
	}
}
