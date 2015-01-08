package com.cards.framework.util.game.pieces;

/**
 * Gives a more general way of giving game objects color.
 * 
 * @author William
 *
 */

public enum ColorPath {
	GREEN("Green"),
	BLUE("Blue"),
	RED("Red"),
	YELLOW("Yellow"),
	ORANGE("Orange"),
	WHITE("White"),
	BLACK("Black");
	
	private String color;
	
	/**
	 * Adds color attribute to given object.
	 * 
	 * @param color
	 */
	
	private ColorPath(String color) {
		this.color = color;
	}
	
	// Getters //
	
	public String getColorPath() {
		return color;
	}
}
