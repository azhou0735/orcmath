package testClicker;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

import com.itextpdf.awt.geom.Rectangle;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ClickyButton extends Button {

	private int status;
	private Action a;
	
	public ClickyButton(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, "", color, action);
		update();
	}

	public void drawButton(Graphics2D g) {
		g.setColor(Color.blue);
		Shape rect = (Shape) new Rectangle(0,0,300,150);
		g.draw(rect);
		g.fill(rect);
		g.setColor(Color.BLACK);
		if(status == 0) {
			g.drawString("Start", 100, 300);
		}
		if(status == 1) {
			g.drawString("Wait", 100, 300);
		}

		if(status == 2) {
			g.drawString("CLICK", 100, 300);
		}
		if(status == 3) {
			g.drawString("Game Over", 100, 300);
		}
	}
	
	public void setStatus(int s) {
		this.status = s;
		update();
	}
}
