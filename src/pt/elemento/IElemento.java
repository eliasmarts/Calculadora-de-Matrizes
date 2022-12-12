package pt.elemento;

import pt.matriz.IOperavel;

public interface IElemento extends IOperacoesEspecificas, IOperavel {
	public String getRepresentacao();

	public IElemento somar(IElemento outro);
	
	public IElemento subtrair(IElemento outro);
	
	public IElemento multiplicar(IElemento outro);
	
	public IElemento dividir(IElemento outro);
	
	public IElemento potencia(IElemento outro);
	
	public boolean igual(IElemento outro);
	
	public IElemento inverso();
	
	public IElemento negativo();
	
	
	public IElemento deepClone();
	
	
	public void accept(ElementoVisitor v);
}
