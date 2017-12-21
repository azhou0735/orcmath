package andrewKevinHolidayCard;

import guiTeacher.GUIApplication;

public class HolidayCardMaker extends GUIApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = -448346274737675637L;
	
	public static HolidayCardMaker sample;
	public static HolidayCardScreen s1;
	public static HolidayCardScreen1 s2;


	public HolidayCardMaker(int width, int height) {
		super(width, height);
		setVisible(true);
		s1 = new HolidayCardScreen(800, 1100);
		s2 = new HolidayCardScreen1(800, 1100);
	}

	public static void main(String[] args) {
		sample = new HolidayCardMaker(1200,1650);
		Thread go = new Thread(sample);
		go.start();
	}

	@Override
	public void initScreen() {
		HolidayCardScreen s = new HolidayCardScreen(getWidth(),getHeight());
		setScreen(s);
	}

}
