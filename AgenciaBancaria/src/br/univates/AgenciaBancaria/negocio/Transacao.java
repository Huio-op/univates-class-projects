package br.univates.AgenciaBancaria.negocio;

import java.io.Serializable;
import java.util.Date;

public class Transacao implements Serializable{
	
	private ContaCorrente autor;
	private ContaCorrente remetente;
	private double valor;
	private Date data;
	private char tipo; //  t = transferencia, d = depósito, s = saque, p = pagamento

	public Transacao(ContaCorrente autor, ContaCorrente remetente, double valor, Date data) {
		
		this.autor = autor;
		this.remetente = remetente;
		this.valor = valor;
		this.data = data;
		this.tipo = 't';
		
	}
	
	public Transacao(ContaCorrente autor, double valor, Date data, char tipo) {
		
		this.autor = autor;
		this.valor = valor;
		this.data = data;
		this.tipo = tipo;
		
	}

	public ContaCorrente getAutor() {
		return autor;
	}

	public ContaCorrente getRemetente() {
		return remetente;
	}

	public double getValor() {
		return valor;
	}

	public Date getData() {
		return data;
	}

	public char getTipo() {
		return tipo;
	}
	
}
