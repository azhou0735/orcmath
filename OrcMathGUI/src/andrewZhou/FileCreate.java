package andrewZhou;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileCreate {

	public static Scanner in = new Scanner(System.in);
	
	public static void main(String args[]) {
		String input;
		System.out.println("Say something");
		
		input = in.nextLine();
		String txt = input;
		
		System.out.println("File name?");
		input = in.nextLine();
		saveFile(input, txt);
	}
	
	public static void saveFile(String filename, String txt) {
		 try{    
			 FileWriter fw=new FileWriter(filename);    
			 fw.write(txt);    
			 fw.close();    
			 System.out.println("Success! File \""+filename+"\" saved!");
			 }catch(IOException e){
			 System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
			 }
	}
}
