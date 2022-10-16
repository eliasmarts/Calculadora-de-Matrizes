package pt.elemento;


import pt.matriz.IMatriz;


public abstract class Elemento implements IElemento {
	public String toString() {
		return getRepresentacao();
	}
	
	
	public IMatriz getMatriz()	{
		return null;
	}
	
	
	public IElemento getElemento() {
		return this;
	}
}
