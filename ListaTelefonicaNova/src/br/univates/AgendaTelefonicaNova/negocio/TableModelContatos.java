/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.AgendaTelefonicaNova.negocio;

import br.univates.AgendaTelefonicaNova.persistencia.ContatoDB;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Felipe
 */
public class TableModelContatos extends AbstractTableModel
{

    ContatoDB contatos = new ContatoDB();
    
    private String[] colunas = {"Nome", "Número"};

    @Override
    public String getColumnName(int column)
    {
        return colunas[column];
    }
    
    @Override
    public int getRowCount()
    {
        return contatos.getListaSize();
    }

    @Override
    public int getColumnCount()
    {
       return colunas.length;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

        return false;

    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        switch(columnIndex){
            
            case 0:
                return contatos.getContatoByIndex(rowIndex).getNome();
            case 1:
                return contatos.getContatoByIndex(rowIndex).getNumero();
        }
        return null;  
        
    }
    
    public void deleteRow(int rowIndex) throws IOException{
        
        contatos.removeContato(contatos.getContatoByIndex(rowIndex));
        contatos.saveFile();
        this.fireTableDataChanged();
        
    }
    
    
    
    public void addRow(Contato contato){
        this.contatos.addContato(contato);
        this.fireTableDataChanged();
    }
    
    public boolean refreshTable() throws IOException, ClassNotFoundException{
        
        boolean hasFile = false;
        
        if(contatos.loadListaContatosFromFile()){
            hasFile = true;
            this.fireTableDataChanged();
        }
        
        return hasFile;
        
    }
    
}
