package pt.matriz;

import pt.operavel.IOperacoesElemento;
import pt.operavel.IOperavel;

public class SomaMultiplo implements OpElementar {
	private int linha1, linha2;
	private IOperavel multiplicador;

	public SomaMultiplo(int linha1, int linha2, IOperavel multiplicador) {
		super();
		this.linha1 = linha1;
		this.linha2 = linha2;
		this.multiplicador = multiplicador;
	}

	@Override
	public void aplicar(Matriz matriz) {
		IOperacoesElemento[] linhaAux = matriz.getLinha(linha1);
		IOperacoesElemento[] linha2el = matriz.getLinha(linha2);
		
		for (int i = 0; i < linhaAux.length; i++) {
			linhaAux[i] = linhaAux[i].somar(linha2el[i].multiplicar(multiplicador));
		}
		
		matriz.setLinha(linha1, linhaAux);
	}

	@Override
	public IOperavel aplicarNoDeterminante(IOperavel determinante) {
		return determinante;
	}

	@Override
	public OpElementar opInversa() {
		return new SomaMultiplo(linha1, linha2, multiplicador.inverso());
	}

}
