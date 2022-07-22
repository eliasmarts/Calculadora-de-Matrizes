package pt.matriz;

import pt.operavel.IOperavel;
import pt.operavel.OperavelFactory;

public class Matriz implements IMatriz {
	private IOperavel[][] valores;
	private int linhas, colunas;
	
	

	public Matriz() {
		valores = null;
		linhas = 1;
		colunas = 1;
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

	
	public IOperavel[][] getValores() {
		return valores;
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	
	private void criarMatriz() {
		valores = new IOperavel[linhas][colunas];
		
		
		for (IOperavel[] linha : valores) {
			for (IOperavel valor : linha) {
				valor = null;
			}
		}
	}

	@Override
	public void setElemento(int x, int y, IOperavel elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMatriz(IOperavel[][] matriz) {
		valores = matriz;
		linhas = matriz.length;
		colunas = matriz[0].length;
	}

	@Override
	public void setLinha(int numLinha, IOperavel[] linha) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IOperavel[] getLinha(int numLinha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumLinhas() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumColunas() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
