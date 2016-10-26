package cz.uhk.fim.pro2.game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class HomeScreen extends Screen {
	
	public HomeScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		JButton btnPlay = new JButton("Play");
		JButton btnScore = new JButton("Score");
		JButton btnSound = new JButton("Sound");
		
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
		
		add(btnPlay);
		add(btnScore);
		add(btnSound);
		
	}

}
