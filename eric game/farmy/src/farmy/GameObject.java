package farmy;

import java.awt.Graphics;


public abstract class GameObject {
	protected double x, y;
	protected ID id;
	protected double velX, velY;
	private double CenterX;
	private double CenterY;
	private double sizeX, sizeY;
	
	public GameObject(double x, double y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
		CenterX = (2 * x + sizeX)/2;
		CenterY = (2 * y + sizeY)/2; 
	}
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return (int)x;
	}
	public int getY() {
		return (int)y;
	}
	public void setId(ID id) {
		this.id = id;
	}
	public ID getId() {
	       	return id;
	}
	public void setVelX(double velX) {
		this.velX = velX;
	}
	public double getVelX() {
		return velX;
	}
	public void setVelY(double velY) {
		this.velY = velY;
	}
	public double getVelY() {
		return velY;
	}
	public int getCX() {
		return (int)CenterX;
	}
	
	public int getCY(){
		return (int)CenterY;
	}
}

