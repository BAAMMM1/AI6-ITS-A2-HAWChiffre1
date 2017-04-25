package lCGenerator;

import test.TestLCGenerator;

public class LCG {
	
	/*
	 * Festewerte aus der Datei "LinearerKongruenz-generator-infos.pdf"
	 */
	private static final long A_DEFAULT = 16807;
	private static final long B_DEFAULT = 0;
	private static final long N_DEFAULT = (long) (Math.pow(2.0, 31.0)-1);
	
	private long a = A_DEFAULT;
	private long b = B_DEFAULT;
	private long n = N_DEFAULT;
	private long xAccu;


	public LCG(long startValueSeed){
		/*
		 * xk => x0 => startValueSeed
		 */
		this.xAccu = startValueSeed;
	}
	
	public LCG(long startValueSeed, long a, long b, long n){
		this.xAccu = startValueSeed;
		this.a = a;
		this.b = b;
		this.n = n;
	}
	

	// Fortschaltfunktion
	public int nextInt(){		
		
		//xk+1 = ((a*xk1)+b) % n
		this.xAccu = ((a*xAccu) + b) % n;
		
		/*
		 * Wirft eine Exception, falls der int überläuft
		 */
		return Math.toIntExact(this.xAccu);
	}

	public long getA() {
		return a;
	}

	public long getB() {
		return b;
	}

	public long getN() {
		return n;
	}
		
	

}
