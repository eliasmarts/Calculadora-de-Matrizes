package pt.controleCalculo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import pt.avaliador.IAvaliaExpressao;
import pt.exceptions.ExpressaoInvalida;
import pt.exceptions.OperacaoInvalida;
import pt.matriz.IMatriz;
import pt.matriz.IOperacoesStrategy;
import pt.matriz.Matriz;
import pt.operavel.IOperacoesElemento;
import pt.operavel.IOperavel;
import pt.operavel.OperavelFactory;
import pt.visual.Imprimivel;
import pt.visual.ImprimivelFactory;

public class ControleCalculo implements IControleCalculo {
	private IAvaliaExpressao avaliador;
	
	private Map<Character, IMatriz> matrizes;
	
	
	public ControleCalculo() {
		matrizes = new HashMap<Character, IMatriz>();
	}

	
	@Override
	public void armazenaMatriz(char nome, String[][] matriz) {
		matrizes.put(nome, criaMatriz(matriz));
	}
	
	
	private void atribuicao(String expressao) {
		String[] atribuicao = expressao.split("=");
		String matriz = atribuicao[0].trim();
		String expressaoAtribuida = atribuicao[1].trim();
		
		if (matriz.length() != 1 || !(Character.isLetter(matriz.charAt(0)) && Character.isUpperCase(matriz.charAt(0))) ) {
			ExpressaoInvalida erro = new ExpressaoInvalida(expressao);
			erro.setMotivo(atribuicao[0] + "nao e uma matriz");
			throw erro;
		}
		IOperacoesStrategy resp = calculo(expressaoAtribuida);
		IMatriz m = resp.getMatriz();
		
		if (m != null)
			matrizes.put(matriz.charAt(0), m);
		else {
			ExpressaoInvalida erro = new ExpressaoInvalida(expressao);
			erro.setMotivo("o resultado nao e uma matriz");
			throw erro;
		}
	}
	
	
	private IOperacoesStrategy calculo(String expressao) {
		String[] expressaoSeparada = avaliador.separaExpressao(expressao);
		String[] expressaoPosfixa = avaliador.converterPraPosFixa(expressaoSeparada);
		return realizarExpressao(expressaoPosfixa);
	}
	
	private IOperacoesStrategy comparacao(String expressao) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


	@Override
	public void connect(IAvaliaExpressao separador) {
		this.avaliador = separador;
	}


	private IOperacoesElemento[][] convertePraOperavel(String[][] matriz) {
		IOperacoesElemento[][] matrizOperavel = new IOperavel[matriz.length][matriz[0].length];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matrizOperavel[i][j] = OperavelFactory.criarOperavel(matriz[i][j]);
			}
		}
		
		return matrizOperavel;
	}


	private String[][] convertePraRepresentacao(IOperacoesElemento[][] matrizOperavel) {
		String[][] matriz = new String[matrizOperavel.length][matrizOperavel[0].length];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = matrizOperavel[i][j].getRepresentacao();
			}
		}
		
		return matriz;
	}


	private IMatriz criaMatriz(String[][] matriz) {
		IMatriz matrizComp = new Matriz();
		IOperacoesElemento[][] matrizOperavel = convertePraOperavel(matriz);
		
		matrizComp.setMatriz(matrizOperavel);
		
		return matrizComp;
	}


	@Override
	public String[][] getMatriz(char nome) {
		IOperacoesElemento[][] matrizOperavel = matrizes.get(nome).getValores();
		return convertePraRepresentacao(matrizOperavel);
	}


	public String[][] getTeste() {
		IMatriz resp = matrizes.get('A').somar(matrizes.get('B'));
		
		return convertePraRepresentacao(resp.getValores());
	}


	private IMatriz pegaMatriz(char charAt) {
		if (matrizes.containsKey(charAt))
			return matrizes.get(charAt);
		else
			throw new OperacaoInvalida();
	}


	@Override
	public Imprimivel realizarExpressao(String expressao) {
		int tipo = avaliador.getTipoExpressao(expressao);
		IOperacoesStrategy resp;
		
		if (tipo == IAvaliaExpressao.ATRIBUICAO) {
			atribuicao(expressao);
			resp = null;
		} else if (tipo == IAvaliaExpressao.COMPARACAO) {
			resp = comparacao(expressao);
		} else
			resp = calculo(expressao);
	
		return ImprimivelFactory.criaImprimivel(resp);
	}
	
	
	private IOperacoesStrategy realizarExpressao(String[] expressaoPosfixa) {
		Stack<IOperacoesStrategy> pilhaOperandos = new Stack<IOperacoesStrategy>();
		
		
		for (int i = 0; i < expressaoPosfixa.length; i++) {
			if (avaliador.isOperacao(expressaoPosfixa[i]))
				realizarOperacao(pilhaOperandos, expressaoPosfixa[i]);
			else if (avaliador.isNumber(expressaoPosfixa[i])) {
				pilhaOperandos.add(OperavelFactory.criarOperavel(expressaoPosfixa[i]));
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

	
	private void realizarOperacao(Stack<IOperacoesStrategy> pilhaOperandos, String operacao) {
		
		if (operacao.equals("+")) {
			soma(pilhaOperandos);
		} 
		else if (operacao.equals("-")) {
			subtracao(pilhaOperandos);
		}
		else if (operacao.equals("*")) {
			multiplicacao(pilhaOperandos);
		}
	}

	
	private void soma(Stack<IOperacoesStrategy> pilhaOperandos) {
		IOperacoesStrategy operando1, operando2;
		if (pilhaOperandos.size() < 2) {
			OperacaoInvalida erro = new OperacaoInvalida();
			erro.setMotivo("operacoes desbalanceadas");
			throw erro;
		}
		operando1 = pilhaOperandos.pop();
		operando2 = pilhaOperandos.pop();
		
		pilhaOperandos.add(operando2.somarOp(operando1));
	}
	
	
	private void subtracao(Stack<IOperacoesStrategy> pilhaOperandos) {
		IOperacoesStrategy operando1, operando2;
		if (pilhaOperandos.size() < 1) {
			OperacaoInvalida erro = new OperacaoInvalida();
			erro.setMotivo("operacoes desbalanceadas");
			throw erro;
		}
		
		operando1 = pilhaOperandos.pop();
		if (pilhaOperandos.size() == 0) {
			pilhaOperandos.add(operando1.negativo());
		} else {
			operando2 = pilhaOperandos.pop();
			pilhaOperandos.add(operando2.subtrairOp(operando1));
		}
	}
	
	
	private void multiplicacao(Stack<IOperacoesStrategy> pilhaOperandos) {
		IOperacoesStrategy operando1, operando2;
		if (pilhaOperandos.size() < 2) {
			OperacaoInvalida erro = new OperacaoInvalida();
			erro.setMotivo("operacoes desbalanceadas");
			throw erro;
		}
		operando1 = pilhaOperandos.pop();
		operando2 = pilhaOperandos.pop();
		
		pilhaOperandos.add(operando2.multiplicarOp(operando1));
	}
}
