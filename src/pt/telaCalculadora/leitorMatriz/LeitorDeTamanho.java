package pt.telaCalculadora.leitorMatriz;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import pt.matriz.IMatriz;
import pt.telaCalculadora.util.TextFieldCommand;

public class LeitorDeTamanho extends JPanel {
	private LeitorTam tamX, tamY;
	private IMatriz matriz;
	
	
	public LeitorDeTamanho(IMatriz matriz, LeitorDeMatriz leitor, int linhaI, int colunaI) {
		super();
		
		setLayout(new FlowLayout());
		
		add(new JLabel("Linhas: "));
		
		tamX = new LeitorTam(matriz, leitor, 'x', linhaI);
		
		add(tamX);
		
		add(new JLabel("Colunas: "));
		
		tamY = new LeitorTam(matriz, leitor, 'y', colunaI);
		
		add(tamY);
		
		this.matriz = matriz;
	}
	
	
	public void atualiza() {
		tamX.update(matriz, 'x');
		tamY.update(matriz, 'y');
	}
}
