/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package batalhanaval;

import batalhanaval.Barco;
import batalhanaval.Seletor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alef
 */
public abstract class JogadorGenerico {
    private String nome;
    private int pontuacao;
    private Seletor seletor;
    private List<Barco> listaBarcos = new ArrayList<Barco>();
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Seletor getSeletor() {
        return seletor;
    }

    public void setSeletor(Seletor seletor) {
        this.seletor = seletor;
    }
    
    public void iniciarBarcos(int x, int y){
        listaBarcos.add(new Barco(1, 0, 16));
        listaBarcos.add(new Barco(2, 1, 32));
        listaBarcos.add(new Barco(3, 2, 48));
        listaBarcos.add(new Barco(4, 3, 64));
        listaBarcos.add(new Barco(5, 4, 80));
        
        for (Barco barco : listaBarcos) {
            barco.setxPixel(x);
            barco.setyPixel(y);
        }
    }

    public List<Barco> getListaBarcos() {
        return listaBarcos;
    }
    
}
