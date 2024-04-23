package com.mycompany.tf_batalhanaval;

/**
 *
 * @author gabri
 */
public class Registro implements GameObserver{      
    @Override
    public void update(EstadoJogo jogo) {
        switch(jogo){
            case VEZ_JOGADOR_1 -> System.out.println("Vez do jogador 1");
            case VEZ_JOGADOR_2 -> System.out.println("Vez do jogador 2");
            case VITORIA_JOGADOR_1 -> System.out.println("Vitoria do jogador 1");
            case VITORIA_JOGADOR_2 -> System.out.println("Vitoria do jogador 2");
            case EMPATE -> System.out.println("Empate");
            default -> throw new AssertionError(jogo.name());
        }
    }
}
