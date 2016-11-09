package cz.uhk.fim.pro2.game.model;

import java.util.ArrayList;
import java.util.List;

public class World {
	
	public static final int SPEED = 100;
	
	private Bird bird;
	private List<Tube> tubes;
	private List<Heart> hearts;
	
	public World(Bird  bird) {
		this.bird = bird;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
	}
	
	public void update(float deltaTime) {
		bird.update(deltaTime);
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
