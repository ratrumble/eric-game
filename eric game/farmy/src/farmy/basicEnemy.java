package farmy;

import java.awt.Color;
import java.awt.Graphics;



public class basicEnemy extends GameObject{
	
	private int HP;
	
	public basicEnemy(double x, double y, ID id) {
		super(x, y, id);
		velX = 5;
		velY = 5;
		HP = 100;
	}
	public void tick() {
		x += velX;
		y += velY;
		
		if( y <= 0 || y >= Game.HEIGHT-32) {
			velY *= -1;
		}
		if( x <= 0 || x >= Game.WIDTH-16) {
			velX *= -1;
		}
	}
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}
	
	public int getHP() {
		return HP;
	}
}
