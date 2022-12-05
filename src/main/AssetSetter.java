package main;

import monster.SlimeMon;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setMonster() {

        gp.slimMonster[0] = new SlimeMon(gp);
        gp.slimMonster[0].worldX = gp.tileSize*9;
        gp.slimMonster[0].worldY = gp.tileSize*8;

        gp.slimMonster[1] = new SlimeMon(gp);
        gp.slimMonster[1].worldX = gp.tileSize*8;
        gp.slimMonster[1].worldY = gp.tileSize*7;
        
        gp.slimMonster[2] = new SlimeMon(gp);
        gp.slimMonster[2].worldX = gp.tileSize*7;
        gp.slimMonster[2].worldY = gp.tileSize*7;

       
        
        
        //level 1
 

        gp.slimMonster[5] = new SlimeMon(gp);
        gp.slimMonster[5].worldX = gp.tileSize*44;
        gp.slimMonster[5].worldY = gp.tileSize*5;

        gp.slimMonster[6] = new SlimeMon(gp);
        gp.slimMonster[6].worldX = gp.tileSize*44;
        gp.slimMonster[6].worldY = gp.tileSize*8;

        gp.slimMonster[7] = new SlimeMon(gp);
        gp.slimMonster[7].worldX = gp.tileSize*44;
        gp.slimMonster[7].worldY = gp.tileSize*10;

        gp.slimMonster[8] = new SlimeMon(gp);
        gp.slimMonster[8].worldX = gp.tileSize*44;
        gp.slimMonster[8].worldY = gp.tileSize*9;
         
        gp.slimMonster[9] = new SlimeMon(gp);
        gp.slimMonster[9].worldX = gp.tileSize*44;
        gp.slimMonster[9].worldY = gp.tileSize*11;

        gp.slimMonster[10] = new SlimeMon(gp);
        gp.slimMonster[10].worldX = gp.tileSize*44;
        gp.slimMonster[10].worldY = gp.tileSize*12;
 
        gp.slimMonster[10] = new SlimeMon(gp);
        gp.slimMonster[10].worldX = gp.tileSize*44;
        gp.slimMonster[10].worldY = gp.tileSize*13;

        gp.slimMonster[10] = new SlimeMon(gp);
        gp.slimMonster[10].worldX = gp.tileSize*44;
        gp.slimMonster[10].worldY = gp.tileSize*14;
        

    }
}
