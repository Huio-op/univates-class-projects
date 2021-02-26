package br.univates.AgenciaBancaria.apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import br.univates.AgenciaBancaria.negocio.ContaCorrente;
import br.univates.AgenciaBancaria.negocio.Transacao;
import br.univates.AgenciaBancaria.persistencia.RegistroContas;
import br.univates.system32.MyComponents.JMyCPFField;
import br.univates.system32.util.JNumberFormatField;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListModel;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class TelaContaGUI extends Tela {

	private JPanel contentPane;

	private ContaCorrente conta;

	/**
	 * Create the frame.
	 */
	public TelaContaGUI(ContaCorrente contaAberta) throws ClassNotFoundException, IOException {

		this.conta = contaAberta;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		JPanel panelChoices = new JPanel();
		panelChoices.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		JPanel panelMain = new JPanel();
		panelMain.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panelMain, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelChoices, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(94, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panelChoices, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(panelMain, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)));

		JLabel lblNewLabel = new JLabel("Bem Vindo(a) " + conta.getNome().split(" ")[0] + "! ");
		lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblEscolhaAAo = new JLabel("Escolha acima a a\u00E7\u00E3o");
		lblEscolhaAAo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscolhaAAo.setFont(new Font("Vivaldi", Font.BOLD, 35));

		JLabel lblQueDesejaRealizar = new JLabel("que deseja realizar.");
		lblQueDesejaRealizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblQueDesejaRealizar.setFont(new Font("Vivaldi", Font.BOLD, 35));
		GroupLayout gl_panelMain = new GroupLayout(panelMain);
		gl_panelMain.setHorizontalGroup(gl_panelMain.createParallelGroup(Alignment.LEADING).addGroup(gl_panelMain
				.createSequentialGroup()
				.addGroup(gl_panelMain.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMain.createSequentialGroup().addGap(2)
								.addGroup(gl_panelMain.createParallelGroup(Alignment.LEADING)
										.addComponent(lblQueDesejaRealizar, GroupLayout.PREFERRED_SIZE, 500,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEscolhaAAo, GroupLayout.PREFERRED_SIZE, 500,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelMain.createSequentialGroup().addContainerGap().addComponent(lblNewLabel,
								GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)))
				.addContainerGap()));
		gl_panelMain
				.setVerticalGroup(gl_panelMain.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMain.createSequentialGroup().addGap(29).addComponent(lblNewLabel).addGap(52)
								.addComponent(lblEscolhaAAo, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblQueDesejaRealizar,
										GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(31, Short.MAX_VALUE)));
		panelMain.setLayout(gl_panelMain);

		JButton btnSaque = new JButton("Saque");

		btnSaque.setFont(new Font("Times New Roman", Font.BOLD, 14));

		JButton btnTransferencia = new JButton("Transferência");

		btnTransferencia.setFont(new Font("Times New Roman", Font.BOLD, 14));

		JButton btnSair = new JButton("Sair");

		btnSair.setFont(new Font("Times New Roman", Font.BOLD, 18));

		JButton btnPagar = new JButton("Pagar Conta");

		btnPagar.setFont(new Font("Times New Roman", Font.BOLD, 14));

		JButton btnConta = new JButton("Conta");

		btnConta.setFont(new Font("Times New Roman", Font.BOLD, 14));

		JButton btnHistorico = new JButton("Histórico ");

		btnHistorico.setFont(new Font("Times New Roman", Font.BOLD, 14));

		JButton btnDeposito = new JButton("Depósito");

		btnDeposito.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GroupLayout gl_panelChoices = new GroupLayout(panelChoices);
		gl_panelChoices.setHorizontalGroup(gl_panelChoices.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelChoices.createSequentialGroup().addGap(27)
						.addGroup(gl_panelChoices.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnPagar, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnConta, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(
								gl_panelChoices.createParallelGroup(Alignment.LEADING)
										.addComponent(btnSaque, GroupLayout.PREFERRED_SIZE, 115,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnTransferencia, GroupLayout.PREFERRED_SIZE, 115,
												GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panelChoices.createParallelGroup(Alignment.LEADING)
								.addComponent(btnHistorico, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDeposito, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(23)));
		gl_panelChoices.setVerticalGroup(gl_panelChoices.createParallelGroup(Alignment.LEADING).addGroup(gl_panelChoices
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panelChoices.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panelChoices.createSequentialGroup()
								.addGroup(gl_panelChoices.createParallelGroup(Alignment.BASELINE).addComponent(btnSaque)
										.addComponent(btnConta).addComponent(btnDeposito))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelChoices.createParallelGroup(Alignment.BASELINE).addComponent(btnPagar)
										.addComponent(btnHistorico).addComponent(btnTransferencia))))
				.addContainerGap()));
		panelChoices.setLayout(gl_panelChoices);
		contentPane.setLayout(gl_contentPane);

		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				try {
					TelaLoginGUI criarConta;
					criarConta = new TelaLoginGUI();
					criarConta.setVisible(true);
					dispose();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelMain.removeAll();
				contentPane.add(getInfoConta(panelMain));
				contentPane.validate();

			}
		});

		btnDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelMain.removeAll();
				contentPane.add(getPanelDeposito(panelMain));
				contentPane.validate();

			}
		});

		btnSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelMain.removeAll();
				contentPane.add(getPanelSaque(panelMain));
				contentPane.validate();

			}
		});

		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelMain.removeAll();
				contentPane.add(getPanelPagar(panelMain));
				contentPane.validate();

			}
		});

		btnTransferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					panelMain.removeAll();
					contentPane.add(getPanelTransferencia(panelMain));
					contentPane.validate();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});

		btnHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelMain.removeAll();
				contentPane.add(getPanelHistorico(panelMain));
				contentPane.validate();

			}
		});

	}

	private JPanel getInfoConta(JPanel panel) {
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(97)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		
		JLabel lblNome = new JLabel(conta.getNome());
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JLabel lblSaldo = new JLabel("Saldo em conta:");
		lblSaldo.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		JLabel lblNumero = new JLabel("Número da Conta:");
		lblNumero.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		JLabel lblTransacoes = new JLabel("Número de Transações:");
		lblTransacoes.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JPanel panel_1_2_1_1 = new JPanel();
		panel_1_2_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		JLabel lblSaldoNum = new JLabel("R$ " +conta.getSaldo());
		lblSaldoNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSaldoNum.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JLabel lblNumConta = new JLabel(conta.getIdConta() + "");
		lblNumConta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumConta.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JLabel lblCPFnum = new JLabel(conta.getCPFCompleto() + "");
		lblCPFnum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCPFnum.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JLabel lblNumTransacoes = new JLabel(conta.getEstrato().size() + "");
		lblNumTransacoes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumTransacoes.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JButton btnDelete = new JButton("Deletar Conta");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1_2_1_1, GroupLayout.PREFERRED_SIZE, 502, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNome, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
								.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 502, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
								.addComponent(panel_1_2, GroupLayout.PREFERRED_SIZE, 502, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1_2_1, GroupLayout.PREFERRED_SIZE, 502, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblSaldo)
							.addPreferredGap(ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
							.addComponent(lblSaldoNum, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(20))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
							.addComponent(lblNumConta, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(20))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblCPF, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
							.addComponent(lblCPFnum, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(20))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblTransacoes)
							.addPreferredGap(ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
							.addComponent(lblNumTransacoes, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(20)))
					.addGap(6))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(201)
					.addComponent(btnDelete)
					.addContainerGap(203, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNome)
					.addGap(34)
					.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSaldo)
						.addComponent(lblSaldoNum, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumConta, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_2, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCPF, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCPFnum, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_2_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTransacoes, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumTransacoes, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1_2_1_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDelete)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_contentPane.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(97)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(75, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
		
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int input = JOptionPane.showConfirmDialog(null, "Deseja realmente deletar a conta?", 
						"Deletar?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if(input == 0) {
					
					registro.removeConta(conta);
					JOptionPane.showMessageDialog(null, "Conta excluida com sucesso!");
					try {
						registro.saveFile();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						TelaLoginGUI criarConta;
						criarConta = new TelaLoginGUI();
						criarConta.setVisible(true);
						dispose();
						
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					
				}
				
			}
		});
		
		return panel;

	}

	private JPanel getPanelDeposito(JPanel panel) {

		JLabel lblNome = new JLabel("Digite a quantidade que deseja depositar:");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		JNumberFormatField textDep = new JNumberFormatField();
		textDep.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnNewButton = new JButton("Depositar");

		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING,
								gl_panel.createSequentialGroup()
										.addComponent(panel_1_1_1, GroupLayout.PREFERRED_SIZE, 510,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
						.addGroup(Alignment.LEADING,
								gl_panel.createSequentialGroup()
										.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 510,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
						.addGroup(Alignment.LEADING,
								gl_panel.createSequentialGroup()
										.addComponent(lblNome, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
										.addContainerGap())
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup().addGap(180)
								.addComponent(textDep, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE).addGap(184))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup().addGap(202)
								.addComponent(btnNewButton).addContainerGap(211, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(33).addComponent(lblNome).addGap(32)
						.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE).addGap(29)
						.addComponent(textDep, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE).addGap(28)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addGap(27).addComponent(panel_1_1_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(13, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(16, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(97)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(32, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textDep.getValue().doubleValue() == 0) {
					textDep.setBackground(Color.RED);
				} else {

					try {
						textDep.setBackground(Color.WHITE);
						conta.depositar(textDep.getValue().doubleValue());
						JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
						registro.saveFile();
						textDep.setText("");
					} catch (IOException e1) {
						e1.printStackTrace();
					}

				}

			}
		});

		return panel;

	}

	private JPanel getPanelSaque(JPanel panel) {

		JLabel lblSacar = new JLabel("Digite a quantidade que deseja sacar:");
		lblSacar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSacar.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		JNumberFormatField textSaque = new JNumberFormatField();
		textSaque.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnSacar = new JButton("Sacar");

		btnSacar.setFont(new Font("Times New Roman", Font.BOLD, 18));

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		JLabel lblSaldo = new JLabel("Saldo em Conta: R$" + conta.getSaldo());
		lblSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaldo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(180)
								.addComponent(textSaque, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE).addGap(184))
						.addGroup(
								gl_panel.createSequentialGroup()
										.addComponent(panel_1_1_1, GroupLayout.PREFERRED_SIZE, 510,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup().addGap(218).addComponent(btnSacar)
								.addContainerGap(227, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblSacar, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
								.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblSaldo, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(21)
						.addComponent(lblSaldo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lblSacar).addGap(18)
						.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(textSaque, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE).addGap(28)
						.addComponent(btnSacar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panel_1_1_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(18, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(16, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(97)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(32, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textSaque.getValue().doubleValue() == 0) {

					textSaque.setBackground(Color.RED);

				} else if (conta.sacar(textSaque.getValue().doubleValue())) {

					try {
						textSaque.setBackground(Color.WHITE);
						JOptionPane.showMessageDialog(null, "Saque realizado com sucesso! Colete o seu dinheiro.");
						lblSaldo.setText("Saldo em Conta: R$" + conta.getSaldo());
						textSaque.setText("");
						registro.saveFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
					textSaque.setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Saldo em Conta insuficiente para realizar este saque.");
				}

			}
		});

		return panel;

	}

	private JPanel getPanelPagar(JPanel panel) {

		JLabel lblConta = new JLabel("Digite o valor da conta:");
		lblConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblConta.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		JNumberFormatField textPagar = new JNumberFormatField();
		textPagar.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnPagar = new JButton("Pagar");

		btnPagar.setFont(new Font("Times New Roman", Font.BOLD, 18));

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		JLabel lblSaldo = new JLabel("Saldo em Conta: ");
		lblSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaldo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(180)
								.addComponent(textPagar, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE).addGap(184))
						.addGroup(
								gl_panel.createSequentialGroup()
										.addComponent(panel_1_1_1, GroupLayout.PREFERRED_SIZE, 510,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup().addGap(218).addComponent(btnPagar)
								.addContainerGap(227, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblConta, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
								.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblSaldo, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(21)
						.addComponent(lblSaldo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(lblConta).addGap(18)
						.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(textPagar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE).addGap(28)
						.addComponent(btnPagar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(panel_1_1_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(18, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(16, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(97)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(32, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textPagar.getValue().doubleValue() == 0) {
					textPagar.setBackground(Color.RED);
				} else if (conta.pagarConta(textPagar.getValue().doubleValue())) {
					
					try {
						textPagar.setBackground(Color.WHITE);
						JOptionPane.showMessageDialog(null, "Pagamento realizado com sucesso!");
						lblSaldo.setText("Saldo em Conta: R$" + conta.getSaldo());
						textPagar.setText("");
						registro.saveFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} else {
					textPagar.setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Saldo em Conta insuficiente para pagar a conta.");
				}

			}
		});

		return panel;

	}

	private JPanel getPanelTransferencia(JPanel panel) throws ParseException {

		JLabel lblTransferir = new JLabel("Digite o valor que deseja transferir");
		lblTransferir.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransferir.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		JNumberFormatField textTransf = new JNumberFormatField();
		textTransf.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnTransf = new JButton("Transferir");

		btnTransf.setFont(new Font("Times New Roman", Font.BOLD, 18));

		JLabel lblSaldo = new JLabel("Saldo em Conta: R$" + conta.getSaldo());
		lblSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaldo.setFont(new Font("Times New Roman", Font.BOLD, 18));

		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		JLabel lblEOCpf = new JLabel("e o CPF do remetente:");
		lblEOCpf.setHorizontalAlignment(SwingConstants.CENTER);
		lblEOCpf.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JMyCPFField textCPF = new JMyCPFField();
		textCPF.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(lblSaldo, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(lblTransferir, GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE).addContainerGap())
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(panel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(lblEOCpf, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup().addGap(181)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textCPF, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 158,
										Short.MAX_VALUE)
								.addComponent(textTransf, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 158,
										Short.MAX_VALUE))
						.addGap(183))
				.addGroup(gl_panel.createSequentialGroup().addGap(208).addComponent(btnTransf).addContainerGap(209,
						Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(lblSaldo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblTransferir)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblEOCpf, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textTransf, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(textCPF, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
						.addComponent(panel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnTransf, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addGap(13)));
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(16, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(97)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(32, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

		btnTransf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroContas registro = new RegistroContas();

				if (registro.hasConta(textCPF.getText()) && !textCPF.equals(conta.getCPFCompleto())) {
					if (conta.transferenciaDeFundos(textTransf.getValue().doubleValue(),
							registro.getContaByCPF(textCPF.getText()))) {
						
						try {
							textTransf.setBackground(Color.WHITE);
							textCPF.setBackground(Color.WHITE);
							JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!.");
							textTransf.setText("");
							textCPF.setText("");
							lblSaldo.setText("Saldo em Conta: R$" + conta.getSaldo());
							registro.saveFile();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					} else {
						JOptionPane.showMessageDialog(null, "Saldo em conta insuficiente para realizar a transação.");
						textTransf.setBackground(Color.RED);
					}
				} else {
					JOptionPane.showMessageDialog(null, "CPF digitado não foi cadastrado ou referencia a própria conta.");
					textCPF.setBackground(Color.RED);
				}

			}
		});

		return panel;

	}

	private JPanel getPanelHistorico(JPanel panel) {

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(16, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(97)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(32, Short.MAX_VALUE)));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE));

		DefaultListModel<String> listModel = new DefaultListModel();

		for (String s : conta.getExtratoString()) {

			listModel.addElement(s);

		}

		JList list = new JList(listModel);
		scrollPane.setViewportView(list);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer();
		renderer.setHorizontalAlignment(JLabel.CENTER);

		return panel;

	}

}
