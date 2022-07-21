package pt.telaCalculadora;

import pt.controleCalculo.ICalculoMatriz;

public class TelaCalculadora implements ITelaCalculadora {
	private ICalculoMatriz controleCalculo;


	public void connect(ICalculoMatriz controleCalculo) {
		this.controleCalculo = controleCalculo;
	}
	
	
	

	@Override
	public void iniciar() {
		System.out.println("Iniciando calculadora");
		String[][] teste = lerMatrizEntrada();
		
		controleCalculo.armazenaMatriz('A', teste);
		
		
		String[][] testeRetorno = controleCalculo.getMatriz('A');
		
		
		imprimirMatriz(testeRetorno);
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
