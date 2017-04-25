package main;

import java.io.IOException;

import hawChiffre1.IOController;

public class Main {
	

	
	public static void main(String[] args){
		IOController controller = new IOController();	
		try {
			byte[] file1 = controller.readFile("Test1.txt");
			byte[] file2 = controller.readFile("Test1DeChiff.txt");
			
			String fileString1 = new String(file1);
			String fileString2 = new String(file2);
			
			System.out.println(fileString1);
			System.out.println(fileString2);
			System.out.println(fileString1.equals(fileString2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
