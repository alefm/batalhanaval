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
public class Entidade {
    private int x = 0;
    private int y = 0;
    private int xPixel;
    private int yPixel;
    private int dx;
    private int dy;
    private int imagem;
    private int tamanho = 1;
    private int tamanhoImg;
    private int tamanhoTab = 10;
    private boolean vertical;
    private boolean draw;
    private Tabuleiro tab;

    
    /**
     * Metodo responsável por mover a entidade.
     * @param dx distancia em x que a entidade será movida.
     * @param dy distancia em y que a entidade será movida.
     */
    public void mover(int dx, int dy) {
            this.x += dx;
            this.y += dy;

    }
    
//    /**
//     * Metodo recursivo responsável por verificar se as posicoes estão validas
//     * @param x
//     * @param xFinal
//     * @param y
//     * @param yFinal
//     * @return 
//     */
//    public boolean checaPosicao(int x, int xFinal, int y, int yFinal){
//        System.out.println(tab);
//        if(x == xFinal && y == yFinal && tab.getPosition(x, y) == 0){
//            return true;
//        }
//        
//        if(isVertical()){
//            return checaPosicao(x, xFinal, y+1, yFinal);
//        } else {
//            return checaPosicao(x+1, xFinal, y, yFinal);
//        }
//    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public int getxPixel() {
        return xPixel;
    }

    public void setxPixel(int xPixel) {
        this.xPixel = xPixel;
    }

    public int getyPixel() {
        return yPixel;
    }

    public void setyPixel(int yPixel) {
        this.yPixel = yPixel;
    }

    public int getTamanhoImg() {
        return tamanhoImg;
    }

    public void setTamanhoImg(int tamanhoImg) {
        this.tamanhoImg = tamanhoImg;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isVertical() {
        return vertical;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    public Tabuleiro getTab() {
        return tab;
    }

    public void setTab(Tabuleiro tab) {
        this.tab = tab;
    }

    public boolean isDraw() {
        return draw;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }
}
