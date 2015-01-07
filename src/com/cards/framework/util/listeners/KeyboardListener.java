package com.cards.framework.util.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;


/**
 * 
 * @author Ben
 * This Class can be implemented and will store all keys pressed into a hashmap so that lookup is quick and easy.
 */
public class KeyboardListener implements KeyListener {
	
	HashMap<Integer, Boolean> keys = new HashMap<>();
	
	
	@Override
	public void keyPressed(KeyEvent event) {
		keys.put(event.getKeyCode(), true);
	}
	
	@Override
	public void keyReleased(KeyEvent event) {
		keys.put(event.getKeyCode(), false);
	}
	
	@Override
	public void keyTyped(KeyEvent event) {
	}
	
	/**
	 * Returns whether or not a specific key is pressed
	 * @param keyEventKeyCode
	 * @return
	 */
	public boolean isKeyPressed(int keyEventKeyCode) {
		if(keys.get(keyEventKeyCode) == null) return false;
		return keys.get(keyEventKeyCode);
	}
	
	/**
	 * Allows keys to be set pressed or unset by code rather than by system.
	 * @param keyCode
	 * @param state
	 */
	public void setKeyPressed(int keyCode, boolean state){
		keys.put(keyCode, state);
	}
	
}
