package andrewZhou;

import java.util.List;

import guiTeacher.components.Button;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2719674095375736401L;

	private TextField weight;
	private TextField age;
	private TextField gender;
	private TextField breed;
	private Button b;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		//new TextField(x, y, w, h, text)
		
		weight = new TextField(40,40,200,40,"Enter weight","Weight");
		viewObjects.add(weight);
		age = new TextField(40,120,200,40,"Enter age","Age");
		viewObjects.add(age);
		gender = new TextField(40,200,200,40,"Enter gender","Gender");
		viewObjects.add(gender);
		breed = new TextField(40,280,200,40,"Enter breed","Breed");
		viewObjects.add(breed);
		b = new Button(40, 320, w, h, text, action)
	}

}
