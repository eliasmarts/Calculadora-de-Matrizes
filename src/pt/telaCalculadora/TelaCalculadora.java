package pt.telaCalculadora;

import java.util.Scanner;

import pt.controleCalculo.ICalculoMatriz;
import pt.exceptions.ErroDeCalculo;

public class TelaCalculadora implements ITelaCalculadora {
	private ICalculoMatriz controleCalculo;
	private Scanner sc;
	
	public TelaCalculadora() {
		sc = new Scanner(System.in);
	}


	public void connect(ICalculoMatriz controleCalculo) {
		this.controleCalculo = controleCalculo;
	}
	
	
	

	@Override
	public void iniciar() {
		System.out.println("Iniciando calculadora");
		while (true) {
			System.out.println("Escolha seu comando: ");
			System.out.println("(l) ler matriz, (e) digitar expressao, (p) imprimir matriz, (x) sair");
			
			char comando = sc.next().charAt(0);
			sc.nextLine();
			
			if (comando == 'x') {
				encerrar();
				break;
			}
			else if (comando == 'l')
				lerMatriz();
			else if (comando == 'e')
				lerExpressao();
			else if (comando == 'p')
				lerImpressao();
		}
	}

	private void lerImpressao() {
		System.out.print("Digite qual matriz deseja imprimir: ");
		char matriz = sc.next().charAt(0);
		
		imprimirMatriz(controleCalculo.getMatriz(matriz));
	}


	private void lerExpressao() {
		System.out.println("Digite a expressao:");
		String expressao = sc.nextLine();
		
		try {
			controleCalculo.realizarExpressao(expressao);
		} catch (ErroDeCalculo e) {
			System.err.println("Erro no calculo: ");
			System.err.print(e.getMessage());
		}
	}


	private void lerMatriz() {
		System.out.print("Qual o nome da matriz: ");
		char nome = sc.next().charAt(0);
		System.out.print("Numero de linhas: ");
		int linhas = sc.nextInt();
		System.out.print("Numero de colunas: ");
		int colunas = sc.nextInt();
		sc.nextLine();
		System.out.println();
		
		String[][] matriz = lerMatrizEntrada(linhas, colunas);
		
		controleCalculo.armazenaMatriz(nome, matriz);
	}


	@Override
	public void encerrar() {
		sc.close();
	}

	
	private void imprimirMatriz(String[][] matriz) {
		for (String[] linha : matriz) {
			for (String valor : linha) {
				System.out.print(valor + " ");
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	
	private String[][] lerMatrizEntrada(int x, int y) {
		String[][] entrada = new String[x][y];
		
		System.out.println("Digite os valores de uma matriz " + x + " por " + y);
		
		for (int i = 0; i < x; i++) {
			System.out.print("LINHA " + Integer.toString(i + 1) + ": ");
			for (int j = 0; j < y; j++) {
				entrada[i][j] = sc.next();
			}
		}
		System.out.println();
		
		return entrada;
	}
}
