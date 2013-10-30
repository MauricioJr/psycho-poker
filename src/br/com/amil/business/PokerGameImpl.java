package br.com.amil.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import br.com.amil.constants.PokerHand;
import br.com.amil.models.Card;
import br.com.amil.models.Match;

public class PokerGameImpl implements PokerGame {
	
	PokerHandAnalyzer pokerHandAnalyzer = new PokerHandAnalyzerImpl();
	ArrayList<Card> combination = new ArrayList<Card>();
	TreeMap<PokerHand, ArrayList<Card>> combinationsMap;
	ArrayList<Card> cardsToMap;
	PokerHand combinationResult;

	public TreeMap<PokerHand, ArrayList<Card>> getBestHand(Match match) {
		List<Card> cardsOnHand = match.getMatchPlayer().getHand().getCards();
		List<Card> cardsInDeck = match.getMatchDeck().getCardsInDeck();
		combinationsMap = new TreeMap<PokerHand, ArrayList<Card>>();
		combinationsMap.put(pokerHandAnalyzer.handAnalyzer(cardsOnHand), (ArrayList<Card>) cardsOnHand);
		
		for (int k = 2; k < 5; k++) {
			combination.clear();
			
			for (int i = 0; i < 5; i++) {
					setAllPossibilitiesForOneTrade(cardsOnHand, cardsInDeck, i);
				
				if (k == 2) {
					for (int j = i + 1; j < 5; j++) {
						getAllPossibilitiesForTwoTrades(cardsOnHand,cardsInDeck, i, j);
					}
				}

				if (k == 3) {
					for (int y = i + 2; y < 5; y++) {
						getAllPossibilitiesForThreeTrades(cardsOnHand,cardsInDeck, i, y);
					}
				}

				if (k == 4) {
					for (int z = i + 3; z < 5; z++) {
						//Todas possibilidades para 4 troca
						getAllPossibilitiesForFourTrades(cardsOnHand,cardsInDeck, i, z);
					}
				}
			}
			
			tradeAllCards(cardsInDeck);
		}
		
		return combinationsMap;
		
	}

	private void tradeAllCards(List<Card> cardsInDeck) {
		combinationResult = pokerHandAnalyzer.handAnalyzer(cardsInDeck);
		combinationsMap.put(combinationResult, (ArrayList<Card>) cardsInDeck);
	}

	private void getAllPossibilitiesForFourTrades(List<Card> cardsOnHand,
			List<Card> cardsInDeck, int i, int z) {
		combination.addAll(cardsOnHand);
		combination.remove(i);   combination.add(i, cardsInDeck.get(0));
		combination.remove(i+1); combination.add(i+1, cardsInDeck.get(1));
		combination.remove(i+2); combination.add(i+2, cardsInDeck.get(2));
		combination.remove(z);   combination.add(z, cardsInDeck.get(3));
		Collections.sort(combination);
		combinationResult = pokerHandAnalyzer.handAnalyzer(combination);
		cardsToMap = new ArrayList<Card>();
		cardsToMap.addAll(combination);
		combinationsMap.put(combinationResult, cardsToMap);
		combination.clear();
	
		if (i == 1) {
			fourTradesExceptionCase(cardsOnHand, cardsInDeck, i, z);
		}
	}

	/**
	 * Excepetion Comparation Cases like index [5 0 1 2] [5 1 2 3]
	 * @param cardsOnHand
	 * @param cardsInDeck
	 * @param i
	 * @param y
	 */
	private void fourTradesExceptionCase(List<Card> cardsOnHand,
			List<Card> cardsInDeck, int i, int z) {
		combination.addAll(cardsOnHand);
		combination.remove(0);   combination.add(0, cardsInDeck.get(0));
		combination.remove(i);   combination.add(i, cardsInDeck.get(1));
		combination.remove(i+2); combination.add(i+1, cardsInDeck.get(2));
		combination.remove(z);   combination.add(z, cardsInDeck.get(3));
		Collections.sort(combination);
		combinationResult = pokerHandAnalyzer.handAnalyzer(combination);
		cardsToMap = new ArrayList<Card>();
		cardsToMap.addAll(combination);
		combinationsMap.put(combinationResult, cardsToMap);
		combination.clear();
		
		combination.addAll(cardsOnHand);
		combination.remove(0);   combination.add(0,cardsInDeck.get(0));
		combination.remove(i+1); combination.add(i+1,cardsInDeck.get(1));
		combination.remove(i+2); combination.add(i+2,cardsInDeck.get(2));
		combination.remove(z);   combination.add(z,cardsInDeck.get(3));
		Collections.sort(combination);
		combinationResult = pokerHandAnalyzer.handAnalyzer(combination);
		cardsToMap = new ArrayList<Card>();
		cardsToMap.addAll(combination);
		combinationsMap.put(combinationResult, cardsToMap);
		combination.clear();
		
		i = 5;
	}

