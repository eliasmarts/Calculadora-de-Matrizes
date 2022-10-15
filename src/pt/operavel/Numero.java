package pt.operavel;


public class Numero extends Operavel {
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
	
	
	protected Number getNumero() {
		return numero;
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
	public IOperavel somar(IOperacoesElemento outro) {
		return outro.somar(this);
	}
	
	
	public IOperavel somar(Numero outro) {
		Numero resposta;
		
		if (this.tipo == 'd' || outro.tipo == 'd') {
			double resp = this.getNumero().doubleValue() + outro.getNumero().doubleValue();
			resposta = new Numero(resp);
		}
		else {
			int respI = this.getNumero().intValue() + outro.getNumero().intValue();
			resposta = new Numero(respI);
		}
		
		return resposta;
	}

	@Override
	public IOperavel subtrair(IOperacoesElemento outro) {
		return outro.subtrair(this).negativo();
	}

	@Override
	public IOperavel multiplicar(IOperacoesElemento outro) {
		return outro.multiplicar(this);
	}

	@Override
	public IOperavel subtrair(Numero outro) {
		Numero resposta;
		
		if (this.tipo == 'd' || outro.tipo == 'd') {
			double resp = this.getNumero().doubleValue() - outro.getNumero().doubleValue();
			resposta = new Numero(resp);
		}
		else {
			int respI = this.getNumero().intValue() - outro.getNumero().intValue();
			resposta = new Numero(respI);
		}
		
		return resposta;
	}

	@Override
	public IOperavel multiplicar(Numero outro) {
		Numero resposta;
		
		if (this.tipo == 'd' || outro.tipo == 'd') {
			double resp = this.getNumero().doubleValue() * outro.getNumero().doubleValue();
			resposta = new Numero(resp);
		}
		else {
			int respI = this.getNumero().intValue() * outro.getNumero().intValue();
			resposta = new Numero(respI);
		}
		
		return resposta;
	}

	@Override
	public IOperavel inverso() {
		Numero inverso = null;
		
		if (tipo == 'd')
			inverso = new Numero(1 / numero.doubleValue());
		else
			inverso = new Numero((double) 1 / numero.intValue());
		
		return inverso;
	}

	@Override
	public IOperavel negativo() {
		Numero negativo = null;
		
		if (tipo == 'd')
			negativo = new Numero(- numero.doubleValue());
		else
			negativo = new Numero(- numero.intValue());
		
		return negativo;
	}

}
