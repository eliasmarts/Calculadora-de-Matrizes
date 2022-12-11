package pt.operador.operacao;

import java.util.List;

import pt.elemento.ElementoFactory;
import pt.elemento.IElemento;
import pt.exceptions.ErroDeTipo;
import pt.exceptions.OperacaoInvalida;
import pt.matriz.IMatriz;
import pt.matriz.IOperavel;
import pt.operador.opElementar.OpElementar;

public class Determinante extends Operacao {
	
	private IOperavel determinante(IMatriz m) {
		if (m.getNumLinhas() != m.getNumColunas()) {
			throw new OperacaoInvalida("Determinante so e valido para matrizes quadradas");
		}
		
		IElemento det = ElementoFactory.criarOperavel(1);
		List<OpElementar> escalonamento = getEscalonamento(m);
		
		for (OpElementar opElementar : escalonamento) {
			det = opElementar.aplicarNoDeterminante(det);
		}
		
		return det;
	}


	@Override
	public IOperavel realizarOperacao(IOperavel op, IOperavel op2) {
		IMatriz m = op.getMatriz();
		IOperavel resp = null;
		
		if (m != null)
			resp = determinante(m);
		else {
			ErroDeTipo erro = new ErroDeTipo("numero");
			erro.setOperacao("determinante");
			throw erro;
		}
		
		return resp;
	}

}
