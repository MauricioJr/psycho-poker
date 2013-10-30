package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.amil.business.MatchBusinessImpl;
import br.com.amil.business.PokerHandAnalyzerImpl;
import br.com.amil.constants.PokerHand;
import br.com.amil.models.Match;

public class PokerHandAnalyzerTest {
	
	String resourceLine;
	MatchBusinessImpl matchB;
	Match match;
	PokerHandAnalyzerImpl pokerGameImpl;
	Boolean sequenceResult;

//  método privado. Foi implementado vários cenários devido a complexidade no desenvolvimento como caso de exceções [A 2 3 4 K] por exemplo.
//	@Test
//	public void testValueSequenceValidator(){
//		
//		//Error scene
//	    resourceLine = "2H AD 5H AC 7H AH 6H 9H 4H 3C";
//	    matchB = new MatchBusinessImpl();
//	    match = matchB.initMatch(resourceLine);
//	    pokerGameImpl = new PokerHandAnalyzerImpl();
//	    sequenceResult = pokerGameImpl.valueSequenceValidator(match.getMatchPlayer().getHand().getCards());
//	    assertEquals(false, sequenceResult);
//	    
//	    //Error scene
//	    resourceLine = "2H 6D 7H 8C 9H TH JH QH KH 3C";
//	    match = matchB.initMatch(resourceLine);
//	    pokerGameImpl = new PokerHandAnalyzerImpl();
//	    sequenceResult = pokerGameImpl.valueSequenceValidator(match.getMatchPlayer().getHand().getCards());
//	    assertEquals(false, sequenceResult);  
//
//	    //Sucess scene
//	    resourceLine = "AH AD JS QH KS TH JH QH KH AC";
//	    match = matchB.initMatch(resourceLine);
//	    pokerGameImpl = new PokerHandAnalyzerImpl();
//	    sequenceResult = pokerGameImpl.valueSequenceValidator(match.getMatchPlayer().getHand().getCards());
//	    assertEquals(false, sequenceResult);  
//	    
//	    //Sucess scene
//	    resourceLine = "AH TH JS QH KS 5S 4D KS AS AD";
//	    match = matchB.initMatch(resourceLine);
//	    pokerGameImpl = new PokerHandAnalyzerImpl();
//	    sequenceResult = pokerGameImpl.valueSequenceValidator(match.getMatchPlayer().getHand().getCards());
//	    assertEquals(true, sequenceResult);  
//	    
//	    //Sucess scene
//	    resourceLine = "AH 2D 3H 4C 5H 6H 7H 8H 9H TC";
//	    match = matchB.initMatch(resourceLine);
//	    pokerGameImpl = new PokerHandAnalyzerImpl();
//	    sequenceResult = pokerGameImpl.valueSequenceValidator(match.getMatchPlayer().getHand().getCards());
//	    assertEquals(true, sequenceResult);
//	    
//	    //Sucess scene
//	    resourceLine = "5H 6D 7H 8C 9H TH JH QH KH AC";
//	    match = matchB.initMatch(resourceLine);
//	    pokerGameImpl = new PokerHandAnalyzerImpl();
//	    sequenceResult = pokerGameImpl.valueSequenceValidator(match.getMatchPlayer().getHand().getCards());
//	    assertEquals(true, sequenceResult);
//	}

	@Test
	public void testFourOfKindAnalyzer(){
		resourceLine = "5H 5D 5S 5C 9H TH JH QH KH AC";
		matchB = new MatchBusinessImpl();
		match = matchB.initMatch(resourceLine);
		pokerGameImpl = new PokerHandAnalyzerImpl();
		PokerHand realPokerHand = pokerGameImpl.handAnalyzer(match.getMatchPlayer().getHand().getCards());
		assertEquals(PokerHand.four_of_a_kind, realPokerHand);
	}
	
	@Test
	public void testFullHouseAnalyzer(){
		resourceLine = "9H 5D 5S 9C 5H TH JH QH KH AC";
		matchB = new MatchBusinessImpl();
		match = matchB.initMatch(resourceLine);
		pokerGameImpl = new PokerHandAnalyzerImpl();
		PokerHand realPokerHand = pokerGameImpl.handAnalyzer(match.getMatchPlayer().getHand().getCards());
		assertEquals(PokerHand.full_house, realPokerHand);
	}
	
	@Test
	public void TestTwoPairsAnalyzer(){
		resourceLine = "KD AH 2C KS AD 9S 3C QH JS JD";
		matchB = new MatchBusinessImpl();
		match = matchB.initMatch(resourceLine);
		pokerGameImpl = new PokerHandAnalyzerImpl();
		PokerHand realPokerHand = pokerGameImpl.handAnalyzer(match.getMatchPlayer().getHand().getCards());
		assertEquals(PokerHand.two_pairs, realPokerHand);
	}
}
