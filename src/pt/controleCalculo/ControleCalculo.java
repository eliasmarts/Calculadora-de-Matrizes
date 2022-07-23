package pt.controleCalculo;

import java.util.HashMap;
import java.util.Map;

import pt.matriz.IMatriz;
import pt.matriz.Matriz;
import pt.operador.IOperacoes;
import pt.operavel.IOperavel;
import pt.operavel.OperavelFactory;
import pt.separador.IAvaliaExpressao;

public class ControleCalculo implements IControleCalculo {
	private IOperacoes operador;
	private IAvaliaExpressao separador;
	
	private Map<Character, IMatriz> matrizes;
	
	
	public ControleCalculo() {
		matrizes = new HashMap<Character, IMatriz>();
	}

	
	@Override
	public void realizarExpressao(String expressao) {
		// TODO Auto-generated method stub

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
		this.separador = separador;
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
