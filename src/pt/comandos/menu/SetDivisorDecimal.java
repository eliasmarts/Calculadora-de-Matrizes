package pt.comandos.menu;

import pt.Configurations;
import pt.comandos.Command;

public class SetDivisorDecimal implements Command {
	private char divisor;
	
	
	public SetDivisorDecimal(char divisor) {
		this.divisor = divisor;
	}


	@Override
	public void execute() {
		Configurations.setDecimalDivisor(divisor);
	}

}
