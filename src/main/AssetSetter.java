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

        //level 1
        
        gp.slimMonster[2] = new SlimeMon(gp);
        gp.slimMonster[2].worldX = gp.tileSize*44;
        gp.slimMonster[2].worldY = gp.tileSize*9;


        gp.slimMonster[5] = new SlimeMon(gp);
        gp.slimMonster[5].worldX = gp.tileSize*43;
        gp.slimMonster[5].worldY = gp.tileSize*5;

        gp.slimMonster[6] = new SlimeMon(gp);
        gp.slimMonster[6].worldX = gp.tileSize*44;
        gp.slimMonster[6].worldY = gp.tileSize*8;

        gp.slimMonster[7] = new SlimeMon(gp);
        gp.slimMonster[7].worldX = gp.tileSize*45;
        gp.slimMonster[7].worldY = gp.tileSize*9;


        // level 2

        gp.slimMonster[8] = new SlimeMon(gp);
        gp.slimMonster[8].worldX = gp.tileSize*12;
        gp.slimMonster[8].worldY = gp.tileSize*23;
         
        gp.slimMonster[9] = new SlimeMon(gp);
        gp.slimMonster[9].worldX = gp.tileSize*13;
        gp.slimMonster[9].worldY = gp.tileSize*24;

        gp.slimMonster[10] = new SlimeMon(gp);
        gp.slimMonster[10].worldX = gp.tileSize*12;
        gp.slimMonster[10].worldY = gp.tileSize*25;
 
        gp.slimMonster[11] = new SlimeMon(gp);
        gp.slimMonster[11].worldX = gp.tileSize*11;
        gp.slimMonster[11].worldY = gp.tileSize*23;

        gp.slimMonster[12] = new SlimeMon(gp);
        gp.slimMonster[12].worldX = gp.tileSize*16;
        gp.slimMonster[12].worldY = gp.tileSize*24;
        
        gp.slimMonster[13] = new SlimeMon(gp);
        gp.slimMonster[13].worldX = gp.tileSize*13;
        gp.slimMonster[13].worldY = gp.tileSize*25;

        //level 3


        gp.slimMonster[14] = new SlimeMon(gp);
        gp.slimMonster[14].worldX = gp.tileSize*14;
        gp.slimMonster[14].worldY = gp.tileSize*45;
 
        gp.slimMonster[15] = new SlimeMon(gp);
        gp.slimMonster[15].worldX = gp.tileSize*15;
        gp.slimMonster[15].worldY = gp.tileSize*45;

        gp.slimMonster[16] = new SlimeMon(gp);
        gp.slimMonster[16].worldX = gp.tileSize*17;
        gp.slimMonster[16].worldY = gp.tileSize*45;
        
        gp.slimMonster[17] = new SlimeMon(gp);
        gp.slimMonster[17].worldX = gp.tileSize*20;
        gp.slimMonster[17].worldY = gp.tileSize*45;

        gp.slimMonster[18] = new SlimeMon(gp);
        gp.slimMonster[18].worldX = gp.tileSize*22;
        gp.slimMonster[18].worldY = gp.tileSize*45;

        gp.slimMonster[19] = new SlimeMon(gp);
        gp.slimMonster[19].worldX = gp.tileSize*25;
        gp.slimMonster[19].worldY = gp.tileSize*45;
        
       
     
        //son level







    }
}
