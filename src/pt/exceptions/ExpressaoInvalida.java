package pt.exceptions;

import java.util.HashSet;
import java.util.Set;

public class ExpressaoInvalida extends ErroDeCalculo {
	private String expressao;
	private Set<Integer> localizacoesDoErro;
	
	public ExpressaoInvalida() {
		super();
		motivo = "";
		localizacoesDoErro = new HashSet<Integer>();
	}
	
	
	public ExpressaoInvalida(String expressao) {
		super();
		this.expressao = expressao;
		motivo = "";
		localizacoesDoErro = new HashSet<Integer>();
	}
	
	
	public ExpressaoInvalida(String expressao, int localizacaoDoErro) {
		super();
		this.expressao = expressao;
	}
	
	
	public void adicionaErro(int localizacao) {
		localizacoesDoErro.add(localizacao);
	}
	
	
	private String getLocalizacoesErro() {
		String localizacoes = "";
		
		for (int i = 0; i < expressao.length(); i++) {
			if (localizacoesDoErro.contains(i))
				localizacoes += "^";
			else
				localizacoes += " ";
				
		}
		
		return localizacoes;
	}
	
	
	public String getMessage() {
		String message = "Expressao Invalida";
		
		
		
		if (expressao != "") {
			message += "%n" + expressao;
			if (!localizacoesDoErro.isEmpty())
				message += "%n" + getLocalizacoesErro();
		}
		
		if (motivo != "")
			message += "%n" + motivo;
		
		return message;
	}
}
