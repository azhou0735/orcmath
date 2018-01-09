package myStuff;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import guiTeacher.components.Component;

public class ProgressAndrew extends Component implements ProgressInterfaceAndrew {

	private int round;
	private int sequenceSize;
	private boolean gameOver;
	private int x;
	private int y;
	
	public ProgressAndrew(int x, int y, int w, int h) {
		super(x, y, w, h);
		this.x = x;
		this.y = y;
		// TODO Auto-generated constructor stub
	}
	
	public void gameOver() {
		gameOver = true;
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if(gameOver) {
			g.drawString("Game Over", x, y);
		}else {

			g.drawString("Level: "+sequenceSize, x, y);
			g.drawString("Round: "+round, x+30, y+30);
		}
	}

	@Override
	public void setRound(int roundNumber) {
		// TODO Auto-generated method stub
		round = roundNumber;
	}

	@Override
	public void setSequenceSize(int size) {
		// TODO Auto-generated method stub
		sequenceSize = size;
	}
}
