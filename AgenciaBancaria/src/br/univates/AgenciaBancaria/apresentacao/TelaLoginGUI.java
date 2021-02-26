package br.univates.AgenciaBancaria.apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import br.univates.AgenciaBancaria.negocio.ContaCorrente;
import br.univates.AgenciaBancaria.persistencia.RegistroContas;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import br.univates.system32.MyComponents.JMyCPFField;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class TelaLoginGUI extends Tela {

	private JPanel contentPane;

	private JPasswordField passwordField;
	private boolean CPFValid = false;
	private ContaCorrente conta;
	

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public TelaLoginGUI() throws ParseException, ClassNotFoundException, IOException{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAgencia = new JLabel("Ag\u00EAncia Banc\u00E1ria");
		lblAgencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgencia.setFont(new Font("Vivaldi", Font.BOLD, 30));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		
		JLabel lblCPF = new JLabel("Digite seu CPF:");
		lblCPF.setHorizontalAlignment(SwingConstants.CENTER);
		lblCPF.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JMyCPFField textCPF = new JMyCPFField();
		
		textCPF.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblSenha = new JLabel("Digite sua senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		passwordField = new JPasswordField();
		
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JLabel lblCPFInfo = new JLabel("");
		lblCPFInfo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCPFInfo.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblSenhaInfo = new JLabel("");
		lblSenhaInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenhaInfo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JButton btnEntrar = new JButton("Login");
		
		btnEntrar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JButton btnVoltar = new JButton("Voltar");
		
		btnVoltar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblCPF, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCPFInfo, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
								.addComponent(textCPF, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSenhaInfo, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
								.addComponent(btnEntrar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnVoltar, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCPF)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textCPF, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCPFInfo, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSenhaInfo, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEntrar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAgencia, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
							.addGap(82))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAgencia, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		textCPF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if(registro.hasConta(textCPF.getText())) {
					textCPF.setBackground(Color.GREEN);
					conta = registro.getContaByCPF(textCPF.getText());
					CPFValid = true;
				}else {
					textCPF.setBackground(Color.RED);
					lblCPFInfo.setText("CPF não registrado.");
					CPFValid = false;
				}
				
//				for (int i = 0; i < registro.getSize(); i++) {
//					if(registro.getContaAt(i).getCPFCompleto().equals(textCPF.getText())){
//						textCPF.setBackground(Color.GREEN);
//						conta = registro.getContaAt(i);
//						CPFValid = true;
//					}else {
//						textCPF.setBackground(Color.RED);
//						lblCPFInfo.setText("CPF não registrado.");
//						CPFValid = false;
//					}
//				}
				
			}
		});
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					TelaInicialGUI telaIni;
					telaIni = new TelaInicialGUI();
					telaIni.setVisible(true);
					dispose();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(CPFValid == true) {
					String senha = "";
					for(char c : passwordField.getPassword()) {
						senha += c;
					}
					
					if(conta.getSenha().equals(senha)) {
						lblSenhaInfo.setText("");
						
						
						try {
							TelaContaGUI telaC;
							telaC = new TelaContaGUI(conta);
							telaC.setVisible(true);
							dispose();
						} catch (ClassNotFoundException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
					}else {
						lblSenhaInfo.setText("Senha incorreta!");
						lblSenhaInfo.setForeground(Color.RED);
						passwordField.setBackground(Color.RED);
					}
				}
				
			}
		});
		
	}
}
