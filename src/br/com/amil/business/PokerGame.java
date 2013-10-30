package br.com.amil.business;

import java.util.ArrayList;
import java.util.TreeMap;

import br.com.amil.constants.PokerHand;
import br.com.amil.models.Card;
import br.com.amil.models.Match;

public interface PokerGame {

	public TreeMap<PokerHand, ArrayList<Card>> getBestHand(Match match);
}
