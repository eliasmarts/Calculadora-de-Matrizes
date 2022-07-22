package pt.matriz;

import pt.operavel.IOperavel;

public interface IMatrizProperties {
	public void setLinhas(int numLinhas);
	
	
	public void setColunas(int numColunas);
	
	
	public void setElemento(int x, int y, IOperavel elemento);
	
	
	public void setMatriz(IOperavel[][] matriz);
	
	
	public void setLinha(int numLinha, IOperavel[] linha);

	
	public IOperavel[][] getValores();
	
	
	public IOperavel[] getLinha(int numLinha);

	public int getNumLinhas();

	public int getNumColunas();

	
}
