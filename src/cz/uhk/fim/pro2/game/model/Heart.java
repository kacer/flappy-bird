package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Heart {
	
	private float positionX, positionY;

	public Heart(float positionX, float positionY) {
		super();
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		
		Rectangle rectangle = getRectangle();
		
		g.fillRect(
				(int) rectangle.getX(), 
				(int) rectangle.getY(),
				(int) rectangle.getWidth(),
				(int) rectangle.getHeight()
		);
	}
	
	public Rectangle getRectangle() {
		return new Rectangle(
			(int) getPositionX() - 25, 
			(int) getPositionY() - 25,
			50,
			50
		);
	}
	
	public void update(float deltaTime) {
		positionX -= World.SPEED * deltaTime;
	}
	
	public static float getRandomY() {
		return (new Random().nextFloat() * 300) + 200;
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
