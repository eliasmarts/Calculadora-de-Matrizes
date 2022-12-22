package pt.telaCalculadora.leitorMatriz;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import pt.comandos.Command;
import pt.comandos.PasteDivisor;
import pt.telaCalculadora.util.ActionCommand;

public class LeitorElementoDivisor extends JTextArea implements KeyListener {
	private Command comando;
	private LeitorElemento leitor;
	
	public LeitorElementoDivisor(LeitorDeMatriz lei, TelaLeitores t, int x, int y) {
		super();
		
		leitor = new LeitorElemento(t, x, y);
		
		getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK, true), "cola");
		
		
		getActionMap().put("cola",
				new ActionCommand(new PasteDivisor(this, lei)));
		
		setText(leitor.getText());
		leitor.setVisible(false);
	}
	
	
	public void setComando(Command comando) {
		leitor.setComando(comando);
	}

	
	public void atualiza(TelaLeitores t, int x, int y) {
		leitor.atualiza(t, x, y);
		setText(leitor.getText());
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		leitor.setText(this.getText());
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
