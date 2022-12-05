package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

import java.awt.Rectangle;

public class Player extends Entity {


	KeyHandler keyH;

	public final int screenX;
	public final int screenY;
	//constructor
	public Player(GamePanel gp, KeyHandler keyH) {
		super(gp);
		this.keyH=keyH;

		screenX=gp.screenWidth/2-gp.tileSize/2;
		screenY=gp.screenHeight/2-gp.tileSize/2;
		setDefoultValues();
		getPlayerImage();

		solidArea = new Rectangle(8,16,32,32);
	}
	public void setDefoultValues() {
		worldX=gp.tileSize*10;
		worldY=gp.tileSize*9;
		speed = 4;
		direction = "up";
		maxLife = 6;
		life = maxLife;
	}
	public void getPlayerImage() {
		try {
			up1=ImageIO.read(getClass().getResourceAsStream("/player/p_up1.png"));
			up2=ImageIO.read(getClass().getResourceAsStream("/player/p_up2.png"));
			down1=ImageIO.read(getClass().getResourceAsStream("/player/p_down1.png"));
			down2=ImageIO.read(getClass().getResourceAsStream("/player/p_down2.png"));   //bu metod playerin her yönü için 2 şer resim içeriyor 
			left1=ImageIO.read(getClass().getResourceAsStream("/player/p_left1.png"));   //2 resmin olma sebebi ise bir yönde ilerlerken resimleri sıra
			left2=ImageIO.read(getClass().getResourceAsStream("/player/p_left2.png"));   //değiştirerek animasyon yaratmak
			right1=ImageIO.read(getClass().getResourceAsStream("/player/p_right1.png"));
			right2=ImageIO.read(getClass().getResourceAsStream("/player/p_right2.png"));
		}catch(IOException e) {
		e.printStackTrace();
		}
	}
	public void upDate() {// update metodu oyunun asıl işlemlerinin gerçekleştiği yer(konum güncellemesi sağlık barı güncellemesi vs.)
	if(keyH.upPressed==true||keyH.downPressed==true||keyH.leftPressed==true||keyH.rightPressed==true) {//bu if cümlesi bir tuşa basmadığımız zaman ana karakterin durmasını sağlıyor
		// bir tuşa basmayınca elbette hareket etmeyecek fakat olduğu yerde aynı directionun resimleri arasında sürekli geçiş yapacağı için kötü bir görüntü oluşturacak
		if(keyH.upPressed==true) {
			direction="up";
		}
		else if(keyH.downPressed==true) {
			direction="down";
		}
		else if(keyH.leftPressed==true) {
				direction = "left";
		}
		else if(keyH.rightPressed==true) {
				direction = "right";
		}
		//check tile collision
		collisionOn = false;
		gp.cChaecker.checkTile(this);

		//Check Event
		gp.eHandler.checkEvent();

		//Check monster Entity
		int monsterIndex = gp.cChaecker.checkEntity(this, gp.slimMonster);
		contactMonster(monsterIndex);

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
		if(invincible == true){
			invincibleCounter++;
			if(invincibleCounter > 60){
				invincible = false;
				invincibleCounter = 0;
			}
		}
	}
	private void contactMonster(int i) {
		if(i != 999 ){
			if(invincible == false ){
				life -= 1 ;
				invincible = true;
			}

		}
	}
	public void draw(Graphics2D g2) { // draw metodunun özelliği ise loopun içinde uptadeden gelen bilgileri ekrana dökmesi
      //  g2.setColor(Color.white); bunla anlatmk için
      //g2.fillRect( x , y , gp.tileSize, gp.tileSize); //3.ve 4. oyuncuyu çiziyor 1 ve 2 ise oyuncunun konumu
		BufferedImage image = null;
		switch(direction) {
		case"up":
			if(spriteNum==1) {
				image=up1;
			}
			if(spriteNum==2) {
				image=up2;
			}
			break;
		case"down":
			if(spriteNum==1) {
				image=down1;
			}
			if(spriteNum==2) {
				image=down2;
			}
			break;
		case"left":
			if(spriteNum==1) {
				image=left1;
			}
			if(spriteNum==2) {
				image=left2;
			}
			break;
		case "right":
			if(spriteNum==1) {
				image=right1;
			}
			if(spriteNum==2) {
				image=right2;
			}
			 break;
			 	}
		g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);//spnuncusu image observer ne işe yarıyor sor
	}
}
