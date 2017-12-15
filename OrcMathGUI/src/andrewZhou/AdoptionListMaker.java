package andrewZhou;

import java.util.ArrayList;
import java.util.Collections;

public class AdoptionListMaker {

	private ArrayList<Dog> list;
	
	public AdoptionListMaker() {
		list = new ArrayList<Dog>();
		list.add(new Dog(60, 2, 1, "Huskey"));
		list.add(new Dog(4000, 4, 1, "Clifford"));
		list.add(new Dog(10, 7, 0, "Chihuahua"));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdoptionListMaker a= new AdoptionListMaker();
		System.out.println(a.getCsvContent());
	}
	
	public String getCsvContent(){
		String data = "";
		for(Dog a:list) {
			data += a + "\n";
		}
		return data;
	}

}
