/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.tf_batalhanaval;

/**
 *
 * @author gabri
 */
public enum TipoNavio {

    PORTA_AVIOES("Porta-Aviões", 5),
    ENCOURACADO("Encouraçado", 4),
    DESTROYER("Destroyer", 3),
    SUBMARINO("Submarino", 3),
    PATRULHA("Patrulha", 2);

    private final String nome;
    private final int tamanho;

    TipoNavio(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public int getTamanho() {
        return tamanho;
    }

}
