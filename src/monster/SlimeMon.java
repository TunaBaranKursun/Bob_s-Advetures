package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;


public class SlimeMon extends Entity{
    

    public SlimeMon(GamePanel gp){
        super(gp);

        name = "Slime Monster";
        speed = 1 ;
		type = 1;
        maxLife = 4;
        life = maxLife;

        solidArea.x = 3;
        solidArea.y = 10;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

		getImage();
    }

    public void getImage (){

            up1=setup("/monster/slimeMonster/slime1");
			up2=setup("/monster/slimeMonster/slime2");
			down1=setup("/monster/slimeMonster/slime3");
			down2=setup("/monster/slimeMonster/slime4");   //bu metod playerin her yönü için 2 şer resim içeriyor 
			left1=setup("/monster/slimeMonster/slime5");   //2 resmin olma sebebi ise bir yönde ilerlerken resimleri sıra
			left2=setup("/monster/slimeMonster/slime6");   //değiştirerek animasyon yaratmak
			right1=setup("/monster/slimeMonster/slime7");
			right2=setup("/monster/slimeMonster/slime8");
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
