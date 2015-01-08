package com.cards.framework.util.game.pieces;

import java.awt.Graphics;
import java.util.Random;

public class Coin extends GamePiece implements Rollable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2265248380549780457L;
	private int coin;

	public Coin() {
		super();
		coin = 0;
	}

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

	public int getCoin() {
		return coin;
	}

	@Override
	public void drawPiece(Graphics g) {
	}

}
