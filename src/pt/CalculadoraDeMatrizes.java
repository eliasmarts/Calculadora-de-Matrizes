package pt;

import pt.controleCalculo.ControleCalculo;
import pt.controleCalculo.IControleCalculo;
import pt.operador.IOperador;
import pt.operador.Operador;
import pt.separador.ISeparador;
import pt.separador.Separador;
import pt.telaCalculadora.ITelaCalculadora;
import pt.telaCalculadora.TelaCalculadora;

public class CalculadoraDeMatrizes {
	private static ITelaCalculadora tela;
	private static ISeparador separador;
	private static IOperador operador;
	private static IControleCalculo controle;


	public static void main(String[] args) {
		build();
		
		tela.iniciar();
	}
	
	
	public static void build() {
		tela = new TelaCalculadora();
		separador = Separador.getInstance();
		operador = new Operador();
		controle = new ControleCalculo();
		connectComponents();
	}
	
	
	public static void connectComponents() {
		tela.connect(controle);
		controle.connect(separador);
		controle.connect(operador);
		separador.connect(operador);
	}
}
