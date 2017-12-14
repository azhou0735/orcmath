package andrewZhou;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class Sidewalk extends Component {

	public Sidewalk() {
		super(40, 40, 100, 100);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.GRAY);
		g.drawRect(0, 0, getWidth(), getHeight());
	}

}
