package pt.matriz;

import pt.exceptions.ErroDeTamanho;
import pt.exceptions.OperacaoInvalida;
import pt.operavel.IOperacoesElemento;
import pt.operavel.IOperavel;
import pt.operavel.OperavelFactory;

public class Matriz implements IMatriz {
	public static IMatriz matrizIdentidade(int n) {
		IOperacoesElemento[][] valoresId = new IOperavel[n][n];
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (i == j)
					valoresId[i][j] = OperavelFactory.criarOperavel("1");
				else
					valoresId[i][j] = OperavelFactory.criarOperavel("0");
			}
		
		return new Matriz(valoresId);
	}
	
	private IOperacoesElemento[][] valores;
	private int linhas, colunas;


	public Matriz() {
		valores = null;
		linhas = 1;
		colunas = 1;
	}
	
	
	private Matriz(IOperacoesElemento[][] resp) {
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

	
	public IOperacoesElemento[][] getValores() {
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
		
		
		for (IOperacoesElemento[] linha : valores) {
			for (IOperacoesElemento valor : linha) {
				valor = null;
			}
		}
	}

	@Override
	public void setElemento(int x, int y, IOperacoesElemento elemento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMatriz(IOperacoesElemento[][] resp) {
		valores = resp;
		linhas = resp.length;
		colunas = resp[0].length;
	}

	@Override
	public void setLinha(int numLinha, IOperacoesElemento[] linha) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IOperacoesElemento[] getLinha(int numLinha) {
		return valores[numLinha];
	}
	
	
	public IOperacoesElemento[] getColuna(int numColuna) {
		IOperacoesElemento[] resp = new IOperavel[this.linhas];
		
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
		
		IOperacoesElemento[][] resp = new IOperacoesElemento[linhas][colunas], outraMatriz = outra.getValores();
		
		for (int i = 0; i < this.linhas; i++)
			for (int j = 0; j < this.colunas; j++)
				resp[i][j] = this.valores[i][j].somar(outraMatriz[i][j]);
		
		return new Matriz(resp);
	}

	@Override
	public IMatriz subtrair(IMatriz outra) {
		if (outra.getNumLinhas() != this.linhas || outra.getNumColunas() != this.colunas)
			throw new OperacaoInvalida("Tamanho incompativel");
		
		IOperacoesElemento[][] resp = new IOperavel[linhas][colunas], outraMatriz = outra.getValores();
		
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
	
		IOperacoesElemento[][] resp = new IOperavel[this.linhas][colunasOutra];
		
		for (int i = 0; i < this.linhas; i++)
			for (int j = 0; j < colunasOutra; j++)
				resp[i][j] = multiplicar(this.getLinha(i), outra.getColuna(j));
		
		return new Matriz(resp);
	}

	
	private IOperacoesElemento multiplicar(IOperacoesElemento[] iOperacoesElementos, IOperacoesElemento[] coluna) {
		IOperacoesElemento result = OperavelFactory.criarOperavel(0);
		
		for (int i = 0; i < iOperacoesElementos.length; i++) {
			result = result.somar(iOperacoesElementos[i].multiplicar(coluna[i]));
		}
		
		return result;
	}


	@Override
	public IMatriz multiplicar(IOperavel operavel) {
		IOperacoesElemento[][] resp = new IOperavel[linhas][colunas];
		
		for (int i = 0; i < linhas; i++)
			for (int j = 0; j < colunas; j++)
				resp[i][j] = valores[i][j].multiplicar(operavel);
		
		return new Matriz(resp);
	}


	@Override
	public IOperacoes somarOp(IOperacoes op) {
		return op.somar(this);
	}


	@Override
	public IOperacoes subtrairOP(IOperacoes op) {
		return op.subtrair(this).negativo();
	}


	@Override
	public IOperacoes multiplicarOp(IOperacoes op) {
		return op.multiplicar(this);
	}


	@Override
	public IOperacoes negativo() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public IOperacoes somar(IOperavel operavel) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public IOperacoes subtrair(IOperavel operavel) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
