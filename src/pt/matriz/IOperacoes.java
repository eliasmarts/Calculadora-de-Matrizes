package pt.matriz;

public interface IOperacoes extends IOperacoesEsp {
	public IOperacoes somarOp(IOperacoes op);
	
	
	public IOperacoes subtrairOP(IOperacoes op);
	
	
	public IOperacoes multiplicarOp(IOperacoes op);
	
	
	public IOperacoes negativo();
}
