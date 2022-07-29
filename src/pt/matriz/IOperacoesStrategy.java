package pt.matriz;

public interface IOperacoesStrategy extends IOperacoesEsp {
	public IOperacoesStrategy somarOp(IOperacoesStrategy op);
	
	
	public IOperacoesStrategy subtrairOp(IOperacoesStrategy op);
	
	
	public IOperacoesStrategy multiplicarOp(IOperacoesStrategy op);
	
	
	public IOperacoesStrategy negativo();
}
