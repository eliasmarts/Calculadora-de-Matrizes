package pt.comandos.botoesLeitores;

import pt.comandos.Command;
import pt.telaCalculadora.PainelDeMatrizes;
import pt.telaCalculadora.leitorMatriz.LeitorDeMatriz;

public class MostraLeitor implements Command {
	private boolean visible;
	private PainelDeMatrizes painel;
	private char m;
	LeitorDeMatriz lei;
	
	public MostraLeitor(LeitorDeMatriz lei, PainelDeMatrizes painel, char m) {
		this.painel = painel;
		this.m = m;
		this.lei = lei;
		this.visible = false;
	}

	@Override
	public void execute() {
		if (visible)
			painel.remove(m);
		else {
			lei.atualiza();
			painel.add(lei, m);
		}

		visible = !visible;
	}

}
