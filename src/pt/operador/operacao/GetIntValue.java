package pt.operador.operacao;

import pt.elemento.ElementoVisitor;
import pt.elemento.Numero;

public class GetIntValue implements ElementoVisitor {
	
	private Integer valor;

	@Override
	public void visit(Numero numero) {
		if (numero.getTipo() == 'i')
			valor = numero.getNumero().intValue();
	}

	
	public Integer getValor() {
		return valor;
	}
}
