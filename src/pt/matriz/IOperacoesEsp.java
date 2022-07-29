package pt.matriz;

import pt.operavel.IOperavel;

public interface IOperacoesEsp {
	public IOperacoesStrategy somar(IMatriz matriz);
	
	public IOperacoesStrategy somar(IOperavel operavel);
	
	
	public IOperacoesStrategy subtrair(IMatriz matriz);
	
	public IOperacoesStrategy subtrair(IOperavel operavel);
	
	
	public IOperacoesStrategy multiplicar(IMatriz matriz);
	
	public IOperacoesStrategy multiplicar(IOperavel operavel);
	
	
}
