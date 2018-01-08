package myStuff;

import java.awt.Color;

import guiTeacher.Utilities;
import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class SunnyButton extends Button implements ButtonInterfaceAndrew{

	public SunnyButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void highlight() {
		// TODO Auto-generated method stub
		Color currentColor = getBackground();
		Utilities.lighten(currentColor, 50);
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		setBackground(color);
	}

	@Override
	public void dim() {
		// TODO Auto-generated method stub
		Color currentColor = getBackground();
		Utilities.lighten(currentColor, -50);
	}

}
