package com.cards.framework.util.game.pieces;

public enum ColorPath {
	GREEN("Green"),
	BLUE("Blue"),
	RED("Red"),
	YELLOW("Yellow"),
	ORANGE("Orange"),
	WHITE("White"),
	BLACK("Black");
	
	private String color;
	
	private ColorPath(String color) {
		this.color = color;
	}
	
	public String getColorPath() {
		return color;
	}
}
