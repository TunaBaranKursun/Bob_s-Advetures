package main;

import javax.swing.JFrame;
// aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
public class Main {
//  4
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// This lets the window properly close when user clicks the close ("x") buton		
		
		window.setTitle("Bob's Adventures");
		
		GamePanel gamePanel = new GamePanel();// gamePanel is a JPanel with extra functions
		window.setResizable(false);
		window.add(gamePanel);
		
		window.pack(); 
	    
	    
		window.setLocationRelativeTo(null);// No specify the location of the window(Bunun sayesinde pencere ekranın ortasında çıkacak)
		window.setVisible(true);//its for see the window

		gamePanel.setupGame();
		gamePanel.startGameThreat();
              


	}

}
