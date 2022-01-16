package shieldio;

import java.awt.Graphics;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AllPlayers {
	private AtomicInteger num = new AtomicInteger();
	
	protected int ID;
	
	protected Triangle triangle;
	protected int radius;
	protected int x;
	protected int y;
	protected int velX;
	protected int velY;
	protected double degree;
	protected CannonShape rectangle;
	protected String name;
	
	public AllPlayers(int x, int y, int radius, String name) {
		ID = num.incrementAndGet();
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.name = name;
		triangle = new Triangle(x, y, radius, degree);
		rectangle = new CannonShape(triangle);
	}
	
	public int getID() {
		return ID;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);

	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getVelX() {
		return velX;
	}
	
	public void setVelX(int velX) {
		this.velX = velX;
	}
	
	public int getVelY() {
		return velY;
	}
	
	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public Triangle getTriangle() {
		return triangle;
	}
	
	public void setTriangle(int x, int y, int radius) {
		triangle = new Triangle(x, y, radius, degree);
	}
	
	public CannonShape getCannonShape() {
		return rectangle;
	}
	
	public void setCannonShape(Triangle triangle) {
		rectangle = new CannonShape(triangle);
	}
	
	public double getDegree() {
		return degree;
	}
	
	public void setDegree(double degree) {
		this.degree = degree;
	}
	
	
	
}
