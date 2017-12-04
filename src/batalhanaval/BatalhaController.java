/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalhanaval;

import Actions.InputHandler;
import Estados.EasyIA;
import Estados.Estado;
import Estados.EstadoInicial;
import Estados.HardIA;
import view.KAdapter;
import view.ViewController;


/**
 *
 * @author Alef
 */
public class BatalhaController{
    // private Estado estadoAtual = new EstadoDefinirBarco();
    private Estado estadoAtual = new EstadoInicial();
    private InputHandler inputHdl;
    private KAdapter adapter = new KAdapter();
    
    private Tabuleiro tabJogador, tabMaquina, tabAtual;
    private JogadorGenerico jogador, maquina, jogadorAtual, ganhador;
    private boolean atualizarMaquina = true;
    
    private ViewController view = new ViewController();

    public BatalhaController() {
        iniciarTabuleiros();
        iniciarJogadores();
        iniciarView();
        iniciarEstados();
        iniciar();
    }
    
    public void trocarTab(){
        if(tabAtual == tabJogador){
            tabAtual = tabMaquina;
        } else {
            tabAtual = tabJogador;
        }
        view.setTabAtual(tabAtual);
        estadoAtual.setTabAtual(tabAtual);
    }

    private void iniciar(){
        adapter.setInputhdl(inputHdl);
        adapter.setView(view);
        
        view.setKeyAdapter(adapter);
        view.keyListener();
    }
    
    /**
     * Metodo chamado para atualizar o estado atual
     */
    public void atualizarEstado(){
        estadoAtual = estadoAtual.trocarEstado();
        iniciarEstados();
        repaint();
    }
    
    /**
     * Metodo responsável por dar o repaint na tela.
     */
    private void repaint(){
        view.repaint();
    }
    
    
    /**
     * Metodo responsável por iniciar todos os atributos da view.
     */
    private void iniciarView(){
        view.setJogadorAtual(jogadorAtual);
        view.setJogador(jogador);
        view.setMaquina(maquina);
        
        view.setTabAtual(tabAtual);
        view.setTabJogador(tabJogador);
        view.setTabMaquina(tabMaquina);
    }
    
    /**
     * Metodo responsável por iniciar e/ou atualizar algum novo estado.
     */
    private void iniciarEstados(){
        estadoAtual.setBc(this);
        
        estadoAtual.setView(view);
        estadoAtual.setJogador(jogador);
        estadoAtual.setMaquina(maquina);
        estadoAtual.setJogadorAtual(jogadorAtual);
        
        estadoAtual.setTabAtual(tabAtual);
        estadoAtual.setTabJogador(tabJogador);
        estadoAtual.setTabMaquina(tabMaquina);
        
        // INICIA O ESTADO
        estadoAtual.iniciarEstado();
        inputHdl = estadoAtual.getInputHandler();
        adapter.setInputhdl(inputHdl);
    }
    
    private void iniciarTabuleiros(){
        tabJogador = new Tabuleiro(10);
        tabAtual = new Tabuleiro(10);
        tabMaquina = new Tabuleiro(10);
        
        tabJogador.setxPixel(63);
        tabJogador.setyPixel(161);
        
        tabMaquina.setxPixel(447);
        tabMaquina.setyPixel(158);
        
        tabAtual = tabJogador;
    }
    
    /**
     * Metodo responsável por iniciar todas as inforamções dos jogadores
     */
    private void iniciarJogadores(){
        jogador = new Jogador();
        if(atualizarMaquina){
            maquina = new EasyIA();
        }
        
        jogador.setSeletor(new Seletor(7));
        maquina.setSeletor(new Seletor(7));
        
        //Jogador
        jogador.getSeletor().setxPixel(63);
        jogador.getSeletor().setyPixel(161);
        
        //Jogador 2 - Maquina
        maquina.getSeletor().setxPixel(447);
        maquina.getSeletor().setyPixel(158);
        
        jogadorAtual = jogador;
        
        //INICIA BARCOS
        jogador.iniciarBarcos(tabJogador.getxPixel(), tabJogador.getyPixel());
        maquina.iniciarBarcos(tabMaquina.getxPixel(), tabMaquina.getyPixel());
    }
    
    public void zerarJogo(){
        iniciarTabuleiros();
        iniciarJogadores();
        this.ganhador = null;
        iniciarView();
    }

    public JogadorGenerico getGanhador() {
        return ganhador;
    }

    public void setGanhador(JogadorGenerico ganhador) {
        this.ganhador = ganhador;
    }

    public void setInputHdl(InputHandler inputHdl) {
        this.inputHdl = inputHdl;
    }

    public void setTabAtual(Tabuleiro tabAtual) {
        this.tabAtual = tabAtual;
    }

    public void setTabJogador(Tabuleiro tabJogador) {
        this.tabJogador = tabJogador;
    }

    public void setMaquina(JogadorGenerico maquina) {
        this.maquina = maquina;
    }

    public JogadorGenerico getMaquina() {
        return maquina;
    }

    public boolean isAtualizarMaquina() {
        return atualizarMaquina;
    }

    public void setAtualizarMaquina(boolean atualizarMaquina) {
        this.atualizarMaquina = atualizarMaquina;
    }
}
