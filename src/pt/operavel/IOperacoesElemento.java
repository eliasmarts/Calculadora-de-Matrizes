package pt.operavel;

public interface IOperacoesElemento extends IOperacoesEspecificas {
	public String getRepresentacao();

	public IOperavel somar(IOperacoesElemento outro);
	
	public IOperavel subtrair(IOperacoesElemento outro);
	
	public IOperavel multiplicar(IOperacoesElemento outro);
	
	public IOperavel inverso();
	
	public IOperavel negativo();
	
}
