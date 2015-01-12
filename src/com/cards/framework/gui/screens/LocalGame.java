package com.cards.framework.gui.screens;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

import com.cards.framework.util.game.pieces.Card;
import com.cards.framework.util.game.pieces.CardSuit;
import com.cards.framework.util.game.pieces.GamePiece;

public class LocalGame extends BackgroundPanel {
	private int x, y;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4467081789954538980L;

	/**
	 * Creates a local game
	 */
	public LocalGame() {
		super(Color.GREEN);
		setOpaque(false);
		setLocation(0, 0);
		// setLayout(null);
	}

	@Override
	public void addComponents() {
		Card card = new Card(1, CardSuit.SPADES);
		add(card);
		handleDrag(card);
	}

	/**
	 * A method for adding game pieces to the board after creation. This will
	 * allow for the "Sandbox" feel
	 * 
	 * @param piece
	 */
	public void addComponent(GamePiece piece) {
		add(piece);
		handleDrag(piece);
	}

	/**
	 * This method allows the different game pieces to be dragged around the
	 * screen.
	 * 
	 * @param component
	 */
	public void handleDrag(final JComponent component) {
		component.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				x = me.getX();
				y = me.getY();
			}
		});
		component.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent me) {
				me.translatePoint(me.getComponent().getLocation().x - x, me
						.getComponent().getLocation().y - y);
				component.setLocation(me.getX(), me.getY());
			}
		});
	}

}
