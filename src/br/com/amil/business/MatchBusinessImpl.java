package br.com.amil.business;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.amil.models.Card;
import br.com.amil.models.Deck;
import br.com.amil.models.Match;
import br.com.amil.models.Player;

public class MatchBusinessImpl implements MatchBusiness{

	public Match initMatch(String resourceLine){
		
		Deck  currentDeck = new Deck();
		List<Card> cardsInDeck = currentDeck.getCardsInDeck(resourceLine);
		List<Card> handleCards = new ArrayList<Card>(cardsInDeck.subList(0, 5));
		
		Player currentPlayer = new Player();
		currentPlayer.getHand().setCards(handleCards);
		
		cardsInDeck.removeAll(handleCards);
		currentDeck.setCardsInDeck(cardsInDeck);	
		
		Collections.sort(currentPlayer.getHand().getCards());
		
		Match currentMatch = new Match(currentPlayer, currentDeck);
		
		return currentMatch;
	}
    
}
