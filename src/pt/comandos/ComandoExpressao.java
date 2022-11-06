package pt.comandos;

import javax.swing.JTextField;

import pt.controleCalculo.ICalculoMatriz;
import pt.exceptions.ComandoInvalido;
import pt.matriz.IMatriz;
import pt.telaCalculadora.TelaCalculadora;
import pt.telaCalculadora.leitorMatriz.LeitorDeMatriz;
import pt.visual.IVisualFactory;

public class ComandoExpressao implements Command {
	private String msg;
	private int estado;
	private ICalculoMatriz controle;
	private IVisualFactory visFac;
	private JTextField leitor;
	private TelaCalculadora tela;
	
	private static final int COMANDO = 0;
	private static final int LER_M = 1;
	private static final int LER_E = 2;
	
	
	
	
	public ComandoExpressao(ICalculoMatriz controle, IVisualFactory visFac, JTextField leitor, TelaCalculadora tela) {
		this.controle = controle;
		this.visFac = visFac;
		this.leitor = leitor;
		this.tela = tela;
		reniciaEstado();
	}
	
	private void reniciaEstado() {
		msg = "Escolha seu comando: (l) ler matriz, (e) digitar expressao";
		estado = COMANDO;
	}
	
	
	public void execute() {
		String comando = leitor.getText();
		if (estado == COMANDO) {
			if (comando.charAt(0) == 'l') {
				estado = LER_M;
				msg = "NOME DA MATRIZ";
			} else if (comando.charAt(0) == 'e') {
				estado = LER_E;
				msg = "DIGITE A EXPRESSAO";
			}
		}
		else if (estado == LER_E) {
			tela.getAreaResp().insereResposta(visFac.criaVisual(controle.realizarExpressao(comando)));
			reniciaEstado();
		}
		else if (estado == LER_M) {
			if (Character.isUpperCase(comando.charAt(0))) {
				IMatriz m = controle.getMatriz(comando.charAt(0));
				
				tela.getPainelDeMatrizes().add(new LeitorDeMatriz(tela, comando.charAt(0), m));
				
				tela.getPainelDeMatrizes().repaint();
				
				
				
				reniciaEstado();
			} else
				throw new ComandoInvalido();
		}
		
		tela.update();
	}
	
	public String getMsg() {
		return msg;
	}
}
