/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Actions.Acao;
import Actions.InputHandler;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Alef
 */
public class KAdapter extends KeyAdapter {
    private InputHandler inputhdl;
    private ViewController view;

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Acao acao = inputhdl.getAction(e.getKeyCode());
        if(acao != null){
            inputhdl.getAction(e.getKeyCode()).run();
            view.repaint();
        }
    }

    public void setInputhdl(InputHandler inputhdl) {
        this.inputhdl = inputhdl;
    }
    
    public void setView(ViewController view) {
        this.view = view;
    }
}
