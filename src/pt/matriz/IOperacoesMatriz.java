package pt.matriz;

import pt.operavel.IOperavel;

public interface IOperacoesMatriz {
	public IMatriz somar(IMatriz matriz);
	
	
	public IMatriz subtrair(IMatriz matriz);
	
	
	public IMatriz multiplicar(IMatriz matriz);
	
	
	public IMatriz multiplicar(IOperavel operavel);
	
	
	public IMatriz clone();
}
