/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Estados.EstadoDefinirBarco;
import batalhanaval.Barco;
import batalhanaval.Entidade;
import batalhanaval.Tabuleiro;

/**
 *
 * @author Alef
 */
public class AcaoDefinirFrota extends Acao{
    private Entidade entidade;
    private EstadoDefinirBarco estado;
    private Tabuleiro tabAtual;

    public AcaoDefinirFrota(EstadoDefinirBarco estado, Tabuleiro tab) {
        this.entidade = estado.getEntidadeAtual();
        this.estado = estado;
        this.tabAtual = tab;
    }

    @Override
    public void run() {
        this.entidade = estado.getEntidadeAtual();
        
        if(entidade instanceof Barco){
            Barco barco = (Barco) entidade;
            estado.getView().setTamBarco(barco.getTamanhoImg());
            for(int i = 0; i < barco.getTamanho(); i++){
                if(barco.isVertical()){
                    tabAtual.setPosition(entidade.getX(), entidade.getY() + i, entidade.getTamanho());
                } else {
                    tabAtual.setPosition(entidade.getX() + i, entidade.getY(), entidade.getTamanho());
                } 
                entidade.setDraw(true);
            }
        }
        estado.proxBarco();
    }
}
