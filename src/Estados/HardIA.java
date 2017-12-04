/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import batalhanaval.Tabuleiro;
import java.awt.Point;
import java.util.Random;

/**
 *
 * @author Alef
 */
public class HardIA extends IA {

    private boolean gerarRandom;
    private boolean procuraHorizontal;
    private static int AGUA = 99;
    private int nAcertos;
    private Point vizinho;
    private int ultimoX, ultimoY, xInicial, yInicial;

    public HardIA() {
        this.gerarRandom = true;
        this.procuraHorizontal = true;
        this.vizinho = DIREITA;
        this.ultimoX = AGUA;
        this.ultimoY = AGUA;

    }

    @Override
    public void fazerJogada(Tabuleiro tab) {
        if (gerarRandom) {
            Random generator = new Random();
            int xRand = 0;
            int yRand = 0;
            boolean jogada = false;

            while (!jogada) {
                xRand = generator.nextInt(10);
                yRand = generator.nextInt(10);

                if (tab.getPosition(xRand, yRand) >= 1 && tab.getPosition(xRand, yRand) <= 5) {
                    tab.setPosition(xRand, yRand, 9);
                    xInicial = xRand;
                    yInicial = yRand;
                    ultimoX = xRand;
                    ultimoY = yRand;
                    gerarRandom = false;
                    this.nAcertos++;
                    jogada = true;
                } else {
                    if (tab.getPosition(xRand, yRand) != 13 && tab.getPosition(xRand, yRand) != 9) {
                        tab.setPosition(xRand, yRand, 13);
                        jogada = true;
                    }
                }
            }

        } else {
            
            if (procuraHorizontal) {
                if (atirarVizinho(ultimoX + DIREITA.x, ultimoY + DIREITA.y, tab)) {
                    return;
                }

                if (atirarVizinho(ultimoX + ESQUERDA.x, ultimoY + ESQUERDA.y, tab)) {
                    return;
                }
                
                if(nAcertos == 1){
                    procuraHorizontal = false;
                    fazerJogada(tab);
                    return;
                }
            } else {
                if (atirarVizinho(ultimoX + CIMA.x, ultimoY + CIMA.y, tab)) {
                    return;
                }

                if (atirarVizinho(ultimoX + BAIXO.x, ultimoY + BAIXO.y, tab)) {
                    return;
                }

                // Verifica se é o barco de tamanho 1
                if (nAcertos == 1) {
                    gerarRandom = true;
                    procuraHorizontal = true;
                    this.nAcertos = 0;
                    fazerJogada(tab);
                    return;
                }
            }
            
            gerarRandom = true;
            procuraHorizontal = true;
            this.nAcertos = 0;
            fazerJogada(tab);
            return;
        }
    }

    private boolean atirarVizinho(int x, int y, Tabuleiro tab) {
        if ((x < 0 || x >= tab.getTam()) || (y < 0 || y >= tab.getTam())) {
            ultimoX = xInicial;
            ultimoY = yInicial;
            return false;
        }

        int positionInTab = tab.getPosition(x, y);

        if (positionInTab >= 1 && positionInTab <= 5) {
            tab.setPosition(x, y, 9);
            ultimoX = x;
            ultimoY = y;
            this.nAcertos++;
            return true;

        } else {

            if (positionInTab == 0) {
                tab.setPosition(x, y, 13);
                ultimoX = xInicial;
                ultimoY = yInicial;
                return true;
            }
        }

        if(positionInTab == 13){
            ultimoX = xInicial;
            ultimoY = yInicial;
        }
        return false;
    }
}
