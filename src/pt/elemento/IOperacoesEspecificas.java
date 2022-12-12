package pt.elemento;

public interface IOperacoesEspecificas {
	public IElemento somar(Numero outro);
	
	public IElemento subtrair(Numero outro);

	public IElemento multiplicar(Numero outro);
	
	public IElemento dividir(Numero outro);
	
	public IElemento potencia(Numero outro);
	
	public boolean igual(Numero outro);
}
