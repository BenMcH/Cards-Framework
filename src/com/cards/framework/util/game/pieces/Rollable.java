package com.cards.framework.util.game.pieces;

public interface Rollable {
	
	// Meant for getting number of all available outcomes. 
	public int getNumberOfPossibleOutcomes();
	
	// Rolls an object that is based on which side it lands on.
	public int Roll();
}
