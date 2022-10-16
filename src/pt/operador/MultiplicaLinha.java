package pt.operador;

import pt.elemento.IElemento;
import pt.matriz.Matriz;

public class MultiplicaLinha implements OpElementar {
	private int linha;
	private IElemento multiplicador;
	

	public MultiplicaLinha(int linha, IElemento multiplicador) {
		this.linha = linha;
		this.multiplicador = multiplicador;
	
	}

	@Override
	public void aplicar(Matriz matriz) {
		IElemento[] linhaAux = matriz.getLinha(linha);
		
		for (int i = 0; i < linhaAux.length; i++)
			linhaAux[i] = linhaAux[i].multiplicar(multiplicador);
		
		matriz.setLinha(linha, linhaAux);
	}

	@Override
	public IElemento aplicarNoDeterminante(IElemento determinante) {
		return determinante.multiplicar(multiplicador);
	}

	@Override
	public OpElementar opInversa() {
		// TODO Auto-generated method stub
		return null;
	}

}
