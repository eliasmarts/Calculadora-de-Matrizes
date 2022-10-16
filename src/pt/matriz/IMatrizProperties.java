package pt.matriz;

import pt.elemento.IElemento;

public interface IMatrizProperties {
	public void setLinhas(int numLinhas);
	
	
	public void setColunas(int numColunas);
	
	
	public void setElemento(int x, int y, IElemento elemento);
	
	
	public void setMatriz(IElemento[][] matriz);
	
	
	public void setLinha(int numLinha, IElemento[] linha);

	
	public IElemento[][] getValores();
	
	
	public IElemento[] getLinha(int numLinha);
	
	public IElemento[] getColuna(int numColuna);

	public int getNumLinhas();

	public int getNumColunas();

	
}
