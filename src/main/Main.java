package main;

import java.io.FileNotFoundException;
import java.io.IOException;

import hawChiffre1.HC1;

public class Main {

	// Test
	public static void main(String[] args) {
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
