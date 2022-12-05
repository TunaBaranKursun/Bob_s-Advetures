package main;

public class EventHandler {
    GamePanel gp ;
    EventRect evenRect[][];

    public EventHandler(GamePanel gp){
        this.gp = gp;
        evenRect = new EventRect[gp.maxWorldCol][gp.maxWorldRow];

        int col  = 0 ;
        int row = 0 ;

        while (col < gp.maxWorldCol && row < gp.maxWorldRow) {

            evenRect[col][row] = new EventRect();
            evenRect[col][row].x = 23;
            evenRect[col][row].y = 23;
            evenRect[col][row].width = 2;
            evenRect[col][row].height = 2;
            evenRect[col][row].eventRecDefaultX = evenRect[col][row].x;
            evenRect[col][row].eventRecDefaultY = evenRect[col][row].y;

        col++;
        if(col == gp.maxScreenCol){
            col = 0 ;
            row++;
        }
    }

}
    //*******************************************
    public void checkEvent() {
        /*if(hit(27, 16, "right") == true){
            damagePit(gp.gameState);
        }*/
    }

    
    /*public boolean hit(int col, int row, String reqDirection){
        boolean hit = false;

        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;

        evenRect[col][row].x = col*gp.tileSize + evenRect[col][row].x;
        evenRect[col][row].y = row*gp.tileSize + evenRect[col][row].y;

        if(gp.player.solidArea.intersects(evenRect[col][row])){
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;
            }
        }

        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;

        evenRect[col][row].x = evenRect[col][row].eventRecDefaultX;
        evenRect[col][row].y = evenRect[col][row].eventRecDefaultY;


        return hit;
    }*/
    public void damagePit(int gameState){
        gp.gameState = gameState;
        gp.player.life -= 1;
    }
}
