package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import cz.uhk.fim.pro2.game.ScoreManager;

public class ScoreScreen extends Screen {

	public ScoreScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		for(int i = 0; i < ScoreManager.size(); i++) {
			int score = ScoreManager.get(i);
			
			ScoreItem scoreItem = new ScoreItem(i + 1, score);
			scoreItem.setBounds(50, 200 + i * 50, 300, 50);
			add(scoreItem);
		}
		
		JButton btnBack = new JButton("Back");
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));				
			}
		});
		
		btnBack.setBounds(20, 20, 60, 60);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 11));
		btnBack.setForeground(Color.BLUE);
		
		add(btnBack);
	}

}
