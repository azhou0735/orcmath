package myTest;

import guiTeacher.GUIApplication;

public class MyMain extends GUIApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5515668624330878266L;

	private static MyMain main;
	private static MyScreen screen;
	
	public MyMain(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		screen = new MyScreen(getWidth(),getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		main = new MyMain(600,600);
		Thread app = new Thread(main);
		app.run();
	}

}
