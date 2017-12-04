/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import batalhanaval.JogadorGenerico;
import Actions.InputHandler;
import batalhanaval.BatalhaController;
import batalhanaval.Entidade;
import batalhanaval.Seletor;
import batalhanaval.Tabuleiro;
import java.awt.Point;
import view.ViewController;

/**
 *
 * @author Alef
 */
public abstract class Estado {
    
    /**
     * Tamanho do tabuleiro em pixels
     */
    protected final int sizeX = 800;
    protected final int sizeY = 532;
    
    public final static Point CIMA = new Point(0, -1);
    public final static Point BAIXO = new Point(0, 1);
    public final static Point DIREITA = new Point(1, 0);
    public final static Point ESQUERDA = new Point(-1, 0); 
    
    private BatalhaController bc;
    
    private boolean atualizaEstado = false;
    
    private InputHandler inputHandler = new InputHandler();
    private Seletor seletor = new Seletor();
    
    private Tabuleiro tabJogador, tabMaquina, tabAtual;
    private JogadorGenerico jogador, maquina, jogadorAtual;
    private Entidade entidadeAtual;
    private ViewController view;

    abstract public void iniciarEstado();
    
    abstract void setInputHdl();
    
    abstract void desenhar();
    
    abstract void iniciarAtributos();
    
    abstract public Estado trocarEstado();
    
    abstract public void definirOpcao(int op);
    

    public boolean isAtualizaEstado() {
        return atualizaEstado;
    }
    
    public void setAtualizaEstado(boolean atualizaEstado) {
        this.atualizaEstado = atualizaEstado;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public void setInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public Seletor getSeletor() {
        return seletor;
    }

    public void setSeletor(Seletor seletor) {
        this.seletor = seletor;
    }

    public JogadorGenerico getJogador() {
        return jogador;
    }

    public void setJogador(JogadorGenerico jogador) {
        this.jogador = jogador;
    }

    public JogadorGenerico getMaquina() {
        return maquina;
    }

    public void setMaquina(JogadorGenerico maquina) {
        this.maquina = maquina;
    }

    public JogadorGenerico getJogadorAtual() {
        return jogadorAtual;
    }

    public void setJogadorAtual(JogadorGenerico jogadorAtual) {
        this.jogadorAtual = jogadorAtual;
    }

    public ViewController getView() {
        return view;
    }

    public void setView(ViewController view) {
        this.view = view;
    }

    public Tabuleiro getTabJogador() {
        return tabJogador;
    }

    public void setTabJogador(Tabuleiro tabJogador) {
        this.tabJogador = tabJogador;
    }

    public Tabuleiro getTabMaquina() {
        return tabMaquina;
    }

    public void setTabMaquina(Tabuleiro tabMaquina) {
        this.tabMaquina = tabMaquina;
    }

    public Tabuleiro getTabAtual() {
        return tabAtual;
    }

    public void setTabAtual(Tabuleiro tabAtual) {
        this.tabAtual = tabAtual;
    }

    public void setBc(BatalhaController bc) {
        this.bc = bc;
    }

    public BatalhaController getBc() {
        return bc;
    }

    public Entidade getEntidadeAtual() {
        return entidadeAtual;
    }

    public void setEntidadeAtual(Entidade entidadeAtual) {
        this.entidadeAtual = entidadeAtual;
    }
}
