package br.com.amil.models;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deck {
	List<Card> cardsInDeck;
	
	
	
	public void setCardsInDeck(List<Card> cardsInDeck) {
		this.cardsInDeck = cardsInDeck;
	}

	public List<Card> getCardsInDeck(String resourceLine) {

		if (this.cardsInDeck == null) {
			this.cardsInDeck = new ArrayList<Card>();
			Pattern pattern = Pattern.compile("([A2-9TJQK][HCSD])");
			Matcher matcher = pattern.matcher(resourceLine);
		 
			while(matcher.find()){
				String cardInLine = matcher.group();
				Card card = new Card(cardInLine.substring(0,1), new Suit(cardInLine.substring(1)));
				this.cardsInDeck.add(card);
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
