package service;

import java.io.IOException;

import model.Deck;

public class KnowYourCards {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Deck deck = new Deck();
		Game game = new Game(deck);
		LetsPlay letsPlay = new LetsPlay(game);
		letsPlay.play();
	}
}
