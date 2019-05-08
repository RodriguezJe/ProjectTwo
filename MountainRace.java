/*
 * MountainRace.java
 */


//two options for marvin killing threads. Kill the thread or make it sleep for MAX_INT seconds.

//a "turn" should be a thread waiting for 1 second after it has finished it's main loop.

import java.util.Random;

public class MountainRace {

    public static void main(String[] args) throws InterruptedException {

	String nameOfTheWinner = Play();
        
	System.out.println( nameOfTheWinner + "WINS!");
	
	//print grid state
				
			
    }
    
    
    public static String Play() {
		System.out.println("B-Bugs Bunny D-Taz Devil T-Tweety M-Marvin F-Mountain C-Carrot");
        Grid gameGrid = new Grid();
        gameGrid.createGrid();
        

        PlayerThread bugsBunnyObject = new PlayerThread("B");
        Thread bugsThread = new Thread(bugsBunnyObject,"B");
        
        PlayerThread tazDevilObject = new PlayerThread("D");
        Thread tazDevilThread = new Thread(tazDevilObject, "D");
        
        PlayerThread tweetyObject = new PlayerThread("T");
        Thread tweetyThread = new Thread(tweetyObject, "T");
        
        PlayerThread marvinObject = new PlayerThread("M");
        Thread marvinThread = new Thread(marvinObject, "M");
        
		bugsThread.start();
		tazDevilThread.start();
		tweetyThread.start();
		marvinThread.start();
		
		String nameOfWinner = "testing!";
		return nameOfWinner;
	}
}
