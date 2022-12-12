package pt.operador.operacao;

import pt.elemento.IElemento;
import pt.exceptions.ErroDeTipo;
import pt.exceptions.OperacaoInvalida;
import pt.matriz.IMatriz;
import pt.matriz.IOperavel;
import pt.matriz.Matriz;

public class Potencia extends Operacao {
	private Multiplicacao multiplicacao;
	private Inverso inverso;
	
	
	public Potencia() {
		multiplicacao = new Multiplicacao();
		inverso = new Inverso();
	}

	@Override
	public IOperavel realizarOperacao(IOperavel op1, IOperavel op2) {
		IMatriz m1 = op1.getMatriz(), m2 = op2.getMatriz();
		IElemento o1 = op1.getElemento(), o2 = op2.getElemento();
		IOperavel resp = null;
		
		if (o1 != null && o2 != null)
			resp = potencia(o1, o2);
		else if (m1 != null && o2 != null)
			resp = potencia(m1, o2);
		else if (m1 != null && m2 != null) {
			ErroDeTipo erro = new ErroDeTipo("matriz", "matriz");
			erro.setOperacao("^");
			throw erro;
		} else {
			ErroDeTipo erro = new ErroDeTipo("numero", "matriz");
			erro.setOperacao("^");
			throw erro;
		}

		return resp;
	}

	private IOperavel potencia(IMatriz m1, IElemento o2) {
		GetIntValue visitor = new GetIntValue();
		o2.accept(visitor);
		Integer pow = visitor.getValor();
		
		if (pow == null)
			throw new OperacaoInvalida("So e possivel elevar matrizes a numeros inteiros");
		
		
		
		IMatriz m1copy = m1.deepClone();
		
		
		if (pow < 0) {
			m1copy = inverso.inverso(m1copy);
			pow *= -1;
		}
		
		IMatriz resp = Matriz.matrizIdentidade(m1copy.getNumLinhas());
		
		if (m1.getNumLinhas() != m1.getNumColunas()) {
			throw new OperacaoInvalida("potencia so e valido pra matrizes quadradas");
		}
		// fast exponentiation
		while (pow > 0) {
			int last_bit = (pow & 1);
			
			if (last_bit > 0)
				resp = multiplicacao.multiplicar(resp, m1copy);
			
			m1copy = multiplicacao.multiplicar(m1copy, m1copy);
			
			pow = (pow >> 1);
		}
		
		return resp;
	}

	private IOperavel potencia(IElemento o1, IElemento o2) {
		return o2.potencia(o1);
	}

}
