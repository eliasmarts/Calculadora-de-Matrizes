package pt.telaCalculadora.leitorMatriz;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pt.matriz.IMatriz;

public class LeitorDeTamanho extends JPanel {
	private JTextField tamX, tamY;
	private IMatriz matriz;
	
	
	public LeitorDeTamanho(IMatriz matriz, LeitorDeMatriz leitor, int linhaI, int colunaI) {
		super();
		
		setLayout(new FlowLayout());
		
		add(new JLabel("Linhas: "));
		add(new LeitorTam(matriz, leitor, 'y', linhaI));
		add(new JLabel("Colunas: "));
		add(new LeitorTam(matriz, leitor, 'x', colunaI));
	}
}
