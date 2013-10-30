package br.com.amil.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.amil.constants.PokerHand;
import br.com.amil.constants.Value;
import br.com.amil.models.Card;

public class PokerHandAnalyzerImpl implements PokerHandAnalyzer{

	public PokerHand handAnalyzer(List<Card> cardsOnHand){
		List<Value>cardsValues = new ArrayList<Value>();
		for (Card card : cardsOnHand) {
			cardsValues.add(card.getValue());
		}
		
		if(straightFlushAnalyzer(cardsOnHand)){
			return PokerHand.straight_flush;
		}
		
		if(fourOfKindAnalyzer(cardsValues)){
			return PokerHand.four_of_a_kind;
		}
		
		if(fullHouseAnalyzer(cardsValues)){
		   return PokerHand.full_house;	
		}

		if(flushAnalyzer(cardsOnHand)){
			return PokerHand.flush;
		}
		
		if(straightAnalyzer(cardsOnHand)){
			return PokerHand.straight;
		}
		
		if(threeOfKindAnalyzer(cardsValues)){
			return PokerHand.three_of_a_kind;
		}
		
		if(twoPairsAnalyzer(cardsValues)){
			return PokerHand.two_pairs;
		}
		
		if(pairOfKindAnalyzer(cardsValues)){
			return PokerHand.one_pair;
		}
		
		return PokerHand.highest_card;
	}


	private boolean twoPairsAnalyzer(List<Value> cardsValues) {
		Value firstPairValue = null;
		
		for (Value value : cardsValues) {
			if(Collections.frequency(cardsValues, value) == 2){
				firstPairValue = value;
				break;
			}
		}
		
		for (Value value : cardsValues) {
			if((Collections.frequency(cardsValues, value) == 2) && (value != firstPairValue)){
				return true;
			}
		}
		
		return false;
	}

	private boolean fullHouseAnalyzer(List<Value>cardsValues) {
		return (threeOfKindAnalyzer(cardsValues) && pairOfKindAnalyzer(cardsValues));
	
	}

	private Boolean threeOfKindAnalyzer(List<Value> listOfValues){
		for (Value value : listOfValues) {
			if(Collections.frequency(listOfValues, value) == 3){
				return true;
			}
		}
		return false;
	}
	
	private Boolean pairOfKindAnalyzer(List<Value> listOfValues){
		for (Value value : listOfValues) {
			if(Collections.frequency(listOfValues, value) == 2){
				return true;
			}
		}
		return false;
	}
	
	private boolean straightAnalyzer(List<Card>cardsOnHand) {
		return valueSequenceValidator(cardsOnHand);
	}

	private boolean flushAnalyzer(List<Card>cardsOnHand) {
		return suitSequenceValidator(cardsOnHand);
	}

	private Boolean straightFlushAnalyzer(List<Card>cardsOnHand){
		return valueSequenceValidator(cardsOnHand) && suitSequenceValidator(cardsOnHand);
	}
	
	private Boolean suitSequenceValidator(List<Card> cardsOnHand){
		for (Card card : cardsOnHand) {
			if(!card.getSuit().equals(cardsOnHand.get(0).getSuit())){
			   return false;
			}
		}
		return true;
	}
	
	private Boolean valueSequenceValidator(List<Card>cardsOnHand) {
	
		Card possibleA = cardsOnHand.get(0);
		Card possibleK =  cardsOnHand.get(cardsOnHand.size()-1);
		boolean kingSequence = kingSequenceValidator(possibleA.getValue(), possibleK.getValue());
		
		Value lastValue = cardsOnHand.get(0).getValue();
		Value currentValue = null;
		
		for (int i = 1; i < cardsOnHand.size(); i++) {
			currentValue = cardsOnHand.get(i).getValue();
			
			boolean notEqualsValue = (!lastValue.getIntValue().equals(currentValue.getIntValue()));
			boolean isNextValue    = (lastValue.getIntValue().equals(currentValue.getIntValue() - 1));

			if (notEqualsValue) {
				if (!(isNextValue)) {
					if(! ((lastValue.equals(Value.A)) && (kingSequence)) ){ return false;}
				}
			}else{
				return false;
			}
		
			 lastValue = currentValue;
		}
		
		return true;
				
	
	}

	private Boolean kingSequenceValidator(Value lastValue, Value currentValue) {
		if ( (lastValue.equals(Value.A)) && (currentValue.equals(Value.K)) ) {
			return true;
		}
		return false;
	}
	
	private Boolean fourOfKindAnalyzer(List<Value>cardsValues) {

		for (int i = 0; i < cardsValues.size(); i++) {
			Value cardValue = cardsValues.get(i);
			if ((Collections.frequency(cardsValues, cardValue) == 4)) {
				return true;
			}
		}
		return false;
	}
	
}
