package pt.operador.operavel;

public interface IOperacoesElemento {
	public IOperacoesElemento somar(IOperacoesElemento operavel);
	
	
	public IOperacoesElemento subtrair(IOperacoesElemento operavel);
	
	
	public IOperacoesElemento multiplicar(IOperacoesElemento operavel);
	
	
	public IOperacoesElemento dividir(IOperacoesElemento operavel);
	
	
	public IOperacoesElemento inverso();
	
	
	public String getRepresentacao();
}
