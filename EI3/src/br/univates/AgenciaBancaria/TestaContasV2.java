package br.univates.AgenciaBancaria;

import java.io.IOException;
import java.util.ArrayList;

import br.univates.AgenciaBancaria.apresentacao.Tela;
import br.univates.AgenciaBancaria.apresentacao.TelaInicialGUI;
import br.univates.AgenciaBancaria.negocio.ContaCorrente;
import br.univates.AgenciaBancaria.persistencia.RegistroContas;
import br.univates.system32.CPF;

public class TestaContasV2 {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		TelaInicialGUI t = new TelaInicialGUI();
		t.setVisible(true);;

	}

}
