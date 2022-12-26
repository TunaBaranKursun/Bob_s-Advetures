package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.AssetSetter;
import main.GamePanel;
import main.KeyHandler;
import monster.SlimeMon;

import java.awt.Rectangle;

public class Player extends Entity {


	public KeyHandler keyH;

	public final int screenX; //fina lolmasının sebebi player ın ekran pozisyonunun değişmemesi için
	public final int screenY;
	//constructor
	public Player(GamePanel gp, KeyHandler keyH) {
		super(gp);
		
		this.keyH=keyH;

		screenX=gp.screenWidth/2-gp.tileSize/2;// burası player' ın ekranın ortasında çıkmasını sağlıyor
		screenY=gp.screenHeight/2-gp.tileSize/2;
		setDefoultValues();
		getPlayerImage();
		getPlayerAttackImage();

		solidArea = new Rectangle(0,0,gp.tileSize,gp.tileSize);
		
		attackArea.width=36;
		attackArea.height=36;
	}
	public void setDefoultValues() {
		worldX=gp.tileSize*4;//player başlama noktası
		worldY=gp.tileSize*6;
		speed = 4;
		direction = "up";
		maxLife = 6;
		life = maxLife;
	}
	public void getPlayerImage() {
		
			up1= setup("/player/p_up1",gp.tileSize,gp.tileSize); 
			// ImageIO.read(getClass().getResourceAsStream("/player/p_up1.png"));
			up2=  setup("/player/p_up2",gp.tileSize,gp.tileSize);
			 //ImageIO.read(getClass().getResourceAsStream("/player/p_up2.png"));
			down1= setup("/player/p_down1",gp.tileSize,gp.tileSize);                                                         //ImageIO.read(getClass().getResourceAsStream("/player/p_down1.png"));
			down2=setup("/player/p_down2",gp.tileSize,gp.tileSize);
			//ImageIO.read(getClass().getResourceAsStream("/player/p_down2.png"));   //bu metod playerin her yönü için 2 şer resim içeriyor 
			left1=setup("/player/p_left1",gp.tileSize,gp.tileSize);
			//ImageIO.read(getClass().getResourceAsStream("/player/p_left1.png"));   //2 resmin olma sebebi ise bir yönde ilerlerken resimleri sıra
			left2=setup("/player/p_left2",gp.tileSize,gp.tileSize);
			//ImageIO.read(getClass().getResourceAsStream("/player/p_left2.png"));   //değiştirerek animasyon yaratmak
			right1=setup("/player/p_right1",gp.tileSize,gp.tileSize);
			//ImageIO.read(getClass().getResourceAsStream("/player/p_right1.png"));
			right2=setup("/player/p_right2",gp.tileSize,gp.tileSize);
			//ImageIO.read(getClass().getResourceAsStream("/player/p_right2.png"));
		
	}
	public void getPlayerAttackImage(){
		attackUp1= setup("/player/arkaVuruşHazırlığı",gp.tileSize,gp.tileSize*2);
		attackUp2= setup("/player/arkaVuruş",gp.tileSize,gp.tileSize*2);
		attackDown1= setup("/player/önVuruşHazırlığı",gp.tileSize,gp.tileSize*2);
		attackDown2= setup("/player/önVuruş",gp.tileSize,gp.tileSize*2);
		attackLeft1= setup("/player/solVuruşHazırlığı",gp.tileSize*2,gp.tileSize);
		attackLeft2= setup("/player/solVuruş",gp.tileSize*2,gp.tileSize);
		attackRight1= setup("/player/sağVuruşHazırlığı",gp.tileSize*2,gp.tileSize);
		attackRight2= setup("/player/sağVuruş",gp.tileSize*2,gp.tileSize);
	
	
	}
	public void upDate() {// update metodu oyunun asıl işlemlerinin gerçekleştiği yer(konum güncellemesi sağlık barı güncellemesi vs.)

		if(gp.slimMonster[19]==null&&gp.slimMonster[18]==null&&gp.slimMonster[17]==null&&gp.slimMonster[16]==null&&gp.slimMonster[15]==null&&gp.slimMonster[14]==null&&gp.slimMonster[13]==null&&gp.slimMonster[12]==null&&gp.slimMonster[11]==null&&gp.slimMonster[10]==null&&gp.slimMonster[9]==null&&gp.slimMonster[8]==null&&gp.slimMonster[7]==null&&gp.slimMonster[6]==null&&gp.slimMonster[5]==null&&gp.slimMonster[4]==null&&gp.slimMonster[3]==null&&gp.slimMonster[2]==null&&gp.slimMonster[1]==null&&gp.slimMonster[0]==null){//level 4 den itibaren canavarların yaşayıp yaşamadığını kontol edip ona göre haritayı güncelliyorum bu da oyuna level sistemini eklemiş oluyor.
			gp.gameFinished=true;
		}
		else if(gp.player.life==0){
			System.exit(0);
		}
		if(gp.keyH.enterPressed==true){
			attacking=true;
		}
		
		if(attacking==true){

			Attacking();


		}
else{
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
		collisionOn = false;   //burası collesionu true olan bir yere girince oyuncunun çıkabilmesi için fırsat yaratır aksi taktirde 
		//oyncu true olan bir yerde sıkışıp kalır
		gp.cChaecker.checkTile(this);

		
	

		//Check monster Entity
		int monsterIndex = gp.cChaecker.checkEntity(this, gp.slimMonster);
		contactMonster(monsterIndex);

		// if collision is false player can move
        if(collisionOn==false&&keyH.enterPressed==false){
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
		if(invincible == true){//bir süre sonra karakteri invinciblemoddan çıkarır
			invincibleCounter++;
			if(invincibleCounter > 60){
				invincible = false;
				invincibleCounter = 0;
			}
		}
	}}
	public void Attacking(){
		spriteCounter++;
		if(spriteCounter<=5){
			spriteNum=1;
		}
		if(spriteCounter>5&&spriteCounter<=25){
			spriteNum=2;
			//its for save the current values
int currentWorldX = worldX;
int currentWorldY = worldY;
int solidAreaHeight=solidArea.height;
int solidAreaWidth=solidArea.width;
          switch(direction){
			case "up": worldY-=attackArea.height;break;
			case "down":worldY += attackArea.height;break;
			case "left":worldX -=attackArea.width;break;
			case "right":worldX += attackArea.width;break;
		  }
		  //attack area becomes solid area
		  solidArea.width=attackArea.width;
		  solidArea.height=attackArea.height;
		  //check monster collision with updated world x and world Y and solidArea
		  int monsterIndex =gp.cChaecker.checkEntity(this, gp.slimMonster);
		  damageMonster(monsterIndex);
        //after checking the collesion of monster restoring the original data
		   worldX=currentWorldX;
		   worldY=currentWorldY;
		   solidArea.height=solidAreaHeight;
		   solidArea.width=solidAreaWidth;

		}
		if(spriteCounter>25){
			spriteNum=1;
			spriteCounter=0;
			attacking=false;
		}
	}
	private void contactMonster(int i) {
		if(i != 999 ){
			if(invincible == false ){
				life -= 1 ;
				invincible = true;
			}
		}
	}public void damageMonster(int a){
		if(a!=999){
			if(gp.slimMonster[a].invincible==false){
				gp.slimMonster[a].life-=1;
				gp.slimMonster[a].invincible=true;
				if(gp.slimMonster[a].life==0){
					gp.slimMonster[a]=null;
				}
			}
		}
	}
	public void draw(Graphics2D g2) { // draw metodunun özelliği ise loopun içinde uptadeden gelen bilgileri ekrana dökmesi
      //  g2.setColor(Color.white); bunla anlatmk için
      //g2.fillRect( x , y , gp.tileSize, gp.tileSize); //3.ve 4. oyuncuyu çiziyor 1 ve 2 ise oyuncunun konumu
		BufferedImage image = null;
		int tempScreenX = screenX;
        int tempScreenY = screenY;
		switch(direction) {
		case"up":
		if(attacking==false){
			if(spriteNum==1) {image=up1;}
			if(spriteNum==2) {image=up2;}}
		if(attacking==true){
			tempScreenY=screenY-gp.tileSize;
			if(spriteNum==1) {image=attackUp1;}
			if(spriteNum==2) {image=attackUp2;}	
		}
			break;
		case"down":
		if(attacking==false){
			if(spriteNum==1) {image=down1;}
			if(spriteNum==2) {image=down2;}}
		if(attacking==true){
			if(spriteNum==1) {image=attackDown1;}
		    if(spriteNum==2) {image=attackDown2;}	
	    }
			break;
		case"left":
		if(attacking==false){
			
			if(spriteNum==1) {image=left1;}
			if(spriteNum==2) {image=left2;}}
		if(attacking==true){
			tempScreenX=screenX-gp.tileSize;
				if(spriteNum==1) {image=attackLeft1;}
				if(spriteNum==2) {image=attackLeft2;}	
			}	
			break;
		case "right":
		if(attacking==false){
		if(spriteNum==1) {image=right1;}
		if(spriteNum==2) {image=right2;}}
		if(attacking==true){
			if(spriteNum==1) {image=attackRight1;}
			if(spriteNum==2) {image=attackRight2;}	
		}	
		    break;}
			
		g2.drawImage(image,tempScreenX,tempScreenY,null);//
}}
