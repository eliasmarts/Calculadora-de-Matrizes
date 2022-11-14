package pt.comandos.botoesLeitores;

import pt.comandos.Command;
import pt.telaCalculadora.BotoesLeitores.BotoesLeitores;
import pt.telaCalculadora.BotoesLeitores.NovoBotao;

public class MexeBotoes implements Command {
	private boolean mais;
	private BotoesLeitores botoes;
	
	

	public MexeBotoes(BotoesLeitores botoes, boolean mais) {
		super();
		this.mais = mais;
		this.botoes = botoes;
	}



	@Override
	public void execute() {
		if (mais) {
			botoes.toggleNovoBotao();
		} else
			botoes.removeUltimo();
	}

}
