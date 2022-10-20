package pt.comando;

import javax.swing.JPanel;

import pt.controleCalculo.ICalculoMatriz;

public class Comando implements IComando {
	private String msg;
	private int estado;
	private ICalculoMatriz controle;
	
	private static final int COMANDO = 0;
	private static final int LER_M = 1;
	private static final int LER_E = 2;
	
	
	public Comando() {
		reniciaEstado();
	}
	
	private void reniciaEstado() {
		msg = "Escolha seu comando: (l) ler matriz, (e) digitar expressao";
		estado = COMANDO;
	}
	
	
	public void realizaComando(String comando, JPanel telaMat) {
		if (estado == COMANDO) {
			if (comando.charAt(0) == 'l') {
				estado = LER_M;
				msg = "LENDO MATRIZ";
			} else if (comando.charAt(0) == 'e') {
				estado = LER_E;
				msg = "DIGITE A EXPRESSAO";
			}
		}
		else if (estado == LER_E) {
			//telaMat.add(controle.realizarExpressao(comando));
			reniciaEstado();
		}
	}
	
	
	public void connect(ICalculoMatriz controle) {
		this.controle = controle;
	}

	@Override
	public String getMsg() {
		return msg;
	}
}
