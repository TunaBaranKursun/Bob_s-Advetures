package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;


public class SlimeMon extends Entity{
    GamePanel gp;
	

    public SlimeMon(GamePanel gp){
        super(gp);
		this.gp=gp;
        name = "Slime Monster";
        speed = 3;
		
        maxLife = 2;
        life = maxLife;

        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 48;
        solidArea.height = 48;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

		getImage();
    }

    public void getImage (){

            up1=setup("/monster/slimeMonster/slimeyukarı1",gp.tileSize,gp.tileSize);
			up2=setup("/monster/slimeMonster/slimeyukarı2",gp.tileSize,gp.tileSize);
			down1=setup("/monster/slimeMonster/slimeaşağı1",gp.tileSize,gp.tileSize);
			down2=setup("/monster/slimeMonster/slimeaşağı2",gp.tileSize,gp.tileSize);   //bu metod canavarın her yönü için 2 şer resim içeriyor 
			left1=setup("/monster/slimeMonster/slimesol1",gp.tileSize,gp.tileSize);   //2 resmin olma sebebi ise bir yönde ilerlerken resimleri sıra
			left2=setup("/monster/slimeMonster/slimesol2",gp.tileSize,gp.tileSize);   //değiştirerek animasyon yaratmak
			right1=setup("/monster/slimeMonster/slimesağ1",gp.tileSize,gp.tileSize);
			right2=setup("/monster/slimeMonster/slimesağ2",gp.tileSize,gp.tileSize);
    }
    
    public void setAction() {
		actionLookCounter++;

		if(actionLookCounter == 120){
			Random random = new Random();
			int i = random.nextInt(100) + 1 ;
			if(i <= 25) {
				direction = "up";
			}
			if(i > 25 && i <= 50) {
				direction = "down";
			}
			if(i > 50 && i <= 75) {
				direction = "left";
			}
			if(i > 75 && i <= 100) {
				direction = "right";
			}

			actionLookCounter = 0;
		}

	}

	@Override
	public void update() {
		super.update();
		setAction();

	}
}
