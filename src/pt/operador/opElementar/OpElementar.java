package pt.operador.opElementar;

import pt.elemento.IElemento;
import pt.matriz.IMatriz;

public interface OpElementar {
	public void aplicar(IMatriz matriz);
	
	
	public IElemento aplicarNoDeterminante(IElemento determinante);
	
	
	public OpElementar opInversa();
}
