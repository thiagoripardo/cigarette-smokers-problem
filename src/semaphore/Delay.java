package semaphore;

public class Delay {
	
	private static int TIME = 5;
	
	/**
	 * Delay between zero and TIME seconds.
	 */
	public static void delay() {
		delay(TIME);
	}

	/**
	 * Delay between zero and duration seconds.
	 */
	public static void delay(int duration) {
        	int sleeptime = 1;//(int) (duration * Math.random() );
        	try { Thread.sleep(sleeptime*1500); }
        	catch (InterruptedException e) {}
	}	
}
