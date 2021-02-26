package br.univates.AgenciaBancaria.apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.LineBorder;
import javax.swing.plaf.OptionPaneUI;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;

import br.univates.AgenciaBancaria.negocio.ContaCorrente;
import br.univates.AgenciaBancaria.persistencia.RegistroContas;
import br.univates.system32.CPF;
import br.univates.system32.MyComponents.JMyCPFField;
import br.univates.system32.MyComponents.JMyCurrencyField;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JFormattedTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JFormattedTextField.AbstractFormatter;

import br.univates.system32.util.JNumberFormatField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCriacaoConta extends Tela {

	private JPanel contentPane;
	private JTextField textNome;
	private JPasswordField fieldSenhaConf;
	private boolean checkNome = false;
	private boolean checkCPF = false;
	private boolean checkPassword = false;
	private boolean checkSenhaConf = false;

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public TelaCriacaoConta() throws ParseException, ClassNotFoundException, IOException{

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 740, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null); // Seta a posição da janela no centro do monitor

		JLabel lblCriacaoConta = new JLabel("Cria\u00E7\u00E3o de Conta");
		lblCriacaoConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCriacaoConta.setFont(new Font("Vivaldi", Font.BOLD, 30));

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 694,
										Short.MAX_VALUE)
								.addComponent(lblCriacaoConta, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1279,
										Short.MAX_VALUE))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblCriacaoConta)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE).addContainerGap()));

		JLabel lblNome = new JLabel("Digite seu nome completo:");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 15));

		textNome = new JTextField();
		
		textNome.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textNome.setHorizontalAlignment(SwingConstants.CENTER);
		textNome.setColumns(10);

		JLabel lblCPF = new JLabel("Digite seu CPF:");
		lblCPF.setHorizontalAlignment(SwingConstants.CENTER);
		lblCPF.setFont(new Font("Times New Roman", Font.BOLD, 15));

		MaskFormatter maskCPF = new MaskFormatter("###.###.###-##");
		JMyCPFField textCPF = new JMyCPFField();
		
		textCPF.setHorizontalAlignment(SwingConstants.CENTER);

		textCPF.setFont(new Font("Times New Roman", Font.BOLD, 15));

		JLabel lblCPFInfo = new JLabel("");
		lblCPFInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCPFInfo.setFont(new Font("Times New Roman", Font.BOLD, 12));

		JLabel lblNomeInfo = new JLabel("");
		lblNomeInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeInfo.setFont(new Font("Times New Roman", Font.BOLD, 12));

		JLabel lblSenha = new JLabel("Digite sua senha :");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Times New Roman", Font.BOLD, 15));

		JPasswordField fieldSenha = new JPasswordField();

		fieldSenha.setFont(new Font("Times New Roman", Font.BOLD, 15));
		fieldSenha.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblSenhaInfo = new JLabel("Digite pelo menos 4 caracteres");
		lblSenhaInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenhaInfo.setFont(new Font("Times New Roman", Font.BOLD, 12));

		JLabel lblSenhaConf = new JLabel("Confirme sua senha :");
		lblSenhaConf.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenhaConf.setFont(new Font("Times New Roman", Font.BOLD, 15));

		JLabel lblSenhaConfInfo = new JLabel("");
		lblSenhaConfInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenhaConfInfo.setFont(new Font("Times New Roman", Font.BOLD, 12));

		JLabel lblDeposito = new JLabel("Digite o valor do dep\u00F3sito inicial:");
		lblDeposito.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeposito.setFont(new Font("Times New Roman", Font.BOLD, 15));

		JNumberFormatField textDeposito = new JNumberFormatField();
		textDeposito.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnNewButton = new JButton("Criar Conta");

		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));

		fieldSenhaConf = new JPasswordField();

		fieldSenhaConf.setHorizontalAlignment(SwingConstants.CENTER);
		fieldSenhaConf.setFont(new Font("Times New Roman", Font.BOLD, 15));

		JLabel lblDepositoInfo = new JLabel("Campo opcional");
		lblDepositoInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepositoInfo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JButton btnVoltar = new JButton("Voltar");
		
		btnVoltar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDeposito, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
								.addComponent(textNome, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNomeInfo, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
								.addComponent(fieldSenha, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSenhaInfo, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
								.addComponent(textDeposito, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDepositoInfo, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE))
							.addGap(55)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnVoltar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(fieldSenhaConf, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
								.addComponent(lblSenhaConfInfo, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
								.addComponent(lblSenhaConf, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
								.addComponent(textCPF, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
								.addComponent(lblCPF, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
								.addComponent(lblCPFInfo, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))))
					.addGap(635))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(lblCPF, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNomeInfo, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSenha)
								.addComponent(lblSenhaConf, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblCPFInfo, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(fieldSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSenhaInfo, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(fieldSenhaConf, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblSenhaConfInfo, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(lblDeposito, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textDeposito, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDepositoInfo, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVoltar))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		textNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				if (textNome.getText().equals("")) {
					textNome.setBackground(Color.RED);
					lblNomeInfo.setText("Digite um nome para continuar.");
					lblNomeInfo.setForeground(Color.RED);
					checkNome = false;
				} else {
					textNome.setBackground(Color.GREEN);
					lblNomeInfo.setText("");
					checkNome = true;
				}

			}
		});

		textCPF.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				RegistroContas registro = new RegistroContas();
				
				if(registro.hasConta(textCPF.getText())) {
					lblCPFInfo.setText("Este CPF já foi cadastrado!");
					lblCPFInfo.setForeground(Color.RED);
					textCPF.setBackground(Color.RED);
					checkCPF = false;
				}else if (CPF.validaCPF(textCPF.getText()) == true) {
					lblCPFInfo.setText("CPF válido!");
					lblCPFInfo.setForeground(Color.GREEN);
					textCPF.setBackground(Color.GREEN);
					checkCPF = true;
				} else {
					lblCPFInfo.setText("Por favor digite um CPF válido!");
					lblCPFInfo.setForeground(Color.RED);
					textCPF.setBackground(Color.RED);
					checkCPF = false;
				}

			}
		});

		fieldSenha.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {

				if (fieldSenha.getPassword().length <= 3) {
					fieldSenha.setBackground(Color.RED);
					lblSenhaInfo.setText("A senha deve conter mais de 3 caracteres.");
					lblSenhaInfo.setForeground(Color.RED);
					checkPassword = false;
				} else if (fieldSenha.getPassword().length <= 5) {
					fieldSenha.setBackground(Color.ORANGE);
					lblSenhaInfo.setText("Senha fraca.");
					lblSenhaInfo.setForeground(Color.ORANGE);
					if (checkPassword == false) {
						checkPassword = true;
					}
				} else if (fieldSenha.getPassword().length < 10) {
					fieldSenha.setBackground(Color.GREEN);
					lblSenhaInfo.setText("Senha média.");
					lblSenhaInfo.setForeground(Color.GREEN);
				} else if (fieldSenha.getPassword().length >= 10) {
					fieldSenha.setBackground(Color.GREEN);
					lblSenhaInfo.setText("Senha forte.");
					for (char character : fieldSenha.getPassword()) {
						if (Character.isDigit(character) == true || Character.isDigit(e.getKeyChar())) {
							fieldSenha.setBackground(Color.GREEN);
							lblSenhaInfo.setText("Senha muito forte!");

						}
					}
				}

				if (e.getKeyCode() == 8) { // checar se o usuario apagou
					if (fieldSenha.getPassword().length <= 3) {
						fieldSenha.setBackground(Color.RED);
						lblSenhaInfo.setText("A senha deve conter mais de 3 caracteres.");
						lblSenhaInfo.setForeground(Color.RED);
						checkPassword = false;
					}
				}
			}

		});

		fieldSenhaConf.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {

				String senhaOri = "";
				for (char charSenha : fieldSenha.getPassword()) {
					senhaOri += charSenha;
				}
				String senhaConf = "";
				for (char charSenhaConf : fieldSenhaConf.getPassword()) {
					senhaConf += charSenhaConf;
				}

				if (senhaOri.equals(senhaConf)) {
					fieldSenhaConf.setBackground(Color.GREEN);
					lblSenhaConfInfo.setText("As senhas coincidem.");
					lblSenhaConfInfo.setForeground(Color.GREEN);
					checkSenhaConf = true;
				} else {
					fieldSenhaConf.setBackground(Color.RED);
					lblSenhaConfInfo.setText("As senhas não coincidem.");
					lblSenhaConfInfo.setForeground(Color.GREEN);
					checkSenhaConf = false;

				}
			}

			
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RegistroContas registro = new RegistroContas();
				
				if (checkNome == true && checkCPF == true && checkPassword == true && checkSenhaConf == true) {
					ContaCorrente c;

					String senha = "";
					for (char charSenha : fieldSenha.getPassword()) {
						senha += charSenha;
					}
					
					if (textDeposito.getValue().doubleValue() != 0) {
						
						try {
							registro.addConta(new ContaCorrente(registro.getSize()+1, textNome.getText(), 
									textCPF.getText(), senha, textDeposito.getValue().doubleValue()));
							registro.saveFile();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					} else {
						
						try {
							registro.addConta( new ContaCorrente(registro.getSize()+1, textNome.getText(), 
									textCPF.getText(), senha));
							registro.saveFile();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					try {
						JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
						TelaInicialGUI telaIni;
						telaIni = new TelaInicialGUI();
						telaIni.setVisible(true);
						dispose();
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
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
		
		
		
		
	}

	
}
