package monitor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import semaphore.Delay;

public class AgentSmokerMonitor {
	private Lock lock = new ReentrantLock();
	private Condition notFull = lock.newCondition();
	private Condition notEmpty =lock.newCondition();
	private int count = 0, n = 2;
	private String ingredient1 = new String();
	private String ingredient2 = new String();
	
	public void depositIngredients(String ingredient1, String ingredient2) {
		
		lock.lock();
		try {
			while(count == n) 
				this.notFull.await();
			
			this.ingredient1 = ingredient1;
			this.ingredient2 = ingredient2;
			System.out.println("I am the agent and I offer " + this.ingredient1 + " and " + this.ingredient2);
		    this.count = 2;
		    this.notEmpty.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void fetchIngredientsAndSmoke(String name, String ingredient) {
		lock.lock();
		try {
			while (count == 0) {
				this.notEmpty.await();
			}
			
			if (!this.haveThisIngredient(ingredient)) {
				Delay.delay();
				Delay.delay();
				System.out.println("I am the " + name + " and I have " + ingredient + 
						". So I will make a cigarette with your " + this.ingredient1 + 
						" and " + this.ingredient2);
				Delay.delay();
				System.out.println("Making");
				Delay.delay();
				System.out.println("Smoking");
				Delay.delay();
				this.count = 0;
				this.notFull.signal();
			} else
				this.notEmpty.signal();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public boolean haveThisIngredient(String ing) {
		if(this.ingredient1.equals(ing) || this.ingredient2.equals(ing)) {
			return true;
		}
		return false;
	}
}
