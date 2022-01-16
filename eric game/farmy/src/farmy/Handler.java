package farmy;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	PlayerBullet tempBullet;
	
	public static LinkedList<PlayerBullet> bullets = new LinkedList<PlayerBullet>();
	
	public static void addBullet(int x, int y, double velX, double velY) {
		bullets.add(new PlayerBullet(x, y, velX, velY));
	}
	
	public static LinkedList<PlayerBullet> getBulletList(){
		return bullets;
	}
	
	public void tick() {
		for (int i= 0; i< object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
		for (int i= 0; i< bullets.size(); i++) {
			tempBullet = bullets.get(i);
			tempBullet.tick();
			
		}
	}
	public void render(Graphics g) {
		for (int i= 0; i< object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.render(g);
	}
		for (int i= 0; i< bullets.size(); i++) {
			tempBullet = bullets.get(i);
			tempBullet.render(g);
			
			}
		for (int x = 0; x< bullets.size(); x++) {
			int count = bullets.get(x).getBulletTimer();
			if (count >= 130) {
				bullets.remove(x);
			}
	}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	public static void removeBullet(PlayerBullet bullet) {
		Handler.bullets.remove(bullet);
	}
}
