package com.cards.framework.util.game.pieces;

import java.awt.Graphics;
import java.util.Random;

public class Coin extends GamePiece implements Rollable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2265248380549780457L;
	private int coin;
	public static final int HEADS = 0, TAILS = 1;

	public Coin() {
		super();
		coin = 0;
	}

	/**
	 * Documentation for these methods in Rollable
	 */
	@Override
	public int getNumberOfPossibleOutcomes() {
		return 2;
	}

	@Override
	public int Roll() {
		Random side = new Random();
		coin = side.nextInt(2);
		return coin;
	}

	/**
	 * Returns heads (0) or tails (1)
	 * 
	 * @return
	 */
	public int getCoin() {
		return coin;
	}

	/**
	 * Documentation for this in the GamePiece class
	 */
	@Override
	public void drawPiece(Graphics g) {
	}

}
