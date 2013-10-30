package test.java;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.TreeMap;

import org.junit.Test;

import br.com.amil.business.MatchBusinessImpl;
import br.com.amil.business.PokerGameImpl;
import br.com.amil.business.PokerHandAnalyzerImpl;
import br.com.amil.constants.PokerHand;
import br.com.amil.models.Card;
import br.com.amil.models.Match;

public class TestPokerGame {
	String resourceLine;
	MatchBusinessImpl matchB;
	Match match;
	PokerHandAnalyzerImpl pokerGameImpl;
	Boolean sequenceResult;
	
	@Test
	public void tryStraightFlushHandTest(){
		 //Sucess scene
	    resourceLine = "TH JH QC QD QS QH KH AH 2S 6S";
	    matchB = new MatchBusinessImpl();
	    match = matchB.initMatch(resourceLine);
	    
	   PokerGameImpl pokerGame = new PokerGameImpl();
	   TreeMap<PokerHand, ArrayList<Card>> treeMap = pokerGame.getBestHand(match);
	   assertEquals(PokerHand.straight_flush, treeMap.firstKey());
   }
	
	@Test
	public void fourOfKindTest(){
		 resourceLine = "2H 2S 3H 3S 3C 2D 3D 6C 9C TH";
		 matchB = new MatchBusinessImpl();
		 match = matchB.initMatch(resourceLine);
		 PokerGameImpl pokerGame = new PokerGameImpl();
		 TreeMap<PokerHand, ArrayList<Card>> treeMap = pokerGame.getBestHand(match);
		 assertEquals(PokerHand.four_of_a_kind,treeMap.firstKey());
	}
	
	
	@Test
	public void fullHouseTest(){
		 resourceLine = "2H 2S 3H 3S 3C 2D 9C 3D 6C TH";
		 matchB = new MatchBusinessImpl();
		 match = matchB.initMatch(resourceLine);
		 PokerGameImpl pokerGame = new PokerGameImpl();
		 TreeMap<PokerHand, ArrayList<Card>> treeMap = pokerGame.getBestHand(match);
		 assertEquals(PokerHand.full_house,treeMap.firstKey());
	}
	

	@Test
	public void SuitSequenceTest(){
		 resourceLine = "2H AD 5H AC 7H AH 6H 9H 4H 3C";
		 matchB = new MatchBusinessImpl();
		 match = matchB.initMatch(resourceLine);
		 PokerGameImpl pokerGame = new PokerGameImpl();
		 TreeMap<PokerHand, ArrayList<Card>> treeMap = pokerGame.getBestHand(match);
		 assertEquals(PokerHand.flush,treeMap.firstKey());
	}
	
	@Test
	public void ValueSequenceTest(){
		 resourceLine = "AC 2D 9C 3S KD 5S 4D KS AS 4C";
		 matchB = new MatchBusinessImpl();
		 match = matchB.initMatch(resourceLine);
		 PokerGameImpl pokerGame = new PokerGameImpl();
		 TreeMap<PokerHand, ArrayList<Card>> treeMap = pokerGame.getBestHand(match);
		 assertEquals(PokerHand.straight,treeMap.firstKey());
	}

	@Test
	public void ThreeOfKindTest(){
		 resourceLine = "KS AH 2H 3C 4H KC 2C TC 2D AS";
		 matchB = new MatchBusinessImpl();
		 match = matchB.initMatch(resourceLine);
		 PokerGameImpl pokerGame = new PokerGameImpl();
		 TreeMap<PokerHand, ArrayList<Card>> treeMap = pokerGame.getBestHand(match);
		 assertEquals(PokerHand.three_of_a_kind,treeMap.firstKey());
	}
	
	@Test
	public void TwoPairsTest(){
		 resourceLine = "AH 2C 9S AD 3C QH KS JS JD KD";
		 matchB = new MatchBusinessImpl();
		 match = matchB.initMatch(resourceLine);
		 PokerGameImpl pokerGame = new PokerGameImpl();
		 TreeMap<PokerHand, ArrayList<Card>> treeMap = pokerGame.getBestHand(match);
		 assertEquals(PokerHand.two_pairs,treeMap.firstKey());
	}
	
	@Test
	public void OnePairTest(){
		 resourceLine = "6C 9C 8C 2D 7C 2H TC 4C 9S AH";
		 matchB = new MatchBusinessImpl();
		 match = matchB.initMatch(resourceLine);
		 PokerGameImpl pokerGame = new PokerGameImpl();
		 TreeMap<PokerHand, ArrayList<Card>> treeMap = pokerGame.getBestHand(match);
		 assertEquals(PokerHand.one_pair,treeMap.firstKey());
	}

}
