package pt;

import pt.avaliador.IAvaliador;
import pt.avaliador.Avaliador;
import pt.controleCalculo.ControleCalculo;
import pt.controleCalculo.IControleCalculo;
import pt.telaCalculadora.ITelaCalculadora;
import pt.telaCalculadora.TelaCalculadora;

public class CalculadoraDeMatrizes {
	private static ITelaCalculadora tela;
	private static IAvaliador separador;
	private static IControleCalculo controle;


	public static void main(String[] args) {
		build();
		
		tela.iniciar();
	}
	
	
	public static void build() {
		tela = new TelaCalculadora();
		separador = Avaliador.getInstance();
		controle = new ControleCalculo();
		connectComponents();
	}
	
	
	public static void connectComponents() {
		tela.connect(controle);
		controle.connect(separador);
		
		
	}
}
