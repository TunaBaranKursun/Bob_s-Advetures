package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	GamePanel gp;

	public KeyHandler(GamePanel gp){
		this.gp = gp;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
public boolean upPressed, downPressed, leftPressed, rightPressed;
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();// returns the integer key keyCode associated with the key in this event

		if(gp.gameState == gp.pauseState){

			if (code==KeyEvent.VK_W) {
				if(gp.ui.comNumber == 1){
					gp.ui.comNumber--;
				}else{
					gp.ui.comNumber = 1;
				}
			}
			if (code==KeyEvent.VK_S) {
				if(gp.ui.comNumber == 0){
					gp.ui.comNumber++;
				}else{
					gp.ui.comNumber = 0;
				}
			}
			if (code==KeyEvent.VK_ENTER) {
				if(gp.ui.comNumber == 0){
					gp.gameState = gp.playState;
				}
				else if(gp.ui.comNumber == 1){
					System.exit(0);
				}
			}

		}

		if(gp.gameState == gp.titleState){
			if (code==KeyEvent.VK_W) {
				if(gp.ui.comNumber == 1){
					gp.ui.comNumber--;
				}else{
					gp.ui.comNumber = 1;
				}
			}
			if (code==KeyEvent.VK_S) {
				if(gp.ui.comNumber == 0){
					gp.ui.comNumber++;
				}else{
					gp.ui.comNumber = 0;
				}
			}
			if (code==KeyEvent.VK_ENTER) {
				if(gp.ui.comNumber == 0){
					gp.gameState = gp.playState;
				}
				else if(gp.ui.comNumber == 1){
					System.exit(0);
				}
			}

		}

		if(gp.gameState == gp.playState){
			if (code==KeyEvent.VK_W) {
				upPressed= true;
			}
			if (code==KeyEvent.VK_S) {
				downPressed=true;
			}
			if (code==KeyEvent.VK_A) {
				leftPressed=true;
			}
			if (code==KeyEvent.VK_D) {
				rightPressed=true;
			}
			if (code==KeyEvent.VK_P) {
				gp.gameState = gp.pauseState;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();

		if (code==KeyEvent.VK_W) {
			upPressed= false;
		}
        if (code==KeyEvent.VK_S) {
			downPressed=false;
		}
        if (code==KeyEvent.VK_A) {
			leftPressed=false;
}
        if (code==KeyEvent.VK_D) {
			rightPressed=false;
}
	}


}
