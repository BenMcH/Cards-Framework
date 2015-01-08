package com.cards.framework.util.game.pieces;

public abstract class GamePiece {
	private ColorPath color;
	public static ColorPath[] avalibleColors;
	
	/**
	 * Gets the color of a given object.
	 * 
	 * @return color
	 */
	
	public ColorPath getColor() {
		return color;
	}
	
}
