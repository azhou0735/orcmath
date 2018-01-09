package myStuff;

import java.awt.Graphics2D;

import guiTeacher.interfaces.Visible;

public interface ProgressInterfaceAndrew extends Visible {

	void gameOver();

	void setRound(int a);
	
	void setSequenceSize(int a);

	void update(Graphics2D g);
	
}
