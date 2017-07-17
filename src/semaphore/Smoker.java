package semaphore;

import java.util.concurrent.Semaphore;

public class Smoker extends Thread{
	
	private String myIngredient;
	private Agent agent;
	private String name;
	private Semaphore mutexS;
	
	public Smoker(Agent agent, String ingredient, String name, Semaphore mutexS) {
		
		this.agent = agent;
		this.myIngredient = ingredient;
		this.name = name;
		this.mutexS = mutexS;
	}
	
	@Override
	public void run() {
		while(true) {
			//receive ingredient
			//make cigarette
			//smoke
			
			try {
				this.agent.full.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				this.mutexS.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (this.agent.haveThisIngredient(this.myIngredient)) {
				this.mutexS.release();
				this.agent.full.release();
				continue;
			}
			
			Delay.delay();
			System.out.println("I am the " + this.name + " and I have " + this.myIngredient + 
					". So I will make a cigarette with your " + this.agent.getIngredient1() + 
					" and " + this.agent.getIngredient2());
			Delay.delay();
			System.out.println("Making");
			Delay.delay();
			System.out.println("Smoking");
			Delay.delay();
			
			this.mutexS.release();
			this.agent.empty.release();	
		}
	}

}
