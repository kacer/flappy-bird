package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.Timer;
import javax.swing.plaf.ActionMapUIResource;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import cz.uhk.fim.pro2.game.interfaces.WorldListener;
import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

public class GameScreen extends Screen implements WorldListener {
	
	public static final int UP_BOUND = 50;
	public static final int DOWN_BOUND = 150;
	
	private long lastTimeMillis;
	private Timer timer;
	private Bird bird;
	private World world;
	
	private BufferedImage imageBird, imageHeart, imageBackground, imageBottom, imageTop, imageTube;
	private Font fontFredoka;

	public GameScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		try {
			fontFredoka = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/FredokaOne-Regular.ttf")).deriveFont(Font.PLAIN, 24);
		} catch (FontFormatException | IOException e) {
			fontFredoka = new Font("Calibri", Font.BOLD, 24);
		}
		
		try {
			imageBird = ImageIO.read(new File("assets/bird.png"));
			imageHeart = ImageIO.read(new File("assets/heart.png"));
			imageTube = ImageIO.read(new File("assets/tube.png"));
			imageBackground = ImageIO.read(new File("assets/background.png"));
			imageTop = ImageIO.read(new File("assets/top.png"));
			imageBottom = ImageIO.read(new File("assets/bottom.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JButton btnBack = new JButton(new ImageIcon("assets/back.png"));
		JButton btnPause = new JButton(new ImageIcon("assets/pause.png"));
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				mainFrame.setScreen(new HomeScreen(mainFrame));
			}
		});
		
		btnPause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(timer.isRunning()) {
					timer.stop();
				} else {
					lastTimeMillis = System.currentTimeMillis();
					timer.start();
				}
			}
		});
		
		btnBack.setBounds(5, 5, 40, 40);
		btnPause.setBounds(430, 5, 40, 40);
		
		add(btnBack);
		add(btnPause);
		
		bird = new Bird("Martin", 240, 400);
		world = new World(bird, this);
		world.generateRandom();
		
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				bird.goUp();
			}
		});
	
		
		timer = new Timer(15, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				long currentTimeMillis = System.currentTimeMillis();
				
				float delta = (currentTimeMillis - lastTimeMillis) / 1000f;
				world.update(delta);
				
				if(!bird.isAlive()) {
					timer.stop();
					mainFrame.setScreen(new FinishScreen(mainFrame, world));
				}
				
				repaint();
				
				lastTimeMillis = currentTimeMillis;
			}
		});
		
		lastTimeMillis = System.currentTimeMillis();
		timer.start();
	}

	@Override
	public void crashTube(Tube tube) {
		bird.removeLive();
		bird.setPositionY(tube.getCenterY());
	}

	@Override
	public void catchHeart(Heart heart) {
		heart.setPositionY(-100);
		bird.catchHeart();
	}

	@Override
	public void outOf() {
		bird.setPositionY(MainFrame.HEIGHT / 2);
		bird.setSpeed(Bird.JUMP / 2);
		bird.removeLive();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(imageBackground, 0, UP_BOUND, MainFrame.WIDTH, MainFrame.HEIGHT - DOWN_BOUND, null);
		
		Bird bird = world.getBird();
		
		bird.paint(g, imageBird);
		
		List<Heart> hearts = world.getHearts();
		for(Heart heart : hearts) {
			heart.paint(g, imageHeart);
		}
		
		List<Tube> tubes = world.getTubes();
		for(Tube tube : tubes) {
			tube.paint(g, imageTube);
		}
		
		g.drawImage(imageTop, 0, 0, MainFrame.WIDTH, UP_BOUND, null);
		
		g.drawImage(imageBottom, 0, MainFrame.HEIGHT - DOWN_BOUND, MainFrame.WIDTH, DOWN_BOUND, null);
		
		g.setColor(Color.WHITE);
		g.setFont(fontFredoka);
		g.drawString("Skóre: " + bird.getScore(), 100, 35);
		g.drawString("Životy: " + bird.getLives(), 270, 35);
	}

}
