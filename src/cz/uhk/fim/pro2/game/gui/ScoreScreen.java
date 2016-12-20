package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import cz.uhk.fim.pro2.game.ScoreManager;

public class ScoreScreen extends Screen {
	
	private BufferedImage background;
	private Font fontFredoka;

	public ScoreScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		try {
			background = ImageIO.read(new File("assets/score-background.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			fontFredoka = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/FredokaOne-Regular.ttf")).deriveFont(Font.PLAIN, 30);
		} catch (FontFormatException | IOException e) {
			fontFredoka = new Font("Calibri", Font.BOLD, 30);
		}
		
		JLabel lbName = new JLabel("Skóre");
		lbName.setFont(fontFredoka.deriveFont(Font.PLAIN, 56));
		lbName.setBounds(160, 20, 200, 100);
		
		JLabel lbPosition = new JLabel("Pozice");
		lbPosition.setFont(fontFredoka);
		lbPosition.setBounds(100, 150, 120, 50);
		
		JLabel lbScore = new JLabel("Skóre");
		lbScore.setFont(fontFredoka);
		lbScore.setBounds(250, 150, 120, 50);
		
		add(lbName);
		add(lbPosition);
		add(lbScore);
		
		Color transparent = new Color(0,0,0,0);
		
		for(int i = 0; i < ScoreManager.size(); i++) {
			int score = ScoreManager.get(i);
			
			ScoreItem scoreItem = new ScoreItem(i + 1, score);
			scoreItem.setBounds(120, 200 + i * 50, 300, 50);
			scoreItem.setBackground(transparent);
			add(scoreItem);
		}
		
		JButton btnBack = new JButton(new ImageIcon("assets/back.png"));
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));				
			}
		});
		
		btnBack.setBounds(5, 5, 40, 40);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 11));
		btnBack.setForeground(Color.BLUE);
		
		add(btnBack);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(background, 0, 0, MainFrame.WIDTH, MainFrame.HEIGHT, null);
	}

}
