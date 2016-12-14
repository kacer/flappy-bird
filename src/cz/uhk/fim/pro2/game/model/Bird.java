package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import cz.uhk.fim.pro2.game.gui.GameCanvas;
import cz.uhk.fim.pro2.game.gui.MainFrame;


public class Bird {

	public static final int DEFAULT_SCORE = 0;
	public static final int DEFAULT_LIVES = 3;
	public static final int JUMP = 500;
	
	private static final int GRAVITY = 300;
	
	private String name;
	private float positionX, positionY;
	private float speed;
	private int lives;
	private int score;
	
	public Bird(String name, float positionX, float positionY) {
		this.name = name;
		this.positionX = positionX;
		this.positionY = positionY;
		speed = JUMP / 2;
		lives = DEFAULT_LIVES;
		score = DEFAULT_SCORE;
	}
	
	public void paint(Graphics g, BufferedImage image) {
		g.setColor(Color.BLUE);
		
		Rectangle rectangle = getRectangle();
		
		g.drawImage(
				image, 
				(int) rectangle.getX(), 
				(int) rectangle.getY(),
				(int) rectangle.getWidth(),
				(int) rectangle.getHeight(),
				null
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
		positionY -= speed * deltaTime;
		positionY += GRAVITY * deltaTime;
		
		speed -= speed * deltaTime;
	}
	
	public boolean colliedWith(Tube tube) {
		Rectangle rectangle = getRectangle();
		
		return 	rectangle.intersects(tube.getBottomRectangle()) ||
				rectangle.intersects(tube.getTopRectangle());
	}
	
	public boolean colliedWith(Heart heart) {
		return getRectangle().intersects(heart.getRectangle());
	}
	
	public boolean isOutOf() {		
		int upLimit = GameCanvas.UP_BOUND;
		int downLimit = MainFrame.HEIGHT - GameCanvas.DOWN_BOUND;
		
		return getRectangle().getMinY() < upLimit || getRectangle().getMaxY() > downLimit;
	}
	
	public void goUp() {
		speed = JUMP;
	}
	
	public void catchHeart() {
		lives++;
	}
	
	public void removeLive() {
		lives--;
	}
	
	public void addPoint() {
		score++;
	}
	
	public boolean isAlive() {
		return lives > 0;
	}
	
	public String getName() {
		return name;
	}
	public float getPositionX() {
		return positionX;
	}
	
	public float getPositionY() {
		return positionY;
	}

	public void setPositionY(float positionY) {
		this.positionY = positionY;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getScore() {
		return score;
	}

	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}
	
}
