package pt.telaCalculadora;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import pt.telaCalculadora.leitorMatriz.LeitorDeMatriz;

public class PainelDeMatrizes extends JPanel {
	private List<LeitorDeMatriz> leitores;
	
	public PainelDeMatrizes() {
		super();
		
		leitores = new ArrayList<LeitorDeMatriz>();
	}
	
	
	public void add(LeitorDeMatriz leitor) {
		super.add(leitor);
		
		leitores.add(leitor);
	}
	
	
	public void update() {
		for (LeitorDeMatriz leitorDeMatriz : leitores) {
			leitorDeMatriz.atualiza();
		}
	}
}
