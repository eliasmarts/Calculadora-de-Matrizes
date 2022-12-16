package pt.telaCalculadora.util;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import pt.telaCalculadora.leitorMatriz.LeitorDeMatriz;
import pt.telaCalculadora.leitorMatriz.LeitorElemento;

public class PasteDivisor implements KeyListener {
	private boolean control;
	private LeitorElemento leitor;
	private LeitorDeMatriz lei;
	private String ant;
	
	
	public PasteDivisor(LeitorElemento leitor, LeitorDeMatriz lei) {
		this.leitor = leitor;
		
		control = false;
		
		this.lei = lei;
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		/*int key = arg0.getKeyCode();
		
		if (key == KeyEvent.VK_CONTROL) {
			control = true;
			ant = leitor.getText();
		}
		else if (key != KeyEvent.VK_V)
			control = false; */
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		int key = arg0.getKeyCode();
		if (control && key == KeyEvent.VK_V) {
			paste(leitor.getText().substring(ant.length()));
			control = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	
	private void paste(String pasted) {
		String[] linhas = pasted.split("\n");
		
		int numLinhas, numColunas = 0;
		
		numLinhas = linhas.length;
		
		String[][] valores = new String[numLinhas][];
		
		for (int i = 0; i < numLinhas; i++) {
			valores[i] = linhas[i].split(" ");
			
			if (valores[i].length > numColunas)
				numColunas = valores[i].length;
		}
		// TODO problema: o JTEXTFIELD n detecta /n
		
		lei.setLinhas(numLinhas);
		lei.setColunas(numColunas);
	}

}
