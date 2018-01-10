package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.*;
import guiTeacher.interfaces.*;

public interface ButtonInterfaceAndrew extends Clickable{

	void setAction(Action a);

	void highlight();

	void setColor(Color color);

	void dim();

}
