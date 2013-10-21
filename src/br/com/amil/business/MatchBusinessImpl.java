package br.com.amil.business;


import java.util.ArrayList;
import java.util.List;

import br.com.amil.models.Card;
import br.com.amil.models.Deck;
import br.com.amil.models.Hand;
import br.com.amil.models.Match;

public class MatchBusinessImpl implements MatchBusiness{

	public Match initMatch(String resourceLine){
		
		Hand  currentHand = new Hand();
		Deck  currentDeck = new Deck();
		
		List<Card> cardsInDeck = currentDeck.getCardsInDeck(resourceLine);
		List<Card> handleCards = new ArrayList<Card>(cardsInDeck.subList(0, 5));
		currentHand.setCards(handleCards);
		cardsInDeck.removeAll(handleCards);
		currentDeck.setCardsInDeck(cardsInDeck);		
		Match currentMatch = new Match(currentHand, currentDeck);
		
		return currentMatch;
	}
    
}
