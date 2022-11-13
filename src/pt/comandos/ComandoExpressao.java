package pt.comandos;

import javax.swing.JTextField;

import pt.controleCalculo.ICalculoMatriz;
import pt.exceptions.ComandoInvalido;
import pt.matriz.IMatriz;
import pt.telaCalculadora.TelaCalculadora;
import pt.telaCalculadora.leitorMatriz.LeitorDeMatriz;
import pt.visual.IVisualFactory;

public class ComandoExpressao implements Command {
	private ICalculoMatriz controle;
	private IVisualFactory visFac;
	private JTextField leitor;
	private TelaCalculadora tela;
	

	public ComandoExpressao(ICalculoMatriz controle, IVisualFactory visFac, JTextField leitor, TelaCalculadora tela) {
		this.controle = controle;
		this.visFac = visFac;
		this.leitor = leitor;
		this.tela = tela;
	}

	
	public void execute() {
		String comando = leitor.getText();
		tela.getAreaResp().insereResposta(visFac.criaVisual(controle.realizarExpressao(comando)));
		tela.update();
	}
}
