package pt.telaCalculadora.leitorMatriz;

import java.awt.GridLayout;

import javax.swing.JPanel;

import pt.matriz.IMatriz;
import pt.telaCalculadora.util.DirectionalKeyAction;
import pt.telaCalculadora.util.PasteDivisor;

public class TelaLeitores extends JPanel {
	private IMatriz m;
	private int linhas, colunas;
	private LeitorElemento[][] leitores;
	
	public TelaLeitores(LeitorDeMatriz lei, IMatriz matriz, int linha, int coluna) {
		super();
		
		setLayout(new GridLayout(linha, coluna, 5, 5));
		
		leitores = new LeitorElemento[linha][coluna];
		m = matriz;
		
		for (int i = 0; i < linha; i++) 
			for (int j = 0; j < coluna; j++) {
				leitores[i][j] = new LeitorElemento(this, i, j);
				add(leitores[i][j]);
		}
		
		
	
		this.linhas = linha;
		this.colunas = coluna;
		
		recreateKeyListeners();
		
		leitores[0][0].addKeyListener(new PasteDivisor(leitores[0][0], lei));
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
		LeitorElemento[][] ant = leitores;
		
		removeAll();
		
		setLayout(new GridLayout(linhas, colunas, 5, 5));
		
		leitores = new LeitorElemento[linhas][colunas];
		
		for (int i = 0; i < this.linhas && i < linhas; i++) 
			for (int j = 0; j < this.colunas; j++) { 
				leitores[i][j] = ant[i][j];
			}
		

		if (linhas > this.linhas) {
			for (int i = this.linhas; i < linhas; i++)
				for (int j = 0; j < this.colunas; j++) {
					leitores[i][j] = new LeitorElemento(this, i, j);
				}
		}
		
		this.linhas = linhas;
		
		for (int i = 0; i < linhas; i++) 
			for (int j = 0; j < colunas; j++) {
				add(leitores[i][j]);
		}
		
		recreateKeyListeners();
		revalidate();
		repaint();
	}


	public void setColunas(int colunas) {
		LeitorElemento[][] ant = leitores;
		
		removeAll();
		
		setLayout(new GridLayout(linhas, colunas, 5, 5));
		
		leitores = new LeitorElemento[linhas][colunas];
		
		for (int i = 0; i < this.linhas; i++) 
			for (int j = 0; j < this.colunas && j < colunas; j++) { 
				leitores[i][j] = ant[i][j];
			}
		

		if (colunas > this.colunas) {
			for (int i = 0; i < linhas; i++)
				for (int j = this.colunas; j < colunas; j++) {
					leitores[i][j] = new LeitorElemento(this, i, j);
				}
		}
		
		this.colunas = colunas;
		
		for (int i = 0; i < linhas; i++) 
			for (int j = 0; j < colunas; j++) {
				add(leitores[i][j]);
		}
		
		recreateKeyListeners();
		revalidate();
		repaint();
	}


	


	public IMatriz getM() {
		return m;
	}


	public void atualiza() {
		if (m.getNumLinhas() != linhas)
			setLinhas(m.getNumLinhas());
		if (m.getNumColunas() != colunas)
			setColunas(m.getNumColunas());
	
		for (int i = 0; i < linhas; i++) 
			for (int j = 0; j < colunas; j++) {
				leitores[i][j].atualiza(this, i, j);
		}
		
		revalidate();
		repaint();
	}
	
	public LeitorElemento getFirst() {
		return leitores[0][0];
	}
	
}
