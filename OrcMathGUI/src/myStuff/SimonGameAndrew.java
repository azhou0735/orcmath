package myStuff;

import guiTeacher.GUIApplication;

public class SimonGameAndrew extends GUIApplication  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 913169627728865089L;
	
	public static void main(String[] args) {
		SimonGameAndrew a = new SimonGameAndrew(500,800);
		Thread r = new Thread(a);
		r.run();
	}
	
	public SimonGameAndrew(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		SimonScreenAndrew screen = new SimonScreenAndrew(getWidth(), getHeight());
		setScreen(screen);
	}
	
}
