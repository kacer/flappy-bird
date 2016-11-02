package cz.uhk.fim.pro2.game.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class HomeScreen extends Screen {
	
	public HomeScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		JButton btnPlay = new JButton("Play");
		JButton btnScore = new JButton("Score");
		JButton btnSound = new JButton("Sound");
		
		JLabel lbTitle = new JLabel("FIM BIRD");
		
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
		
		lbTitle.setFont(new Font("Arial", Font.BOLD, 40));
		
		lbTitle.setBounds(100, 100, 460, 100);
		btnPlay.setBounds(100, 400, 280, 50);
		btnScore.setBounds(100, 460, 280, 50);
		btnSound.setBounds(100, 520, 280, 50);
		
		add(lbTitle);
		add(btnPlay);
		add(btnScore);
		add(btnSound);
		
	}

}
