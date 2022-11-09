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

import pt.comandos.ComandoExpressao;
import pt.comandos.Command;
import pt.comandos.IComando;
import pt.controleCalculo.ICalculoMatriz;
import pt.exceptions.ErroDeCalculo;
import pt.telaCalculadora.TelaCalculadora;
import pt.visual.IVisualFactory;

public class BarraDeComando extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ComandoExpressao comando;
	private JTextField leitor;
	private JButton botao;
	private JLabel texto;
	private TelaCalculadora tela;
	
	private Color corErro;


	public BarraDeComando(TelaCalculadora tela, ICalculoMatriz controle, IVisualFactory visFac) {
		super();
		leitor = new JTextField(50);
		leitor.setFont(new Font("Arial", Font.BOLD, 15));
		botao = new JButton("=");
		
		
		this.tela = tela;
		
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		
		botao.addActionListener(this);
		leitor.addActionListener(this);
		
		// vermelho transparente
		corErro = new Color(255, 170, 170);
		
		comando = new ComandoExpressao(controle, visFac, leitor, tela);
		texto = new JLabel(comando.getMsg());
		
		add(texto);
		add(criaLinhaBaixo());
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
		try {
			comando.execute();
			leitor.setText("");
			
			leitor.setBackground(Color.WHITE);
			texto.setText(comando.getMsg());
		} catch (ErroDeCalculo err) {
			leitor.setBackground(corErro); // vermelho transparente
		}
	}

	

}
