package br.univates.AgendaTelefonicaNova.negocio;

import java.io.Serializable;

public class Contato implements Serializable
{

    private String nome;
    private String numero;

    public Contato(String nome, String numero)
    {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNumero()
    {
        return numero;
    }

    public String getNome()
    {
        return nome;
    }

    public void mudarNome(String novoNome)
    {
        this.nome = novoNome;
    }

    public void mudarNumero(String novoNumero)
    {
        this.numero = novoNumero;
    }

}
