package D20;

import java.util.Random;


public class D20 {
	public D20() {
		
	}
	public int rolarD20() {
	    Random random = new Random();
	    int resultado = random.nextInt(20) + 1;
	    return resultado;
	}
}