package myStuff;

import guiTeacher.GUIApplication;

public class SimonGameAndrew extends GUIApplication  {

	public static void main(String[] args) {
		SimonGameAndrew a = new SimonGameAndrew(500,800);
		Thread r = new Thread(a);
		r.run();
	}
	
	public SimonGameAndrew(int width, int height) {
		super(width, height);
	}

	@Override
	public void initScreen() {
		SimonScreenAndrew screen = new SimonScreenAndrew(getWidth(), getHeight());
		setScreen(screen);
	}
	
}
