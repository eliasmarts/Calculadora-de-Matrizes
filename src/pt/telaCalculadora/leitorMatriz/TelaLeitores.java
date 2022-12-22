package pt.telaCalculadora.leitorMatriz;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.text.JTextComponent;

import pt.matriz.IMatriz;
import pt.telaCalculadora.util.DirectionalKeyAction;

public class TelaLeitores extends JPanel {
	private IMatriz m;
	private int linhas, colunas;
	private JTextComponent[][] leitores;
	private LeitorElemento[][] leit;
	LeitorElementoDivisor leitorDiv;
	
	public TelaLeitores(LeitorDeMatriz lei, IMatriz matriz, int linha, int coluna) {
		super();
		
		setLayout(new GridLayout(linha, coluna, 5, 5));
		
		leitores = new JTextComponent[linha][coluna];
		leit = new LeitorElemento[linha][coluna];
		m = matriz;
		leitorDiv = new LeitorElementoDivisor(lei, this, 0, 0);
		leitores[0][0] = leitorDiv;
		add(leitorDiv);
		
		for (int i = 0; i < linha; i++) 
			for (int j = 0; j < coluna; j++) {
				if (i != 0 || j != 0) {
					leit[i][j] = new LeitorElemento(this, i, j);
							leitores[i][j] = leit[i][j];
					add(leitores[i][j]);
				}
		}
		
		
	
		this.linhas = linha;
		this.colunas = coluna;
		
		recreateKeyListeners();
		
		
	}
	
	
	private void recreateKeyListeners() {
		for (int i = 0; i < linhas; i++) 
			for (int j = 0; j < colunas; j++) {
				DirectionalKeyAction dir = new DirectionalKeyAction();
				if (i - 1 >= 0)
					dir.setUp(leitores[i - 1][j]);
				if (i + 1 < linhas) {
					dir.setDown(leitores[i + 1][j]);
					dir.setEnter(leitores[i + 1][j]);
				}
				if (j - 1 >= 0)
					dir.setLeft(leitores[i][j - 1]);
				if (j + 1 < colunas)
					dir.setRight(leitores[i][j + 1]);
				
				if (i + 1 == linhas) {
					if (j + 1 < colunas)
						dir.setEnter(leitores[0][j + 1]);
				}
				
				if (leitores[i][j].getKeyListeners().length > 1)
					leitores[i][j].removeKeyListener(leitores[i][j].getKeyListeners()[1]);
				
				leitores[i][j].addKeyListener(dir);
			}
	}


	public void setLinhas(int linhas) {
		LeitorElemento[][] ant = leit;
		
		removeAll();
		
		setLayout(new GridLayout(linhas, colunas, 5, 5));
		
		leit = new LeitorElemento[linhas][colunas];
		
		for (int i = 0; i < this.linhas && i < linhas; i++) 
			for (int j = 0; j < this.colunas; j++) { 
				leit[i][j] = ant[i][j];
			}
		

		if (linhas > this.linhas) {
			for (int i = this.linhas; i < linhas; i++)
				for (int j = 0; j < this.colunas; j++) {
					leit[i][j] = new LeitorElemento(this, i, j);
				}
		}
		
		this.linhas = linhas;
		
		
		add(leitorDiv);
		for (int i = 0; i < linhas; i++) 
			for (int j = 0; j < colunas; j++) {
				if (i != 0 || j != 0)
					add(leit[i][j]);
		}
		
		recreateLeitor();
		recreateKeyListeners();
		
		revalidate();
		repaint();
	}



	public void setColunas(int colunas) {
		LeitorElemento[][] ant = leit;
		
		removeAll();
		
		setLayout(new GridLayout(linhas, colunas, 5, 5));
		
		leit = new LeitorElemento[linhas][colunas];
		
		for (int i = 0; i < this.linhas; i++) 
			for (int j = 0; j < this.colunas && j < colunas; j++) { 
				leit[i][j] = ant[i][j];
			}
		

		if (colunas > this.colunas) {
			for (int i = 0; i < linhas; i++)
				for (int j = this.colunas; j < colunas; j++) {
					leit[i][j] = new LeitorElemento(this, i, j);
				}
		}
		
		this.colunas = colunas;
		
		for (int i = 0; i < linhas; i++) 
			for (int j = 0; j < colunas; j++) {
				if (i != 0 || j != 0)
					add(leit[i][j]);
		}
		
		recreateLeitor();
		recreateKeyListeners();
		
		revalidate();
		repaint();
	}


	


	private void recreateLeitor() {
		leitores = new JTextComponent[linhas][colunas];
		
		leitores[0][0] = leitorDiv;
		
		for (int i = 0; i < linhas; i++) 
			for (int j = 0; j < colunas; j++) {
				if (i != 0 || j != 0)
					leitores[i][j] = leit[i][j];
		}
	}


	public IMatriz getM() {
		return m;
	}


	public void atualiza() {
		if (m.getNumLinhas() != linhas)
			setLinhas(m.getNumLinhas());
		if (m.getNumColunas() != colunas)
			setColunas(m.getNumColunas());
		
		leitorDiv.atualiza(this, 0, 0);
	
		for (int i = 0; i < linhas; i++) 
			for (int j = 0; j < colunas; j++) {
				if (i != 0 || j != 0)
					leit[i][j].atualiza(this, i, j);
		}
		
		revalidate();
		repaint();
	}
	
	public JTextComponent getFirst() {
		return leitores[0][0];
	}


	public void setValor(String valor, int x, int y) {
		if (x != 0 || y != 0) {
			leit[x][y].setText(valor);
			leit[x][y].actionPerformed(null);
		}
		else {
			leitorDiv.setText(valor);
		}
	}
	
}
