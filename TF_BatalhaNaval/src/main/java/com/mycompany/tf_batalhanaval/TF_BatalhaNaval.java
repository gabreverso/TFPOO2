/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tf_batalhanaval;

/**
 *
 * @author gabri
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TF_BatalhaNaval extends JFrame implements ActionListener {

    private final JButton[][] player1Buttons;
    private final JButton[][] player2Buttons;
    private final Game game;
    private int currentPlayer;

    public TF_BatalhaNaval(Game game) {
        this.game = game;
        this.currentPlayer = 1;

        setTitle("Batalha Naval");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(1, 2));
        game.adicionarNaviosAleatorios(1);
        game.adicionarNaviosAleatorios(2);
        // Tabuleiro do jogador 1
        JPanel player1Panel = new JPanel(new GridLayout(6, 6));
        player1Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        player1Buttons = new JButton[6][6];
        adicionarNaviosAleatorios(player1Buttons);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(50, 50));
                button.setBackground(Color.WHITE);
                int finalI = i;
                int finalJ = j;
                button.addActionListener(e -> {
                    if (currentPlayer == 1) {
                        int row = finalI, col = finalJ;
                        game.atacar(currentPlayer, row, col);
                        updatePlayer1Board(row, col);
                    } else {
                        JOptionPane.showMessageDialog(this, "Aguarde sua vez!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    }
                });
                player1Buttons[i][j] = button;
                player1Panel.add(button);
            }
        }
        mainPanel.add(player1Panel);

        mainPanel.add(Box.createHorizontalStrut(20));

        // tabuleiro 2
        JPanel player2Panel = new JPanel(new GridLayout(6, 6));
        player2Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        player2Buttons = new JButton[6][6];
        adicionarNaviosAleatorios(player2Buttons);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(50, 50));
                button.setBackground(Color.WHITE);
                int finalI = i;
                int finalJ = j;
                button.addActionListener(e -> {
                    if (currentPlayer == 2) {
                        int row = finalI, col = finalJ;
                        game.atacar(currentPlayer, row, col);
                        updatePlayer2Board(row, col);
                    } else {
                        JOptionPane.showMessageDialog(this, "Aguarde sua vez!", "Atenção", JOptionPane.WARNING_MESSAGE);
                    }
                });
                player2Buttons[i][j] = button;
                player2Panel.add(button);
            }
        }
        mainPanel.add(player2Panel);

        getContentPane().add(mainPanel);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Implementação conforme necessário
    }

    private void updatePlayer1Board(int clickedRow, int clickedCol) {
        char[][] board = game.getTabuleiroJogador1();
        if (board[clickedRow][clickedCol] == '~') {
            player1Buttons[clickedRow][clickedCol].setText("x");
        } else {
            player1Buttons[clickedRow][clickedCol].setText(String.valueOf(board[clickedRow][clickedCol]));
        }
        game.verificarVitoria();
        if (game.jogoAcabou()) {
            int jogadorVencedor = game.getJogadorVencedor();
            JOptionPane.showMessageDialog(this, "Parabéns! Jogador " + jogadorVencedor + " venceu!", "Vitória", JOptionPane.INFORMATION_MESSAGE);
        }
        currentPlayer = 2;
    }

    private void updatePlayer2Board(int clickedRow, int clickedCol) {
        char[][] board = game.getTabuleiroJogador2();
        if (board[clickedRow][clickedCol] == '~') {
            player2Buttons[clickedRow][clickedCol].setText("x");
        } else {
            player2Buttons[clickedRow][clickedCol].setText(String.valueOf(board[clickedRow][clickedCol]));
        }
        game.verificarVitoria();
        if (game.jogoAcabou()) {
            int jogadorVencedor = game.getJogadorVencedor();
            JOptionPane.showMessageDialog(this, "Parabéns! Jogador " + jogadorVencedor + " venceu!", "Vitória", JOptionPane.INFORMATION_MESSAGE);
        }
        currentPlayer = 1;

    }

    // Método para adicionar navios aleatórios em um tabuleiro
    private void adicionarNaviosAleatorios(JButton[][] buttons) {
        Random random = new Random();
        NavioFactory factory = new NavioFactoryImpl();
        for (int i = 0; i < 5; i++) {
            int x = random.nextInt(6);
            int y = random.nextInt(6);
            if (buttons[x][y] != null) {
                Navio navio = factory.criarNavioAleatorio();
                buttons[x][y].setText(navio.getNome());
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game(new Registro());
        AtaquePosicao ataque = new AtaquePosicao(game, 1, 2, 3); // Ataque do jogador 1 na posição (2, 3)
        game.executarAtaque(ataque);

        SwingUtilities.invokeLater(() -> new TF_BatalhaNaval(game));
    }
}
