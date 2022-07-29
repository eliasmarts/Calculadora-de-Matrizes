package pt.avaliador;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import pt.exceptions.ExpressaoInvalida;
import pt.exceptions.OperacaoInvalida;

public class Avaliador implements IAvaliador {
	private static final Avaliador instance = new Avaliador();
	private Set<String> operacoes;
	private Map<String, Integer> prioridadesOperacoes;
	private char divisorDecimal;
	

	
	private Avaliador() {
		operacoes = Set.of("+", "-", "*", "/", "det", "^", "inv", "(", ")");
		prioridadesOperacoes = Map.of(
										"+", 1,
										"-", 1,
										"*", 2,
										"/", 2,
										"det", 3,
										"^", 3,
										"inv", 3,
										"(", -1,
										")", -1
										);
		divisorDecimal = '.';
	}
	
	
	public static Avaliador getInstance() {
		return instance;
	}


	

	@Override
	public String[] separaExpressao(String expressao) throws ExpressaoInvalida  {
		checarValidade(expressao);
		
		
		ArrayList<String> expressaoSeparada = new ArrayList<String>();
		String acumulador = "";
		
		for (int i = 0; i < expressao.length(); i++) {
			if (!isNumeric(expressao.charAt(i)))
				if (verificaAcumulador(acumulador, expressaoSeparada))
					acumulador = "";
			if (!isBlank(expressao.charAt(i)))
				acumulador += expressao.charAt(i);
			if (!isNumeric(expressao.charAt(i)))
				if (verificaAcumulador(acumulador, expressaoSeparada))
					acumulador = "";
			
		}
		
		verificaAcumulador(acumulador, expressaoSeparada);
		
		
		return toStringVec(expressaoSeparada);
	}
	
	
	private String[] toStringVec(ArrayList<String> array) {
		String[] v = new String[array.size()];
		
		for (int i = 0; i < array.size(); i++)
			v[i] = array.get(i);
		
		return v;
	}
	
	
	private boolean isNumeric(char charAt) {
		return Character.isDigit(charAt) || charAt == divisorDecimal;
	}


	private boolean isBlank(char charAt) {
		return Character.isWhitespace(charAt);
	}


	private boolean isNumber(char charAt) {
		return Character.isDigit(charAt);
	}
	
	
	private boolean isNumber(String acumulador) {
		int countPonto = 0;
		boolean number = true;
		
		for (int i = 0; i < acumulador.length(); i++) {
			if (acumulador.charAt(i) == divisorDecimal) {
				countPonto++;
				if (countPonto > 1) {
					number = false;
					break;
				}
			}
			
			else if (!isNumber(acumulador.charAt(i))) {
				number = false;
				break;
			}
		}
		
		return number;
	}


	private boolean isMatriz(String acumulador) {
		return acumulador.length() == 1 && (Character.isLetter(acumulador.charAt(0)) && Character.isUpperCase(acumulador.charAt(0)));
	}
	
	
	private boolean isOperacao(String acumulador) {
		return operacoes.contains(acumulador);
	}


	private boolean verificaAcumulador(String acumulador, ArrayList<String> expressaoSeparada) {
		boolean separou = false;
		String ultimaEntrada = "";
		
		if (expressaoSeparada.size() > 0)
			ultimaEntrada = expressaoSeparada.get(expressaoSeparada.size() - 1);


		if (acumulador.length() == 0)
			separou = false;

		else if (isMatriz(acumulador)) {
			separou = true;
		}

		else if (isNumber(acumulador)) {
			separou = true;
		}

		else if (isOperacao(acumulador)) {
			separou = true;
		}
		
		else if (acumulador.length() > 3) {
			OperacaoInvalida erro = new OperacaoInvalida();
			erro.setMotivo("Nao foi possivel interpretar: '" + acumulador + "'");
			throw erro;
		}
		
		if (separou) {
			verificaMultiplicacao(ultimaEntrada, acumulador, expressaoSeparada);
			expressaoSeparada.add(acumulador);
		}
		
		return separou;
	}


	private void verificaMultiplicacao(String ultimaEntrada, String acumulador, ArrayList<String> expressaoSeparada) {
		boolean temMult = false;
		
		if (ultimaEntrada.length() < 1)
			temMult = false;

		else if (ultimaEntrada.charAt(0) == ')' && !isOperacao(acumulador))
			temMult = true;
		else if ((isMatriz(ultimaEntrada) || isNumber(ultimaEntrada)) && isMatriz(acumulador))
			temMult = true;
		else if ((isMatriz(ultimaEntrada) || isNumber(ultimaEntrada)) && acumulador.charAt(0) == '(')
			temMult = true;
		
		if (temMult)
			expressaoSeparada.add("*");
	}


	private void checarValidade(String expressao) throws ExpressaoInvalida {
		checarBalanceamentoParenteses(expressao);
	}

	
	private void checarBalanceamentoParenteses(String expressao) throws ExpressaoInvalida {
		int countParenteses = 0;
		
		for (int i = 0; i < expressao.length(); i++) {
			if (expressao.charAt(i) == '(')
				countParenteses++;
			else if (expressao.charAt(i) == ')') {
				countParenteses--;
				if (countParenteses < 0) {
					ExpressaoInvalida erro = new ExpressaoInvalida(expressao);
					erro.setMotivo("Parenteses desbalanceados");
					erro.adicionaErro(i);
					throw erro;
				}
			}
		}
		
		if (countParenteses > 0) {
			ExpressaoInvalida erro = new ExpressaoInvalida(expressao);
			erro.setMotivo("Parenteses desbalanceados");
			localizarParentesesAbertos(expressao, erro, countParenteses);
			throw erro;
		}
	}


	private void localizarParentesesAbertos(String expressao, ExpressaoInvalida erro, int numParenteses) {
		for (int i = expressao.length() - 1; i >= 0; i--) {
			if (expressao.charAt(i) == '(') {
				erro.adicionaErro(i);
				numParenteses--;
				if (numParenteses == 0)
					break;
			}
		}
	}


	@Override
	public String[] converterPraPosFixa(String[] expressaoInfixa) {
		ArrayList<String> expressaoPosfixa = new ArrayList<String>();
		int k = 0;
		Stack<String> pilhaOperandos = new Stack<String>();
		
		for (int i = 0; i < expressaoInfixa.length; i++) {
			if (isOperavel(expressaoInfixa[i]))
				expressaoPosfixa.add(expressaoInfixa[i]);
			else if (expressaoInfixa[i].equals("("))
				pilhaOperandos.add(expressaoInfixa[i]);
			else if (expressaoInfixa[i].equals(")")) {
				String op = pilhaOperandos.pop();
				while (!op.equals("(")) {
					expressaoPosfixa.add(op);
					op = pilhaOperandos.pop();
				}
			}
			else {
				// se e operacao
				while (!pilhaOperandos.isEmpty()) {
					if (prioridadesOperacoes.get(pilhaOperandos.peek()) >= prioridadesOperacoes.get(expressaoInfixa[i]))
						expressaoPosfixa.add(pilhaOperandos.pop());
					else
						break;
				}
				pilhaOperandos.add(expressaoInfixa[i]);
			}
		}
		
		// adiciona o resto das operacoes
		while(!pilhaOperandos.isEmpty())
			expressaoPosfixa.add(pilhaOperandos.pop());
		
		
		return toStringVec(expressaoPosfixa);
	}

	
	private boolean isOperavel(String string) {
		return isNumber(string) || isMatriz(string);
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
