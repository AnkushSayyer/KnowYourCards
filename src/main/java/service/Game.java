package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Deck;
import model.Player;

public class Game {
	//List of players playing the game
	private List<Player> players;
	private List<Player> result;
	private final Deck deck;
	//No. of cards a player will hold, 1 card game or 2 card game
	int noOfCards;
	
	public Game(Deck deck) {
		this.deck = deck;
	}
	
	public boolean startGame(int noOfCards, int n) {
		this.noOfCards = noOfCards;
		createPlayers(n);
		return distributeCardsToAll(noOfCards);
	}
	
	//Create n players with list of cards
	private void createPlayers(int n) {
		players = new ArrayList<Player>();
		System.out.println("\nWe have "+n+" players-");
		for(int i=1; i<=n; i++) {
			System.out.print("Player_"+i+" ");
			players.add(new Player("Player_"+i));
		}
	}

	//Give cards to players
	public boolean distributeCardsToAll(int n) {
		if(players.size()*noOfCards>deck.remainingCards()) {
			System.out.println("\n\nCant distribute cards Please check inputs.....\n"
					+ "Remaining cards - " + deck.remainingCards());
			return false;
		}
		System.out.println("\n\nDistributing cards to player/s.....");
		for(Player p : players)
			p.addCards(deck.getCards(n));
		return true;
	}
	
	//Find winner according to rules of games
	public void findWinner() {
		System.out.println("\n\nGenerating Results....");
		result = new ArrayList<>(players);
		Collections.sort(result);
		showResults();
	}
	
	//Add players and give cards to them
	public void addPlayer(int n) {
		System.out.println();
		if(n*noOfCards>deck.remainingCards()) {
			System.out.println("\n\n!!!!Cant distribute cards Please check inputs.....\n"
					+ "Remaining cards - " + deck.remainingCards());
			return;
		}
		for(int i=0; i<n; i++) {
			System.out.println("Adding Player_"+(players.size()+1));
			players.add(new Player("Player_"+(players.size()+1)));
			players.get(players.size()-1).addCards(deck.getCards(noOfCards));
		}
	}
	
	//Remove players from end and add cards back to deck
	public void removePlayer(int n) {
		System.out.println();
		if(players.size()<n) {
			System.out.println("\n\n!!!!Cant remove players Please check inputs.....\n"
					+ "Remaining palyers - " + players.size());
			return;
		}
		for(int i=0; i<n; i++) {
			deck.returnCardsToDeck(players.get(players.size()-1).returnCards());
			System.out.println("Removing Player_"+players.get(players.size()-1).getName());
			players.remove(players.size()-1);
		}
	}
	
	public void displayPlayerCards() {
		System.out.println("\nShowing Player Cards....");
		for(Player p : players)
			System.out.println(p);
		System.out.println();
	}
	
	private void showResults() {
		System.out.println("\nResults(According to Rank) --");
		System.out.println("1. "+result.get(0).getName()+"  ****WINNER****");
		for(int i=1; i<result.size(); i++)
			System.out.println(i+1+". "+result.get(i).getName());
	}
	
	public void finishGame() {
		System.out.println("\nReturning cards to Deck.....");
		for(Player p : result) {
			deck.returnCardsToDeck(p.returnCards());
		}
		players = null;
		result = null;
	}
	
	public void shuffleDeck() {
		deck.shuffle();
	}
	
	public void printCardsInGameDeck() {
		System.out.println(deck);
	}
}
