package andrewKevinHolidayCard;

import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class HolidayCardScreen1 extends FullFunctionScreen implements FileRequester {

	/**
	 * 
	 */
	private static final long serialVersionUID = -176461641319223724L;

	private Button switchscreen;
	
	public HolidayCardScreen1(int width, int height) {
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
		switchscreen = new Button(40, 40, 40, 20, "BACK", new Action() {
			@Override
			public void act() {
				nextScreen();
			}
		});
		viewObjects.add(switchscreen);
	}

	protected void nextScreen() {
		// TODO Auto-generated method stub
		HolidayCardMaker.sample.setScreen(HolidayCardMaker.sample.s1);
	}

}
