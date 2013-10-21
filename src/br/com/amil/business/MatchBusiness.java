package br.com.amil.business;

import br.com.amil.models.Match;

public interface MatchBusiness {

	/**
	 * Responsavel por inicializar a mao da rodada e o deck.
	 * @return Match
	 */
	public Match initMatch(String resourceLine);
}
