package cz.uhk.fim.pro2.game.model;

import java.util.ArrayList;
import java.util.List;

import cz.uhk.fim.pro2.game.interfaces.WorldListener;

public class World {
	
	public static final int SPEED = 100;
	
	private Bird bird;
	private List<Tube> tubes;
	private List<Heart> hearts;
	private WorldListener worldListener;
	
	public World(Bird  bird, WorldListener worldListener) {
		this.bird = bird;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
		this.worldListener = worldListener;
	}
	
	public void update(float deltaTime) {
		bird.update(deltaTime);
		
		if(bird.isOutOf()) {
			worldListener.outOf();
		}
		
		for(Tube tube : tubes) {
			tube.update(deltaTime);
			
			if(bird.colliedWith(tube)) {
				worldListener.crashTube(tube);
			}
		}
		
		for(Heart heart : hearts) {
			heart.update(deltaTime);
			
			if(bird.colliedWith(heart)) {
				worldListener.catchHeart(heart);
			}
		}
	}
	
	public void addTube(Tube tube) {
		tubes.add(tube);
	}
	
	public void addHeart(Heart heart) {
		hearts.add(heart);
	}
	
	public List<Tube> getTubes() {
		return tubes;
	}

	public List<Heart> getHearts() {
		return hearts;
	}

	public String toString() {
		return "Bird: " + bird.getName() + 
				" PosX: " + bird.getPositionX() + 
				" PosY: " + bird.getPositionY() + 
				"\nHearts: " + hearts.size() + " Tubes: " + tubes.size();
	}

	public Bird getBird() {
		return bird;
	}

}
