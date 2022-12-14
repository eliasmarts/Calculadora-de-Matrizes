package pt.telaCalculadora.util;

import java.awt.event.*;

public class AnyKeyAction implements KeyListener {
	private ActionListener observer;

	/**
	 * chama uma acao em observer toda vez que uma tecla é digitada
	 * @param observer
	 */
	public AnyKeyAction(ActionListener observer) {
		super();
		this.observer = observer;
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyChar() != KeyEvent.CHAR_UNDEFINED)
			observer.actionPerformed(null);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
