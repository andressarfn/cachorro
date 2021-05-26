package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CasaCachorro extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CasaCachorro frame = new CasaCachorro();
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
	public CasaCachorro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "MENU", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CadastrarCachorro().setVisible(true);
				dispose();
			}
		});
		botaoCadastrar.setBounds(52, 115, 97, 23);
		contentPane.add(botaoCadastrar);
		
		JButton botaoListar = new JButton("Listar");
		botaoListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListarCachorro().setVisible(true);
				dispose();
			}
		});
		botaoListar.setBounds(170, 115, 97, 23);
		contentPane.add(botaoListar);
		
		JButton botaoSair = new JButton("Sair");
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		botaoSair.setBounds(293, 115, 94, 23);
		contentPane.add(botaoSair);
	}

}
