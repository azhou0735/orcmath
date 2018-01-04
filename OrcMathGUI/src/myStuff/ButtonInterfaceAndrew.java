package myStuff;

import java.awt.Color;

import guiTeacher.components.*;
import guiTeacher.interfaces.*;

public interface ButtonInterfaceAndrew extends Clickable{

	void setAction(Action a);

	void highlight();

	void setColor(Color color);

	void dim();

}
