package com.cards.framework.gui.screens;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

import com.cards.framework.util.game.pieces.Card;
import com.cards.framework.util.game.pieces.CardSuit;

public class LocalGame extends BackgroundPanel {
	private int x, y;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4467081789954538980L;

	public LocalGame() {
		super(Color.GREEN);
		setOpaque(false);
		//setLayout(null);
	}

	@Override
	public void addComponents() {
		Card card = new Card(1, CardSuit.SPADES);
		handleDrag(card);
		add(card);
	}

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
