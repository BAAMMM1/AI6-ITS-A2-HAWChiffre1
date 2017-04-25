package hawChiffre1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.SecureRandom;

import lCGenerator.LCG;

public class HC1 {
	

	private IOController controller;
	private java.security.SecureRandom secureRandom;

	public HC1(){
		this.controller = new IOController();
		
	}
	
	public void cryptFile(int startValue, String pathIn, String pathOut, boolean lcgFlag) throws FileNotFoundException, IOException{
		LCG lcg = new LCG(startValue);
		
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.setSeed(startValue);
		
		byte[] file = controller.readFile(pathIn);
		
		for(int i = 0; i < file.length; i++){
			int schluessel;
			if(lcgFlag){
				schluessel = lcg.nextInt();
			} else {
				schluessel = secureRandom.nextInt();
			}
			
			/*
			 * XOR in Java ^
			 */
			file[i] = (byte) (file[i] ^ schluessel);
		}
		
		this.controller.writeFile(file, pathOut);
	}

	
	
	 public static void main(String[] args){
		if(args.length == 3) {
			int startValue = Integer.valueOf(args[0]).intValue();
			String pathIn = args[1];
			String pathOut = args[2];
			HC1 hc1 = new HC1();
			
			try {
				hc1.cryptFile(startValue, pathIn, pathOut, true);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		} else {
			throw new IllegalArgumentException("Parameter: Startwert, In-Dateipfad, Out-Dateipfad");
		}
	}

}
