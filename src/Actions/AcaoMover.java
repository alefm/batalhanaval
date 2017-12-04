/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Estados.Estado;
import Estados.EstadoConfiguracao;
import Estados.EstadoFimJogo;
import Estados.EstadoInicial;
import batalhanaval.Entidade;
import batalhanaval.Tabuleiro;
import java.awt.Point;

/**
 *
 * @author Alef
 */
public class AcaoMover extends Acao {
    private Point direcao;
    private Entidade entidade;
    private Tabuleiro tabAtual;
    private Estado estado;

    public AcaoMover(Estado estado, Point direcao, Tabuleiro tab) {
        this.entidade = estado.getEntidadeAtual();
        this.direcao = direcao;
        this.tabAtual = tab;
        this.estado = estado;
    }
    
    @Override
    public void run() {
        this.entidade = estado.getEntidadeAtual();
        if(super.verificarPosicao(entidade, direcao.x, direcao.y, tabAtual.getTam())){
            
            if((estado instanceof EstadoInicial) || (estado instanceof EstadoFimJogo)){
                entidade.mover(direcao.x, direcao.y);
                
                switch(entidade.getY()){
                    case 0:
                        tabAtual.setxPixel(310);
                        tabAtual.setyPixel(235);
                        break;
                    case 1:
                        tabAtual.setxPixel(220);
                        tabAtual.setyPixel(274);
                        break;
                    case 2:
                        tabAtual.setxPixel(320);
                        tabAtual.setyPixel(315);
                        break;
                }
            } else if(estado instanceof EstadoConfiguracao){
                entidade.mover(direcao.x, direcao.y);
                
                switch(entidade.getY()){
                    case 0:
                        tabAtual.setxPixel(310);
                        tabAtual.setyPixel(295);
                        break;
                    case 1:
                        tabAtual.setxPixel(295);
                        tabAtual.setyPixel(335);
                        break;
                }
            } else {
                entidade.mover(direcao.x, direcao.y);
            }
        }
    }
    
    
}
