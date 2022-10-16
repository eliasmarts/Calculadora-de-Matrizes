package pt.operador;

import pt.elemento.IElemento;
import pt.matriz.Matriz;

public class TrocaDeLinha implements OpElementar {
	private int linha1, linha2;
	

	public TrocaDeLinha(int linha1, int linha2) {
		this.linha1 = linha1;
		this.linha2 = linha2;
	}

	@Override
	public void aplicar(Matriz matriz) {
		IElemento[] linhaAux = matriz.getLinha(linha1);
		
		matriz.setLinha(linha2, linhaAux);

	}

	@Override
	public IElemento aplicarNoDeterminante(IElemento determinante) {
		return determinante.negativo();
	}

	@Override
	public OpElementar opInversa() {
		return new TrocaDeLinha(linha1, linha2);
	}

}
