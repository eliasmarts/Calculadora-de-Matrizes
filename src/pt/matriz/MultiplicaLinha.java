package pt.matriz;

import pt.operavel.IOperacoesElemento;
import pt.operavel.IOperavel;

public class MultiplicaLinha implements OpElementar {
	private int linha;
	private IOperavel multiplicador;
	

	public MultiplicaLinha(int linha, IOperavel multiplicador) {
		this.linha = linha;
		this.multiplicador = multiplicador;
	
	}

	@Override
	public void aplicar(Matriz matriz) {
		IOperacoesElemento[] linhaAux = matriz.getLinha(linha);
		
		for (int i = 0; i < linhaAux.length; i++)
			linhaAux[i] = linhaAux[i].multiplicar(multiplicador);
		
		matriz.setLinha(linha, linhaAux);
	}

	@Override
	public IOperavel aplicarNoDeterminante(IOperavel determinante) {
		return determinante.multiplicar(multiplicador);
	}

	@Override
	public OpElementar opInversa() {
		// TODO Auto-generated method stub
		return null;
	}

}
