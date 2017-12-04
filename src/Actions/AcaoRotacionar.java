/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Estados.EstadoDefinirBarco;
import batalhanaval.Entidade;

/**
 *
 * @author Alef
 */
public class AcaoRotacionar extends Acao{
    private Entidade entidade;
    private EstadoDefinirBarco estado;

    public AcaoRotacionar(EstadoDefinirBarco estado) {
        this.estado = estado;
        this.entidade = estado.getEntidadeAtual();
    }
    
    @Override
    public void run() {
        this.entidade = estado.getEntidadeAtual();
        if(entidade.isVertical()){
            if(verifRotacao()){
                entidade.setVertical(false);
            }
        } else {
            if(verifRotacao()){
                entidade.setVertical(true);
            }
        }
        estado.setEntidadeAtual(entidade);
        estado.getView().setEtd(entidade);
        estado.getView().repaint();
    }
    
    /**
     * Metodo responsável por saber se é possivel rotacionar ou não o barco na sua posicao atual.
     * @return 
     */
    private boolean verifRotacao(){
        int x = entidade.getX();
        int y = entidade.getY();
        int tam = estado.getTabAtual().getTam();
        
        if(entidade.isVertical()){
            if((x + entidade.getTamanho()) > tam){
                return false;
            }
        } else {
            if((y + entidade.getTamanho()) > tam){
                return false;
            }
        }
        
        return true;
    }
    
}
