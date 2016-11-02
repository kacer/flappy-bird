package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GameScreen extends Screen {

	public GameScreen(MainFrame mainFrame) {
		super(mainFrame);
		
		JButton btnBack = new JButton("Back");
		JButton btnPause = new JButton("Pause");
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));
			}
		});
		
		btnBack.setBounds(20, 20, 60, 60);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 8));
		btnBack.setForeground(Color.BLUE);
		btnPause.setBounds(400, 20, 60, 60);
		
		add(btnBack);
		add(btnPause);
	}

}
