package pt.operador;

import pt.elemento.IElemento;
import pt.matriz.Matriz;

public class SomaMultiplo implements OpElementar {
	private int linha1, linha2;
	private IElemento multiplicador;

	public SomaMultiplo(int linha1, int linha2, IElemento multiplicador) {
		super();
		this.linha1 = linha1;
		this.linha2 = linha2;
		this.multiplicador = multiplicador;
	}

	@Override
	public void aplicar(Matriz matriz) {
		IElemento[] linhaAux = matriz.getLinha(linha1);
		IElemento[] linha2el = matriz.getLinha(linha2);
		
		for (int i = 0; i < linhaAux.length; i++) {
			linhaAux[i] = linhaAux[i].somar(linha2el[i].multiplicar(multiplicador));
		}
		
		matriz.setLinha(linha1, linhaAux);
	}

	@Override
	public IElemento aplicarNoDeterminante(IElemento determinante) {
		return determinante;
	}

	@Override
	public OpElementar opInversa() {
		return new SomaMultiplo(linha1, linha2, multiplicador.inverso());
	}

}
