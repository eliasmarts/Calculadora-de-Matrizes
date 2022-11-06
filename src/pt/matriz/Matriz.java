package pt.matriz;

import pt.elemento.ElementoFactory;
import pt.elemento.IElemento;


public class Matriz implements IMatriz {
	public static IMatriz matrizIdentidade(int n) {
		IElemento[][] valoresId = new IElemento[n][n];
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (i == j)
					valoresId[i][j] = ElementoFactory.criarOperavel("1");
				else
					valoresId[i][j] = ElementoFactory.criarOperavel("0");
			}
		
		return new Matriz(valoresId);
	}
	
	private IElemento[][] valores;
	private int linhas, colunas;


	public Matriz() {
		valores = new IElemento[1][1];
		linhas = 1;
		colunas = 1;
		valores[0][0] = ElementoFactory.criarOperavel(0);
	}
	
	
	private Matriz(IElemento[][] resp) {
		this.setMatriz(resp);
	}

	@Override
	public void setLinhas(int numLinhas) {
		this.linhas = numLinhas;
		
		IElemento[][] ant = valores;
		
		
		valores = new IElemento[linhas][colunas];
		
		// copía os valores anteriores
		for (int i = 0; i < ant.length && i < linhas; i++)
			for (int j = 0; j < ant[i].length && j < colunas; j++)
				valores[i][j] = ant[i][j];


		// coloca 0 nas novas posicoes
		for (int i = ant.length; i < linhas; i++)
			for (int j = 0; j < colunas; j++)
				valores[i][j] = ElementoFactory.criarOperavel(0);
	}

	@Override
	public void setColunas(int numColunas) {
		this.colunas = numColunas;
		
		IElemento[][] ant = valores;
		
		
		valores = new IElemento[linhas][colunas];
		
		// copía os valores anteriores
		for (int i = 0; i < ant.length && i < linhas; i++)
			for (int j = 0; j < ant[i].length && j < colunas; j++)
				valores[i][j] = ant[i][j];


		// coloca 0 nas novas posicoes
		for (int i = 0; i < linhas; i++)
			for (int j = ant[0].length; j < colunas; j++)
				valores[i][j] = ElementoFactory.criarOperavel(0);
	}

	
	public IElemento[][] getValores() {
		return valores;
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	
	private void recriarMatriz() {
		IElemento[][] ant = valores;
		
		
		valores = new IElemento[linhas][colunas];
		
		// copía os valores anteriores
		for (int i = 0; i < ant.length && i < linhas; i++)
			for (int j = 0; j < ant[i].length && j < colunas; j++)
				valores[i][j] = ant[i][j];


		// coloca 0 nas novas posicoes
		for (int i = ant.length; i < linhas; i++)
			for (int j = ant[0].length; j < colunas; j++)
				valores[i][j] = ElementoFactory.criarOperavel(0);
	}

	@Override
	public void setElemento(int x, int y, IElemento elemento) {
		valores[x][y] = elemento;
	}

	@Override
	public void setMatriz(IElemento[][] resp) {
		valores = resp;
		linhas = resp.length;
		colunas = resp[0].length;
	}

	@Override
	public void setLinha(int numLinha, IElemento[] linha) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IElemento[] getLinha(int numLinha) {
		return valores[numLinha];
	}
	
	
	public IElemento[] getColuna(int numColuna) {
		IElemento[] resp = new IElemento[this.linhas];
		
		for (int i = 0; i < linhas; i++) 
			resp[i] = valores[i][numColuna];
		
		return resp;
	}

	@Override
	public int getNumLinhas() {
		return linhas;
	}

	@Override
	public int getNumColunas() {
		return colunas;
	}
	
	
	public Matriz clone() {
		return null;
	}


	public IMatriz getMatriz() {
		return this;
	}
	
	
	public IElemento getElemento() {
		return null;
	}


	@Override
	public void setElemento(int x, int y, String elemento) {
		valores[x][y] = ElementoFactory.criarOperavel(elemento);
	}
}
