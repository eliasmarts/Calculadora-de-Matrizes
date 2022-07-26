package pt.controleCalculo;

import java.util.HashMap;
import java.util.Map;

import pt.avaliador.IAvaliaExpressao;
import pt.exceptions.ExpressaoInvalida;
import pt.matriz.IMatriz;
import pt.matriz.Matriz;
import pt.operador.IOperacoes;
import pt.operavel.IOperavel;
import pt.operavel.OperavelFactory;

public class ControleCalculo implements IControleCalculo {
	private IOperacoes operador;
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
		
		
		for (int i = 0; i < expressaoSeparada.length; i++) {
			System.out.print(expressaoSeparada[i] + " ; ");
		}
		return matrizes.get('A');
		
	}


	@Override
	public String[][] getMatriz(char nome) {
		IOperavel[][] matrizOperavel = matrizes.get(nome).getValores();
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

	
	@Override
	public void connect(IOperacoes operador) {
		this.operador = operador;
	}
	
	
	public String[][] getTeste() {
		IMatriz resp = matrizes.get('A').somar(matrizes.get('B'));
		
		return convertePraRepresentacao(resp.getValores());
	}

	
	private IMatriz criaMatriz(String[][] matriz) {
		IMatriz matrizComp = new Matriz();
		IOperavel[][] matrizOperavel = convertePraOperavel(matriz);
		
		matrizComp.setMatriz(matrizOperavel);
		
		return matrizComp;
	}

	
	private IOperavel[][] convertePraOperavel(String[][] matriz) {
		IOperavel[][] matrizOperavel = new IOperavel[matriz.length][matriz[0].length];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matrizOperavel[i][j] = OperavelFactory.criarOperavel(matriz[i][j]);
			}
		}
		
		return matrizOperavel;
	}
	
	
	private String[][] convertePraRepresentacao(IOperavel[][] matrizOperavel) {
		String[][] matriz = new String[matrizOperavel.length][matrizOperavel[0].length];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = matrizOperavel[i][j].getRepresentacao();
			}
		}
		
		return matriz;
	}
}
