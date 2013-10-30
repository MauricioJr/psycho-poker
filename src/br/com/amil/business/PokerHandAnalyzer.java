package br.com.amil.business;

import java.util.List;

import br.com.amil.constants.PokerHand;
import br.com.amil.models.Card;

public interface PokerHandAnalyzer {
	public PokerHand handAnalyzer(List<Card> cardsOnHand);
}
