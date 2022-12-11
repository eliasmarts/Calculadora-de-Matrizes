package pt.operador;

import pt.matriz.IOperavel;
/**
 * Interface de operacoes entre operaveis, que podem ser matrizes ou elementos
 * @author elias
 *
 */
public interface IOperador {
	public IOperavel realizarOperacao(String operacao, IOperavel op);
	
	
	public IOperavel realizarOperacao(String operacao, IOperavel op1, IOperavel op2);
}
