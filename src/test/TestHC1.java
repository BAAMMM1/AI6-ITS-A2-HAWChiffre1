package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import hawChiffre1.HC1;
import hawChiffre1.IOController;
import utility.Printer;

public class TestHC1 {

	private static final int START_VALUE = 1;
	private static final String TEST_LCG_FILE_PATH = "Test1.txt";
	private static final String TEST_LCG_FILE_ENCRYPT_PATH = "Test1EnCrpyt.txt";
	private static final String TEST_LCG_FILE_DECRYPT_PATH = "Test1DECrpyt.txt";
	
	private static final String TEST_SECURE_RANDOM_FILE_PATH = "Test2.txt";
	private static final String TEST_SECURE_RANDOM_FILE_ENCRYPT_PATH = "Test2EnCrpyt.txt";
	private static final String TEST_SECURE_RANDOM_FILE_DECRYPT_PATH = "Test2DECrpyt.txt";

	public TestHC1() {

	}

	public void startTest() {
		Printer.promptTestOut(this, "Starte HC1 Test");
		IOController controller = new IOController();
		HC1 hc1LCG = new HC1(START_VALUE, TEST_LCG_FILE_PATH, TEST_LCG_FILE_ENCRYPT_PATH);
		HC1 hc2LCG = new HC1(START_VALUE, TEST_LCG_FILE_ENCRYPT_PATH, TEST_LCG_FILE_DECRYPT_PATH);
		
		HC1 hc1SecureRandom = new HC1(START_VALUE, TEST_SECURE_RANDOM_FILE_PATH, TEST_SECURE_RANDOM_FILE_ENCRYPT_PATH);
		HC1 hc2SecureRandom = new HC1(START_VALUE, TEST_SECURE_RANDOM_FILE_ENCRYPT_PATH, TEST_SECURE_RANDOM_FILE_DECRYPT_PATH);
		
		try {
			/*
			 * Ausführen mit der selber geschriebenen LCG Klasse
			 */
			hc1LCG.encryptFileWithLCG();
			hc2LCG.encryptFileWithLCG();

			String fileLCG_Defualt = new String(controller.readFile(TEST_LCG_FILE_PATH));
			String fileLCG_DeEnCrypt = new String(controller.readFile(TEST_LCG_FILE_DECRYPT_PATH));

			Printer.promptTestOut(this, "File sind gleich: " + fileLCG_Defualt.equals(fileLCG_DeEnCrypt) + " mit LCG");
			
			/*
			 * Ausführung mit der SecureRandom Klasse
			 */
			hc1SecureRandom.encryptFileWithLCG();
			hc2SecureRandom.encryptFileWithLCG();

			String fileSecureRandom_Default = new String(controller.readFile(TEST_SECURE_RANDOM_FILE_PATH));
			String fileSecureRandom_DeEnCrypt = new String(controller.readFile(TEST_SECURE_RANDOM_FILE_DECRYPT_PATH));

			Printer.promptTestOut(this, "File sind gleich: " + fileSecureRandom_Default.equals(fileSecureRandom_DeEnCrypt) + " mit SecureRandom");

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
