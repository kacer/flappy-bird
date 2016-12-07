package cz.uhk.fim.pro2.game.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreItem extends JPanel {
	
	private JLabel lbIndex, lbScore;
	
	public ScoreItem(int index, int score) {
		setLayout(null);
		
		lbIndex = new JLabel(index + ". ");
		lbIndex.setFont(new Font("Arial", Font.BOLD, 40));
		lbIndex.setBounds(0, 0, 100, 50);
		
		
		lbScore = new JLabel(String.valueOf(score));
		lbScore.setFont(new Font("Arial", Font.BOLD, 40));
		lbScore.setBounds(50, 0, 200, 50);
		
		add(lbIndex);
		add(lbScore);
	}

}
