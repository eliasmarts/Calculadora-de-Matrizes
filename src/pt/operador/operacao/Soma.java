package pt.operador.operacao;

import pt.elemento.IElemento;
import pt.exceptions.ErroDeTamanho;
import pt.exceptions.ErroDeTipo;
import pt.matriz.IMatriz;
import pt.matriz.IOperavel;

public class Soma extends Operacao {
	
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
	public IOperavel realizarOperacao(IOperavel op1, IOperavel op2) {
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

}
