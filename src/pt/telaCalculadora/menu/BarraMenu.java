package pt.telaCalculadora.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import pt.comandos.menu.SetDivisorDecimal;
import pt.comandos.menu.ShowJDialog;
import pt.telaCalculadora.TelaCalculadora;
import pt.telaCalculadora.util.MenuItemCommand;

public class BarraMenu extends JMenuBar {
	public BarraMenu(TelaCalculadora tela) {
		super();
		
		add(barraOpcoes(tela));
	}
	
	
	private JMenu barraOpcoes(TelaCalculadora tela) {
		JMenu opcoes = new JMenu("Opcoes");
		
		JMenuItem decimal = new MenuItemCommand("Precisao decimal"
				, new ShowJDialog(new LeitorPrecisaoDecimal(tela)));

		opcoes.add(decimal);
		
		opcoes.add(divisorDecimal());
		
		return opcoes;
	}
	
	
	private JMenu divisorDecimal() {
		JMenu divisor = new JMenu("Divisor Decimal");
		
		divisor.add(new MenuItemCommand(".", new SetDivisorDecimal('.')));
		divisor.add(new MenuItemCommand(",", new SetDivisorDecimal(',')));
		
		return divisor;
	}
}
