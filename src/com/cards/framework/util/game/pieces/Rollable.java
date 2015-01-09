package com.cards.framework.util.game.pieces;

public interface Rollable {
	
	/**
	 * Meant for getting number of all available outcomes. 
	 * @return
	 */
	public int getNumberOfPossibleOutcomes();
	
	/**
	 *  Rolls an object that is based on which side it lands on.
	 * @return
	 */
	public int Roll();
}
