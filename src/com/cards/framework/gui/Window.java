package com.cards.framework.gui;

import java.io.IOException;

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
	private final KeyboardListener keyBoardListener;
	private final MouseListener mouseListener;
	public static Window window;
	
	public Window() {
		super("Cards");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		keyBoardListener = new KeyboardListener();
		mouseListener = new MouseListener();
		Window.window = this;
	}
	

	/**
	 * Returns the keyboard listener
	 * 
	 * @return
	 */
	public KeyboardListener getKeyboardListener() {
		return keyBoardListener;
	}

	/**
	 * Returns the mouse listener
	 * 
	 * @return
	 */
	public MouseListener getMouseListener() {
		return mouseListener;
	}

	/**
	 * Replaces the Screen that is shown
	 * 
	 * @param screen
	 */
	public void setScreen(Screen screen) {
		this.setContentPane(screen);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Window window = new Window();
		try {
			window.setScreen(new MainMenu());
		} catch (IOException e) {
			e.printStackTrace();
		}
		window.setSize(1280, 720);
		window.setVisible(true);
	}
}
