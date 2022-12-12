package pt.telaCalculadora.util;

import java.awt.event.*;

public class KeyListenerCommand implements KeyListener {
	private ActionListener observer;

	public KeyListenerCommand(ActionListener observer) {
		super();
		this.observer = observer;
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		observer.actionPerformed(null);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
