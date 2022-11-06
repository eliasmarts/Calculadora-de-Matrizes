package pt.telaCalculadora.leitorMatriz;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pt.matriz.IMatriz;
import pt.telaCalculadora.TelaCalculadora;

public class LeitorDeMatriz extends JPanel {
	private TelaLeitores telaLeitores;
	private TelaCalculadora tela;
	private LeitorDeTamanho tamanho;
	
	public TelaLeitores getTelaLeitores() {
		return telaLeitores;
	}

	public LeitorDeMatriz(TelaCalculadora tela, char m, IMatriz matriz) {
		super();
		
		this.tela = tela;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(new JLabel("Matriz " + String.valueOf(m)));
		
		telaLeitores = new TelaLeitores(matriz, matriz.getNumLinhas(), matriz.getNumColunas());
		
		tamanho = new LeitorDeTamanho(matriz, this, matriz.getNumLinhas(), matriz.getNumColunas());
		
		add(tamanho);
		
		add(telaLeitores);
		
		
	}
	
	
	public void atualiza() {
		telaLeitores.atualiza();
		if (tamanho != null)
			tamanho.atualiza();
	}
	

}
