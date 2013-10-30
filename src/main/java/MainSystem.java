package main.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import br.com.amil.business.FileReader;
import br.com.amil.business.FileReaderImpl;
import br.com.amil.business.MatchBusiness;
import br.com.amil.business.MatchBusinessImpl;
import br.com.amil.business.PokerGame;
import br.com.amil.business.PokerGameImpl;
import br.com.amil.business.PokerHandAnalyzerImpl;
import br.com.amil.constants.PokerHand;
import br.com.amil.models.Card;
import br.com.amil.models.Match;

public class MainSystem {

	public static void main(String[] args) {
		FileReader fileReader = new FileReaderImpl();
		List<String> listOfResourceLines = new ArrayList<String>();
		try {
			listOfResourceLines = fileReader.getFileLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		MatchBusiness matchBusiness = new MatchBusinessImpl();
		PokerGame  pokerGame = new PokerGameImpl();
		TreeMap<PokerHand, ArrayList<Card>> bestHand;
		Match match;
		String ouput = "";
		
		for (String resourceLine : listOfResourceLines) {
			match = matchBusiness.initMatch(resourceLine);
			bestHand = new TreeMap<PokerHand, ArrayList<Card>>(); 
			bestHand = pokerGame.getBestHand(match);
			PokerHand pokerHand = bestHand.firstKey();
			 ouput+="\nPoker Hand Score: " +pokerHand.toString() +"\n"+
								"Hand Cards: " +bestHand.get(pokerHand)+"\n";
			
			
		} 
		JOptionPane.showMessageDialog(null, ouput);
	}
}
