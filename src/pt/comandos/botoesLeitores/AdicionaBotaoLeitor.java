package pt.comandos.botoesLeitores;

import java.awt.Container;

import javax.swing.JTextField;

import pt.comandos.Command;
import pt.exceptions.ComandoInvalido;
import pt.telaCalculadora.BotoesLeitores.BotoesLeitores;

public class AdicionaBotaoLeitor implements Command {
	private BotoesLeitores botoes;
	private JTextField leitor;
	
	

	public AdicionaBotaoLeitor(BotoesLeitores botoes, JTextField leitor) {
		super();
		this.botoes = botoes;
		this.leitor = leitor;
	}



	@Override
	public void execute() {
		String entrada = leitor.getText();
		if (!Character.isUpperCase(entrada.charAt(0)))
			throw new ComandoInvalido();
		botoes.addBotao(entrada.charAt(0));
		
		botoes.toggleNovoBotao();
	}

}
