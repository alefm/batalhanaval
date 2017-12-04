/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import batalhanaval.Entidade;


/**
 *
 * @author Alef
 */
public abstract class Acao {
    
   public abstract void run();
   
   /**
     * Metodo responsável por verificar se uma posicao que será movida é valida
     * @param dx
     * @param dy
     */
    public static boolean verificarPosicao(Entidade entidade, int dx, int dy, int tamTab){
        int somaX = 0;
        int somaY = 0;
        int somaHorizontal = entidade.getX() + dx;
        int somaVertical = entidade.getY() + dy;
        
        if(entidade.isVertical()){
            somaX = entidade.getX() + dx;
            somaY = entidade.getY() + dy + entidade.getTamanho() - 1; 
            
        } else {
            somaX = entidade.getX() + dx + entidade.getTamanho() - 1;
            somaY = entidade.getY() + dy;
        }
        if(somaX >= 0 && somaX < tamTab && somaHorizontal >= 0 && somaY >= 0 && somaY < tamTab && somaVertical >= 0){
            return true;
        }
        
        return false;
    }
}
