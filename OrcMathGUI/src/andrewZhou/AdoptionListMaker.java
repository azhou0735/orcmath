package andrewZhou;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AdoptionListMaker {

	private ArrayList<Dog> list;
	public static Scanner in = new Scanner(System.in);
	
	public AdoptionListMaker() {
		list = new ArrayList<Dog>();
		/*list.add(new Dog(60, 2, "1", "Huskey"));
		list.add(new Dog(4000, 4, "1", "Clifford"));
		list.add(new Dog(10, 7, "1", "Chihuahua"));*/
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//AdoptionListMaker a= new AdoptionListMaker();
		//System.out.println(a.getCsvContent());
		
		String input;
		boolean making = false;
		AdoptionListMaker a = new AdoptionListMaker();
		
		System.out.println("Would you like to load a file?");
		input = in.nextLine();
		if(input.equalsIgnoreCase("yes")) {
			System.out.println("What's the file name?");
			boolean looking = true;
			while(looking) {
				try {
					input=in.nextLine();
					FileReader fileReader = new FileReader(new File(input));
					List<String> content = new ArrayList<String>();
					String line = "";

					 BufferedReader br = new BufferedReader(fileReader);
					 while ((line = br.readLine()) != null) {
						 content.add(line);
						 }
					 for(String i: content) {
						 List<String> temp = Arrays.asList(i.split(","));
						 a.addDog(new Dog(Integer.parseInt(temp.get(0)), Integer.parseInt(temp.get(1)), temp.get(2), temp.get(3)));
					 }
					 System.out.println("Would you like to add on to the list?");
					 input = in.nextLine();
					 if(input.equalsIgnoreCase("yes")) {
						 looking = false;
						 making = true;
					 }else {
						 looking = false;
					 }
				}catch(IOException e) {
					System.out.println("The file name you specified does not exist.");
				}
			}
		}else {
			making = true;
		}
		
		while(making) {
			int weight;
			int age;
			String gender;
			String breed;
			
			weight = askForIntWithInput("How heavy is your dog?");
			age = askForIntWithInput("How old is the dog?");
			
			System.out.println("Gender?");
			input = in.nextLine();
			gender = input;
			System.out.println("Breed?");
			input = in.nextLine();
			breed = input;
			
			a.addDog(new Dog(weight,age,gender,breed));
			System.out.println(a.getCsvContent());
			
			System.out.println("Add more?");
			input = in.nextLine();
			if(input.equalsIgnoreCase("yes")) {
			}else {
				making = false;
			}

			System.out.println("Save the file");
			input = in.nextLine();
			a.testSaveContent(input);
		}
		
		
	}
	
	public void addDog(Dog a) {
		this.list.add(a);
	}
	
	public void testSaveContent(String fileName) {
		 try{    
		 FileWriter fw=new FileWriter(fileName);    
		 fw.write(this.getCsvContent());    
		 fw.close();    
		 System.out.println("Success! File \""+fileName+".csv\" saved!");
		 }catch(IOException e){
		 System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		 }
	 }
	
	public static int askForIntWithInput(String question) {
		boolean properAnswer = false;
		String input = "1";
		while(!properAnswer) {
			System.out.println(question);
			input = in.nextLine();
			try{Integer.parseInt(input); properAnswer = true;}catch(NumberFormatException e) {}
			
		}
		return Integer.parseInt(input);
	}
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

	public String getCsvContent(){
		String data = "";
		for(Dog a:list) {
			data += a + "\n";
		}
		return data;
	}

}
