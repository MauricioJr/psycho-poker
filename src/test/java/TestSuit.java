package test.java;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.amil.models.Card;
import br.com.amil.models.Deck;
import br.com.amil.models.Hand;
import br.com.amil.models.Match;
import br.com.amil.models.Player;
import br.com.amil.models.Suit;

public class TestSuit {

	@Test
	public void testHandSuitValidator(){
List <Card> cardsToHandTest = new ArrayList<Card>(); 
		
		cardsToHandTest.add(new Card("2", new Suit("H")));
		cardsToHandTest.add(new Card("A", new Suit("H")));
		cardsToHandTest.add(new Card("5", new Suit("H")));
		cardsToHandTest.add(new Card("A", new Suit("H")));
		cardsToHandTest.add(new Card("7", new Suit("H")));
		Hand hand = new Hand();
		hand.setCards(cardsToHandTest);
	
		Match match = new Match(new Player(), new Deck());
		match.getMatchPlayer().setHand(hand);
		Suit suit = new Suit("H");
		Boolean suitSequence = suit.suitSequenceValidator(match);
		assertEquals(true, suitSequence);
		
		
	
	}
}
