package shieldio;

import java.awt.Graphics;
import java.util.ArrayList;

public class BulletHandler {
	
	private ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
	
	public void tick() {
		for(int i = 0; i < bulletList.size(); i++) {
			Bullet bullet = bulletList.get(i);
			bullet.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < bulletList.size(); i++) {
			Bullet bullet = bulletList.get(i);
			bullet.render(g);
		}
	}
	
	public void addBullet(Bullet bullet) {
		this.bulletList.add(bullet);
	}
	
	public void removeBullet(Bullet bullet) {
		this.bulletList.remove(bullet);
	}
	
	public ArrayList<Bullet> getBulletList(){
		return bulletList;
	}
}
