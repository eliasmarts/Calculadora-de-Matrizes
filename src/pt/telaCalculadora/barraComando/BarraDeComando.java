package pt.telaCalculadora.barraComando;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pt.comando.IComando;
import pt.exceptions.ErroDeCalculo;
import pt.telaCalculadora.AreaDeResposta;
import pt.telaCalculadora.TelaCalculadora;
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
	private TelaCalculadora tela;
	
	private Color corErro;


	public BarraDeComando(TelaCalculadora tela) {
		super();
		leitor = new JTextField("digite aqui", 50);
		leitor.setFont(new Font("Arial", Font.BOLD, 15));
		botao = new JButton("=");
		texto = new JLabel("TESTANDO 1 2 3");
		
		this.tela = tela;
		
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(texto);
		add(criaLinhaBaixo());
		
		botao.addActionListener(this);
		leitor.addActionListener(this);
		
		// vermelho transparente
		corErro = new Color(255, 170, 170);
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
		

		try {
			
			comando.realizaComando(msg, tela);
			leitor.setText("");
			
			leitor.setBackground(Color.WHITE);
			texto.setText(comando.getMsg());
		} catch (ErroDeCalculo err) {
			leitor.setBackground(corErro); // vermelho transparente
		}
	}

	

}
