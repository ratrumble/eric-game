package shieldio;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;



public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 0;
	
	public static final int WIDTH = 960, HEIGHT = WIDTH /12 * 9;
	
	private Thread thread;
	private boolean running = false;
	private PlayerHandler playerHandler;
	private BulletHandler bulletHandler;
	
	public Game() {

		new Window(WIDTH, HEIGHT, "SHIELDIO", this);
		
		playerHandler = new PlayerHandler();
		bulletHandler = new BulletHandler();
		
		playerHandler.addPlayer(new Player(480, 480, 100, "Eric"));
		
		this.addKeyListener(new KeyInput(playerHandler, bulletHandler));
		this.addMouseListener(new KeyInput(playerHandler, bulletHandler));
		this.addMouseMotionListener(new KeyInput(playerHandler, bulletHandler));

	}
	
		public synchronized void start() {
			thread = new Thread(this);
			thread.start();
			running = true;
		}
		public synchronized void stop() {
			try {
				thread.join();
				running = false;
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}

		public void run() {
		
			this.requestFocus();
			long lastTime = System.nanoTime();
			double amountOfTicks = 60.0;
			double ns = 1000000000 / amountOfTicks;
			double delta = 0;

			while(running) {
				long now = System.nanoTime();
				delta += (now - lastTime) / ns;
				lastTime = now;
				while(delta >= 1) {
					tick();
					delta--;
				}
				if(running) {
					render();
				}
				
				
			}
			stop();
		}

		private void tick() {
			playerHandler.tick();
			bulletHandler.tick();
		}
		

		private void render() {
			BufferStrategy bs = this.getBufferStrategy();
			if (bs == null) {
				this.createBufferStrategy(3);
				return;
		}
			
			Graphics g = bs.getDrawGraphics();
			g.setColor(Color.darkGray);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			
			bulletHandler.render(g);
			playerHandler.render(g);

			
			
			
			g.dispose();
			bs.show();
		}
		

		public static int clamp(int var, int min, int max) {
			if(var >= max)
				return var = max;
			else if (var <= min)
				return var = min;
			else
				return var;
		}
		
		public static void main (String args[]) {
			new Game();
		}
}

