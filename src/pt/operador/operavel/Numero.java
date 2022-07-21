package pt.operador.operavel;

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
	public IOperacoesElemento somar(IOperacoesElemento operavel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IOperacoesElemento subtrair(IOperacoesElemento operavel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IOperacoesElemento multiplicar(IOperacoesElemento operavel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IOperacoesElemento dividir(IOperacoesElemento operavel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IOperacoesElemento inverso() {
		// TODO Auto-generated method stub
		return null;
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

	

}
