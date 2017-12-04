/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import Estados.Estado;
import batalhanaval.Entidade;
import batalhanaval.Tabuleiro;

/**
 *
 * @author Alef
 */
public class AcaoEscolher extends Acao{
    private Entidade entidade;
    private Estado estado;
    private Tabuleiro tabAtual;
    
    public AcaoEscolher(Estado estado, Tabuleiro tab) {
        this.entidade = estado.getEntidadeAtual();
        this.estado = estado;
        this.tabAtual = tab;
    }

    @Override
    public void run() {
        estado.definirOpcao(entidade.getY());
    }
    
    
}
