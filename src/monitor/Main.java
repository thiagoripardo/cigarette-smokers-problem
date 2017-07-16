package monitor;

public class Main {

	public static void main(String[] args) {
		
		Agent agent = new Agent();
       
        agent.start();
        new Smoker(agent, "Tabacco", "Smoker 1").start();
        new Smoker(agent, "Paper", "Smoker 2").start();
        new Smoker(agent, "Matches", "Smoker 3").start();
        
	}
}
