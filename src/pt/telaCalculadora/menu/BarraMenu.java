package pt.telaCalculadora.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import pt.comandos.menu.ShowJDialog;
import pt.telaCalculadora.TelaCalculadora;
import pt.telaCalculadora.util.MenuItemCommand;

public class BarraMenu extends JMenuBar {
	public BarraMenu(TelaCalculadora tela) {
		super();
		
		add(barraOpcoes(tela));
	}
	
	
	public JMenu barraOpcoes(TelaCalculadora tela) {
		JMenu opcoes = new JMenu("Opcoes");
		
		JMenuItem decimal = new MenuItemCommand("Precisao decimal"
				, new ShowJDialog(new LeitorPrecisaoDecimal(tela)));
		
		

		opcoes.add(decimal);
		
		return opcoes;
	}
}
