/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tf_batalhanaval;

/**
 *
 * @author gabri
 */
public class AtaquePosicao implements Command {
    private final Game game;
    private final int jogador;
    private final int row;
    private final int col;

    public AtaquePosicao(Game game, int jogador, int row, int col) {
        this.game = game;
        this.jogador = jogador;
        this.row = row;
        this.col = col;
    }

    @Override
    public void execute() {
        game.atacar(jogador, row, col);
    }
}
