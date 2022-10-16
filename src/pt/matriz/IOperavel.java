package pt.matriz;

import pt.elemento.IElemento;

public interface IOperavel {
	/**
	 * 
	 * @return matriz se for matriz, null se nao for
	 */
	public IMatriz getMatriz();
	
	
	/**
	 * 
	 * @return elemento se for elemento, null se nao for
	 */
	public IElemento getElemento();
}
