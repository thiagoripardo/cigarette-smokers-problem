package monitor;

public class Smoker extends Thread{
	
	private String myIngredient;
	private String name;
	private AgentSmokerMonitor monitor;
	
	public Smoker(String name, String ingredient, AgentSmokerMonitor monitor) {
		
		this.myIngredient = ingredient;
		this.name = name;
		this.monitor = monitor;
	}
	
	@Override
	public void run() {
		while(true) {
			
			this.monitor.fetchIngredientsAndSmoke(this.name, this.myIngredient);

		}
	}

}
