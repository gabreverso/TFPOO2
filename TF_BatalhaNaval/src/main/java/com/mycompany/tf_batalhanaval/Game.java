package com.mycompany.tf_batalhanaval;

import java.util.Random;

public class Game {

    private static Game instance;
    private final int tamanho = 6;
    private final char EMPTY_CELL = '~';
    private final char[][] tabuleiroJogador1; // tabuleiros
    private final char[][] tabuleiroJogador2;
    private final EstadoJogo estadoAtual;
    private final GameObserver observer;

    private boolean jogoAcabou = false; 
    private int jogadorVencedor = -1;

    // Construtor privado para impedir instanciação direta
    Game(GameObserver observer) {
        this.observer = observer;
        this.tabuleiroJogador1 = new char[tamanho][tamanho];
        this.tabuleiroJogador2 = new char[tamanho][tamanho];
        this.estadoAtual = EstadoJogo.VEZ_JOGADOR_1;

        // Inicializa os tabuleiros com células vazias
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                tabuleiroJogador1[i][j] = EMPTY_CELL;
                tabuleiroJogador2[i][j] = EMPTY_CELL;
            }
        }
    }

    // Método estático para obter a instância única do jogo
    public static Game getInstance(GameObserver observer) {
        if (instance == null) {
            instance = new Game(observer);
        }
        return instance;
    }

    public char[][] getTabuleiroJogador1() {
        return tabuleiroJogador1;
    }

    public char[][] getTabuleiroJogador2() {
        return tabuleiroJogador2;
    }

    public EstadoJogo getEstadoAtual() {
        return estadoAtual;
    }

    // Método para executar um ataque em uma posição específica
    public void executarAtaque(AtaquePosicao ataque) {
        ataque.execute();
    }

    public void atacar(int jogador, int row, int col) {
        char[][] tabuleiroAlvo = (jogador == 1) ? tabuleiroJogador2 : tabuleiroJogador1;
        // Lógica de ataque
        // Exemplo: tabuleiroAlvo[row][col] = 'X';
    }

    public void adicionarNaviosAleatorios(int jogador) {
        char[][] tabuleiro = (jogador == 1) ? tabuleiroJogador1 : tabuleiroJogador2;
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int x = random.nextInt(tamanho);
            int y = random.nextInt(tamanho);
            tabuleiro[x][y] = 'N';
        }
    }

    public void verificarVitoria() {
        boolean jogador1Venceu = true;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (tabuleiroJogador2[i][j] == 'N') {
                    jogador1Venceu = false;
                    break;
                }
            }
            if (!jogador1Venceu) {
                break;
            }
        }

        boolean jogador2Venceu = true;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (tabuleiroJogador1[i][j] == 'N') {
                    jogador2Venceu = false;
                    break;
                }
            }
            if (!jogador2Venceu) {
                break;
            }
        }

        if (jogador1Venceu) {
            jogoAcabou = true;
            jogadorVencedor = 1;
        } else if (jogador2Venceu) {
            jogoAcabou = true;
            jogadorVencedor = 2;
        }
    }
    
    public boolean jogoAcabou() {
        return jogoAcabou;
    }

    
    public int getJogadorVencedor() {
        return jogadorVencedor;
    }
}
