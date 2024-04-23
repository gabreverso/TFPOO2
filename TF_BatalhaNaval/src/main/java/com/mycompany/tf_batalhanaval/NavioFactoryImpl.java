/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tf_batalhanaval;

/**
 *
 * @author gabri
 */
import java.util.Random;

public class NavioFactoryImpl implements NavioFactory {
    
    private final Random random;

    public NavioFactoryImpl() {
        this.random = new Random();
    }

    @Override
    public Navio criarNavio(TipoNavio tipo) {
        return switch (tipo) {
            case PORTA_AVIOES -> new Navio("Porta-Aviões", 5);
            case ENCOURACADO -> new Navio("Encouraçado", 4);
            case DESTROYER -> new Navio("Destroyer", 3);
            case SUBMARINO -> new Navio("Submarino", 3);
            case PATRULHA -> new Navio("Patrulha", 2);
            default -> null;
        };
    }
    
    @Override
    public Navio criarNavioAleatorio() {
        TipoNavio[] tipos = TipoNavio.values();
        TipoNavio tipoAleatorio = tipos[random.nextInt(tipos.length)];
        return criarNavio(tipoAleatorio);
    }
}