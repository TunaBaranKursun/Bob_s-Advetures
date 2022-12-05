package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


import entity.Entity;
import object.HeartObject;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    public int comNumber = 0;
    BufferedImage heartFull , heartHalf ,heartBlank ;

   

    public UI(GamePanel gp){
        this.gp = gp;

        //create hud object

        Entity heart = new HeartObject(gp);
        heartFull = heart.image;
        heartHalf = heart.image2;
        heartBlank = heart.image3;
        
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        if(gp.gameState == gp.playState){
            drawPlayerLife();
        }

        else if(gp.gameState == gp.titleState){
            drawPlayerLife();
            drawTitleScreen();
        }
        else if(gp.gameState == gp.pauseState){
            drawPlayerLife();
            drawPouseScreen();
        }
    }
    private void drawPlayerLife() {

        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i = 0;

        //draw blank heart
        while (i < gp.player.maxLife/2) {
            g2.drawImage(heartBlank, x, y,null);
            i++;
            x += gp.tileSize;
        }

        x = gp.tileSize/2;
        y = gp.tileSize/2;
        i = 0;

        //draw Current Life
        while (i < gp.player.life) {
            g2.drawImage(heartHalf, x, y, null);
            i++;
            if(i < gp.player.life){
                g2.drawImage(heartFull,  x, y, null);
            }
            i++;
            x += gp.tileSize;
        }
    }

    public void drawTitleScreen() {

        g2.setColor(Color.blue);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Bobs Adventure";
        int x = getXforCenteredText(text);
        int y = gp.tileSize*3;

        g2.setColor(Color.gray);
        g2.drawString(text, x+5, y+5);

        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        //MENU
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

        text = "NEW GAME";
        x = getXforCenteredText(text);
        y = gp.tileSize*6;
        g2.drawString(text, x, y);
        if(comNumber == 0){
            g2.drawString(">", gp.tileSize*4, y);
        }


        text = "QUIT";
        x = getXforCenteredText(text);
        y = gp.tileSize*10;
        g2.drawString(text, x, y);
        if(comNumber == 1){
            g2.drawString(">", gp.tileSize*4, y);
        }
    }
    public void drawPouseScreen() {
        g2.setColor(Color.blue);
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Bobs Adventure";
        int x = getXforCenteredText(text);
        int y = gp.tileSize*3;

        g2.setColor(Color.gray);
        g2.drawString(text, x+5, y+5);

        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        //MENU
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

        text = "LOAD GAME";
        x = getXforCenteredText(text);
        y = gp.tileSize*8;
        g2.drawString(text, x, y);
        if(comNumber == 0){
            g2.drawString(">", gp.tileSize*4, y);
        }

        text = "QUIT";
        x = getXforCenteredText(text);
        y = gp.tileSize*10;
        g2.drawString(text, x, y);
        if(comNumber == 1){
            g2.drawString(">", gp.tileSize*4, y);
        }
    }

    private int getXforCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}
