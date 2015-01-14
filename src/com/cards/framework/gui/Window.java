package com.cards.framework.gui;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.cards.framework.gui.screens.MainMenu;
import com.cards.framework.gui.screens.Screen;
import com.cards.framework.util.listeners.KeyboardListener;
import com.cards.framework.util.listeners.MouseListener;

/**
 * The window that will hold the screens
 * 
 * @author Ben
 *
 */
public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6933979738614649740L;
	public static Window window;

	public Window() {
		super("Cards");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window.window = this;
	}


	/**
	 * Replaces the Screen that is shown
	 * 
	 * @param screen
	 */
	public void setScreen(Screen screen) {
		this.setContentPane(screen);
		revalidate();
		repaint();
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Window window = new Window();
		window.setScreen(new MainMenu());
		window.setSize(1280, 720);
		window.setVisible(true);
		window.setResizable(false);
	}
}
