package andrewZhou;

import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.*;
import guiTeacher.interfaces.*;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen implements FileRequester{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2719674095375736401L;

	private TextField weight;
	private TextField age;
	private TextField gender;
	private TextField breed;
	private TextArea text;
	private Button addbutton;
	private Button savebutton;
	private Button deletebutton;
	private FileOpenButton fileopenbutton;
	
	private AdoptionListMaker catalog;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
		catalog = new AdoptionListMaker();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		//new TextField(x, y, w, h, text)
		
		weight = new TextField(40,40,200,40,"","Weight");
		weight.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(weight);
		age = new TextField(40,120,200,40,"","Age");
		age.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(age);
		gender = new TextField(40,200,200,40,"","Gender");
		viewObjects.add(gender);
		breed = new TextField(40,280,200,40,"","Breed");
		viewObjects.add(breed);
		text = new TextArea(400, 40, 200, 600, "Hello there \n Kenobi");
		viewObjects.add(text);
		addbutton = new Button(40, 330, 100, 20, "Add",new Action() {
			
			@Override
			public void act() {
				addClick();
			}
		});
		viewObjects.add(addbutton);
		savebutton = new Button(40, 360, 100, 20, "Save",new Action() {
			@Override
			public void act() {
				saveClick();
			}
		});
		viewObjects.add(savebutton);
		deletebutton = new Button(40, 390, 100, 20, "Delete",new Action() {
			
			@Override
			public void act() {
				deleteClick();
			}
		});
		viewObjects.add(deletebutton);
		fileopenbutton = new FileOpenButton(40, 420, 100, 20, null, this);
		viewObjects.add(fileopenbutton);
	}

	protected void deleteClick() {
		// TODO Auto-generated method stub
		
	}
	
	protected void saveClick() {
		// TODO Auto-generated method stub
		TextArea temp = new TextArea(x, y, w, h, text)
		
	}

	protected void addClick() {
		//text.setText("Add Button clicked");
		if(age.getText().equals("") || weight.getText().equals("") ) {
		Dog a = new Dog(Integer.parseInt(weight.getText()),Integer.parseInt(age.getText()),gender.getText(),breed.getText());
		text.setText(text.getText() + "\n" + a);

		
		weight.setText("");
		age.setText("");
		gender.setText("");
		breed.setText("");
		catalog.addDog(a);
		}else {}
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

}
