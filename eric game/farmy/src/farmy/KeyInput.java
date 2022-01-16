package farmy;

import java.awt.event.KeyAdapter;
import java.lang.Math; 
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KeyInput extends KeyAdapter implements MouseListener{
	private Handler handler;
	private double distanceX;
	private double distanceY;
	private double distanceZ;
	private double velX;
	private double velY;
	//private double multiplier;
	private int locX;
	private int locY;
	private boolean isShooting;

	public KeyInput(Handler handler) {
		this.handler = handler;

	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Player) {

				if(key == KeyEvent.VK_W) tempObject.setVelY(-5); 
				if(key == KeyEvent.VK_S) tempObject.setVelY(5); 
				if(key == KeyEvent.VK_D) tempObject.setVelX(5); 
				if(key == KeyEvent.VK_A) tempObject.setVelX(-5);
				if(key == KeyEvent.VK_SPACE) {
					Handler.addBullet(tempObject.getX(), tempObject.getY(), 5, 5);
				}
			}

		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Player) {

				if(key == KeyEvent.VK_W) tempObject.setVelY(0); 
				if(key == KeyEvent.VK_S) tempObject.setVelY(0); 
				if(key == KeyEvent.VK_D) tempObject.setVelX(0); 
				if(key == KeyEvent.VK_A) tempObject.setVelX(0); 
			}

			if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		}
	}

	public void mousePressed(MouseEvent e) {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			isShooting = true;
			if (tempObject.getId() == ID.Player) {
				
				locX = tempObject.getX();
				locY = tempObject.getY();
				distanceX = -1*(tempObject.getX() - e.getX());
				distanceY = -1*(tempObject.getY() - e.getY());
				distanceZ = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
				double asinCalcX = Math.asin(Math.abs(distanceX/distanceZ));
				double asinCalcY = Math.asin(Math.abs(distanceY/distanceZ));
				double sinCalcX = Math.sin(asinCalcX);
				double sinCalcY = Math.sin(asinCalcY);
				velX = Math.abs(distanceX)/distanceX * sinCalcX *5;
				velY = Math.abs(distanceY)/distanceY * sinCalcY *5;

				if (Double.isNaN(velX)) {
					velX = 0;
				}
				if (Double.isNaN(velY)) {
					velY = 0;
				}
				/*
				 * multiplier = (int)(Math.sqrt(distanceX*distanceX + distanceY*distanceY)/5);
				 * //scaling distance to velocity
				 * 
				 * if ((Math.abs(distanceY)) < 1 && Math.abs(distanceX)>= 1) { velX =
				 * Math.abs(distanceX)/distanceX * 5; velY = Math.abs(distanceY)/distanceY * .5;
				 * } else if ((Math.abs(distanceX)) < 1 && Math.abs(distanceY)>= 1) { velX =
				 * Math.abs(distanceX)/distanceX * .5; velY = Math.abs(distanceY)/distanceY * 5;
				 * } else if (Math.abs(distanceY) >= 1 && Math.abs(distanceX) >= 1) { velX =
				 * (Math.abs(distanceX)/distanceX) * Math.sqrt(25 -
				 * (Math.abs(distanceY)/multiplier)*(Math.abs(distanceY)/multiplier)); if
				 * (Math.abs(velX) < 1) { velX = Math.abs(distanceX)/distanceX * .5; } velY =
				 * (Math.abs(distanceY)/distanceY) * Math.sqrt(25 -
				 * (Math.abs(distanceX)/multiplier)*(Math.abs(distanceX)/multiplier)); if
				 * (Math.abs(velY) < 1) { velY = Math.abs(distanceY)/distanceY * .5; } } else {
				 * velX = 0; velY = 0; }
				 */
				Handler.addBullet(locX, locY, velX, velY);
				System.out.println("--------------------------------");
				System.out.println("distanceX=" + distanceX + " distanceY=" + distanceY + "\n");
				System.out.println("locX=" + locX + " locY=" + locY + " velX=" + velX + " velY=" + velY +"\n");
				System.out.println("degree X " + asinCalcX + " degree Y " + asinCalcY + " x ratio " + sinCalcX + " y ratio " + sinCalcY +"\n");
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		isShooting = false;

	}

	public int getLocX() {
		return locX;
	}

	public int getLocY() {
		return locY;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if (isShooting) {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ID.Player) {
				locX = tempObject.getX();
				locY = tempObject.getY();
				distanceX = -1*(tempObject.getX() - e.getX());
				distanceY = -1*(tempObject.getY() - e.getY());
				distanceZ = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
				double asinCalcX = Math.asin(Math.abs(distanceX/distanceZ));
				double asinCalcY = Math.asin(Math.abs(distanceY/distanceZ));
				double sinCalcX = Math.sin(asinCalcX);
				double sinCalcY = Math.sin(asinCalcY);
				velX = Math.abs(distanceX)/distanceX * sinCalcX *5;
				velY = Math.abs(distanceY)/distanceY * sinCalcY *5;
				if (Double.isNaN(velX)) {
					velX = 0;
				}
				if (Double.isNaN(velY)) {
					velY = 0;
				}
				Handler.addBullet(locX, locY, velX, velY);}
		}
		
	}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
