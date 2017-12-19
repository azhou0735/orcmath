package andrewZhou;

import guiTeacher.GUIApplication;

public class CatalogMakerGUI extends GUIApplication{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5098155837358756420L;

	public CatalogMakerGUI(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		// TODO Auto-generated method stub
		CatalogScreen s = new CatalogScreen(getWidth(),getHeight());
		setScreen(s);
	}

	public static void main(String[] args) {
		CatalogMakerGUI sample = new CatalogMakerGUI(800,550);
		Thread go = new Thread(sample);
		go.start();
	}
	
}
