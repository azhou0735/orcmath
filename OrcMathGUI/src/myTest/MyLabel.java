package myTest;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class MyLabel extends Component {

	private String myString;
	
	public MyLabel(int x, int y, int w, int h, String text) {
		super(x, y, w, h);
		myString = text;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.drawString(myString, 0, 100);;
	}

	public void setString(String s) {
		super.clear();
		myString = s;
		update();
	}
}
