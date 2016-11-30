package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import cz.uhk.fim.pro2.game.interfaces.WorldListener;

public class World {
	
	public static final int SPEED = 100;
	
	private static final int SPACE_BETWEEN_TUBES = 300;
	private static final int SPACE_BETWEEN_HEARTS = 450;
	
	private Bird bird;
	private List<Tube> tubes;
	private List<Heart> hearts;
	private WorldListener worldListener;
	private boolean generated;
	
	public World(Bird  bird, WorldListener worldListener) {
		this.bird = bird;
		tubes = new ArrayList<>();
		hearts = new ArrayList<>();
		this.worldListener = worldListener;
	}
	
	public void update(float deltaTime) {
		if(generated) {
			regenerate();
		}
		
		bird.update(deltaTime);
		
		if(bird.isOutOf()) {
			worldListener.outOf();
		}
		
		for(Tube tube : tubes) {
			tube.update(deltaTime);
			
			if(bird.colliedWith(tube)) {
				tube.setFlew(true);
				worldListener.crashTube(tube);
			} else {
				if(!tube.isFlew() && 
					bird.getPositionX() > tube.getMaxX()) {
						bird.addPoint();
						tube.setFlew(true);
				}
			}
		}
		
		for(Heart heart : hearts) {
			heart.update(deltaTime);
			
			if(bird.colliedWith(heart)) {
				worldListener.catchHeart(heart);
			} 
		}
	}
	
	public void generateRandom() {
		for(int i = 0; i < 3; i++) {
			addTube(new Tube(SPACE_BETWEEN_TUBES + i * SPACE_BETWEEN_TUBES, Tube.getRandomHeight(), Color.GREEN));
		}
		
		addHeart(new Heart(SPACE_BETWEEN_HEARTS, Heart.getRandomY()));
		
		generated = true;
	}
	
	private void regenerate() {
		for(Tube tube : tubes) {
			if(tube.getPositionX() < -100) {
				tube.setPositionX(tube.getPositionX() + tubes.size() * SPACE_BETWEEN_TUBES);
				tube.setHeight(Tube.getRandomHeight());
				tube.setFlew(false);
			}
		}
		
		for(Heart heart : hearts) {
			if(heart.getPositionX() < -100) {
				heart.setPositionX(heart.getPositionX() + (hearts.size() + 1) * SPACE_BETWEEN_HEARTS);
				heart.setPositionY(heart.getRandomY());
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
