package sv.hawklibrary.com.validators;

import java.util.Random;

public class RandomInt {

	public int nextTenDigitsRnaodm() {
		
		Random random = new Random();
		int number =  random.nextInt(1000000000)+1;
		return number;
	}
	
}
