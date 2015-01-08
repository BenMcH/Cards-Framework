package com.cards.framework.util.game.pieces;

import java.util.Random;

public class Coin extends GamePiece implements Rollable{
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

}
