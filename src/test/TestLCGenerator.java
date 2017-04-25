package test;

import lCGenerator.LCG;
import utility.Printer;

public class TestLCGenerator {

	private static final long START_VALUE = 1;
	private static final int RUNS = 256;
	private LCG lCG;

	public TestLCGenerator() {
		super();
	}

	public void startTest() {
		Printer.prompt(this, "Starte LCG Test");
		this.initTest();
		this.computeTest();
		Printer.prompt(this, "Beende LCG Test");
	}

	private void initTest() {
		this.lCG = new LCG(START_VALUE);
		Printer.prompt(this, "START_VALUE: " + START_VALUE + " - a: " + this.lCG.getA()
				+ " - b: " + this.lCG.getB() + " - N: " + this.lCG.getN());
	}

	private void computeTest() {
		for (int i = 0; i < RUNS - 1; i++) {
			Printer.prompt(this, "" + (this.lCG.nextInt() & 0x000000FF));
		}
	}

	@Override
	public String toString() {
		return "TestLCG";
	}
	
	public static void main(String[] args){	
		TestLCGenerator testLCG = new TestLCGenerator();
		testLCG.startTest();
		
	}


}
