package shieldio;

import java.awt.Graphics;
import java.util.ArrayList;

public class PlayerHandler {

	private ArrayList<Player> playerList = new ArrayList<Player>();
	
	public void tick() {
		for(int i = 0; i < playerList.size(); i++) {
			Player player = playerList.get(i);
			player.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < playerList.size(); i++) {
			Player player = playerList.get(i);
			player.render(g);
		}
	}
	
	public void addPlayer(Player player) {
		this.playerList.add(player);
	}
	
	public void removePlayer(Player player) {
		this.playerList.remove(player);
	}
	
	public ArrayList<Player> getPlayerList(){
		return playerList;
	}
	
}
