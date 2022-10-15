package pt.operador;

import pt.matriz.IOperacoesStrategy;

public interface IOperador {
	public IOperacoesStrategy somar(IOperacoesStrategy op1, IOperacoesStrategy op2);
	
	
	public IOperacoesStrategy subtrair(IOperacoesStrategy op1, IOperacoesStrategy op2);
	
	
	public IOperacoesStrategy multiplicar(IOperacoesStrategy op1, IOperacoesStrategy op2);
	
	
	public IOperacoesStrategy dividir(IOperacoesStrategy op1, IOperacoesStrategy op2);
	
	
	public IOperacoesStrategy inverso(IOperacoesStrategy op1);
}
