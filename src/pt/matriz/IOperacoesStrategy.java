package pt.matriz;

import pt.operavel.IOperavel;

public interface IOperacoesStrategy extends IOperacoesEsp {
	public IOperacoesStrategy somarOp(IOperacoesStrategy op);
	
	
	public IOperacoesStrategy subtrairOp(IOperacoesStrategy op);
	
	
	public IOperacoesStrategy multiplicarOp(IOperacoesStrategy op);
	
	
	public IOperacoesStrategy negativo();
	
	
	public IMatriz getMatriz();
	
	
	public IOperavel getOperavel();
}
