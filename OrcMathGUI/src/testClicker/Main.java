package testClicker;

import guiTeacher.GUIApplication;

public class Main extends GUIApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1044041195117012455L;
	
	private static Main a;
	private static MainGame game;

	public Main(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		game = new MainGame(getWidth(),getHeight());
		setScreen(game);
	}

	public static void main(String[] args) {
		a = new Main(1000,1000);
		Thread run = new Thread(a);
		run.start();
	}

}
