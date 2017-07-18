package monitor;

public class Main {

	public static void main(String[] args) {
		
		AgentSmokerMonitor monitor = new AgentSmokerMonitor();
		Agent agent = new Agent(monitor);
       
        agent.start();
        new Smoker("Smoker 1", "Tabacco", monitor).start();
        new Smoker("Smoker 2", "Paper", monitor).start();
        new Smoker("Smoker 3", "Matches", monitor).start();
        
	}
}
