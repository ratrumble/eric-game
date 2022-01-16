package shieldio;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;

public class CannonShape {

	private int[] xPoints;
	private int[] yPoints;
	private int width;
	private int height;
	private Polygon rectangle;
	private Triangle triangle;
	
	public CannonShape(Triangle triangle) {
		this.triangle = triangle;
		width = Math.abs(triangle.getRadius())/2;
		height = Math.abs(triangle.getRadius())/4 * 3;
		
		
		xPoints = new int[] {triangle.getXList().get(1), triangle.getXList().get(2),
				triangle.getAdditionalX().get(1), triangle.getAdditionalX().get(0)};
		
		yPoints = new int[] {triangle.getYList().get(1), triangle.getYList().get(2),
				triangle.getAdditionalY().get(1), triangle.getAdditionalY().get(0)};
		
		
		
		rectangle = new Polygon(xPoints, yPoints, 4);
	}
	
	public void updateDegree() {
		int[] newX = new int[4];
		int[] newY = new int[4];
		newX[0] = xPoints[0];
		newX[1] = xPoints[1];
		newY[0] = yPoints[0];
		newY[1] = yPoints[1];
		for (int i = 2; i < xPoints.length; i ++) {
			
			newY[i] = (int)(triangle.getCenterY() + (xPoints[i] - triangle.getCenterX()) * 
					Math.sin(triangle.getDegree())+ (yPoints[i] - triangle.getCenterY()) * 
					Math.cos((triangle.getDegree())));
			
		}

		yPoints = newY;
	}
	
	public Polygon getRect() {
		return rectangle;
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
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}
