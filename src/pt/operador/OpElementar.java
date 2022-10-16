package pt.operador;

import pt.elemento.IElemento;
import pt.matriz.Matriz;

public interface OpElementar {
	public void aplicar(Matriz matriz);
	
	
	public IElemento aplicarNoDeterminante(IElemento determinante);
	
	
	public OpElementar opInversa();
}
