package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cachorro;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CadastrarCachorro extends JFrame {
	
	public static ArrayList<Cachorro> lista = new ArrayList<Cachorro>();
	
	public CadastrarCachorro(ArrayList<Cachorro> lista) {
		CadastrarCachorro.lista = lista;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoRaca;
	private JTextField campoSexo;
	private JTextField campoIdade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarCachorro frame = new CadastrarCachorro();
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
	public CadastrarCachorro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(37, 52, 46, 14);
		contentPane.add(lblNewLabel);
		
		campoNome = new JTextField();
		campoNome.setBounds(86, 50, 86, 20);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		
		JLabel lblRaa = new JLabel("Ra\u00E7a");
		lblRaa.setBounds(35, 92, 46, 14);
		contentPane.add(lblRaa);
		
		campoRaca = new JTextField();
		campoRaca.setColumns(10);
		campoRaca.setBounds(85, 89, 86, 20);
		contentPane.add(campoRaca);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(36, 133, 46, 14);
		contentPane.add(lblSexo);
		
		campoSexo = new JTextField();
		campoSexo.setColumns(10);
		campoSexo.setBounds(85, 128, 86, 20);
		contentPane.add(campoSexo);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(33, 171, 46, 14);
		contentPane.add(lblIdade);
		
		campoIdade = new JTextField();
		campoIdade.setBounds(86, 168, 86, 20);
		contentPane.add(campoIdade);
		campoIdade.setColumns(10);
		
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = campoNome.getText();
				String raca = campoRaca.getText();
				String sexo = campoSexo.getText();
				int idade = Integer.parseInt(campoIdade.getText());
				
				
				Cachorro cachorro = new Cachorro();
				
				cachorro.setNome(nome);
				cachorro.setRaca(raca);
				cachorro.setSexo(sexo);
				cachorro.setIdade(idade);
				
				lista.add(cachorro);
				
				Limpar();
				
			}
		});
		botaoCadastrar.setBounds(86, 214, 96, 23);
		contentPane.add(botaoCadastrar);
		
		JButton botaoMenu = new JButton("Menu");
		botaoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CasaCachorro().setVisible(true);
				dispose();
			}
		});
		botaoMenu.setBounds(291, 214, 89, 23);
		contentPane.add(botaoMenu);
		
		JButton botaoLimpar = new JButton("Limpar");
		botaoLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
			}
		});
		botaoLimpar.setBounds(192, 214, 89, 23);
		contentPane.add(botaoLimpar);
	}
	
	public void Limpar() {
    	campoNome.setText("");
        campoNome.requestFocus();
        campoRaca.setText("");
        campoSexo.setText("");
        campoIdade.setText("");
	}

}
