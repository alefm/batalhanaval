/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Estados;

import batalhanaval.Tabuleiro;
import java.util.Random;

/**
 *
 * @author Alef
 */
public class EasyIA extends IA{

    public EasyIA() {
        super.setNome("Computer");
    }

    @Override
    public void fazerJogada(Tabuleiro tab) {
        Random generator = new Random();
        int xRand = 0;
        int yRand = 0;
        boolean jogada = false;
        
        while(!jogada){
            xRand = generator.nextInt(10);
            yRand = generator.nextInt(10);
            
            if(tab.getPosition(xRand, yRand) >= 1 && tab.getPosition(xRand, yRand) <= 5){
                tab.setPosition(xRand, yRand, 9);
                jogada = true;
            } else {
                if(tab.getPosition(xRand, yRand) != 13 && tab.getPosition(xRand, yRand) != 9){
                    tab.setPosition(xRand, yRand, 13);
                    jogada = true;
                }
            }
        }
    }
    
}
