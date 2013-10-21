package test.java;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.amil.business.MatchBusinessImpl;
import br.com.amil.models.Card;
import br.com.amil.models.Deck;
import br.com.amil.models.Hand;
import br.com.amil.models.Match;
import br.com.amil.models.Suit;

public class TestMatch {

	@Test
	public void testMatch() {
		List <Card> cardsToHandTest = new ArrayList<Card>(); 
		
		cardsToHandTest.add(new Card("2", new Suit("H")));
		cardsToHandTest.add(new Card("A", new Suit("D")));
		cardsToHandTest.add(new Card("5", new Suit("H")));
		cardsToHandTest.add(new Card("A", new Suit("C")));
		cardsToHandTest.add(new Card("7", new Suit("H")));
		
		
		List <Card> cardsToDeckTest = new ArrayList<Card>();
		cardsToDeckTest.add(new Card("A", new Suit("H"))); 
		cardsToDeckTest.add(new Card("6", new Suit("H")));
		cardsToDeckTest.add(new Card("9", new Suit("H")));
		cardsToDeckTest.add(new Card("4", new Suit("H")));
		cardsToDeckTest.add(new Card("3", new Suit("C")));	
		
		Hand hand = new Hand();
		Deck deck = new Deck();
		
		hand.setCards(cardsToHandTest);
		deck.setCardsInDeck(cardsToDeckTest);
		
		String resourceLine = "2H AD 5H AC 7H AH 6H 9H 4H 3C";
	    MatchBusinessImpl matchB = new MatchBusinessImpl();
	    Match match = matchB.initMatch(resourceLine);
     
	    assertEquals(hand, match.getMatchHand());
	    assertEquals(deck, match.getMatchDeck());
	    
	}
}
