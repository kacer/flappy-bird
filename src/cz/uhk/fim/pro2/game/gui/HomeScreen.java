package cz.uhk.fim.pro2.game.gui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;

public class HomeScreen extends Screen {
	
	private BufferedImage background;
	
	public HomeScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		try {
			background = ImageIO.read(new File("assets/menu-background.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		JButton btnPlay = new JButton("Hrát");
		JButton btnScore = new JButton("Skóre");
		JButton btnSound = new JButton("Zvuk");

		
		btnPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new GameScreen(mainFrame));
			}
		});
		
		btnScore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new ScoreScreen(mainFrame));	
			}
		});
		
		btnPlay.setBounds(100, 400, 280, 50);
		btnScore.setBounds(100, 460, 280, 50);
		btnSound.setBounds(100, 520, 280, 50);
		
		add(btnPlay);
		add(btnScore);
		add(btnSound);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(background, 0, 0, MainFrame.WIDTH, MainFrame.HEIGHT, null);
	}

}
