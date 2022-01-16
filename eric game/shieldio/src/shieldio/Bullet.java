package shieldio;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class Bullet {

	private Ellipse2D.Double bullet;
	private double x;
	private double y;
	private double velX;
	private double velY;
	private int diameter;
	private int ID;
	private double degree;
	private AllPlayers player;
	
	public Bullet(AllPlayers player, double velX, double velY) {
		x = player.getTriangle().getCenterX();
		y = player.getTriangle().getCenterY();
		this.velX = velX;
		this.velY = velY;
		diameter = player.getCannonShape().getWidth();
		ID = player.getID();
		bullet = new Ellipse2D.Double(x, y, diameter, diameter);
		degree = player.getDegree();
		
	}
	
	public void tick() {
		x += velX;
		y += velY;
		bullet = new Ellipse2D.Double(x, y, diameter, diameter);
	}
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.blue);
		g2d.fill(bullet);
		
	}
	
}
