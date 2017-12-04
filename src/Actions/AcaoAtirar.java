/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Estados.EstadoJogo;
import Estados.IA;
import batalhanaval.Entidade;
import batalhanaval.Tabuleiro;

/**
 *
 * @author Alef
 */
public class AcaoAtirar extends Acao{
    private Entidade entidade;
    private EstadoJogo estado;
    private Tabuleiro tabAtual;
    
    public AcaoAtirar(EstadoJogo estado, Tabuleiro tab) {
        this.entidade = estado.getEntidadeAtual();
        this.estado = estado;
        this.tabAtual = tab;
    }
    
    @Override
    public void run() {
        this.entidade = estado.getEntidadeAtual();
        if(super.verificarPosicao(entidade, 0, 0, tabAtual.getTam()) && tiroValido(entidade.getX(), entidade.getY())){
            
            if(tabAtual.getPosition(entidade.getX(), entidade.getY()) != 0){
                tabAtual.setPosition(entidade.getX(), entidade.getY(), 9);
            } else {
                tabAtual.setPosition(entidade.getX(), entidade.getY(), 13);
            }
            
            
            if(estado.verificaFinalGame()){
                estado.getBc().atualizarEstado();
            }
            
            estado.proxJogador();
            estado.getBc().trocarTab();
            estado.setInputHdl();
            
            if(estado.getJogadorAtual() instanceof IA && estado.getBc().getGanhador() == null){
                IA ia = (IA) estado.getMaquina();
                ia.fazerJogada(estado.getTabJogador());
                estado.proxJogador();
                estado.getBc().trocarTab();
                if(estado.verificaFinalGame()){
                    estado.getBc().atualizarEstado();
                }
                estado.setInputHdl();
            }
        }
    }
    
    /**
     * Metodo responsável por vertificar se um tiro é valido
     * @param x
     * @param y
     * @return 
     */
    public boolean tiroValido(int x, int y){
        if(x < 0 || x >= tabAtual.getTam() || y < 0 || y >= tabAtual.getTam()){
            return false;
        }
        
        if(tabAtual.getPosition(x, y) != 9 && tabAtual.getPosition(x, y) != 13){
            return true;
        }
        return false;
    }
    
}
