package pt.telaCalculadora.util;


import java.awt.event.*;


import javax.swing.JTextField;
import javax.swing.text.JTextComponent;


/**
 * vai para o textfield da direcao caso a tecla seja pressionada
 * e ele esteja setado
 * @author elias
 *
 */
public class DirectionalKeyAction implements KeyListener {
	private JTextComponent actual;
	
	private JTextComponent up, down, left, right, enter;
	
	

	public void setUp(JTextComponent up) {
		this.up = up;
	}

	public void setDown(JTextComponent down) {
		this.down = down;
	}

	public void setLeft(JTextComponent leitores) {
		this.left = leitores;
	}

	public void setRight(JTextComponent right) {
		this.right = right;
	}
	
	public void setEnter(JTextComponent enter) {
		this.enter = enter;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();
		
		if (key == KeyEvent.VK_DOWN && down != null)
			down.requestFocusInWindow();
		else if (key == KeyEvent.VK_UP && up != null)
			up.requestFocusInWindow();
		else if (key == KeyEvent.VK_LEFT && left != null) {
			int pos = actual.getCaretPosition();
			
			if (pos == 0)
				left.requestFocusInWindow();
		}
		else if (key == KeyEvent.VK_RIGHT && right != null) {
			int pos = actual.getCaretPosition();
			
			if (pos == actual.getText().length())
				right.requestFocusInWindow();
		}
		
		else if (key == KeyEvent.VK_ENTER && enter != null) {
			enter.requestFocusInWindow();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
