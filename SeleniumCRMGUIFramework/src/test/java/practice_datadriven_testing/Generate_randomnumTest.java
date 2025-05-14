package practice_datadriven_testing;

import java.util.Random;

public class Generate_randomnumTest {

	public static void main(String[] args) {
		
		
		Random random = new Random();
		int num = random.nextInt(1000);
		System.out.println(num);
	}

}
