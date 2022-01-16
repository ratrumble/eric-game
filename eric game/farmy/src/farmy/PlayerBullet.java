package farmy;

import java.awt.Color;
import java.awt.Graphics;

public class PlayerBullet extends GameObject{
	
	private double orgSpeed;
	private int bulletTimer;
	
	private int bulletCenterX;
	private int bulletCenterY;
	
	public PlayerBullet(int x, int y, double velX, double velY) {
		super(x, y);
		this.velX = velX;
		this.velY = velY;
		orgSpeed = 5;
		bulletTimer = 0;
		bulletCenterX = (2 * x + 16)/2;
		bulletCenterY = (2 * y + 8)/2;
	}
	public void tick() {
		x += velX;
		y += velY;
		bulletTimer++;
	}
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 4, 4);
		
	}
	public double getSpeed() {
		return orgSpeed;
	}
	public int getBulletTimer() {
		return bulletTimer;
	}
	
	public int BCX() {
		return bulletCenterX;
	}
	
	public int BCY() {
		return bulletCenterY;
	}
}

