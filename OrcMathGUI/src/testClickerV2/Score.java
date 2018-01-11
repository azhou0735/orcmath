package testClickerV2;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class Score extends Component {

	private String display;
	
	public Score(int x, int y, int w, int h) {
		super(x, y, w, h);
		display = "";
		update();
	}

	@Override
	public void update(Graphics2D g) {
		super.clear();
		g.setColor(Color.BLACK);
		g.drawString(display, 100,50);
	}

	public void setScore(int score) {
		display = "Score: " + score;
		update();
	}

}
