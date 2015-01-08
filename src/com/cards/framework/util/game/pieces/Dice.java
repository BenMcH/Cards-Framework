package com.cards.framework.util.game.pieces;

import java.util.Random;

public class Dice extends GamePiece implements Rollable{
	private int dice;
	private int size;
	private ColorPath color;
	
	public static final ColorPath[] avalibleColors= {
		ColorPath.WHITE,
		ColorPath.RED
	};
	
	public static final int[] avalibleSizes = {
		6
	};
	
	public Dice() {
		dice = 1;
		size = 6;
		color = ColorPath.WHITE;
		
	}
	
	public Dice(int size, ColorPath color) {
		this();
		this.size = size;
		this.color = color;
	}

	@Override
	public int getNumberOfPossibleOutcomes() {
		return size;
	}

	@Override
	public int Roll() {
		Random side = new Random();
		dice = side.nextInt(size) + 1;
		return dice;
	}

	@Override
	public ColorPath getColor() {
		return color;
	}
		
}
