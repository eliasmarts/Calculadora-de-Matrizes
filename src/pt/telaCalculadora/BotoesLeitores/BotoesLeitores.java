package pt.telaCalculadora.BotoesLeitores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import pt.comandos.botoesLeitores.MexeBotoes;
import pt.comandos.botoesLeitores.MostraLeitor;
import pt.controleCalculo.ICalculoMatriz;
import pt.telaCalculadora.PainelDeMatrizes;
import pt.telaCalculadora.leitorMatriz.LeitorDeMatriz;
import pt.telaCalculadora.util.ButtonCommand;

public class BotoesLeitores extends JPanel implements ActionListener {
	private PainelDeMatrizes painel;
	private ICalculoMatriz controle;
	private List<ButtonCommand> botoes;
	private boolean botoesAtivos[];
	private JPanel bot;
	private NovoBotao novoB;
	private boolean novoBativo;
	
	public BotoesLeitores(PainelDeMatrizes painel, ICalculoMatriz controle) {
		super();
		this.painel = painel;
		
		botoes = new ArrayList<ButtonCommand>();
		
		this.controle = controle;
		
		bot = new JPanel();
		
		add(bot);
		
		add(new ButtonCommand("+", new MexeBotoes(this, true)));
		
		novoB = new NovoBotao(this);
		novoB.setVisible(novoBativo);
		
		add(novoB);
		
		add(new ButtonCommand("-", new MexeBotoes(this, false)));
		
		botoesAtivos = new boolean[26];
		
		for (boolean b : botoesAtivos) {
			b = false;
		}
		
		addBotao('A');
		addBotao('B');
		
	}
	
	
	public void addBotao(char c) {
		if (!botoesAtivos[c - 48]) {
			LeitorDeMatriz lei = new LeitorDeMatriz(c, controle.getMatriz(c));
			ButtonCommand botao = new ButtonCommand(String.valueOf(c), new MostraLeitor(lei, painel, c));
			
			botao.addActionListener(this);
			
			botoes.add(botao);
			
			bot.add(botao, botoes.indexOf(botao));
			
			botao.actionPerformed(null);
			
			atualiza();
			
			botoesAtivos[c - 48] = true;
		}
	}
	
	
	public void removeUltimo() {
		if (botoes.size() > 0) {
			ButtonCommand botao = botoes.get(botoes.size() - 1);
			botoes.remove(botoes.size() - 1);
			
			bot.remove(botao);
			
			botoesAtivos[botao.getText().charAt(0) - 48] = false;
			
			atualiza();
		}
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		painel.atualiza();
	}
	
	
	public void atualiza() {
		revalidate();
		repaint();
	}
	
	
	public void toggleNovoBotao() {
		if (!novoB.isVisible())
			novoB.setVisible(true);
		else {
			novoB.setText("");
			novoB.setVisible(false);
		}

		atualiza();
	}
}
