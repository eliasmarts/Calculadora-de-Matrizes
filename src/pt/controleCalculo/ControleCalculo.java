package pt.controleCalculo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javax.script.Compilable;

import pt.avaliador.IAvaliaExpressao;
import pt.exceptions.ExpressaoInvalida;
import pt.exceptions.OperacaoInvalida;
import pt.matriz.IMatriz;
import pt.matriz.IOperacoes;
import pt.matriz.Matriz;
import pt.operavel.IOperacoesElemento;
import pt.operavel.IOperavel;
import pt.operavel.OperavelFactory;

public class ControleCalculo implements IControleCalculo {
	private IAvaliaExpressao avaliador;
	
	private Map<Character, IMatriz> matrizes;
	
	
	public ControleCalculo() {
		matrizes = new HashMap<Character, IMatriz>();
	}

	
	@Override
	public void realizarExpressao(String expressao) {
		int tipo = avaliador.getTipoExpressao(expressao);
		
		if (tipo == IAvaliaExpressao.ATRIBUICAO) {
			atribuicao(expressao);
		} else if (tipo == IAvaliaExpressao.COMPARACAO) {
			comparacao(expressao);
		} else
			calculo(expressao);
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
		
		matrizes.put(matriz.charAt(0), calculo(expressaoAtribuida));
	}
	
	
	private void comparacao(String expressao) {
		// TODO Auto-generated method stub
		
	}
	
	private IMatriz calculo(String expressao) {
		String[] expressaoSeparada = avaliador.separaExpressao(expressao);
		String[] expressaoPosfixa = avaliador.converterPraPosFixa(expressaoSeparada);
		
		
		for (int i = 0; i < expressaoPosfixa.length; i++) {
			System.out.print(expressaoPosfixa[i] + " ; ");
		}
		return realizarExpressao(expressaoPosfixa);
		
	}
	
	


	private IMatriz realizarExpressao(String[] expressaoPosfixa) {
		Stack<IOperacoes> pilhaOperandos = new Stack<IOperacoes>();
		
		
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
		
		return (IMatriz) pilhaOperandos.pop();
	}


	private IMatriz pegaMatriz(char charAt) {
		if (matrizes.containsKey(charAt))
			return matrizes.get(charAt);
		else
			throw new OperacaoInvalida();
	}


	private void realizarOperacao(Stack<IOperacoes> pilhaOperandos, String operacao) {
		IOperacoes operando1, operando2;
		OperacaoInvalida erro = new OperacaoInvalida();
		
		if (operacao.equals("+")) {
			if (pilhaOperandos.size() < 2) {
				erro.setMotivo("operacoes desbalanceadas");
				throw erro;
			}
			operando1 = pilhaOperandos.pop();
			operando2 = pilhaOperandos.pop();
			
			pilhaOperandos.add(operando2.somarOp(operando1));
		} 
		else if (operacao.equals("-")) {
			if (pilhaOperandos.size() < 2) {
				erro.setMotivo("operacoes desbalanceadas");
				throw erro;
			}
			operando1 = pilhaOperandos.pop();
			operando2 = pilhaOperandos.pop();
			
			pilhaOperandos.add(operando2.subtrairOP(operando1));
		}
		else if (operacao.equals("*")) {
			if (pilhaOperandos.size() < 2) {
				erro.setMotivo("operacoes desbalanceadas");
				throw erro;
			}
			operando1 = pilhaOperandos.pop();
			operando2 = pilhaOperandos.pop();
			
			pilhaOperandos.add(operando2.multiplicarOp(operando1));
		} else if (operacao.equals("/")) {
			
		} else if (operacao.equals("-")) {
			
		}
	}


	@Override
	public String[][] getMatriz(char nome) {
		IOperacoesElemento[][] matrizOperavel = matrizes.get(nome).getValores();
		return convertePraRepresentacao(matrizOperavel);
	}

	
	@Override
	public void armazenaMatriz(char nome, String[][] matriz) {
		matrizes.put(nome, criaMatriz(matriz));
	}


	@Override
	public void connect(IAvaliaExpressao separador) {
		this.avaliador = separador;
	}
	
	
	public String[][] getTeste() {
		IMatriz resp = matrizes.get('A').somar(matrizes.get('B'));
		
		return convertePraRepresentacao(resp.getValores());
	}

	
	private IMatriz criaMatriz(String[][] matriz) {
		IMatriz matrizComp = new Matriz();
		IOperacoesElemento[][] matrizOperavel = convertePraOperavel(matriz);
		
		matrizComp.setMatriz(matrizOperavel);
		
		return matrizComp;
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
}
