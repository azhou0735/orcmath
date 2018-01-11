package testClicker;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class Header extends Component {

	private String display;
	
	public Header(int x, int y, int w, int h) {
		super(x, y, w, h);
		display = "";
		update();
	}

	@Override
	public void update(Graphics2D g) {
		super.clear();
		g.setColor(Color.BLACK);
		g.drawString(display, 0, 100);
	}

	public void setCurrentTime(int i) {
		display = "Time: " + i;
		update();
	}

}
