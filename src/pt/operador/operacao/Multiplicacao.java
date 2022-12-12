package pt.operador.operacao;

import pt.elemento.ElementoFactory;
import pt.elemento.IElemento;
import pt.exceptions.ErroDeTamanho;
import pt.exceptions.ErroDeTipo;
import pt.matriz.IMatriz;
import pt.matriz.IOperavel;

public class Multiplicacao extends Operacao {
	private IElemento multiplicar(IElemento[] linha, IElemento[] coluna) {
		IElemento result = ElementoFactory.criarOperavel(0);
			
			for (int i = 0; i < linha.length; i++) {
				result = result.somar(linha[i].multiplicar(coluna[i]));
			}
			
			return result;
		}
		
		
		protected IMatriz multiplicar(IMatriz m1, IMatriz m2) {
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
	public IOperavel realizarOperacao(IOperavel op1, IOperavel op2) {
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
}
