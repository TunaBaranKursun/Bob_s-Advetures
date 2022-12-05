package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;
import java.awt.Graphics2D;

import main.GamePanel;
import main.UtilityTool;

public class Entity {
	// it will store that variables that will be used in player,monster and Npc classes
	GamePanel gp;
	KeyHandler keyH;

    public int worldX;
	public int worldY;
	public int speed;
	
	public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
	public BufferedImage attackUp1,attackUp2,attackDown1,attackDown2,attackRight1,attackRight2,attackLeft1,attackLeft2;
	public String direction = "down";

	public int x,y;
	public Rectangle solidArea = new Rectangle(0,0,48,48);
	public Rectangle attackArea = new Rectangle(0,0,0,0);
	public int solidAreaDefaultX, solidAreaDefaultY;
	public String name;
	public int actionLookCounter = 0;
	public BufferedImage image, image2, image3 ;

	public int maxLife;
	public int life;
	public boolean invincible = false;
	public int invincibleCounter = 0;
	public boolean attacking = false;
	
	public int spriteCounter=0;
	public int spriteNum=1;

	public int type ; // 0 = player , 1 = monster

	
	public boolean collisionOn = false;

	public Entity(GamePanel gp ){
		this.gp = gp;
	}
	public void draw(Graphics2D g2) {
		
		BufferedImage imageDraw = null;

		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;

		if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
			worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
			worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
			worldY - gp.tileSize < gp.player.worldY + gp.player.screenY ){



			switch (direction) {
				case "up":
					if(spriteNum == 1){imageDraw = up1;}
					if(spriteNum == 2){imageDraw = up2;}
					break;
			    case "down":
					if(spriteNum == 1){imageDraw = down1;}
					if(spriteNum == 2){imageDraw = down2;}
					break;
				case "left":
					if(spriteNum == 1){imageDraw = left1;}
					if(spriteNum == 2){imageDraw = left2;}
					break;
				case "right":
					if(spriteNum == 1){imageDraw = right1;}
					if(spriteNum == 2){imageDraw = right2;}
					break;
				default:
					break;
				}
				
				g2.drawImage(imageDraw,  screenX, screenY, gp.tileSize, gp.tileSize, null);
		}
	}

	public BufferedImage setup(String imagePath,int width,int height){
		UtilityTool uTool = new UtilityTool();
		BufferedImage imageRan = null;
		
		try {
			imageRan = ImageIO.read(getClass().getResourceAsStream(imagePath+".png"));
			imageRan = uTool.scaleImage(imageRan, width,height);
		} catch (Exception e) {
			System.out.println("Okumadı");
		}

		return imageRan;
	}
	public void update(){
		collisionOn = false;
		gp.cChaecker.checkTile(this);
		gp.cChaecker.checkEntity(this, gp.slimMonster);
		boolean contactPlayer = gp.cChaecker.checkPlayer(this);

		if(this.type == 1 && contactPlayer){
			if(gp.player.invincible == false){
				gp.player.life -= 1;
				gp.player.invincible = true;
			}
		}

		// if collision is false player can move
        if(collisionOn==false){
			switch(direction){
				case"up":
				worldY -= speed;
				break;
				case "down":
				worldY += speed;
				break;
				case "left":
				worldX-=speed;
				break;
				case "right":
				worldX+=speed;
				break;
			}
		}
		spriteCounter++;
		if(invincible == true){
			invincibleCounter++;
			if(invincibleCounter > 30){
				invincible = false;
				invincibleCounter = 0;
			}
		}

		if(spriteCounter>10) {
			if(spriteNum==1) {
				spriteNum=2;
			}
			else if(spriteNum==2) {
			spriteNum=1;
			}
			spriteCounter=0;
		}
	}
}
