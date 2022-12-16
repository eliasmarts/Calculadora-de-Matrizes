package pt.elemento;



import java.text.NumberFormat;

import pt.Configurations;
import pt.exceptions.OperacaoInvalida;
import pt.util.FuncoesString;

public class Numero extends Elemento {
	public static final NumberFormat nf = Configurations.getNumberFormatter();
	
	private Number numero;
	private char tipo;
	
	public Numero(int valor) {
		this.numero = valor;
		tipo = 'i';
	}
	
	public Numero(double valor) {
		if (valor - Math.floor(valor) == 0) {
			this.numero = (int) valor;
			tipo = 'i';
		}
		else {
		this.numero = valor;
		tipo = 'd';
		}
	}
	
	
	public char getTipo() {
		return tipo;
	}

	
	public Number getNumero() {
		return numero;
	}

	@Override
	public String getRepresentacao() {
		String representacao = "-";
	
		if (tipo == 'i') {
			representacao = nf.format(numero.intValue());
		} else if (tipo == 'd') {
			representacao = nf.format(numero.doubleValue());
		}
		if (Configurations.getDecimalDivisor() == '.')
			representacao = FuncoesString.substitute(representacao, ",", ".");
		
		return representacao;
	}

	@Override
	public IElemento somar(IElemento outro) {
		return outro.somar(this);
	}
	
	
	public IElemento somar(Numero outro) {
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
	public IElemento subtrair(IElemento outro) {
		return outro.subtrair(this);
	}

	@Override
	public IElemento multiplicar(IElemento outro) {
		return outro.multiplicar(this);
	}

	@Override
	public IElemento subtrair(Numero outro) {
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
	public IElemento multiplicar(Numero outro) {
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
	public IElemento inverso() {
		
		return new Numero(1 / numero.doubleValue());
	}

	@Override
	public IElemento negativo() {
		Numero negativo = null;
		
		if (tipo == 'd')
			negativo = new Numero(- numero.doubleValue());
		else
			negativo = new Numero(- numero.intValue());
		
		return negativo;
	}

	@Override
	public IElemento dividir(IElemento outro) {
		return outro.dividir(this);
	}

	@Override
	public IElemento dividir(Numero outro) {
		Numero resposta;
		try {
			double resp = this.getNumero().doubleValue() / outro.getNumero().doubleValue();
			resposta = new Numero(resp);
		} catch (ArithmeticException e) {
			throw new OperacaoInvalida("Divisao por 0");
		}
		
		return resposta;
	}

	@Override
	public boolean igual(IElemento outro) {
		return outro.igual(this);
	}

	@Override
	public boolean igual(Numero outro) {
		return this.getNumero().doubleValue() == outro.getNumero().doubleValue();
	}

	@Override
	public IElemento deepClone() {
		return new Numero(this.numero.doubleValue());
				
	}

	@Override
	public void accept(ElementoVisitor v) {
		v.visit(this);
	}

	@Override
	public IElemento potencia(IElemento outro) {
		return outro.potencia(this);
	}

	@Override
	public IElemento potencia(Numero outro) {
		return new Numero(Math.pow(numero.doubleValue(), outro.getNumero().doubleValue()));
	}

}
