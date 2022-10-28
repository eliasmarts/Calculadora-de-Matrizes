package pt.telaCalculadora.leitorMatriz;

import java.awt.GridLayout;

import javax.swing.JPanel;

import pt.matriz.IMatriz;

public class TelaLeitores extends JPanel {
	private IMatriz m;
	private int linhas, colunas;
	private LeitorElemento[][] leitores;


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
		revalidate();
		repaint();
	}


	public TelaLeitores(IMatriz matriz, int linha, int coluna) {
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
	}


	public IMatriz getM() {
		return m;
	}
	
	
	
}