	private void getAllPossibilitiesForThreeTrades(List<Card> cardsOnHand,
			List<Card> cardsInDeck, int i, int y) {
		combination.addAll(cardsOnHand);
		combination.remove(i);   combination.add(i, cardsInDeck.get(0));
		combination.remove(i+1); combination.add(i+1, cardsInDeck.get(1));
		combination.remove(y); combination.add(y, cardsInDeck.get(2));
		Collections.sort(combination);
		combinationResult = pokerHandAnalyzer.handAnalyzer(combination);
		cardsToMap = new ArrayList<Card>();
		cardsToMap.addAll(combination);
		combinationsMap.put(combinationResult, cardsToMap);
		combination.clear();
		
		if (i == 2) {
				threeTradesExceptionCase(cardsOnHand, cardsInDeck, i, y);
		}
	}

	/**
	 * Excepetion Comparation Cases like index [5 0 1]
	 * @param cardsOnHand
	 * @param cardsInDeck
	 * @param i
	 * @param y
	 */
	private void threeTradesExceptionCase(List<Card> cardsOnHand,
			List<Card> cardsInDeck, int i, int y) {
		combination.addAll(cardsOnHand);
		combination.remove(0); 	 combination.add(0, cardsInDeck.get(0));
		combination.remove(i+1); combination.add(i+1, cardsInDeck.get(1));
		combination.remove(y);   combination.add(y, cardsInDeck.get(2));
		Collections.sort(combination);
		combinationResult = pokerHandAnalyzer.handAnalyzer(combination);
		cardsToMap = new ArrayList<Card>();
		cardsToMap.addAll(combination);
		combinationsMap.put(combinationResult, cardsToMap);
		combination.clear();
		
		combination.addAll(cardsOnHand);
		combination.remove(1);   combination.add(1, cardsInDeck.get(0));
		combination.remove(i+1); combination.add(i+1, cardsInDeck.get(1));
		combination.remove(y);   combination.add(y, cardsInDeck.get(2));
		Collections.sort(combination);
		combinationResult = pokerHandAnalyzer.handAnalyzer(combination);
		cardsToMap = new ArrayList<Card>();
		cardsToMap.addAll(combination);
		combinationsMap.put(combinationResult, cardsToMap);
		combination.clear();
		i = 5;
	}

	private void getAllPossibilitiesForTwoTrades(List<Card> cardsOnHand,
			List<Card> cardsInDeck, int i, int j) {
		//Todas possibilidades para 2 trocas
		combination.addAll(cardsOnHand);
		combination.remove(i); combination.add(i, cardsInDeck.get(0));
		combination.remove(j); combination.add(j, cardsInDeck.get(1));
		Collections.sort(combination);
		combinationResult = pokerHandAnalyzer.handAnalyzer(combination);
		cardsToMap = new ArrayList<Card>();
		cardsToMap.addAll(combination);
		combinationsMap.put(combinationResult, cardsToMap);
		combination.clear();
	}

	private void setAllPossibilitiesForOneTrade(List<Card> cardsOnHand,
			List<Card> cardsInDeck, int i) {
		combination.addAll(cardsOnHand);
		combination.remove(i); combination.add(cardsInDeck.get(0));
		Collections.sort(combination);
		combinationResult = pokerHandAnalyzer.handAnalyzer(combination);
		cardsToMap = new ArrayList<Card>();
		cardsToMap.addAll(combination);
		combinationsMap.put(combinationResult, cardsToMap);
		combination.clear();
	}

}
