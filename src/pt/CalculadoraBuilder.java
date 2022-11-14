package pt;

import pt.avaliador.Avaliador;
import pt.avaliador.IAvaliador;
import pt.comandos.IComando;
import pt.comandos.barraComando.ComandoExpressao;
import pt.controleCalculo.ControleCalculo;
import pt.controleCalculo.IControleCalculo;
import pt.operador.IOperador;
import pt.operador.Operador;
import pt.telaCalculadora.ITelaCalculadora;
import pt.telaCalculadora.TelaCalculadora;
import pt.visual.IVisualFactory;
import pt.visual.VisualFactory;

public class CalculadoraBuilder {
	private static ITelaCalculadora tela;
	private static IAvaliador separador;
	private static IControleCalculo controle;
	private static IOperador operador;
	private static IVisualFactory visualFac;

	public static ITelaCalculadora build() {
		tela = new TelaCalculadora();
		separador = Avaliador.getInstance();
		controle = new ControleCalculo();
		operador = Operador.getInstance();
		visualFac = VisualFactory.getInstance();
		connectComponents();

		return tela;
	}

	private static void connectComponents() {
		tela.connect(controle);
		tela.connect(visualFac);

		controle.connect(separador);
		controle.connect(operador);
		controle.connect(visualFac);
	}
}
