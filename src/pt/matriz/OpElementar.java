package pt.matriz;

import pt.operavel.IOperavel;

public interface OpElementar {
	public void aplicar(Matriz matriz);
	
	
	public IOperavel aplicarNoDeterminante(IOperavel determinante);
	
	
	public OpElementar opInversa();
}
