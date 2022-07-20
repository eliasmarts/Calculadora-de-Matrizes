package pt.separador;

import pt.operador.IValidaOperacao;

public class Separador implements ISeparador {
	private static final Separador instance = new Separador();
	

	
	private Separador() {
		
	}
	
	
	public static Separador getInstance() {
		return instance;
	}

	@Override
	public String checarValidade(String expressao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] separaExpressao(String expressao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] converterPraPosFixa(String[] expressaoInfixa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void connect(IValidaOperacao validador) {
		// TODO Auto-generated method stub

	}

}
