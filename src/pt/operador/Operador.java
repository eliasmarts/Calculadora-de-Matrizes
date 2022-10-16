package pt.operador;

import pt.elemento.ElementoFactory;
import pt.elemento.IElemento;
import pt.exceptions.ErroDeTamanho;
import pt.exceptions.ErroDeTipo;
import pt.matriz.IMatriz;
import pt.matriz.IOperavel;
import pt.matriz.Matriz;

public class Operador implements IOperador {
	private static final Operador instance = new Operador();
	
	private Operador() {
		
	}
	
	
	public static Operador getInstance() {
		return instance;
	}
	
	
	private IMatriz criaMatriz(IElemento[][] operaveis) {
		IMatriz m = new Matriz();
		m.setMatriz(operaveis);
		return m;
	}
	
	
	private IMatriz somar(IMatriz m1, IMatriz m2) {
		if (m1.getNumLinhas() != m2.getNumLinhas() || m1.getNumColunas() != m2.getNumColunas()) {
			ErroDeTamanho erro = new ErroDeTamanho("+");

			if (m1.getNumLinhas() != m2.getNumLinhas())
				erro.setMotivo("Numero de linhas diferente");
			else if (m1.getNumColunas() != m2.getNumColunas())
				erro.setMotivo("Numero de coluans diferente");
			
			throw erro;
		}
		
		int linhas = m1.getNumLinhas(), colunas = m2.getNumColunas();
		
		IElemento[][] resp = new IElemento[linhas][colunas];
		IElemento[][] vm1 = m1.getValores(), vm2 = m2.getValores();
		
		for (int i = 0; i < linhas; i++)
			for (int j = 0; j < colunas; j++)
				resp[i][j] = vm1[i][j].somar(vm2[i][j]);
	
		return criaMatriz(resp);
	}
	
	
	private IElemento somar(IElemento o1, IElemento o2) {
		return o1.somar(o2);
	}

	@Override
	public IOperavel somar(IOperavel op1, IOperavel op2) {
		IMatriz m1 = op1.getMatriz(), m2 = op2.getMatriz();
		IElemento o1 = op1.getElemento(), o2 = op2.getElemento();
		IOperavel resp = null;
		
		if (m1 != null && m2 != null)
			resp = somar(m1, m2);
		else if (o1 != null && o2 != null)
			resp = somar(o1, o2);
		else {
			ErroDeTipo erro = new ErroDeTipo("matriz", "numero");
			erro.setOperacao("+");
			throw erro;
		}

		return resp;
	}
	
	
	private IMatriz subtrair(IMatriz m1, IMatriz m2) {
		if (m1.getNumLinhas() != m2.getNumLinhas() || m1.getNumColunas() != m2.getNumColunas()) {
			ErroDeTamanho erro = new ErroDeTamanho("+");

			if (m1.getNumLinhas() != m2.getNumLinhas())
				erro.setMotivo("Numero de linhas diferente");
			else if (m1.getNumColunas() != m2.getNumColunas())
				erro.setMotivo("Numero de coluans diferente");
			
			throw erro;
		}
		
		int linhas = m1.getNumLinhas(), colunas = m2.getNumColunas();
		
		IElemento[][] resp = new IElemento[linhas][colunas];
		IElemento[][] vm1 = m1.getValores(), vm2 = m2.getValores();
		
		for (int i = 0; i < linhas; i++)
			for (int j = 0; j < colunas; j++)
				resp[i][j] = vm1[i][j].subtrair(vm2[i][j]);
	
		return criaMatriz(resp);
	}
	
	
	private IElemento subtrair(IElemento o1, IElemento o2) {
		return o1.subtrair(o2);
	}

	@Override
	public IOperavel subtrair(IOperavel op1, IOperavel op2) {
		IMatriz m1 = op1.getMatriz(), m2 = op2.getMatriz();
		IElemento o1 = op1.getElemento(), o2 = op2.getElemento();
		IOperavel resp = null;
		
		if (m1 != null && m2 != null)
			resp = subtrair(m1, m2);
		else if (o1 != null && o2 != null)
			resp = subtrair(o1, o2);
		else {
			ErroDeTipo erro = new ErroDeTipo("matriz", "numero");
			erro.setOperacao("-");
			throw erro;
		}

		return resp;
	}
	
	
	private IElemento multiplicar(IElemento[] linha, IElemento[] coluna) {
	IElemento result = ElementoFactory.criarOperavel(0);
		
		for (int i = 0; i < linha.length; i++) {
			result = result.somar(linha[i].multiplicar(coluna[i]));
		}
		
		return result;
	}
	
	
	private IMatriz multiplicar(IMatriz m1, IMatriz m2) {
		if (m2.getNumLinhas() != m1.getNumColunas()) {
			ErroDeTamanho erro = new ErroDeTamanho("*");

			erro.setMotivo("Numero de colunas da primeira diferente do numero de linhas da segunda");
			
			throw erro;
		}
		int linhas = m1.getNumLinhas();
		
		int colunas = m2.getNumColunas();
	
		IElemento[][] resp = new IElemento[linhas][colunas];
		
		for (int i = 0; i < linhas; i++)
			for (int j = 0; j < colunas; j++)
				resp[i][j] = multiplicar(m1.getLinha(i), m2.getColuna(j));
		
		return criaMatriz(resp);
	}
	
	
	private IElemento multiplicar(IElemento o1, IElemento o2) {
		return o1.multiplicar(o2);
	}

	
	private IMatriz multiplicar(IElemento o, IMatriz m) {
		int linhas = m.getNumLinhas(), colunas = m.getNumColunas();
		IElemento[][] resp = new IElemento[linhas][colunas];
		IElemento[][] valores = m.getValores();
		
		for (int i = 0; i < linhas; i++)
			for (int j = 0; j < colunas; j++)
				resp[i][j] = valores[i][j].multiplicar(o);
		
		return criaMatriz(resp);
	}

	@Override
	public IOperavel multiplicar(IOperavel op1, IOperavel op2) {
		IMatriz m1 = op1.getMatriz(), m2 = op2.getMatriz();
		IElemento o1 = op1.getElemento(), o2 = op2.getElemento();
		IOperavel resp = null;
		
		if (m1 != null && m2 != null)
			resp = multiplicar(m1, m2);
		else if (o1 != null && o2 != null)
			resp = multiplicar(o1, o2);
		else if (o1 != null && m2 != null)
			resp = multiplicar(o1, m2);
		else {
			ErroDeTipo erro = new ErroDeTipo("matriz", "numero");
			erro.setOperacao("*");
			throw erro;
		}

		return resp;
	}

	@Override
	public IOperavel dividir(IOperavel op1, IOperavel op2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IOperavel inverso(IOperavel op1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private IElemento negativo(IElemento e) {
		return e.negativo();
	}
	
	
	private IMatriz negativo(IMatriz m) {
		int linhas = m.getNumLinhas(), colunas = m.getNumColunas();
		IElemento[][] valores = m.getValores();
		IElemento[][] resp = new IElemento[linhas][colunas];
		
		for (int i = 0; i < linhas; i++)
			for (int j = 0; j < colunas; j++)
				resp[i][j] = valores[i][j].negativo();
	
		return criaMatriz(resp);
	}
	
	
	public IOperavel negativo(IOperavel op1) {
		IMatriz m = op1.getMatriz();
		IElemento e = op1.getElemento();
		IOperavel resp = null;
		
		if (m != null)
			resp = negativo(m);
		else if (e != null)
			resp = negativo(e);
		
		return resp;
	}

}
