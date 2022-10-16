package pt.operador;

import pt.matriz.IOperavel;
/**
 * Interface de operacoes entre operaveis, que podem ser matrizes ou elementos
 * @author elias
 *
 */
public interface IOperador {
	public IOperavel somar(IOperavel op1, IOperavel op2);
	
	
	public IOperavel subtrair(IOperavel op1, IOperavel op2);
	
	
	public IOperavel multiplicar(IOperavel op1, IOperavel op2);
	
	
	public IOperavel dividir(IOperavel op1, IOperavel op2);
	
	
	public IOperavel inverso(IOperavel op1);
	
	
	public IOperavel negativo(IOperavel op1);
}
