/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.tf_batalhanaval;

/**
 *
 * @author gabri
 */
public interface NavioFactory {
    Navio criarNavio(TipoNavio tipo);
    Navio criarNavioAleatorio();
    
}
