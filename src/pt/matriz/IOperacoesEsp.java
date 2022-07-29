package pt.matriz;

import pt.operavel.IOperavel;

public interface IOperacoesEsp {
	public IOperacoes somar(IMatriz matriz);
	
	public IOperacoes somar(IOperavel operavel);
	
	
	public IOperacoes subtrair(IMatriz matriz);
	
	public IOperacoes subtrair(IOperavel operavel);
	
	
	public IOperacoes multiplicar(IMatriz matriz);
	
	public IOperacoes multiplicar(IOperavel operavel);
	
	
}
