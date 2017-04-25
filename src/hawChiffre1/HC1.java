package hawChiffre1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.SecureRandom;

import lCGenerator.LCG;

public class HC1 {
	
	private String pathIn;
	private String pathOut;
	private IOController controller;
	private LCG lcg;
	private java.security.SecureRandom secureRandom;

	public HC1(int startValue, String pathIn, String pathOut){
		this.pathIn = pathIn;
		this.pathOut = pathOut;
		this.controller = new IOController();
		this.lcg = new LCG(startValue);
		this.secureRandom = new SecureRandom();
		this.secureRandom.setSeed(startValue);
	}
	
	public void encryptFileWithLCG() throws FileNotFoundException, IOException{
		byte[] file = controller.readFile(this.pathIn);
		
		for(int i = 0; i < file.length; i++){
			int schluessel = this.lcg.nextInt();
			file[i] = (byte) (file[i] ^ schluessel);
		}
		
		
		this.controller.writeFile(file, pathOut);
	}
	
	public void encryptFileWithSecureRandom() throws FileNotFoundException, IOException{
		byte[] file = controller.readFile(this.pathIn);
		
		for(int i = 0; i < file.length; i++){
			int schluessel = this.secureRandom.nextInt();
			file[i] = (byte) (file[i] ^ schluessel);
		}
		
		
		this.controller.writeFile(file, pathOut);
	}
	
	
	
	
	 public static void main(String[] args){
		if(args.length == 3) {
			int startValue = Integer.valueOf(args[0]).intValue();
			String pathIn = args[1];
			String pathOut = args[2];
			HC1 hc1 = new HC1(startValue, pathIn, pathOut);
			
			try {
				hc1.encryptFileWithLCG();
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
