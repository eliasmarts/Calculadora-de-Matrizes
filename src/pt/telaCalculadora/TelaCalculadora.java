package pt.telaCalculadora;

import pt.controleCalculo.ICalculoMatriz;
import pt.exceptions.OperacaoInvalida;

public class TelaCalculadora implements ITelaCalculadora {
	private ICalculoMatriz controleCalculo;


	public void connect(ICalculoMatriz controleCalculo) {
		this.controleCalculo = controleCalculo;
	}
	
	
	

	@Override
	public void iniciar() {
		System.out.println("Iniciando calculadora");
		String[][] teste = lerMatrizEntrada();
		String[][] teste2 = {
				{"12", "2", "3"},
				{"57", "3", "-22"}
		};
		
		controleCalculo.armazenaMatriz('A', teste);
		
		controleCalculo.armazenaMatriz('B', teste2);
		
		try {
			String[][] test = controleCalculo.getTeste();
			imprimirMatriz(test);
		} catch (OperacaoInvalida e) {
			System.err.println("Erro: " + e.getMessage());
		}
		
		
		
	}

	@Override
	public void encerrar() {
		// TODO Auto-generated method stub

	}

	
	private void imprimirMatriz(String[][] matriz) {
		for (String[] linha : matriz) {
			for (String valor : linha) {
				System.out.print(valor + " ");
			}
			System.out.println();
		}
	}
	
	
	private String[][] lerMatrizEntrada() {
		String[][] teste = {
				{"12", "2", "3"},
				{"57", "3", "22"},
				{"12", "0", "7"}
		};
		
		return teste;
	}
}
