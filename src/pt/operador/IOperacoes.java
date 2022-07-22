package pt.operador;

import pt.matriz.IOperacoesMatriz;
import pt.operavel.IOperacoesElemento;

public interface IOperacoes {
	public IOperacoesMatriz somar(IOperacoesMatriz matriz1, IOperacoesMatriz matriz2);
	
	
	public IOperacoesElemento somar(IOperacoesElemento el1, IOperacoesElemento el2);

	
	public IOperacoesMatriz subtrair(IOperacoesMatriz matriz1, IOperacoesMatriz matriz2);
	
	
	public IOperacoesElemento subtrair(IOperacoesElemento el1, IOperacoesElemento el2);

	
	public IOperacoesMatriz multiplicar(IOperacoesMatriz matriz1, IOperacoesMatriz matriz2);

	
	public IOperacoesMatriz multiplicar(IOperacoesElemento elemento, IOperacoesMatriz matriz);
	
	
	public IOperacoesElemento multiplicar(IOperacoesElemento el1, IOperacoesElemento el2);
}
