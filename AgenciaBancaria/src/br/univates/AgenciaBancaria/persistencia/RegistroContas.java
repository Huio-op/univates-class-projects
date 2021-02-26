package br.univates.AgenciaBancaria.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.univates.AgenciaBancaria.negocio.ContaCorrente;

public class RegistroContas implements Serializable{

	private static ArrayList<ContaCorrente> contasReg = new ArrayList<ContaCorrente>();
	
	public boolean addConta(ContaCorrente conta) {
		boolean ok = false;
		if(contasReg.add(conta)) {
			ok = true;
		}
		return ok;
	}
	
	public boolean removeConta(ContaCorrente conta) {
		boolean ok = false;
		if(contasReg.remove(conta)) {
			ok = true;
		}
		return ok;
	}
	
	public ContaCorrente getContaAt(int index) {
		if(index < 0 || index > contasReg.size()) {
			return null;
		}else {
			return contasReg.get(index);
		}
		
	}
	
	public boolean hasConta(String cpf) {
		boolean cpfValid = false;
		for(int i = 0; i < this.getSize(); i++) {
			if(cpf.equals(getContaAt(i).getCPFCompleto())) {
				cpfValid = true; 
			}
		}
		
		return cpfValid;
		
	}
	
	public ContaCorrente getContaByCPF(String cpf) {
		ContaCorrente c = null;
		for(int i = 0; i < this.getSize(); i++) {
			if(cpf.equals(getContaAt(i).getCPFCompleto())) {
				c = getContaAt(i);
			}
		}
		return c;
	}
	
	public void saveFile() throws IOException {
		
		FileOutputStream fout = new FileOutputStream("RegistroContas.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(contasReg);
		oos.close();
		fout.close();
		
	}
	
	public static Boolean loadRegistroContasFromFile() throws IOException, ClassNotFoundException {
		
		boolean exists = false;
		File f = new File("RegistroContas.txt");
		
		if(f.exists()) {
			
			FileInputStream finp = new FileInputStream("RegistroContas.txt");
			ObjectInputStream ois = new ObjectInputStream(finp);
			contasReg =  (ArrayList<ContaCorrente>) ois.readObject();
			ois.close();
			finp.close();
			exists = true;
		}
		return exists;
	}
	
	private ArrayList<ContaCorrente> getRegistroArray(){
		return contasReg;
	}
	
	public int getSize() {
		return contasReg.size();
	}
	
}
