package pt.matriz;

import pt.operavel.IOperacoesElemento;
import pt.operavel.IOperavel;

public interface IMatrizProperties {
	public void setLinhas(int numLinhas);
	
	
	public void setColunas(int numColunas);
	
	
	public void setElemento(int x, int y, IOperacoesElemento elemento);
	
	
	public void setMatriz(IOperacoesElemento[][] matriz);
	
	
	public void setLinha(int numLinha, IOperacoesElemento[] linha);

	
	public IOperacoesElemento[][] getValores();
	
	
	public IOperacoesElemento[] getLinha(int numLinha);
	
	public IOperacoesElemento[] getColuna(int numColuna);

	public int getNumLinhas();

	public int getNumColunas();

	
}
