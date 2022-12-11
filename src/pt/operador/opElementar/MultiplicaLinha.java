package pt.operador.opElementar;

import pt.elemento.IElemento;
import pt.matriz.IMatriz;

public class MultiplicaLinha implements OpElementar {
	private int linha;
	private IElemento multiplicador;
	

	public MultiplicaLinha(int linha, IElemento multiplicador) {
		this.linha = linha;
		this.multiplicador = multiplicador;
	
	}

	@Override
	public void aplicar(IMatriz matriz) {
		IElemento[] linhaAux = matriz.getLinha(linha);
		
		for (int i = 0; i < linhaAux.length; i++)
			linhaAux[i] = linhaAux[i].multiplicar(multiplicador);
		
		matriz.setLinha(linha, linhaAux);
	}

	@Override
	public IElemento aplicarNoDeterminante(IElemento determinante) {
		return determinante.multiplicar(multiplicador.inverso());
	}

	@Override
	public OpElementar opInversa() {
		return new MultiplicaLinha(linha, multiplicador.inverso());
	}

}
