package andrewKevinHolidayCard;

import java.awt.Color;
import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import andrewZhou.CatalogScreen;
import guiTeacher.components.*;
import guiTeacher.interfaces.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class HolidayCardScreen  extends FullFunctionScreen implements FileRequester{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6665847709487464455L;
	
	/*private List<Visible> viewObjects1;
	private List<Visible> viewObjects2;*/
	private Button switchscreen;
	private TextArea box;
	private TextArea blizzard;
	private Graphic yeti;
	
	public HolidayCardScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setFile(File f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JFrame getWindow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		switchscreen = new Button(40, 40, 40, 20, "NEXT", new Action() {
			@Override
			public void act() {
				nextScreen();
			}
		});
		viewObjects.add(switchscreen);
		
		blizzard = new TextArea(400,400,100,100," Happy \nHolidays");
		viewObjects.add(blizzard);
		
		yeti = new Graphic(400,400,400,400,"C:\\Users\\BT_1N3_06\\git\\orcmath\\OrcMathGUI\\resources\\26c61460eaa8458f0df790a58c91dfdb--monster-illustration-snow-party.jpg");
		viewObjects.add(yeti);
		
		box = new TextArea(getWidth(),getHeight(),getWidth(),getHeight(),"W");
		box.setBackground(new Color(20,20,20));
		viewObjects.add(box);
	}

	protected void nextScreen() {
		//initAllObjects();
		HolidayCardMaker.sample.setScreen(HolidayCardMaker.sample.s2);
	}
}
