package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import guiTeacher.Utilities;
import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonAndrew extends Button implements ButtonInterfaceAndrew {

	private Color bColor;
	private int x;
	private int y;
	private Action action;
	
	public ButtonAndrew(int x, int y, int w, int h, Action action) {
		super(x, y, w, h, "", action);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub
		this.x = x;
	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y = y;
	}
	@Override
	public void setAction(Action a) {
		// TODO Auto-generated method stub
		this.action = a;
	}

	@Override
	public void highlight() {
		// TODO Auto-generated method stub
		Color currentColor = bColor;
		Utilities.lighten(currentColor, 50);
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		this.bColor = color;
	}

	public void act() {
		action.act();
	}
	
	@Override
	public void dim() {
		// TODO Auto-generated method stub
		Color currentColor = bColor;
		Utilities.lighten(currentColor, -50);
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		System.out.println("Drawing");
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(bColor);
		g.drawRect(x, y, getWidth(), getHeight());
		g.fillRect(x,y,getWidth(),getHeight());
	}

}
