package pt.elemento;

import pt.matriz.IOperavel;

public interface IElemento extends IOperacoesEspecificas, IOperavel {
	public String getRepresentacao();

	public IElemento somar(IElemento outro);
	
	public IElemento subtrair(IElemento outro);
	
	public IElemento multiplicar(IElemento outro);
	
	public IElemento inverso();
	
	public IElemento negativo();
	
}
