package andrewZhou;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AdoptionListMaker {

	private ArrayList<Dog> list;
	public static Scanner in = new Scanner(System.in);
	
	public AdoptionListMaker() {
		list = new ArrayList<Dog>();
		list.add(new Dog(60, 2, "1", "Huskey"));
		list.add(new Dog(4000, 4, "1", "Clifford"));
		list.add(new Dog(10, 7, "1", "Chihuahua"));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fw = new FileLoadingConsole();
		
		
		AdoptionListMaker a= new AdoptionListMaker();
		System.out.println(a.getCsvContent());
		
		String input;
		
		boolean making = true;
		while(making) {
			int weight = -1;
			int age = -1;
			String gender = "-1";
			String breed = "Mutt";
			weight = askForInt("How heavy is your dog?");
			age = askForInt("How old is the dog?");
			
			/*System.out.println("How heavy is your dog?");
			input = in.nextLine();
			if(input != "" && Integer.parseInt(input) > 0) {
				System.out.println("Good");
				weight = Integer.parseInt(input);
			}else {
				System.out.println("Bad");
			}
			
			System.out.println("How old is the dog?");
			input = in.nextLine();
			if(input != "" && Integer.parseInt(input) > 0) {
				System.out.println("Good");
				age = Integer.parseInt(input);
			}else {
				System.out.println("Bad");
			}
			
			System.out.println("Gender? If boy, enter 1, if girl enter 0");
			input = in.nextLine();
			if(input != "" && (Integer.parseInt(input) == 0 || Integer.parseInt(input) == 1)) {
				System.out.println("Good");
				gender = Integer.parseInt(input);
			}else {
				System.out.println("Bad");
			}*/
			System.out.println("Gender?");
			input = in.nextLine();
			gender = input;
			System.out.println("Breed?");
			input = in.nextLine();
			breed = input;
			
			a.addDog(new Dog(weight,age,gender,breed));
			System.out.println(a.getCsvContent());
			
			System.out.println("Save it as a file");
			
			s.testSaveContent(in.nextLine());
		}
		
	}
	
	public void addDog(Dog a) {
		this.list.add(a);
	}
	
	 static void testSaveContent(String fileName) {

	 try{    

	 FileWriter fw=new FileWriter(fileName);    

	 fw.write("This file was created programmatically.");    

	 fw.close();    

	 System.out.println("Success! File \""+fileName+"\" saved!");

	 }catch(IOException e){

	 System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");

	 }

	     

	 }
	
	public static int askForInt(String question) {
		boolean properAnswer = false;
		String input = "1";
		while(!properAnswer) {
			System.out.println(question);
			input = in.nextLine();
			try{Integer.parseInt(input); properAnswer = true;}catch(NumberFormatException e) {}
			
		}
		return Integer.parseInt(input);
	}

	public String getCsvContent(){
		String data = "";
		for(Dog a:list) {
			data += a + "\n";
		}
		return data;
	}

}
