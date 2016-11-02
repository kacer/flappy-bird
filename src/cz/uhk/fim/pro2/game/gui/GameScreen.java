package cz.uhk.fim.pro2.game.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

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
		btnBack.setFont(new Font("Arial", Font.PLAIN, 11));
		btnBack.setForeground(Color.BLUE);
		btnPause.setBounds(400, 20, 60, 60);
		
		add(btnBack);
		add(btnPause);
		
		Bird bird = new Bird("Martin", 240, 400);
		World world = new World(bird);
		world.addTube(new Tube(400, 400, Color.GREEN));
		world.addTube(new Tube(600, 300, Color.GREEN));
		world.addTube(new Tube(800, 500, Color.GREEN));
		
		world.addHeart(new Heart(500, 450));
		world.addHeart(new Heart(700, 600));
		
		GameCanvas gameCanvas = new GameCanvas(world);
		gameCanvas.setBounds(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);
		add(gameCanvas);
	}

}
