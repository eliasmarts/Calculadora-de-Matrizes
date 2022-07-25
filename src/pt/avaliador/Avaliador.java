package pt.avaliador;

import pt.exceptions.ExpressaoInvalida;
import pt.operador.IValidaOperacao;

public class Avaliador implements IAvaliador {
	private static final Avaliador instance = new Avaliador();
	

	
	private Avaliador() {
		
	}
	
	
	public static Avaliador getInstance() {
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

	
	private int contarIgual(String expressao) {
		int igual = 0;
		for (int i = 0; i < expressao.length(); i++)
			if (expressao.charAt(i) == '=')
				igual++;
		
		return igual;
	}
	@Override
	public int getTipoExpressao(String expressao) {
		int tipo = CALCULO;
		
		for (int i = 0; i < expressao.length(); i++) {
			if (expressao.charAt(i) == '=') {
				if (i < expressao.length() - 1 && expressao.charAt(i + 1) == '=')
					tipo = COMPARACAO;
				else
					tipo = ATRIBUICAO;
				break;
			}
		}
		
		if ((tipo == ATRIBUICAO && contarIgual(expressao) != 1)
			|| (tipo == COMPARACAO && contarIgual(expressao) != 2)) {
				ExpressaoInvalida erro = new ExpressaoInvalida(expressao);
				erro.setMotivo("Multiplas atribuicoes e comparacoes");
				for (int i = 0; i < expressao.length(); i++) {
					if (expressao.charAt(i) == '=') {
						erro.adicionaErro(i);
					}
				}
				throw erro;
		}
		
		return tipo;
	}


}
