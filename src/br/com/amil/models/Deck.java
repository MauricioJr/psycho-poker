package br.com.amil.models;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.amil.constants.Value;

public class Deck {
	List<Card> cardsInDeck;
	
	
	
	public void setCardsInDeck(List<Card> cardsInDeck) {
		this.cardsInDeck = cardsInDeck;
	}

	public List<Card> getCardsInDeck(){
		return this.cardsInDeck;
	}
	
	public List<Card> getCardsInDeck(String resourceLine) {

		Value[] listOfValues = Value.values();
		
		
		if (this.cardsInDeck == null) {
			this.cardsInDeck = new ArrayList<Card>();
			Pattern pattern = Pattern.compile("([A2-9TJQK][HCSD])");
			Matcher matcher = pattern.matcher(resourceLine);
			
			
			while(matcher.find()){
				String cardInLine = matcher.group();
				String cardValue = cardInLine.substring(0,1);
				String suitValue = cardInLine.substring(1);
				
				
				for (int i = 0; i < listOfValues.length; i++) {
					if( (listOfValues[i].getIntValue().toString().equals(cardValue)) ||  listOfValues[i].getSpecialCard().equals(cardValue)){
						this.cardsInDeck.add( new Card(listOfValues[i], new Suit(suitValue)) );
						break;
					}  
				}
			}
		}
		
		return this.cardsInDeck;
	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cardsInDeck == null) ? 0 : cardsInDeck.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deck other = (Deck) obj;
		if (cardsInDeck == null) {
			if (other.cardsInDeck != null)
				return false;
		} else if (!cardsInDeck.equals(other.cardsInDeck))
			return false;
		return true;
	}
	
}
