package pt.telaCalculadora;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pt.controleCalculo.ICalculoMatriz;
import pt.exceptions.ErroCalculadora;
import pt.telaCalculadora.BotoesLeitores.BotoesLeitores;
import pt.telaCalculadora.barraComando.BarraDeComando;
import pt.telaCalculadora.menu.BarraMenu;
import pt.visual.IVisualFactory;
import pt.visual.Visual;
import pt.visual.VisualFactory;

public class TelaCalculadora extends JFrame implements ITelaCalculadora {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ICalculoMatriz controleCalculo;
	private BarraDeComando barra;
	private PainelDeMatrizes painelDeMatrizes;
	private Container contentPane;
	private IVisualFactory visFac;

	public PainelDeMatrizes getPainelDeMatrizes() {
		return painelDeMatrizes;
	}


	public AreaDeResposta getAreaResp() {
		return areaResp;
	}


	private AreaDeResposta areaResp;
	
	
	public TelaCalculadora() {
		super("Calculadora de matrizes");
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		
		super.setSize(1000, 500);
		
		
		
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		painelDeMatrizes = new PainelDeMatrizes();
		areaResp = new AreaDeResposta();
		
		areaResp.setVisible(true);

		
		
		
		contentPane.add(painelDeMatrizes, BorderLayout.CENTER);
		
		contentPane.add(areaResp, BorderLayout.EAST);
	}


	public void connect(ICalculoMatriz controleCalculo) {
		String[][] inicio = { {"1", "0"}, {"0", "1"}};
		this.controleCalculo = controleCalculo;
		controleCalculo.armazenaMatriz('A', inicio);
		controleCalculo.armazenaMatriz('B', inicio);
	}
	
	@Override
	public void connect(IVisualFactory visualFac) {
		this.visFac = visualFac;
	}
	
	

	
	public void iniciar() {
		barra = new BarraDeComando(this, controleCalculo, visFac);
		contentPane.add(barra, BorderLayout.SOUTH);
		
		contentPane.add(new BotoesLeitores(painelDeMatrizes, controleCalculo), BorderLayout.NORTH);
		
		setJMenuBar(new BarraMenu(this));
		

		setVisible(true);
	}


	@Override
	public void encerrar() {
		// TODO Auto-generated method stub
		
	}
	
	
	public void update() {
		painelDeMatrizes.atualiza();
	}

	/*
	@Override
	public void iniciar() {
		System.out.println("Iniciando calculadora");
		
		repaint();
		
		while (true) {
			System.out.println("Escolha seu comando: ");
			System.out.println("(l) ler matriz, (e) digitar expressao, (p) imprimir matriz, (x) sair");
			
			char comando = sc.next().charAt(0);
			try {
				if (comando == 'x') {
					encerrar();
					break;
				}
				else if (comando == 'l')
					lerMatriz();
				else if (comando == 'e')
					lerExpressao();
				else if (comando == 'p')
					lerImpressao();
			} catch (InputMismatchException e) {
				System.out.println("Entrada invalida");
			}
		}
	}

	private void lerImpressao() {
		System.out.print("Digite qual matriz deseja imprimir: ");
		char matriz = sc.next().charAt(0);
		
		painelDeMatrizes.add(visFac.criaVisual(controleCalculo.realizarExpressao(String.valueOf(matriz)));
		
		painelDeMatrizes.revalidate();
		painelDeMatrizes.repaint();
		
		
		repaint();
	}


	private void lerExpressao() {
		System.out.println("Digite a expressao:");
		String expressao = sc.nextLine();
		
		try {
			painelDeMatrizes.add(controleCalculo.realizarExpressao(expressao));
			painelDeMatrizes.revalidate();
			painelDeMatrizes.repaint();
			repaint();
		} catch (ErroDeCalculo e) {
			System.err.println("Erro no calculo: ");
			System.err.print(e.getMessage());
		}
	}


	private void lerMatriz() {
		System.out.print("Qual o nome da matriz: ");
		char nome = sc.next().charAt(0);
		System.out.print("Numero de linhas: ");
		int linhas = sc.nextInt();
		System.out.print("Numero de colunas: ");
		int colunas = sc.nextInt();
		sc.nextLine();
		System.out.println();
		
		String[][] matriz = lerMatrizEntrada(linhas, colunas);
		
		controleCalculo.armazenaMatriz(nome, matriz);
	}


	@Override
	public void encerrar() {
		sc.close();
	}
	
	
	private String[][] lerMatrizEntrada(int x, int y) {
		String[][] entrada = new String[x][y];
		
		System.out.println("Digite os valores de uma matriz " + x + " por " + y);
		
		for (int i = 0; i < x; i++) {
			System.out.print("LINHA " + Integer.toString(i + 1) + ": ");
			for (int j = 0; j < y; j++) {
				entrada[i][j] = sc.next();
			}
		}
		System.out.println();
		
		return entrada;
	}

	*/
	


	


}
