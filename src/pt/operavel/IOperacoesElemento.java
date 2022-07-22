package pt.operavel;

public interface IOperacoesElemento {
	public String getRepresentacao();
	
	
	public IOperacoesElemento somar(IOperacoesElemento outro);
	
	
	public IOperacoesElemento subtrair(IOperacoesElemento outro);
	
	
	public IOperacoesElemento multiplicar(IOperacoesElemento outro);
}
