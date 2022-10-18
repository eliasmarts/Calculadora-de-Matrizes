package pt.visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.Notification;
import javax.management.NotificationListener;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class BarraDeComando implements Visual, ActionListener {
	private JTextField barra;
	
	public BarraDeComando() {
		barra = new JTextField("Comando: ");
		barra.addActionListener(this);
	}
	@Override
	public void draw(JFrame frame, int x, int y) {
		barra.setBounds(100, 100, 800, 110);
		
		frame.add(barra);

	}
	
	
	
	
	public String getText() {
		return barra.getText().substring(8);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
