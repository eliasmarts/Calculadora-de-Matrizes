package pt.operador.matriz;

import pt.operador.operavel.IOperavel;

public interface IMatrizProperties {
	public void setLinhas(int numLinhas);
	
	
	public void setColunas(int numColunas);
	
	
	public void setElemento(int x, int y, IOperavel elemento);
}
