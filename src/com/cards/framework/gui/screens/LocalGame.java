package com.cards.framework.gui.screens;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import com.cards.framework.gui.Button;
import com.cards.framework.gui.Window;
import com.cards.framework.util.GameKeyEvents;
import com.cards.framework.util.game.pieces.Card;
import com.cards.framework.util.game.pieces.CardSuit;
import com.cards.framework.util.game.pieces.GamePiece;
import com.cards.framework.util.listeners.KeyboardListener;

public class LocalGame extends BackgroundPanel {
	private int x, y;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4467081789954538980L;

	private BackgroundPanel gamePanel;
	private Screen pauseScreen;
	private boolean paused = false;
	private ArrayList<Point> points;
	private ArrayList<GamePiece> components;

	/**
	 * Creates a local game
	 */
	public LocalGame() {
		super(Color.GREEN);
		setLayout(null);
		setFocusable(true);
		GameKeyEvents events = new GameKeyEvents(this);
		points = new ArrayList<Point>();
		components = new ArrayList<GamePiece>();
		pauseScreen = new Screen() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1901929617747026864L;

			@Override
			public void addComponents() {
				setOpaque(false);
				setBounds(0, 0, Window.window.getContentPane().getWidth(),
						Window.window.getHeight());
				GridBagConstraints c = new GridBagConstraints();
				c.insets = new Insets(5, 5, 5, 5);
				c.gridx = 0;
				c.gridy = 0;
				setOpaque(false);
				Button resume = new Button("Resume");
				resume.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						pause();
					}
				});
				add(resume, c);
				c.gridy++;
				Button quit = new Button("Quit");
				quit.addActionListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Window.window.setScreen(new MainMenu());
					}
				});
				add(quit, c);
				revalidate();
			}
		};
		// setLayout()
		setOpaque(false);
		setLocation(0, 0);
		// setLayout(null);
		addKeyListener(new KeyboardListener(events));
		Action pause = new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = -547806494670276982L;

			@Override
			public void actionPerformed(ActionEvent e) {

				pause();
			}
		};
		this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke("ESCAPE"), "pause");
		this.getActionMap().put("pause", pause);
		requestFocusInWindow();
	}

	@Override
	public void addComponents() {
		components = new ArrayList<GamePiece>();
		components.add(new Card(1, CardSuit.SPADES));
		for (GamePiece piece : components) {
			addComponent(piece);
		}
		// setLayout(null);
		gamePanel = this;
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
				if (!paused) {
					me.translatePoint(me.getComponent().getLocation().x - x, me
							.getComponent().getLocation().y - y);
					component.setLocation(me.getX(), me.getY());
				}
			}
		});
	}

	public void pause() {
		paused = !paused;
		// Window.window.setScreen(paused ? pauseScreen : gamePanel);
		if (paused)
			add(pauseScreen);
		else
			remove(pauseScreen);
		repaint();
		revalidate();
	}


}
