/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalhanaval;


/**
 *
 * @author Alef
 */
public class Barco extends Entidade{
    private boolean abatido;
    
    public Barco(int tamanho, int imagem, int tamanhoImg) {
        super.setTamanho(tamanho);
        super.setImagem(imagem);
        super.setTamanhoImg(tamanhoImg);
        this.abatido = false;
        super.setDraw(false);
        super.setVertical(false);
        super.setX(0);
        super.setY(0);
        
    }

    public boolean isAbatido() {
        return abatido;
    }

    public void setAbatido(boolean abatido) {
        this.abatido = abatido;
    }

}
