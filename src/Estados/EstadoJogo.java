/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Actions.AcaoAtirar;
import Actions.AcaoMover;
import batalhanaval.Tabuleiro;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Alef
 */
public class EstadoJogo extends Estado{
    
    public EstadoJogo() {
    }
    
    @Override
    public void iniciarEstado(){
        
        super.setEntidadeAtual(super.getJogadorAtual().getSeletor());
        super.getView().setEtd(super.getEntidadeAtual());
        
        setInputHdl();
        super.getView().setBackground(5);
        super.getJogadorAtual().getSeletor().setImagem(7);
        super.getJogadorAtual().getSeletor().setTamanho(1);
        super.getJogadorAtual().getSeletor().setTamanhoImg(16);
        super.getJogadorAtual().getSeletor().setxPixel(super.getTabAtual().getxPixel());
        super.getJogadorAtual().getSeletor().setyPixel(super.getTabAtual().getyPixel());
        desenhar();
    }
    
    @Override
    void iniciarAtributos() {
        
    }
    
    
    @Override
    public void setInputHdl(){        
        super.getInputHandler().limparMapa();
        
        super.getInputHandler().setAction(KeyEvent.VK_UP, new AcaoMover(this, CIMA, super.getTabAtual()));
        super.getInputHandler().setAction(KeyEvent.VK_DOWN, new AcaoMover(this, BAIXO, super.getTabAtual()));
        super.getInputHandler().setAction(KeyEvent.VK_LEFT, new AcaoMover(this, ESQUERDA, super.getTabAtual()));
        super.getInputHandler().setAction(KeyEvent.VK_RIGHT, new AcaoMover(this, DIREITA, super.getTabAtual()));
        super.getInputHandler().setAction(KeyEvent.VK_ENTER, new AcaoAtirar(this, super.getTabAtual()));
        super.getInputHandler().setAction(KeyEvent.VK_SPACE, new AcaoAtirar(this, super.getTabAtual()));
    }

    @Override
    public void desenhar() {
        
    }
    
    public boolean verificaFinalGame(){
        if(verificaGanhador(super.getTabJogador())){
            super.getBc().setGanhador(super.getMaquina());
            return true;
        } else {
            if(verificaGanhador(super.getTabMaquina())){
                super.getBc().setGanhador(super.getJogador());
                return true;
            }
        }
        return false;
    }
    
    public boolean verificaGanhador(Tabuleiro tab){
        for(int i = 0; i < tab.getTam(); i++){
            for(int j = 0; j < tab.getTam(); j++){
                if(tab.getPosition(i, j) >= 1 && tab.getPosition(i, j) <= 5){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Metodo responsável por alterar o jogador atual.
     */
    public void proxJogador(){
        if(super.getJogadorAtual() == super.getJogador()){
            super.setJogadorAtual(super.getMaquina());
        } else {
            super.setJogadorAtual(super.getJogador());
        }
        super.getView().setJogadorAtual(super.getJogadorAtual());
    }

    @Override
    public Estado trocarEstado() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(super.getView());
        frame.dispose();
        return new EstadoFimJogo();
    }

    @Override
    public void definirOpcao(int op) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

