package pt.operador.operacao;

import pt.elemento.IElemento;
import pt.matriz.IMatriz;
import pt.matriz.IOperavel;

public class Negativo extends Operacao {
	
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

	@Override
	public IOperavel realizarOperacao(IOperavel op1, IOperavel op2) {
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
