package myTest;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class MyButton extends Button {

	private String myString;
	
	public MyButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		myString = text;
		update();
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		g.setColor(Color.RED);
		g.draw(new Rectangle(0, 0, 200, 200));
		g.fill(new Rectangle(0, 0, 200, 200));
		if(myString != null) {
			g.setColor(Color.BLACK);
			g.drawString(myString, 0, 100);
		}
	}
	
	public void setString(String s) {
		myString = s;
		update();
	}

}
