package shieldio;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class KeyInput extends KeyAdapter implements MouseListener, MouseMotionListener{

private PlayerHandler playerHandler;
private BulletHandler bulletHandler;
boolean wHold;
boolean aHold;
boolean sHold;
boolean dHold;
	
	public KeyInput(PlayerHandler playerHandler, BulletHandler bulletHandler) {
		this.playerHandler = playerHandler;
		wHold = false;
		aHold = false;
		sHold = false;
		dHold = false;
		
		this.bulletHandler = bulletHandler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		ArrayList<Player> playerList = playerHandler.getPlayerList();
		
		for (int i = 0; i < playerList.size(); i++) {
			Player player = playerList.get(i);

				if(key == KeyEvent.VK_W) {
					wHold = true;
					if(sHold)
						player.setVelY(0);
					else
					player.setVelY(-5); 
					
					
				}
				if(key == KeyEvent.VK_S) {
					sHold = true;
					if(wHold)
						player.setVelY(0);
					else
					player.setVelY(5); 
					
					
				}
				if(key == KeyEvent.VK_D) {
					dHold = true;
					if(aHold)
						player.setVelX(0);
					else
					player.setVelX(5); 
					
					
				}
				if(key == KeyEvent.VK_A) {
					aHold = true;
					if(dHold)
						player.setVelX(0);
					else
					player.setVelX(-5);
					
					
				}
				
			

		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		ArrayList<Player> playerList = playerHandler.getPlayerList();
		
		for (int i = 0; i < playerList.size(); i++) {
			Player player = playerList.get(i);

			if(key == KeyEvent.VK_W) {
				wHold = false;
				if(!sHold)
					player.setVelY(0); 
				else 
					player.setVelY(5); 
			}
			if(key == KeyEvent.VK_S) {
				sHold = false;
				if(!wHold)
					player.setVelY(0); 
				else
					player.setVelY(-5); 
			}
			if(key == KeyEvent.VK_D) {
				dHold = false;
				if(!aHold)
					player.setVelX(0);
				else
					player.setVelX(-5); 
				
			}
			if(key == KeyEvent.VK_A) {
				aHold = false;
				if(!dHold)
					player.setVelX(0);
				else
					player.setVelX(5); 
				
			}
			
		

	}

			if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		ArrayList<Player> playerList = playerHandler.getPlayerList();
		
		for (int i = 0; i < playerList.size(); i++) {
			Player player = playerList.get(i);
			
				double distanceX = -1*(player.getX() - e.getX());
				double distanceY = -1*(player.getY()- e.getY());
				double distanceZ = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
				double asinCalcX = Math.asin(Math.abs(distanceX/distanceZ));
				double asinCalcY = Math.asin(Math.abs(distanceY/distanceZ));
				double sinCalcX = Math.sin(asinCalcX);
				double sinCalcY = Math.sin(asinCalcY);
				double velX = Math.abs(distanceX)/distanceX * sinCalcX *5;
				double velY = Math.abs(distanceY)/distanceY * sinCalcY *5;
				
				if (Double.isNaN(velX)) {
					velX = 0;
				}
				if (Double.isNaN(velY)) {
					velY = 0;
				}
				
				Bullet bullet = new Bullet(player, velX, velY);
				
				bulletHandler.addBullet(bullet);
				
				

			
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseDragged(MouseEvent e) {
		ArrayList<Player> playerList = playerHandler.getPlayerList();
		for (int i = 0; i < playerList.size(); i++) {
			Player player = playerList.get(i);
			int playerX = player.getX();
			int playerY = player.getY();
			
		    double theta = Math.atan2(e.getY() - playerY, e.getX() - playerX);
		    
			theta += Math.PI/2.0;
			
			player.setDegree(theta);
			//System.out.println(theta);
			
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		ArrayList<Player> playerList = playerHandler.getPlayerList();
		for (int i = 0; i < playerList.size(); i++) {
			Player player = playerList.get(i);
			int playerX = player.getX();
			int playerY = player.getY();
			
		    double theta = Math.atan2(e.getY() - playerY, e.getX() - playerX);
		    
			theta += Math.PI/2.0;
			
			player.setDegree(theta);
			//System.out.println(theta);
			
		}
		
	}
	
	
	}
	
	


