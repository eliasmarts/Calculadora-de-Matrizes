package pt.matriz;

import pt.exceptions.ErroDeTamanho;
import pt.exceptions.OperacaoInvalida;
import pt.operavel.IOperavel;
import pt.operavel.OperavelFactory;

public class Matriz implements IMatriz {
	public static IMatriz matrizIdentidade(int n) {
		IOperavel[][] valoresId = new IOperavel[n][n];
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (i == j)
					valoresId[i][j] = OperavelFactory.criarOperavel("1");
				else
					valoresId[i][j] = OperavelFactory.criarOperavel("0");
			}
		
		return new Matriz(valoresId);
	}
	
	private IOperavel[][] valores;
	private int linhas, colunas;


	public Matriz() {
		valores = null;
		linhas = 1;
		colunas = 1;
	}
	
	
	private Matriz(IOperavel[][] valores) {
		this.setMatriz(valores);
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
		return valores[numLinha];
	}
	
	
	public IOperavel[] getColuna(int numColuna) {
		IOperavel[] resp = new IOperavel[this.linhas];
		
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

	@Override
	public IMatriz somar(IMatriz outra) {
		if (outra.getNumLinhas() != this.linhas || outra.getNumColunas() != this.colunas) {
			ErroDeTamanho erro = new ErroDeTamanho("+");

			if (outra.getNumLinhas() != this.linhas)
				erro.setMotivo("Numero de linhas diferente");
			else if (outra.getNumColunas() != this.colunas)
				erro.setMotivo("Numero de coluans diferente");
			
			throw erro;
		}
		
		IOperavel[][] resp = new IOperavel[linhas][colunas], outraMatriz = outra.getValores();
		
		for (int i = 0; i < this.linhas; i++)
			for (int j = 0; j < this.colunas; j++)
				resp[i][j] = this.valores[i][j].somar(outraMatriz[i][j]);
		
		return new Matriz(resp);
	}

	@Override
	public IMatriz subtrair(IMatriz outra) {
		if (outra.getNumLinhas() != this.linhas || outra.getNumColunas() != this.colunas)
			throw new OperacaoInvalida("Tamanho incompativel");
		
		IOperavel[][] resp = new IOperavel[linhas][colunas], outraMatriz = outra.getValores();
		
		for (int i = 0; i < this.linhas; i++)
			for (int j = 0; j < this.colunas; j++)
				resp[i][j] = this.valores[i][j].subtrair(outraMatriz[i][j]);
		
		return new Matriz(resp);
	}

	@Override
	public IMatriz multiplicar(IMatriz outra) {
		if (outra.getNumLinhas() != this.colunas)
			throw new OperacaoInvalida("Tamanho incompativel");
		
		int colunasOutra = outra.getNumColunas();
	
		IOperavel[][] resp = new IOperavel[this.linhas][colunasOutra];
		
		for (int i = 0; i < this.linhas; i++)
			for (int j = 0; j < colunasOutra; j++)
				resp[i][j] = multiplicar(this.getLinha(i), outra.getColuna(j));
		
		return new Matriz(resp);
	}

	
	private IOperavel multiplicar(IOperavel[] linha, IOperavel[] coluna) {
		IOperavel result = OperavelFactory.criarOperavel(0);
		
		for (int i = 0; i < linha.length; i++) {
			result = result.somar(linha[i].multiplicar(coluna[i]));
		}
		
		return result;
	}


	@Override
	public IMatriz multiplicar(IOperavel operavel) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
