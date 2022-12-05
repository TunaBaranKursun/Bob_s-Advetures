package tile;

import java.awt.Graphics2D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
GamePanel gp;
public Tile[] tile;
public int mapTileNum[][];
Graphics2D g2 ;
public TileManager(GamePanel gpf) {
	this.gp=gpf;
	tile = new Tile[10];
	mapTileNum= new int[gp.maxWorldCol][gp.maxWorldRow];
	loadMap("/maps/word.txt");
	getTileImage();
	
}
public void getTileImage() {
	try {
		tile[0]=new Tile();
        tile[0].image= ImageIO.read(getClass().getResourceAsStream("/tiles/çim.png"));

		tile[1]=new Tile();
		tile[1].image= ImageIO.read(getClass().getResourceAsStream("/tiles/taş.png"));
		tile[1].collision = true;

		tile[2]=new Tile();
		tile[2].image= ImageIO.read(getClass().getResourceAsStream("/tiles/su.png"));
	    tile[2].collision=true;

		tile[3]= new Tile();
		tile[3].image=  ImageIO.read(getClass().getResourceAsStream("/tiles/kum.png"));

		tile[4]= new Tile();
		tile[4].image=  ImageIO.read(getClass().getResourceAsStream("/tiles/ağaç.png"));
		tile[4].collision=true;

		tile[5] = new Tile();
		tile[5].image=  ImageIO.read(getClass().getResourceAsStream("/tiles/tasZemin.png"));

	}catch(IOException e) {
		e.printStackTrace();
	}
}
public void loadMap(String filePath){
	try{
InputStream is = getClass().getResourceAsStream(filePath);
BufferedReader br = new BufferedReader(new InputStreamReader(is));


int col = 0;
int row = 0;


while(col<gp.maxWorldCol&& row<gp.maxWorldRow){
	String line = br.readLine();

	while(col<gp.maxWorldCol){
		String numbers[] = line.split(" ");

		int num = Integer.parseInt(numbers[col]);

		mapTileNum[col][row]= num;
		col++;
	}
	if( col == gp.maxWorldCol){
		col = 0;
		row++;
	}
}
	}catch(Exception e){

	}
}
public void draw(Graphics2D g2) {// toplam 17 satır 32 sütun olması gerekiyor

	
	int worldCol =0;
	int worldRow = 0;
	

	while(worldCol<gp.maxWorldCol&& worldRow < gp.maxWorldRow){

		int tileNum = mapTileNum[worldCol][worldRow];

int worldX = worldCol*gp.tileSize;
int worldY = worldRow*gp.tileSize;
int screenX = worldX - gp.player.worldX + gp.player.screenX;
int screenY = worldY - gp.player.worldY + gp.player.screenY;


		g2.drawImage(tile[tileNum].image,screenX,screenY,gp.tileSize,gp.tileSize,null);
		worldCol++;
		

		if(worldCol == gp.maxWorldCol){
			worldCol=0;
			
			worldRow++;
			
		}
	}
	
	
	
	
	
	
}
}
