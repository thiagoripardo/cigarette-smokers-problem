package monitor;

public class Smoker extends Thread{
	
	private String myIngredient;
	private String missingIngredients;
	private Agent agent;
	private String name;
	
	public Smoker(Agent agent, String ingredient, String name) {
		
		this.agent = agent;
		this.myIngredient = ingredient;
		this.name = name;
		
		if (this.myIngredient.equals("Tabacco")) {
			this.missingIngredients = "Matches and Paper";
		}
		else if (this.myIngredient.equals("Paper")) {
			this.missingIngredients = "Tabacco and Matches";
		}
		else if (this.myIngredient.equals("Matches")) {
			this.missingIngredients = "Tabacco and Paper";
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			//receive ingredient
			//make cigarrete
			//smoke
		}
	}

}
