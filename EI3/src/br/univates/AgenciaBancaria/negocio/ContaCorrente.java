package br.univates.AgenciaBancaria.negocio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import br.univates.system32.CPF;

public class ContaCorrente implements Serializable{

	private int idConta;
	private String nome;
	private CPF cpf = new CPF();
	private String senha;
	private double saldo;
	private ArrayList<Transacao> extrato = new ArrayList<Transacao>();
	
	public ContaCorrente(int id, String nome, long cpf, String senha,double depositoInicial) {
		
		this.idConta = id;
		this.depositar(depositoInicial);
		this.cpf.setCPF(cpf);
		this.nome = nome;
		this.senha = senha;
		
	}
	
	public ContaCorrente(int id, String nome, String cpf, String senha,double depositoInicial) {
		
		this.idConta = id;
		this.depositar(depositoInicial);
		this.cpf.setCPF(cpf);
		this.nome = nome;
		this.senha = senha;
		
	}
	
	public ContaCorrente(int id, String nome, long cpf, String senha) {
		
		this.idConta = id;
		this.cpf.setCPF(cpf);
		this.nome = nome;
		this.senha = senha;
		
	}
	
	public ContaCorrente(int id, String nome, String cpf, String senha) {
		
		this.idConta = id;
		this.cpf.setCPF(cpf);
		this.nome = nome;
		this.senha = senha;
		
	}
	
	
	public boolean depositar(double quant) {
		if(quant > 0) {
			this.saldo += quant;
			
			extrato.add(new Transacao(this, quant, new Date(System.currentTimeMillis()), 'd'));

			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean sacar(double quant) {
		if(this.saldo - quant < 0) {
			return false;
		}else {
			this.saldo -= quant;
			
			extrato.add(new Transacao(this, quant, new Date(System.currentTimeMillis()), 's'));

			return true;
		}
	}
	
	public boolean transferenciaDeFundos(double quant, ContaCorrente receptor) {
		if(this.saldo - quant < 0 || quant < 0) {
			return false;
		}else {
			this.saldo -= quant;
			receptor.depositarPorTransferencia(quant, this);
			
			extrato.add(new Transacao(this, receptor, quant, new Date(System.currentTimeMillis())));
			
			return true;
		}
	}
	
	public boolean depositarPorTransferencia(double quant, ContaCorrente contaOrigem) {
		if(quant > 0) {
			this.saldo += quant;
			
			extrato.add(new Transacao(contaOrigem, this, quant, new Date(System.currentTimeMillis())));

			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean pagarConta(double valorConta) {
		if(this.saldo - valorConta < 0) {
			return false;
		}else {
			this.saldo -= valorConta;
			
			extrato.add(new Transacao(this, valorConta, new Date(System.currentTimeMillis()), 'p'));
			
			return true;
		}
	}
	
	public ArrayList<String> getExtratoString() {
		
		ArrayList<String> extratoFull = new ArrayList<String>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    sdf.setTimeZone(TimeZone.getTimeZone("BRT"));
		
		for (Transacao transacao : extrato) {
			
			if(transacao.getTipo() == 't') {
				extratoFull.add(0, "********************************************");
				extratoFull.add(0, "");
				extratoFull.add(0, "Realizada em " + sdf.format(transacao.getData()));
				extratoFull.add(0, "Valor transferido: R$" + transacao.getValor());
				extratoFull.add(0, "Para: " + transacao.getRemetente().getNome() + ".");
				extratoFull.add(0, "De: "+ transacao.getAutor().getNome()+ "." );
				extratoFull.add(0, "---------------- TRANSFERÊNCIA: -----------------");
				extratoFull.add(0, "");
				
			}else if(transacao.getTipo() == 'd') {
				
				extratoFull.add(0, "********************************************");
				extratoFull.add(0, "");
				extratoFull.add(0, "Realizada em " + sdf.format(transacao.getData()));
				extratoFull.add(0, "Valor depositado: R$" + transacao.getValor());
				extratoFull.add(0, "De: "+ transacao.getAutor().getNome()+ "." );
				extratoFull.add(0, "---------------- DEPÓSITO: -----------------");
				extratoFull.add(0, "");
	
			}else if(transacao.getTipo() == 's') {
				
				extratoFull.add(0, "********************************************");
				extratoFull.add(0, "");
				extratoFull.add(0, "Realizada em " + sdf.format(transacao.getData()));
				extratoFull.add(0, "Valor retirado: R$" + transacao.getValor());
				extratoFull.add(0, "De: "+ transacao.getAutor().getNome()+ "." );
				extratoFull.add(0, "---------------- SAQUE: -----------------");
				extratoFull.add(0, "");
				
				
			}else if(transacao.getTipo() == 'p') {
				
				extratoFull.add(0, "********************************************");
				extratoFull.add(0, "");
				extratoFull.add(0, "Realizada em " + sdf.format(transacao.getData()));
				extratoFull.add(0, "Valor da conta: R$" + transacao.getValor());
				extratoFull.add(0, "De: "+ transacao.getAutor().getNome()+ "." );
				extratoFull.add(0, "---------------- PAGAMENTO: -----------------");
				extratoFull.add(0, "");
				
			}
			
		}
		
		return extratoFull;
		
	}
	
	public double  getSaldo() {
		return this.saldo;
	}

	public int getIdConta() {
		return idConta;
	}

	public String getNome() {
		return nome;
	}
	
	public String getCPFCompleto() {
		return cpf.getCPFString();
	}

	public long getCPFNumeros() {
		return cpf.getCPFNumbers();
	}
	
	public String getSenha() {
		return senha;
	}
	
	public ArrayList<Transacao> getEstrato() {
		return extrato;
	}
	
}
