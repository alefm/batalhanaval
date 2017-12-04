/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Alef
 */
public class ImagemController {
    private List<Image> listaImagens = new ArrayList<Image>();

    public ImagemController() {
        listaImagens.add(new ImageIcon("assets/1x1.png").getImage());           // 0
        listaImagens.add(new ImageIcon("assets/2x1.png").getImage());           // 1
        listaImagens.add(new ImageIcon("assets/3x1.png").getImage());           // 2
        listaImagens.add(new ImageIcon("assets/4x1.png").getImage());           // 3
        listaImagens.add(new ImageIcon("assets/5x1.png").getImage());           // 4
        listaImagens.add(new ImageIcon("assets/background.png").getImage());    // 5
        listaImagens.add(new ImageIcon("assets/board.png").getImage());         // 6
        listaImagens.add(new ImageIcon("assets/bomb.png").getImage());          // 7
        listaImagens.add(new ImageIcon("assets/fire1.png").getImage());         // 8
        listaImagens.add(new ImageIcon("assets/fire2.png").getImage());         // 9
        listaImagens.add(new ImageIcon("assets/fire3.png").getImage());         // 10
        listaImagens.add(new ImageIcon("assets/water.png").getImage());         // 11
        listaImagens.add(new ImageIcon("assets/red-water.png").getImage());     // 12
        listaImagens.add(new ImageIcon("assets/grey-water.png").getImage());    // 13
        listaImagens.add(new ImageIcon("assets/yellow-water.png").getImage());  // 14
        listaImagens.add(new ImageIcon("assets/background-menu.png").getImage());// 15
    }
    
    /**
     * Metodo responsável por retornar uma das imagens da lista de imagens pré cadastradas.
     * @param indice da imagem na lista.
     * @return 
     */
    public Image getImage(int indice){
        return this.listaImagens.get(indice);
    }
}
