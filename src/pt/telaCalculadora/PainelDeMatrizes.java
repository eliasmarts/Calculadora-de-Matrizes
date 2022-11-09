package pt.telaCalculadora;

import javax.swing.JPanel;
import java.awt.FlowLayout;

import pt.telaCalculadora.leitorMatriz.LeitorDeMatriz;

public class PainelDeMatrizes extends JPanel {
	private LeitorDeMatriz leitores[];
	private char leitoresC[];
	
	public PainelDeMatrizes() {
		super();
		
		leitores = new LeitorDeMatriz[26];
		
		setLayout(new FlowLayout(10));
	}
	
	
	public void add(LeitorDeMatriz leitor, char nome) {
		int pos = nome - 48;
		
		if (leitores[pos] == null) {
			super.add(leitor);
			
			leitores[pos] = leitor;
		}
	}
	
	
	public void remove(char nome) {
		int pos = nome - 48;
		
		if (leitores[pos] != null) {
			super.remove(leitores[pos]);
			
			leitores[pos] = null;
			
			revalidate();
			repaint();
		}
	}
	
	
	public void update() {
		for (LeitorDeMatriz leitorDeMatriz : leitores) {
			if (leitorDeMatriz != null)
				leitorDeMatriz.atualiza();
		}
	}
}
