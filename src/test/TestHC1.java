package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import hawChiffre1.HC1;
import hawChiffre1.IOController;
import utility.Printer;

public class TestHC1 {

	private static final int START_VALUE = 1;
	private static final String TEST_SOURCE_FILE_PATH = "test/source.txt";
	private static final String TEST_LCG_FILE_ENCRYPT_PATH = "test/LCG-EnCrpyt.txt";
	private static final String TEST_LCG_FILE_DECRYPT_PATH = "test/LCG-DeCrpyt.txt";
	
	private static final String TEST_SECURE_RANDOM_FILE_ENCRYPT_PATH = "test/SecureRandom-EnCrpyt.txt";
	private static final String TEST_SECURE_RANDOM_FILE_DECRYPT_PATH = "test/SecureRandom-DeCrpyt.txt";

	public TestHC1() {

	}

	public void startTest() {
		Printer.promptTestOut(this, "Starte HC1 Test");
		IOController controller = new IOController();
		HC1 hc1 = new HC1();		
		
		try {
			/*
			 * Ausführen mit der selber geschriebenen LCG Klasse
			 */
			hc1.cryptFile(START_VALUE, TEST_SOURCE_FILE_PATH, TEST_LCG_FILE_ENCRYPT_PATH, true);
			hc1.cryptFile(START_VALUE, TEST_LCG_FILE_ENCRYPT_PATH, TEST_LCG_FILE_DECRYPT_PATH, true);

			String fileSource = new String(controller.readFile(TEST_SOURCE_FILE_PATH));
			String fileLCG_DeEnCrypt = new String(controller.readFile(TEST_LCG_FILE_DECRYPT_PATH));
			
			/*
			 * TODO Diff
			 */
			Printer.promptTestOut(this, "File sind gleich: " + fileSource.equals(fileLCG_DeEnCrypt) + " mit LCG");
			
			/*
			 * Ausführung mit der SecureRandom Klasse
			 */
			hc1.cryptFile(START_VALUE, TEST_SOURCE_FILE_PATH, TEST_SECURE_RANDOM_FILE_ENCRYPT_PATH, false);
			hc1.cryptFile(START_VALUE, TEST_SECURE_RANDOM_FILE_ENCRYPT_PATH, TEST_SECURE_RANDOM_FILE_DECRYPT_PATH, false);

			String fileSecureRandom_DeEnCrypt = new String(controller.readFile(TEST_SECURE_RANDOM_FILE_DECRYPT_PATH));

			/*
			 * TODO Diff
			 */
			Printer.promptTestOut(this, "File sind gleich: " + fileSource.equals(fileSecureRandom_DeEnCrypt) + " mit SecureRandom");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Printer.promptTestOut(this, "Beende HC1 Test");
	}

	public static void main(String[] args) {
		TestHC1 testHC1 = new TestHC1();
		testHC1.startTest();
	}

	@Override
	public String toString() {
		return String.format("TestHC1");
	}

}
