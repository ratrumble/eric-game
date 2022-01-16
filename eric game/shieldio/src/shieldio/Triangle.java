package shieldio;

import java.awt.Polygon;
import java.util.ArrayList;

public class Triangle{

	private int[] xPoints;
	private int[] yPoints;
	private Polygon triangle;
	private int radius;
	private double degree;
	
	private ArrayList<Integer> additionalX = new ArrayList<Integer>();
	private ArrayList<Integer> additionalY = new ArrayList<Integer>();
	
	private int centerX;
	private int centerY;
	
	public Triangle(int x, int y, int radius, double degree) {
		this.radius = radius;
		xPoints = new int[] {x - radius, x - radius/4, x+radius/4, x + radius};
		yPoints = new int[] {y + (int)Math.sqrt(radius*radius/2), y-radius/2, y-radius/2, y + (int)Math.sqrt(radius*radius/2)};
		additionalX.add(x- radius/4);
		additionalX.add(x+ radius/4);
		additionalY.add(y + (int)Math.sqrt(radius*radius/2) + 1);
		additionalY.add(y + (int)Math.sqrt(radius*radius/2) + 1);
		this.degree = degree;
		centerX = x;
		centerY = (int)(y - Math.sqrt(radius*radius/2) + y + radius)/2;
		//for(int i = 0; i < xPoints.length; i ++) {
		//System.out.println("FIRST " + xPoints[i] + " " + yPoints[i]);
		//}
		updateDegree();
		//for(int i = 0; i < xPoints.length; i ++) {
		//	System.out.println("SECOND " + xPoints[i] + " " + yPoints[i]);
		//}
		//System.out.println(centerX + "     " + centerY);
		triangle = new Polygon(xPoints, yPoints, 4);
	}
	
	public void updateDegree() {
		int[] newX = new int[4];
		int[] newY = new int[4];
		for (int i = 0; i < xPoints.length; i ++) {
			newX[i] = (int)(centerX + (xPoints[i] - centerX) * Math.cos(degree) - (yPoints[i] - centerY) * 
					Math.sin((degree)));
			newY[i] = (int)(centerY + (xPoints[i] - centerX) * Math.sin(degree) + (yPoints[i] - centerY) * 
					Math.cos((degree)));
		}
		xPoints = newX;
		yPoints = newY;
		
		ArrayList<Integer> addX = new ArrayList<Integer>();
		ArrayList<Integer> addY = new ArrayList<Integer>();
		
		for (int g = 0; g < additionalX.size(); g++) {
			addX.add((int)(centerX + (additionalX.get(g) - centerX) * Math.cos(degree) - (additionalY.get(g) - centerY) * 
					Math.sin((degree))));
			addY.add((int)(centerY + (additionalX.get(g) - centerX) * Math.sin(degree) + (additionalY.get(g) - centerY) * 
					Math.cos((degree))));
		}
		additionalX = addX;
		additionalY = addY;
	}
	
	public int[] getXPoints() {
		return xPoints; 
	}
	
	public ArrayList<Integer> getXList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < xPoints.length; i++) {
			list.add(xPoints[i]);
		}
		return list;
	}
	
	public void setXPoints(int x1, int x2, int x3) {
		xPoints = new int[] {x1, x2, x3};
	}
	
	public int[] getYPoints() {
		return yPoints;
	}
	
	public ArrayList<Integer> getYList() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < yPoints.length; i++) {
			list.add(yPoints[i]);
		}
		return list;
	}
	
	public void setYPoints(int y1, int y2, int y3) {
		yPoints = new int[] {y1, y2, y3};
	}
	
	public ArrayList<Integer> getAdditionalX(){
		return additionalX;
	}
	
	public ArrayList<Integer> getAdditionalY(){
		return additionalY;
	}
	
	public Polygon getTriangle() {
		return triangle;
	}
	
	public void setTriangle() {
		triangle = new Polygon(xPoints, yPoints, 3);
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public int getCenterX() {
		return centerX;
	}
	
	public int getCenterY() {
		return centerY;
	}
	
	public double getDegree() {
		return degree;
	}
}
