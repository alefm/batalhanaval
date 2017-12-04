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
public class Tabuleiro {
    private int[][] board;
    private int tam;
    private int x;
    private int y;
    private int xPixel;
    private int yPixel;

    public Tabuleiro(int tam) {
        this.tam = tam;
        this.x = tam;
        this.y = tam;
        this.board = new int[tam][tam];
        iniciar();
    }
    
    private void iniciar(){
        for(int i = 0; i < tam; i++){
            for(int j = 0; j < tam; j++){
                this.board[i][j] = 0;
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    /**
     * Retornar o int dada a posição da matriz.
     * @param x 
     * @param y 
     */
    public int getPosition(int x, int y){
        return this.board[x][y];
    }
    
    /**
     * Metodo responsável por alterar o valor de uma posição da matriz.
     * @param x
     * @param y
     * @param value 
     */
    public void setPosition(int x, int y, int value){
        this.board[x][y] = value;
    }
    
    public void print() {
        for(int i = 0; i < tam; i++){
            for(int j = 0; j < tam; j++){
                System.out.print(board[j][i] + " ");
            }
            System.out.println("\n");
        }
    }
    
    public void zerarTabuleiro(){
        for(int i = 0; i < tam; i++){
            for(int j = 0; j < tam; j++){
                this.board[i][j] = 0;
            }
        }
    }
    
    /**
     * Metodo responsável por setar um tipo de int dentro do tabuleiro
     * @param tipo em inteiro que pode corresponder a um barco ou não
     * @param x posicao x da matriz
     * @param y posicao y da matriz
     */
    public void setBoard(int tipo, int x, int y){
        this.board[x][y] = tipo;
    }

    /**
     * Metodo responsavel por mover o x e y da matriz para uma posicao pre determinada
     * @param x posicao x da matriz
     * @param y posicao y da matriz
     */
    public void mover(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
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
}
