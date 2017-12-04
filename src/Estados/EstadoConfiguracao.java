/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import Actions.AcaoEscolher;
import Actions.AcaoMover;
import static Estados.Estado.BAIXO;
import static Estados.Estado.CIMA;
import batalhanaval.Seletor;
import batalhanaval.Tabuleiro;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Alef
 */
public class EstadoConfiguracao extends Estado{
    private Tabuleiro tabuleiro;
    private Seletor sel;
    private Estado estadoAnterior;
    
    @Override
    public void iniciarEstado() {
        tabuleiro = new Tabuleiro(2);
        sel = new Seletor(7);
        
        tabuleiro.setxPixel(310);
        tabuleiro.setyPixel(295);
        
        super.getBc().setTabJogador(tabuleiro);
        setTabAtual(tabuleiro);
        
        super.setEntidadeAtual(sel);
        setInputHdl();
        super.getBc().setInputHdl(super.getInputHandler());
        
        sel.setX(0);
        sel.setY(0);
        sel.setTamanhoImg(16);
        this.setEntidadeAtual(sel);
        
        super.setTabAtual(tabuleiro);
        super.getView().setTabAtual(tabuleiro);
        super.getView().setEtd(sel);
        super.getView().setVencedor(super.getBc().getGanhador());
        super.getView().setWinner(true);
        
        desenhar();
    }

    @Override
    void setInputHdl() {
        super.getInputHandler().limparMapa();
        super.getInputHandler().setAction(KeyEvent.VK_UP, new AcaoMover(this, CIMA, super.getTabAtual()));
        super.getInputHandler().setAction(KeyEvent.VK_DOWN, new AcaoMover(this, BAIXO, super.getTabAtual()));
        super.getInputHandler().setAction(KeyEvent.VK_ENTER, new AcaoEscolher(this, super.getTabAtual()));
    }

    @Override
    void desenhar() {
        super.getView().setFocusable(true);
        super.getView().setSize(super.sizeX, super.sizeY);
        super.getView().setBackground(Color.BLUE);
        super.getView().setDrawTab(true);
        super.getView().setBackground(15);
        super.getView().setDrawTab(false);
        super.getView().setWinner(false);
        super.getView().setInicio(false);
        super.getView().setConfig(true);

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

    @Override
    void iniciarAtributos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estado trocarEstado() {
        return estadoAnterior;
    }

    @Override
    public void definirOpcao(int op) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(super.getView());
        
        switch(op){
            case 0:
                frame.dispose();
                super.getBc().setMaquina(new EasyIA());
                super.getBc().setAtualizarMaquina(false);
                super.getBc().atualizarEstado();
                break;
            case 1:
                frame.dispose();
                super.getBc().setMaquina(new HardIA());
                super.getBc().setAtualizarMaquina(false);
                super.getBc().atualizarEstado();
                break;
        }
    }

    public Estado getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(Estado estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }
}
