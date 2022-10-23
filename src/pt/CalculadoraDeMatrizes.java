package pt;

import pt.telaCalculadora.ITelaCalculadora;

public class CalculadoraDeMatrizes {
	private static ITelaCalculadora tela;

	public static void main(String[] args) {
		tela = CalculadoraBuilder.build();

		tela.iniciar();
		

	}

}
