/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Estados;

import batalhanaval.JogadorGenerico;
import batalhanaval.Seletor;
import batalhanaval.Tabuleiro;
import java.awt.Point;

/**
 *
 * @author Alef
 */
public abstract class IA extends JogadorGenerico{
    private Seletor seletor;
    public final static Point CIMA = new Point(0, -1);
    public final static Point BAIXO = new Point(0, 1);
    public final static Point DIREITA = new Point(1, 0);
    public final static Point ESQUERDA = new Point(-1, 0); 
    
    abstract public void fazerJogada(Tabuleiro tab);

    public IA() {
        super.setNome("Computer");
    }
}
