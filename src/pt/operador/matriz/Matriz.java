package pt.operador.matriz;

import pt.operador.operavel.IOperacoesElemento;
import pt.operador.operavel.IOperavel;
import pt.operador.operavel.OperavelFactory;

public class Matriz implements IMatriz {
	private IOperavel[][] valores;
	private int linhas, colunas;
	
	public Matriz() {
		valores = null;
		linhas = 1;
		colunas = 1;
	}

	@Override
	public String[][] realizarOperacao(String operacao, char matriz1, char matriz2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[][] realizarOperacao(String operacao, String[][] matriz1, String[][] matriz2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void armazenaMatriz(char nome, String[][] matriz) {
		// TODO Auto-generated method stub

	}

	@Override
	public String[][] getMatriz(char nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void connect(IOperacoesElemento operavel) {
		// TODO Auto-generated method stub

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

	@Override
	public void setElemento(int x, int y, String elemento) {
		this.valores[x][y] = OperavelFactory.criarOperavel(elemento);
	}
	
	
	public String getElemento(int x, int y) {
		return valores[x][y].getRepresentacao();
	}

	
	private void criarMatriz() {
		valores = new IOperavel[linhas][colunas];
		
		
		for (IOperavel[] linha : valores) {
			for (IOperavel valor : linha) {
				valor = null;
			}
		}
	}
	
}
