package com.cards.framework.util.game.pieces;

import java.awt.Graphics;
import java.util.Random;

public class Dice extends GamePiece implements Rollable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2043788544461732929L;
	private int dice;
	private int size;
	
	public Dice() {
		dice = 1;
		size = 6;
	}
	
	public Dice(int size) {
		this();
		this.size = size;
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
	public void drawPiece(Graphics g) {
	}
	
	
	
}
