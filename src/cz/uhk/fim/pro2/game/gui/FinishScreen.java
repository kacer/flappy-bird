package cz.uhk.fim.pro2.game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import cz.uhk.fim.pro2.game.ScoreManager;
import cz.uhk.fim.pro2.game.model.World;

public class FinishScreen extends Screen {
	
	private JLabel lbScore;
	private JButton btnStart, btnHome;
	
	public FinishScreen(MainFrame mainFrame, World world) {
		super(mainFrame);
		
		int score = world.getBird().getScore();
		
		ScoreManager.putScore(score);
		
		lbScore = new JLabel("Skóre: " + score);
		lbScore.setBounds(100, 100, 280, 50);
		
		btnStart = new JButton("Start");
		btnHome = new JButton("Home");
		
		btnStart.addActionListener(new ActionListener() {
			
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
		
		btnStart.setBounds(100, 400, 280, 50);
		btnHome.setBounds(100, 480, 280, 50);
		
		add(lbScore);
		add(btnStart);
		add(btnHome);
		
	}

}
