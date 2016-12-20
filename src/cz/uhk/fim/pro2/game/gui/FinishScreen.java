package cz.uhk.fim.pro2.game.gui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;

import cz.uhk.fim.pro2.game.ScoreManager;
import cz.uhk.fim.pro2.game.model.World;

public class FinishScreen extends Screen {
	
	private JLabel lbScore;
	private JButton btnPlay, btnHome;
	private Font fontFredoka;
	private BufferedImage background;
	
	public FinishScreen(MainFrame mainFrame, World world) {
		super(mainFrame);
		
		try {
			background = ImageIO.read(new File("assets/background.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			fontFredoka = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/FredokaOne-Regular.ttf")).deriveFont(Font.PLAIN, 50);
		} catch (FontFormatException | IOException e) {
			fontFredoka = new Font("Calibri", Font.BOLD, 30);
		}
		
		int score = world.getBird().getScore();
		
		ScoreManager.putScore(score);
		
		lbScore = new JLabel("Skóre: " + score);
		lbScore.setFont(fontFredoka);
		lbScore.setBounds(130, 100, 280, 50);
		
		btnPlay = new JButton("Hrát znovu");
		btnHome = new JButton("Menu");
		
		btnPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new GameScreen(mainFrame));
			}
		});
		
		btnHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));				
			}
		});
		
		btnPlay.setBounds(100, 400, 280, 50);
		btnHome.setBounds(100, 460, 280, 50);
		
		add(lbScore);
		add(btnPlay);
		add(btnHome);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, MainFrame.WIDTH, MainFrame.HEIGHT, null);
	}

}
