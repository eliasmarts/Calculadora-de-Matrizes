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
		valores = null;
		linhas = 1;
		colunas = 1;
	}
	
	
	private Matriz(IElemento[][] resp) {
		this.setMatriz(resp);
	}

	@Override
	public void setLinhas(int numLinhas) {
		this.linhas = numLinhas;
		criarMatriz();
	}

	@Override
	public void setColunas(int numColunas) {
		this.colunas = numColunas;
		criarMatriz();
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

	
	private void criarMatriz() {
		valores = new IElemento[linhas][colunas];
	}

	@Override
	public void setElemento(int x, int y, IElemento elemento) {
		// TODO Auto-generated method stub
		
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
}
