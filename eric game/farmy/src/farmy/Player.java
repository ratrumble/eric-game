package farmy;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject{
	Random r = new Random();
	
	private int sizeX;
	
	private int sizeY;
	private int HP;
	
	public Player(int x, int y, ID id) {
		super(x, y, id);
		sizeX = 32;
		sizeY = 32;
		HP = 100;
	}
	public void tick() {
		x+= velX;
		y += velY;
		
		x = Game.clamp((int)x,  0,  Game.WIDTH-37);
		y = Game.clamp((int)y,  0, Game.HEIGHT-60);
	}
	public void render(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect((int)x,  (int)y, sizeX, sizeY);
	}
	
	public int getHP() {
		return HP;
	}

}
