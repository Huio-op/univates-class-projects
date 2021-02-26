package br.univates.AgenciaBancaria.apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import br.univates.system32.util.JNumberFormatField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import br.univates.AgenciaBancaria.persistencia.RegistroContas;
import br.univates.system32.MyComponents.JMyCPFField;
import javax.swing.JList;

public class TESTE extends Tela {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public TESTE() throws ParseException, ClassNotFoundException, IOException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		
		
		
		
		
		
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
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
		
		JLabel lblNome = new JLabel("FELIPE");
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

		JLabel lblSaldoNum = new JLabel("R$ ");
		lblSaldoNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSaldoNum.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JLabel lblNumConta = new JLabel("");
		lblNumConta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumConta.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JLabel lblCPFnum = new JLabel("");
		lblCPFnum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCPFnum.setFont(new Font("Times New Roman", Font.BOLD, 16));

		JLabel lblNumTransacoes = new JLabel("");
		lblNumTransacoes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumTransacoes.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JButton btnDelete = new JButton("Deletar Conta");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		
	}
}
