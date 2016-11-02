package cz.uhk.fim.pro2.game.model;

public class Heart {
	
	private float positionX, positionY;

	public Heart(float positionX, float positionY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public float getPositionX() {
		return positionX;
	}

	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}

	public float getPositionY() {
		return positionY;
	}

	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}
	
	
	//TODO konstruktor, gettery, settery a toString()

}
