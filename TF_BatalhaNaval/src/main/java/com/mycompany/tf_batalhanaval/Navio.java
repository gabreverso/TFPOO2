package com.mycompany.tf_batalhanaval;

/**
 *
 * @author gabri
 */
public class Navio {

    private TipoNavio tipo;
    private String nome;
    private int tamanho;
    private int vida;
    private boolean afundado;

    public Navio(int id, TipoNavio tipo, String nome, int tamanho, int vida) {
        this.tipo = tipo;
        this.nome = nome;
        this.tamanho = tamanho;
        this.vida = vida;
        this.afundado = false;
    }

    public Navio(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoNavio getTipo() {
        return tipo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public boolean isAfundado() {
        return afundado;
    }

    public void setAfundado(boolean afundado) {
        this.afundado = afundado;
    }

}
