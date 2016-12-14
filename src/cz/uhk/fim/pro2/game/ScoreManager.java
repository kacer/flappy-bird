package cz.uhk.fim.pro2.game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScoreManager {
	
	//DEFINICE TRIDY
	private List<Integer> scoreList;

	private ScoreManager() {
		this.scoreList = new ArrayList<>();
	}
	
	public void addScore(int score) {
		
		List<Integer> scoreList = getAll();
		scoreList.add(score);
		
		try {
			FileWriter fileWriter = new FileWriter(Game.SCORE_FILE);
			
			for(int value : scoreList) {
				fileWriter.append(String.valueOf(value));
				fileWriter.append(";");
				fileWriter.append(new Date().toGMTString());
				fileWriter.append("\n");
			}
			
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Chyba pri zapisovani");
		}
		scoreList.add(score);
	}
	
	public List<Integer> getAll() {
		
		List<Integer> scoreList = new ArrayList<>();
		
		FileReader fileReader;
		try {
			fileReader = new FileReader(Game.SCORE_FILE);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line;
			while((line = bufferedReader.readLine()) != null) {
				String[] values = line.split(";");
				scoreList.add(Integer.valueOf(values[0]));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Chyba pri nacitani");
		}
		
		return scoreList;
	}
	
	
	//SINGLETON
	private static ScoreManager instance;
	
	public static ScoreManager getIntstance() {
		
		if(instance == null) {
			instance = new ScoreManager();
		}
		
		return instance;
		
	}

	
	//VEREJNE STATICKE METODY
	public static void putScore(int score) {
		getIntstance().addScore(score);		
	}
	
	public static List getList() {
		return getIntstance().getAll();
	}
	
	public static int size() {
		return getList().size();
	}
	
	public static int get(int i) {
		return (int) getList().get(i);
	}
	
}
