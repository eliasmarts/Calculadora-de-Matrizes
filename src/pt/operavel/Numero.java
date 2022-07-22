package pt.operavel;


public class Numero implements IOperavel {
	private Number numero;
	private char tipo;
	
	public Numero(int valor) {
		this.numero = valor;
		tipo = 'i';
	}
	
	public Numero(double valor) {
		this.numero = valor;
		tipo = 'd';
	}

	@Override
	public String getRepresentacao() {
		String representacao = "-";
	
		if (tipo == 'i') {
			representacao = Integer.toString(numero.intValue());
		} else if (tipo == 'd') {
			representacao = Double.toString(numero.doubleValue());
		}
		
		
		return representacao;
	}

	@Override
	public IOperacoesElemento somar(IOperacoesElemento outro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IOperacoesElemento subtrair(IOperacoesElemento outro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IOperacoesElemento multiplicar(IOperacoesElemento outro) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
