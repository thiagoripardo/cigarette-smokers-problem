package semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Agent extends Thread{
	
	private int randomIngredient;
	private Random random = new Random();
	private String myIngredients = new String();
	
	@Override
	public void run() {
		
		while(true) {
			
			this.randomIngredient = this.random.nextInt(3);
			if (this.randomIngredient == 0) {
				this.myIngredients = "Tabacco and Paper";
			} 
			else if (this.randomIngredient == 1) {
				this.myIngredients = "Tabacco and Matches";
			} 
			else if (this.randomIngredient == 2) {
				this.myIngredients = "Matches and Paper";
			}
			
			
		}
	}
}
