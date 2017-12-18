package andrewZhou;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Dog extends /*Animated*/Component {

	int weight;
	int age;
	String gender;
	String breed;
	String profilePic;
	
	public Dog(int weight, int age, String gender, String breed) {
		super(40, 40, 435, 234);
		this.weight = weight;
		this.age = age;
		this.gender = gender;
		this.breed = breed;
		/*addSequence("resources/dog_sprite_running.png", 150, 1, 1, 340, 200, 4);
		Thread animation = new Thread(this);
		animation.start();
		update();*/
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		/*g.setColor(Color.DARK_GRAY);
		  g.fillRect(0, 0, getWidth(), getHeight());*/
		//super.update(g);
	}

	public String toString() {
		return this.weight +","+this.age+","+this.gender+","+this.breed;
	}
}
