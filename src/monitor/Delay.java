package monitor;

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
        	int sleeptime = (int) (duration * Math.random() );
        	try { Thread.sleep(sleeptime*1000); }
        	catch (InterruptedException e) {}
	}	
}
