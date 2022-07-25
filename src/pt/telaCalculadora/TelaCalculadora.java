package pt.telaCalculadora;

import pt.controleCalculo.ICalculoMatriz;
import pt.exceptions.ErroDeCalculo;

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
				{"2", "9"},
				{"5", "4"}
		};
		
		controleCalculo.armazenaMatriz('A', teste);
		
		controleCalculo.armazenaMatriz('B', teste2);
		
		try {
			String[][] test = controleCalculo.getTeste();
			imprimirMatriz(test);
			controleCalculo.realizarExpressao("C == A");
			String[][] test2 = controleCalculo.getMatriz('C');
			imprimirMatriz(test2);
		} catch (ErroDeCalculo e) {
			System.err.printf("Erro: " + e.getMessage());
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
				{"12", "2"},
				{"57", "3"}
		};
		
		return teste;
	}
}
