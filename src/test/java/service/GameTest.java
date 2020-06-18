package service;

import org.junit.Test;

import model.Deck;

public class GameTest {
	
	@Test
	public void test1() {
		Deck deck = new Deck();
		Game game = new Game(deck);
		
		//noOfCards, noOfPlayers
		game.startGame(2, 3);
		game.displayPlayerCards();
		game.findWinner();
		game.displayPlayerCards();
		game.addPlayer(2);
		game.displayPlayerCards();
		game.findWinner();
		game.displayPlayerCards();
		game.removePlayer(3);
		game.displayPlayerCards();
		game.findWinner();
		game.displayPlayerCards();
	}

}
