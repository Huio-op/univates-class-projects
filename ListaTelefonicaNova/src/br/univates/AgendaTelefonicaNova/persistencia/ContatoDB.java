package br.univates.AgendaTelefonicaNova.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import br.univates.AgendaTelefonicaNova.negocio.Contato;
import java.io.Serializable;

public class ContatoDB implements Serializable{

	private static ArrayList<Contato> listaContatos = new ArrayList<Contato>();

	public boolean addContato(Contato contato) {
		boolean ok = false;
		if (listaContatos.add(contato)) {
			ok = true;
		}
		return ok;
               
	}
        

	public boolean removeContato(Contato contato) {
		boolean ok = false;
		if (listaContatos.remove(contato)) {
			ok = true;
		}
		return ok;
	}
	
	public void saveFile() throws IOException {

            FileOutputStream fout = new FileOutputStream("ListaContatos.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(listaContatos);
            oos.close();
            fout.close();

	}

	public static Boolean loadListaContatosFromFile() throws IOException, ClassNotFoundException {

		boolean exists = false;
		File f = new File("ListaContatos.txt");
		if (f.exists()) {
			FileInputStream finp = new FileInputStream("ListaContatos.txt");
			ObjectInputStream ois = new ObjectInputStream(finp);
			listaContatos = (ArrayList<Contato>) ois.readObject();
			ois.close();
			finp.close();
			exists = true;
		}
		return exists;
	}
        
        public Contato getContatoByIndex(int index){
            if(index < listaContatos.size()){
                return this.listaContatos.get(index);
            }
            return null;
        }
        
        public int getListaSize(){
            return this.listaContatos.size();
        }
	
	private ArrayList<Contato> getRegistroArray(){
		return listaContatos;
	}

}
