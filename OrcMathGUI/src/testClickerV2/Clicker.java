package testClickerV2;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class Clicker extends Button {

	private String display;
	
	public Clicker(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
		update();
	}

	public void setString(String string) {
		display = string;
	}

	public void drawButton(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.drawRect(275,450,200,200);
		g.drawString(display, 0, 0);
	}
}
