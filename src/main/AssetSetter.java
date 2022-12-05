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

    }
}
