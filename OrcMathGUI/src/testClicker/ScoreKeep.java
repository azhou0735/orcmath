package testClicker;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.TextArea;

public class ScoreKeep extends TextArea {

	private String score = "";
	
	public ScoreKeep(int x, int y, int w, int h, String text) {
		super(x, y, w, h, text);
		score = "";
		update();
		
	}
	public void update(Graphics2D g) {
		super.clear();
		g.setColor(Color.BLACK);
		g.drawString("Score:", 0, 100);
	}
	public void setScore(int score) {
		this.score = "Score: " + score;
		update();
	}

}
