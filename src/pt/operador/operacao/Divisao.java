package pt.operador.operacao;

import pt.elemento.IElemento;
import pt.exceptions.ErroDeTipo;
import pt.matriz.IMatriz;
import pt.matriz.IOperavel;

public class Divisao extends Operacao {
	
	private IOperavel dividir(IElemento op1, IElemento op2) {
		return op2.dividir(op1);
	}
	
	
	private IOperavel dividir(IMatriz m, IElemento o) {
		int linhas = m.getNumLinhas(), colunas = m.getNumColunas();
		IElemento[][] resp = new IElemento[linhas][colunas];
		IElemento[][] valores = m.getValores();
		
		for (int i = 0; i < linhas; i++)
			for (int j = 0; j < colunas; j++)
				resp[i][j] = o.dividir(valores[i][j]);
		
		return criaMatriz(resp);
	}
	

	@Override
	public IOperavel realizarOperacao(IOperavel op1, IOperavel op2) {
		IMatriz m1 = op1.getMatriz(), m2 = op2.getMatriz();
		IElemento o1 = op1.getElemento(), o2 = op2.getElemento();
		IOperavel resp = null;
		
		if (o1 != null && o2 != null)
			resp = dividir(o1, o2);
		else if (m1 != null && o2 != null)
			resp = dividir(m1, o2);
		else if (m1 != null && m2 != null) {
			ErroDeTipo erro = new ErroDeTipo("matriz", "matriz");
			erro.setOperacao("/");
			throw erro;
		} else {
			ErroDeTipo erro = new ErroDeTipo("numero", "matriz");
			erro.setOperacao("/");
			throw erro;
		}

		return resp;
	}

}
