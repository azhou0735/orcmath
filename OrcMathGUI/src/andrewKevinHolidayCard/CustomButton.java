package andrewKevinHolidayCard;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public abstract class CustomButton extends Button {

	private String string1;
	private String string2;
	private Color color1;

	public CustomButton(int x, int y) {
		super(x, y, 40, 100, "", null);
		// TODO Auto-generated constructor stub
	}
	
	public void drawButton(Graphics2D g, boolean hover){
		g.setColor(Color.BLACK);
		g.drawString(string1, 10, 10);
		g.drawString(string2, 10, 10);
		g.setColor(color1);
		g.drawRect(0, 0, 20, 20);
		g.fillRect(0, 0, 20, 20);
	}
	
	public void update(){
		
	}
	
	public void updateString1(String string) {
		
		
	}

	public void updateString2(String string) {
		
	}

	public void setIconColor(Color color) {
		
	}
}
