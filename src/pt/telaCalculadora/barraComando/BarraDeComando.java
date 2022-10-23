package pt.telaCalculadora.barraComando;

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
import pt.visual.IVisualFactory;

public class BarraDeComando extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IComando comando;
	private JTextField leitor;
	private JButton botao;
	private JLabel texto;
	private JPanel telaMatriz;


	public BarraDeComando(JPanel telaMatriz) {
		super();
		leitor = new JTextField("digite aqui", 50);
		botao = new JButton("=");
		texto = new JLabel("TESTANDO 1 2 3");
		
		this.telaMatriz = telaMatriz;
		
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(texto);
		add(criaLinhaBaixo());
		
		botao.addActionListener(this);
	}
	
	
	public void connect(IComando comando) {
		this.comando = comando;
		
		texto.setText(comando.getMsg());
	}
	
	
	public void connect(IVisualFactory visualFac) {
		comando.connect(visualFac);
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

		comando.realizaComando(msg, telaMatriz);
		
		texto.setText(comando.getMsg());
	}

	

}
