/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import batalhanaval.JogadorGenerico;
import batalhanaval.Barco;
import batalhanaval.Entidade;
import batalhanaval.Tabuleiro;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Alef
 */
public class ViewController extends JPanel {

    private ImagemController imagens = new ImagemController();
    private KAdapter keyAdapter;
    private Entidade etd;

    private Tabuleiro tabJogador, tabMaquina, tabAtual;
    private JogadorGenerico jogadorAtual, jogador, maquina, vencedor;
    private boolean drawTab;
    private boolean winner;
    private boolean inicio;
    private boolean config;

    private int background;
    private int xPixels = 800;
    private int yPixels = 532;

    private int tamBarco = 0;
    private int ultimoBarco = 0;

    public ViewController() {
        drawTab = false;
        winner = false;
        config = false;
    }

    /**
     * Metodo responsável por adicionar um key listener nesse JPanel.
     */
    public void keyListener() {
        addKeyListener(keyAdapter);

        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX() + "-" + e.getY());
            }
        });

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackGround(g);

        if (drawTab) {
            drawTabuleiro(g);
            drawBarcos(g);
        } else if (winner) {
            drawWinner(g);
        } else if (inicio) {
            drawInicio(g);
        } else if (config) {
            drawConfig(g);
        }

        drawSeletor(g);
        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * Metodo responsável por desenhar o background
     *
     * @param g
     */
    private void drawBackGround(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(imagens.getImage(background), 0, 0, xPixels, yPixels, this);
    }

    /**
     * Metodo responsável por desenhar os barcos no tabuleiro.
     *
     * @param g
     */
    private void drawBarcos(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //Jogador
        for (Barco barco : jogador.getListaBarcos()) {
            if (barco.isDraw()) {
                if (!barco.isVertical()) {
                    g2d.drawImage(imagens.getImage(barco.getImagem()), tabJogador.getxPixel() + barco.getX() * 32, tabJogador.getyPixel() + barco.getY() * 32, barco.getTamanhoImg() * 2, 32, this);
                } else {
                    g2d.drawImage(rotate(imagens.getImage(barco.getImagem()), 90), tabJogador.getxPixel() + barco.getX() * 32, tabJogador.getyPixel() + barco.getY() * 32, 32, barco.getTamanhoImg() * 2, this);
                }
            }
        }

        //Maquina
        for (Barco barco : maquina.getListaBarcos()) {
            if (barco.isDraw()) {
                if (!barco.isVertical()) {
                    g2d.drawImage(imagens.getImage(barco.getImagem()), tabJogador.getxPixel() + barco.getX() * 32, tabJogador.getyPixel() + barco.getY() * 32, barco.getTamanhoImg() * 2, 32, this);
                } else {

                }
            }
        }
    }

    /**
     * Metodo responsável por desenhar o tabuleiro
     *
     * @param g
     */
    public void drawTabuleiro(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // JOGADOR
        for (int i = 0; i < tabJogador.getTam(); i++) {
            for (int j = 0; j < tabJogador.getTam(); j++) {

                switch (tabJogador.getPosition(i, j)) {
                    case 0:
                        g2d.drawImage(imagens.getImage(11), tabJogador.getxPixel() + i * 32, tabJogador.getyPixel() + j * 32, 32, 32, this);
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        g2d.drawImage(imagens.getImage(14), tabJogador.getxPixel() + i * 32, tabJogador.getyPixel() + j * 32, 32, 32, this);
                        break;
                    case 9:
                        g2d.drawImage(imagens.getImage(12), tabJogador.getxPixel() + i * 32, tabJogador.getyPixel() + j * 32, 32, 32, this);
                        break;
                    case 13:
                        g2d.drawImage(imagens.getImage(13), tabJogador.getxPixel() + i * 32, tabJogador.getyPixel() + j * 32, 32, 32, this);
                        break;

                }

                int elemento = tabJogador.getPosition(i, j);

                if (elemento != ultimoBarco) {
                    if (elemento >= 1 && elemento <= 5) {
//                        g2d.drawImage(imagens.getImage(elemento-1), etd.getxPixel() + i*32, etd.getyPixel() + j*32, tamBarco, 16, this);
//                        ultimoBarco = elemento;
                    }
                }

            }
        }

        // MAQUINA
        for (int i = 0; i < tabMaquina.getTam(); i++) {
            for (int j = 0; j < tabMaquina.getTam(); j++) {

                switch (tabMaquina.getPosition(i, j)) {
                    case 0:
                        g2d.drawImage(imagens.getImage(11), tabMaquina.getxPixel() + i * 32, tabMaquina.getyPixel() + j * 32, 32, 32, this);
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        if ("Alef".equalsIgnoreCase(getJogador().getNome())) {
                            g2d.drawImage(imagens.getImage(14), tabMaquina.getxPixel() + i * 32, tabMaquina.getyPixel() + j * 32, 32, 32, this);
                        } else {
                            g2d.drawImage(imagens.getImage(11), tabMaquina.getxPixel() + i * 32, tabMaquina.getyPixel() + j * 32, 32, 32, this);
                        }
                        break;
                    case 9:
                        g2d.drawImage(imagens.getImage(12), tabMaquina.getxPixel() + i * 32, tabMaquina.getyPixel() + j * 32, 32, 32, this);
                        break;
                    case 13:
                        g2d.drawImage(imagens.getImage(13), tabMaquina.getxPixel() + i * 32, tabMaquina.getyPixel() + j * 32, 32, 32, this);
                        break;

                }

            }
        }

    }

    /**
     * Metodo responsável por desenhar o seletor
     *
     * @param g
     */
    private void drawSeletor(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if(!etd.isVertical()){
            g2d.drawImage(imagens.getImage(etd.getImagem()), tabAtual.getxPixel() + etd.getX() * 32, tabAtual.getyPixel() + etd.getY() * 32, etd.getTamanhoImg() * 2, 32, this);
        } else {
            g2d.drawImage(rotate(imagens.getImage(etd.getImagem()), 90), tabAtual.getxPixel() + etd.getX() * 32, tabAtual.getyPixel() + etd.getY() * 32, 32, etd.getTamanhoImg() * 2, this);
        }
    }

    /**
     * Metodo responsável por desenhar o vencedor na tela e as outras opções
     *
     * @param g
     */
    public void drawWinner(Graphics g) {
        String vencedorStr = "VENCEDOR: " + vencedor.getNome();

        drawStringinCenter(g, xPixels, 195, vencedorStr, Color.WHITE);
        drawStringinCenter(g, xPixels, 265, "JOGAR", Color.WHITE);
        drawStringinCenter(g, xPixels, 335, "CONFIGURAÇÕES", Color.WHITE);
        drawStringinCenter(g, xPixels, 405, "SAIR", Color.WHITE);
    }

    public void drawInicio(Graphics g) {
        drawStringinCenter(g, xPixels, 265, "JOGAR", Color.WHITE);
        drawStringinCenter(g, xPixels, 335, "CONFIGURAÇÕES", Color.WHITE);
        drawStringinCenter(g, xPixels, 405, "SAIR", Color.WHITE);
    }
    
    public void drawConfig(Graphics g) {
        drawStringinCenter(g, xPixels, 260, "DIFICULDADE:", Color.WHITE);
        drawStringinCenter(g, xPixels, 325, "FÁCIL", Color.WHITE);
        drawStringinCenter(g, xPixels, 395, "DIFÍCIL", Color.WHITE);
    }

    private void drawStringinCenter(Graphics g, int x, int y, String s, Color cor) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font fonte = null;

        try {
            fonte = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/8bitOperatorPlus-Regular.ttf")).deriveFont(36f);
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/8bitOperatorPlus-Regular.ttf")));
        } catch (FontFormatException ex) {
            Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(fonte);
        g2d.setColor(cor);
        FontMetrics metrics = g2d.getFontMetrics();
        g2d.drawString(s, (x / 2) - (metrics.stringWidth(s) / 2), y);
    }

    /**
     * Rotates an image. Actually rotates a new copy of the image.
     *
     * @param img The image to be rotated
     * @param angle The angle in degrees
     * @return The rotated image
     */
    public static Image rotate(Image img, double angle) {
        double sin = Math.abs(Math.sin(Math.toRadians(angle))),
                cos = Math.abs(Math.cos(Math.toRadians(angle)));

        int w = img.getWidth(null), h = img.getHeight(null);

        int neww = (int) Math.floor(w * cos + h * sin),
                newh = (int) Math.floor(h * cos + w * sin);

        BufferedImage bimg = toBufferedImage(getEmptyImage(neww, newh));
        Graphics2D g = bimg.createGraphics();

        g.translate((neww - w) / 2, (newh - h) / 2);
        g.rotate(Math.toRadians(angle), w / 2, h / 2);
        g.drawRenderedImage(toBufferedImage(img), null);
        g.dispose();

        return toImage(bimg);
    }
    
    public static BufferedImage toBufferedImage(Image img){
		long start = System.nanoTime();
		
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        long last = System.nanoTime();
        // Return the buffered image
        return bimage;
    }
    
    /**
     * Creates an empty image with transparency
     * 
     * @param width The width of required image
     * @param height The height of required image
     * @return The created image
     */
    public static BufferedImage getEmptyImage(int width, int height){
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        return (img);
    }
    
    /**
     * Converts a given BufferedImage into an Image
     * 
     * @param bimage The BufferedImage to be converted
     * @return The converted Image
     */
    public static Image toImage(BufferedImage bimage){
        // Casting is enough to convert from BufferedImage to Image
        Image img = (Image) bimage;
        return img;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public void setKeyAdapter(KAdapter keyAdapter) {
        this.keyAdapter = keyAdapter;
    }

    public boolean isDrawTab() {
        return drawTab;
    }

    public void setDrawTab(boolean drawTab) {
        this.drawTab = drawTab;
    }

    public JogadorGenerico getJogadorAtual() {
        return jogadorAtual;
    }

    public void setJogadorAtual(JogadorGenerico jogadorAtual) {
        this.jogadorAtual = jogadorAtual;
    }

    public JogadorGenerico getJogador() {
        return jogador;
    }

    public void setJogador(JogadorGenerico jogador) {
        this.jogador = jogador;
    }

    public JogadorGenerico getMaquina() {
        return maquina;
    }

    public void setMaquina(JogadorGenerico maquina) {
        this.maquina = maquina;
    }

    public Entidade getEtd() {
        return etd;
    }

    public void setEtd(Entidade etd) {
        this.etd = etd;
    }

    public Tabuleiro getTabJogador() {
        return tabJogador;
    }

    public void setTabJogador(Tabuleiro tabJogador) {
        this.tabJogador = tabJogador;
    }

    public Tabuleiro getTabMaquina() {
        return tabMaquina;
    }

    public void setTabMaquina(Tabuleiro tabMaquina) {
        this.tabMaquina = tabMaquina;
    }

    public Tabuleiro getTabAtual() {
        return tabAtual;
    }

    public void setTabAtual(Tabuleiro tabAtual) {
        this.tabAtual = tabAtual;
    }

    public int getTamBarco() {
        return tamBarco;
    }

    public void setTamBarco(int tamBarco) {
        this.tamBarco = tamBarco;
    }

    public JogadorGenerico getVencedor() {
        return vencedor;
    }

    public void setVencedor(JogadorGenerico vencedor) {
        this.vencedor = vencedor;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public boolean isInicio() {
        return inicio;
    }

    public void setInicio(boolean inicio) {
        this.inicio = inicio;
    }

    public boolean isConfig() {
        return config;
    }

    public void setConfig(boolean config) {
        this.config = config;
    }
}
