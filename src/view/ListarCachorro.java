package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cachorro;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ListarCachorro extends JFrame {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoCachorro;
	private JButton botaoEnviar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarCachorro frame = new ListarCachorro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListarCachorro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea campoListar = new JTextArea();
		campoListar.setEditable(false);
		campoListar.setBounds(10, 11, 414, 310);
		contentPane.add(campoListar);
		
		JLabel lblNewLabel = new JLabel("Escolha um cachorro:");
		lblNewLabel.setBounds(10, 335, 147, 14);
		contentPane.add(lblNewLabel);
		
		campoCachorro = new JTextField();
		campoCachorro.setBounds(167, 332, 86, 20);
		contentPane.add(campoCachorro);
		campoCachorro.setColumns(10);
		
		botaoEnviar = new JButton("Enviar");
		botaoEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			int escolherCachorro = Integer.parseInt(campoCachorro.getText());
			Cachorro manipularCachorro = CadastrarCachorro.lista.get(escolherCachorro);
			campoListar.setText(String.valueOf(manipularCachorro.getNome()));
			}
		});
		botaoEnviar.setBounds(263, 331, 89, 23);
		contentPane.add(botaoEnviar);
		
		JButton botaoDados = new JButton("Dados");
		botaoDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int escolherCachorro = Integer.parseInt(campoCachorro.getText());
				Cachorro manipularCachorro = CadastrarCachorro.lista.get(escolherCachorro);
				campoListar.setText(String.valueOf(manipularCachorro));
			}
		});
		botaoDados.setBounds(23, 398, 89, 23);
		contentPane.add(botaoDados);
		
		JButton botaoAlimentar = new JButton("Alimentar");
		botaoAlimentar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int escolherCachorro = Integer.parseInt(campoCachorro.getText());
				Cachorro manipularCachorro = CadastrarCachorro.lista.get(escolherCachorro);
				
				String comida = JOptionPane.showInputDialog(
						"--------------- COMIDAS ---------------\n"
						+ "R - RAÇÃO \n"
						+ "C - CARNE \n"
						+ "L - LEGUMES\n "
						+ "--------------------------------------"); 
				
				float c = 50;

				if (c > (manipularCachorro.getEnergia())){
					manipularCachorro.comer(comida);
					campoListar.setText("Energia atual: "+manipularCachorro.getEnergia());
				} else {
					campoListar.setText("O cachorro está com energia suficiente e não precisar comer :)");
				}
			}
		});
		botaoAlimentar.setBounds(122, 398, 89, 23);
		contentPane.add(botaoAlimentar);
		
		JButton botaoBrincar = new JButton("Brincar");
		botaoBrincar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int escolherCachorro = Integer.parseInt(campoCachorro.getText());
				Cachorro manipularCachorro = CadastrarCachorro.lista.get(escolherCachorro);
				
				String brincadeira = JOptionPane.showInputDialog(
						"------------- BRINCADEIRAS -------------\n"
						+ "B - BUSCAR BOLINHA \n"
						+ "S - SALTAR \n"
						+ "G - GIRAR PELO CHÃO \n "
						+ "--------------------------------------"); 
				
				float b = 40;
				if (b < (manipularCachorro.getEnergia())){
					manipularCachorro.brincar(brincadeira);
					campoListar.setText("Energia atual: "+manipularCachorro.getEnergia());
				} else {
					campoListar.setText("O cachorro não tem energia para brincar :(");
				}
				
			}
		});
		botaoBrincar.setBounds(221, 398, 89, 23);
		contentPane.add(botaoBrincar);
		
		JButton btnCruzar = new JButton("Cruzar");
		btnCruzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int escolherCachorro = Integer.parseInt(campoCachorro.getText());
				Cachorro manipularCachorro = CadastrarCachorro.lista.get(escolherCachorro);
				
				
				float d = 50;
				if (d < (manipularCachorro.getEnergia())) {
					ArrayList<Cachorro> novaLista = new ArrayList<Cachorro>();
					for (int i = 0; i < CadastrarCachorro.lista.size(); i++) {
						if(manipularCachorro.pode_cruzar(CadastrarCachorro.lista.get(i))) {
							novaLista.add(CadastrarCachorro.lista.get(i));
							
							String aux = "";
							for (int c = 0; c < novaLista.size(); c++) {
								aux+= String.valueOf(c) + novaLista.get(c);
								campoListar.setText(aux);
							}
						}		
					}
					
					int escolherCachorroCruzar = Integer.parseInt(JOptionPane.showInputDialog("ESCOLHA UM CACHORRO PARA CRUZAR: "));
					Cachorro parceiro = novaLista.get(escolherCachorroCruzar);
					campoListar.setText("O número de filhotes é: "+manipularCachorro.cruzar(parceiro));
					
					
				} else {
					campoListar.setText("O cachorro não tem energia suficiente para cruzar");
				}

				
				
			}
		});
		btnCruzar.setBounds(320, 398, 89, 23);
		contentPane.add(btnCruzar);
		
		JButton botaoMenu = new JButton("Menu");
		botaoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CasaCachorro().setVisible(true);
				dispose();
			}
		});
		botaoMenu.setBounds(164, 436, 89, 23);
		contentPane.add(botaoMenu);
		

		int listaNum = CadastrarCachorro.lista.size();
		
		String aux = "";
		
		for (int i = 0; i < listaNum; i++) {
			aux += String.valueOf(i) + CadastrarCachorro.lista.get(i);
			campoListar.setText(aux);
			
		}
		

	}
	public void Limpar() {
    	campoCachorro.setText("");

	}
}
