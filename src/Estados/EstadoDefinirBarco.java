/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Actions.Acao;
import Actions.AcaoDefinirFrota;
import Actions.AcaoMover;
import Actions.AcaoRotacionar;
import static Estados.Estado.BAIXO;
import static Estados.Estado.CIMA;
import static Estados.Estado.DIREITA;
import static Estados.Estado.ESQUERDA;
import batalhanaval.Barco;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Alef
 */
public class EstadoDefinirBarco extends Estado {

    private int contador;
    private Barco barco;

    public EstadoDefinirBarco() {
        iniciarAtributos();
    }

    @Override
    public void iniciarEstado() {
        super.getJogador().setNome(JOptionPane.showInputDialog("Digite o nome do jogador: "));
        super.getView().setBackground(5);
        proxBarco();
        setInputHdl();
        desenhar();
    }

    @Override
    void iniciarAtributos() {
        this.contador = 0;
    }

    @Override
    void setInputHdl() {
        super.getInputHandler().limparMapa();

        super.getInputHandler().setAction(KeyEvent.VK_UP, new AcaoMover(this, CIMA, super.getTabAtual()));
        super.getInputHandler().setAction(KeyEvent.VK_DOWN, new AcaoMover(this, BAIXO, super.getTabAtual()));
        super.getInputHandler().setAction(KeyEvent.VK_LEFT, new AcaoMover(this, ESQUERDA, super.getTabAtual()));
        super.getInputHandler().setAction(KeyEvent.VK_RIGHT, new AcaoMover(this, DIREITA, super.getTabAtual()));
        super.getInputHandler().setAction(KeyEvent.VK_ENTER, new AcaoDefinirFrota(this, super.getTabAtual()));
        super.getInputHandler().setAction(KeyEvent.VK_SPACE, new AcaoRotacionar(this));
    }

    @Override
    void desenhar() {
        super.getView().setFocusable(true);
        super.getView().setSize(super.sizeX, super.sizeY);
        super.getView().setBackground(Color.BLUE);
        super.getView().setDrawTab(true);

        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("Batalha Naval");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(super.getView());
        frame.setSize(sizeX, sizeY);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.BLUE);
        frame.setVisible(true);

    }

    /**
     * Metodo responsável por chamar o proximo barco que será definido no
     * tabuleiro.
     */
    public void proxBarco() {
        if (contador < super.getJogadorAtual().getListaBarcos().size()) {
            barco = super.getJogadorAtual().getListaBarcos().get(contador);
            super.setEntidadeAtual(barco);
            super.getView().setEtd(barco);
            super.getView().repaint();
            contador++;
        } else {
            definirFrotaMaquina();
            super.getBc().trocarTab();
            super.getBc().atualizarEstado();;
        }
    }

    /**
     * Metodo responsável por definir a posicao dos barcos da maquina
     */
    public void definirFrotaMaquina() {
        Random generator = new Random();
        for (Barco barco : super.getMaquina().getListaBarcos()) {
            int xRand = 0;
            int yRand = 0;
            boolean posicao = false;
            boolean ativarPosicao = true;

            while (!posicao) {
                xRand = generator.nextInt(9) + 1;
                yRand = generator.nextInt(9) + 1;

                if (Acao.verificarPosicao(barco, xRand, yRand, super.getTabMaquina().getTam())) {
                    // SE A POSICAO JÁ ESTÁ PREENCHIDA
                    if (super.getTabMaquina().getPosition(xRand, yRand) != 0) {
                        continue;
                    }

                    for (int i = 1; i <= barco.getTamanho(); i++) {
                        ativarPosicao = true;

                        if (barco.isVertical()) {

                            // SE A SOMA DO RAND + TAMANHO DO BARCO ULTRAPASSA O TAMANHO DO TABULEIRO
                            if ((yRand + i) >= super.getTabMaquina().getTam()) {
                                ativarPosicao = false;
                                break;
                            }

                            // SE O TAMANHO DO BARCO NAO VAI SOBRESCREVER OUTRO
                            if (super.getTabMaquina().getPosition(xRand, yRand + i) != 0) {
                                ativarPosicao = false;
                                break;
                            }
                        } else {
                            
                            // SE A SOMA DO RAND + TAMANHO DO BARCO ULTRAPASSA O TAMANHO DO TABULEIRO
                            if ((xRand + i) >= super.getTabMaquina().getTam()) {
                                ativarPosicao = false;
                                break;
                            }

                            // SE O TAMANHO DO BARCO NAO VAI SOBRESCREVER OUTRO
                            if (super.getTabMaquina().getPosition(xRand + i, yRand) != 0) {
                                ativarPosicao = false;
                                break;
                            }
                        }
                    }

                    if (ativarPosicao) {
                        posicao = true;
                    }
                }
            }

            barco.setX(xRand);
            barco.setY(yRand);

            for (int i = 1; i <= barco.getTamanho(); i++) {
                if (barco.isVertical()) {
                    super.getTabMaquina().setPosition(barco.getX(), barco.getY() + i, barco.getTamanho());
                } else {
                    super.getTabMaquina().setPosition(barco.getX() + i, barco.getY(), barco.getTamanho());
                }
            }
        }
    }

    @Override
    public Estado trocarEstado() {
        return new EstadoJogo();
    }

    @Override
    public void definirOpcao(int op) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
