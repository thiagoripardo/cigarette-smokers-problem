package monitor;

import java.util.Random;

public class Agent extends Thread{
	
	private int randomIngredient;
	private Random random = new Random();
	private String ingredient1 = new String();
	private String ingredient2 = new String();
	public AgentSmokerMonitor monitor;
	
	public Agent(AgentSmokerMonitor monitor) {
		this.monitor = monitor;
	}
	@Override
	public void run() {
		
		while(true) {

			this.randomIngredient = this.random.nextInt(3);
			if (this.randomIngredient == 0) {
				this.ingredient1 = "Tabacco";
				this.ingredient2 = "Paper";
			} 
			else if (this.randomIngredient == 1) {
				this.ingredient1 = "Tabacco";
				this.ingredient2 = "Matches";
			} 
			else if (this.randomIngredient == 2) {
				this.ingredient1 = "Matches";
				this.ingredient2 = "Paper";
			}
			
			this.monitor.depositIngredients(this.ingredient1, this.ingredient2);
			
		}
	}
}
