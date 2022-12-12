package pt.controleCalculo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import pt.avaliador.IAvaliaExpressao;
import pt.elemento.ElementoFactory;
import pt.elemento.IElemento;
import pt.exceptions.ExpressaoInvalida;
import pt.exceptions.OperacaoInvalida;
import pt.matriz.IMatriz;
import pt.matriz.IOperavel;
import pt.matriz.Matriz;
import pt.operador.IOperador;

public class ControleCalculo implements IControleCalculo {
	private IAvaliaExpressao avaliador;
	
	private IOperador operador;
	
	private Map<Character, IMatriz> matrizes;
	
	private Set<String> opUnarias, opBinarias;
	
	
	public ControleCalculo() {
		matrizes = new HashMap<Character, IMatriz>();
		
		for (char i = 'A'; i <= 'Z'; i++)
			matrizes.put(i, new Matriz());
		
		opUnarias = Set.of("--", "det");
		
		opBinarias = Set.of("+", "*", "/", "^");
	}

	@Override
	public void connect(IOperador operador) {
		this.operador = operador;
	}
	
	
	@Override
	public void connect(IAvaliaExpressao separador) {
		this.avaliador = separador;
	}
	

	
	@Override
	public void armazenaMatriz(char nome, String[][] matriz) {
		matrizes.put(nome, criaMatriz(matriz));
	}
	
	
	private IOperavel atribuicao(String expressao) {
		String[] atribuicao = expressao.split("=");
		String matriz = atribuicao[0].trim();
		String expressaoAtribuida = atribuicao[1].trim();
		
		if (matriz.length() != 1 || !(Character.isLetter(matriz.charAt(0)) && Character.isUpperCase(matriz.charAt(0))) ) {
			ExpressaoInvalida erro = new ExpressaoInvalida(expressao);
			erro.setMotivo(atribuicao[0] + "nao e uma matriz");
			throw erro;
		}
		IOperavel resp = calculo(expressaoAtribuida);
		IMatriz m = resp.getMatriz();
		
		if (m != null) {
			IMatriz ant = matrizes.get(matriz.charAt(0));
			
			ant.setMatriz(m.getValores());
		}
		else {
			ExpressaoInvalida erro = new ExpressaoInvalida(expressao);
			erro.setMotivo("o resultado nao e uma matriz");
			throw erro;
		}
		
		return m;
	}
	
	
	private IOperavel calculo(String expressao) {
		String[] expressaoSeparada = avaliador.separaExpressao(expressao);
		String[] expressaoPosfixa = avaliador.converterPraPosFixa(expressaoSeparada);
		return realizarExpressao(expressaoPosfixa);
	}
	
	private IOperavel comparacao(String expressao) {
		// TODO Auto-generated method stub
		return null;
	}


	private IElemento[][] convertePraOperavel(String[][] matriz) {
		IElemento[][] matrizOperavel = new IElemento[matriz.length][matriz[0].length];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matrizOperavel[i][j] = ElementoFactory.criarOperavel(matriz[i][j]);
			}
		}
		
		return matrizOperavel;
	}


	private IMatriz criaMatriz(String[][] matriz) {
		IMatriz matrizComp = new Matriz();
		IElemento[][] matrizOperavel = convertePraOperavel(matriz);
		
		matrizComp.setMatriz(matrizOperavel);
		
		return matrizComp;
	}


	@Override
	public IMatriz getMatriz(char nome) {
		IMatriz m = matrizes.get(nome);
		if (m == null)
			throw new OperacaoInvalida();
		
		return m;
	}
	
	
	public void criaMatriz(char nome) {
		matrizes.put(nome, new Matriz());
	}


	private IMatriz pegaMatriz(char charAt) {
		if (matrizes.containsKey(charAt))
			return matrizes.get(charAt);
		else
			throw new OperacaoInvalida();
	}


	@Override
	public IOperavel realizarExpressao(String expressao) {
		int tipo = avaliador.getTipoExpressao(expressao);
		IOperavel resp;
		
		if (tipo == IAvaliaExpressao.ATRIBUICAO) {
			resp = atribuicao(expressao);
		} else if (tipo == IAvaliaExpressao.COMPARACAO) {
			resp = comparacao(expressao);
		} else
			resp = calculo(expressao);
	
		return resp;
	}
	
	
	private IOperavel realizarExpressao(String[] expressaoPosfixa) {
		Stack<IOperavel> pilhaOperandos = new Stack<IOperavel>();
		
		
		for (int i = 0; i < expressaoPosfixa.length; i++) {
			if (avaliador.isOperacao(expressaoPosfixa[i]))
				realizarOperacao(pilhaOperandos, expressaoPosfixa[i]);
			else if (avaliador.isNumber(expressaoPosfixa[i])) {
				pilhaOperandos.add(ElementoFactory.criarOperavel(expressaoPosfixa[i]));
			} else if (avaliador.isMatriz(expressaoPosfixa[i])) {
				pilhaOperandos.add(pegaMatriz(expressaoPosfixa[i].charAt(0)));
			}
		}
		
		if (pilhaOperandos.size() != 1) {
			OperacaoInvalida erro = new OperacaoInvalida();
			erro.setMotivo("operacoes desbalanceadas");
			throw erro;
		}
		
		return pilhaOperandos.pop();
	}

	
	private void realizarOperacao(Stack<IOperavel> pilhaOperandos, String operacao) {
		// subtracao é um caso especial
		if (operacao.equals("-")) {
			subtracao(pilhaOperandos);
		}
		else if (opUnarias.contains(operacao)) {
			operacaoUnaria(operacao, pilhaOperandos);
		} else
			operacaoBinaria(operacao, pilhaOperandos);
	}
	
	
	private void operacaoUnaria(String operacao, Stack<IOperavel> pilhaOperandos) {
		IOperavel operando;
		if (pilhaOperandos.size() < 1) {
			OperacaoInvalida erro = new OperacaoInvalida();
			erro.setMotivo("operacoes desbalanceadas");
			throw erro;
		}
		
		operando = pilhaOperandos.pop();
		
		pilhaOperandos.add(operador.realizarOperacao(operacao, operando));
	}

	
	private void operacaoBinaria(String operacao, Stack<IOperavel> pilhaOperandos) {
		IOperavel operando1, operando2;
		if (pilhaOperandos.size() < 2) {
			OperacaoInvalida erro = new OperacaoInvalida();
			erro.setMotivo("operacoes desbalanceadas");
			throw erro;
		}
		operando2 = pilhaOperandos.pop();
		operando1 = pilhaOperandos.pop();
		
		pilhaOperandos.add(operador.realizarOperacao(operacao, operando1, operando2));
	}
	
	
	private void subtracao(Stack<IOperavel> pilhaOperandos) {
		IOperavel operando1, operando2;
		if (pilhaOperandos.size() < 1) {
			OperacaoInvalida erro = new OperacaoInvalida();
			erro.setMotivo("operacoes desbalanceadas");
			throw erro;
		}
		
		operando2 = pilhaOperandos.pop();
		if (pilhaOperandos.size() == 0) {
			pilhaOperandos.add(operador.realizarOperacao("--", operando2));
		} else {
			operando1 = pilhaOperandos.pop();
			pilhaOperandos.add(operador.realizarOperacao("-", operando1, operando2));
		}
	}
}
