package br.com.amil.models;

public class Match {

	private Hand matchHand;
	private Deck matchDeck;
	
	public Match(Hand currentHand, Deck currentDeck){
		this.matchHand = currentHand;
		this.matchDeck = currentDeck;
	}
	
	public Hand getMatchHand() {
		return matchHand;
	}
	public Deck getMatchDeck() {
		return matchDeck;
	}
	
	
}
