package br.com.amil.models;

public class Match {

	private Player matchPlayer;
	private Deck matchDeck;
	
	public Match(Player matchPlayer, Deck matchDeck) {
		super();
		this.matchPlayer = matchPlayer;
		this.matchDeck = matchDeck;
	}
	public Player getMatchPlayer() {
		return matchPlayer;
	}
	public void setMatchPlayer(Player matchPlayer) {
		this.matchPlayer = matchPlayer;
	}
	public Deck getMatchDeck() {
		return matchDeck;
	}
	public void setMatchDeck(Deck matchDeck) {
		this.matchDeck = matchDeck;
	}
	

	
	
}
