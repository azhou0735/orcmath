package testClickerV2;

import guiTeacher.GUIApplication;

public class Main extends GUIApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = -985089487745403157L;

	private static Main main;
	private static Game game;
	
	public Main(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		game = new Game(750, 750);
		setScreen(game);
	}

	public static void main(String[] args) {
		main = new Main(750,750);
		Thread s = new Thread(main);
		s.run();
	}

}
