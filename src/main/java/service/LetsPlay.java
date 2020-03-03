package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LetsPlay {
	private final Game game;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public LetsPlay(Game game) {
		this.game = game;
	}
	
	public void play() throws NumberFormatException, IOException {
		System.out.println("\n**** KNOW YOUR CARDS ****");
		boolean play = true;
		int n;
		while(play) {
			System.out.println();
			System.out.println("Press 1 to Start Game");
			System.out.println("Press 2 to Quit");
			n = Integer.parseInt(br.readLine());
			switch(n) {
			case 1:
				System.out.println("Enter number of players -");
				int p = Integer.parseInt(br.readLine());
				System.out.println("Press 1 for 1 card game -");
				System.out.println("Press 2 for 2 card game -");
				System.out.println("Rules For 1 card game:\nPlayer with highest number card wins"
						+ ", if number is same winner is decided on basis of House order of which is"
						+ " SPADES>HEART>CLUB>DIAMONDS");
				System.out.println("Rules For 2 card game:\nPlayer with highest sum of number of cards' wins"
						+ ", if sum is same winner is decided on basis of the player which has highest card which"
						+ " is decided as in 1 card game");
				int noOfCards = Integer.parseInt(br.readLine());
				switch(noOfCards) {
				case 1: case 2:
					if(!game.startGame(noOfCards, p)) {
						break;
					}
						
					boolean gameStart = true;
					while(gameStart) {
						System.out.println();
						System.out.println("Press 1 to add players game -");
						System.out.println("Press 2 to remove players from game -");
						System.out.println("Press 3 to print cards in deck in game -");
						System.out.println("Press 4 to print cards of each player -");
						System.out.println("Press 5 to find Winner -");
						System.out.println("Press 6 to finish game(Return cards to Deck) -");
						int option = Integer.parseInt(br.readLine());
						switch(option) {
						case 1:
							System.out.println("Enter number of players to add -");
							int addP = Integer.parseInt(br.readLine());
							game.addPlayer(addP);
							break;
						case 2:
							System.out.println("Enter number of players to remove -");
							int removeP = Integer.parseInt(br.readLine());
							game.addPlayer(removeP);
							break;
						case 3:
							game.printCardsInGameDeck();
							break;
						case 4:
							game.displayPlayerCards();
							break;
						case 5:
							game.findWinner();
							break;
						case 6:
							game.finishGame();
							gameStart = false; 
							break;
						default:
							System.out.println("Invalid option try again");
						}
					}
					break;
				default:
					System.out.println("Invalid option try again");
				}
				break;
			case 2:
				play = false;
			default:
				System.out.println("Invalid option try again");
			}
		}
	}
}
