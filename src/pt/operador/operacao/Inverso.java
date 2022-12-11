package pt.operador.operacao;

import java.util.List;

import pt.elemento.IElemento;
import pt.exceptions.OperacaoInvalida;
import pt.matriz.IMatriz;
import pt.matriz.IOperavel;
import pt.matriz.Matriz;
import pt.operador.opElementar.OpElementar;

public class Inverso extends Operacao {

	@Override
	public IOperavel realizarOperacao(IOperavel op1, IOperavel op2) {
		IMatriz m = op1.getMatriz();
		IElemento e = op1.getElemento();
		IOperavel resp = null;
		
		if (m != null)
			resp = inverso(m);
		else if (e != null)
			resp = inverso(e);
		
		return resp;
	}

	
	private IOperavel inverso(IElemento e) {
		return e.inverso();
	}

	
	private IOperavel inverso(IMatriz m) {
		if (m.getNumLinhas() != m.getNumColunas()) {
			throw new OperacaoInvalida("inverso so e valido pra matrizes quadradas");
		}
		
		List<OpElementar> escalonamento = getEscalonamento(m);
		
		IMatriz inverso = Matriz.matrizIdentidade(m.getNumLinhas());
		
		for (OpElementar opElementar : escalonamento) {
			opElementar.aplicar(inverso);
		}
		
		// TODO nao ta funcionando
		
		return inverso;
	}

}
