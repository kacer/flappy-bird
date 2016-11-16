package cz.uhk.fim.pro2.game.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sun.corba.se.impl.logging.POASystemException;

import cz.uhk.fim.pro2.game.gui.MainFrame;

public class Tube {
	
	private float positionX;
	private float height;
	private Color color;
	
	private static final int GAP = 200;
	
	public Tube(float positionX, float height, Color color) {
		super();
		this.positionX = positionX;
		this.height = height;
		this.color = color;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		
		Rectangle topRectangle = getTopRectangle();
		Rectangle bottomRectangle = getBottomRectangle();
		
		g.fillRect(
			(int) topRectangle.getX(), 
			(int) topRectangle.getY(),
			(int) topRectangle.getWidth(),
			(int) topRectangle.getHeight() 
		);
		
		g.fillRect(
			(int) bottomRectangle.getX(), 
			(int) bottomRectangle.getY(),
			(int) bottomRectangle.getWidth(),
			(int) bottomRectangle.getHeight() 
		);
		
	}
	
	public Rectangle getTopRectangle() {
		return new Rectangle(
			(int) getPositionX() - 25, 
			0,
			50,
			(int) height - GAP 
		);
	}
	
	public Rectangle getBottomRectangle() {
		return new Rectangle(
			(int) getPositionX() - 25, 
			(int) height,
			50,
			(int) (MainFrame.HEIGHT - height) 
		);
	}
	
	public void update(float deltaTime) {
		positionX -= World.SPEED * deltaTime;
	}
	
	public float getPositionX() {
		return positionX;
	}

	public void setPositionX(float positionX) {
		this.positionX = positionX;
	}

	public float getHeight() {
		return height;
	}

	public Color getColor() {
		return color;
	}
	
	
	
	//TODO konstrukto, gettery, settery a toString()

}
