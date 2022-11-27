package pt.exceptions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExpressaoInvalida extends ErroCalculadora {
	private String expressao;
	private List<Integer> localizacoesDoErro;
	
	public ExpressaoInvalida() {
		this("");
	}
	
	
	public ExpressaoInvalida(String expressao) {
		super();
		this.expressao = expressao;
		msg = "";
		localizacoesDoErro = new ArrayList<Integer>();
	}
	
	
	public void adicionaErro(int localizacao) {
		localizacoesDoErro.add(localizacao);
		localizacoesDoErro.sort(Comparator.naturalOrder());
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
		
		if (msg != "")
			message += "%n" + msg;
		
		return message;
	}
	
	
	public String getHTMLMessage() {
		String message = "<html> Expressao Invalida: " + msg + "<br>";
		

		if (expressao != "") {
			for (int i = 0; i < expressao.length(); i++) {
				if (localizacoesDoErro.contains(i)) {
					message += "<u> ";
					message += String.valueOf(expressao.charAt(i));
					message += " </u>";
				}
				else
					message += String.valueOf(expressao.charAt(i));
			}
		}
		
		message += "</html>";
		
		return message;
	}
}
