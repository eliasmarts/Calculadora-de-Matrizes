package pt.visual;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

import pt.comando.Comando;
import pt.comando.IComando;
import pt.controleCalculo.ControleCalculo;

public class BarraDeComando extends JPanel implements Visual, ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IComando comando;
	private JTextField leitor;
	private JButton botao;
	private JLabel texto;


	public BarraDeComando() {
		super();
		leitor = new JTextField("digite aqui", 50);
		botao = new JButton("=");
		texto = new JLabel("TESTANDO 1 2 3");
		
		comando = new Comando();
		
		texto.setText(comando.getMsg());
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(texto);
		add(criaLinhaBaixo());
		
		botao.addActionListener(this);
	}
	
	private JPanel criaLinhaBaixo() {
		JPanel linhaBaixo;
		linhaBaixo = new JPanel();
		linhaBaixo.setLayout(new FlowLayout());
		linhaBaixo.add(leitor);
		linhaBaixo.add(botao);
		
		return linhaBaixo;
	}
	
	
	public String getText() {
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = leitor.getText();
		leitor.setText("");

		comando.realizaComando(msg, null);
		
		texto.setText(comando.getMsg());
	}

}
