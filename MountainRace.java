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
        

        PlayerThread bugsBunnyObject = new PlayerThread("Bugs");
        Thread bugsThread = new Thread(bugsBunnyObject,"Bugs");
        
        PlayerThread tazDevilObject = new PlayerThread("TazDevil");
        Thread tazDevilThread = new Thread(tazDevilObject, "TazDevil");
        
        PlayerThread tweetyObject = new PlayerThread("Tweety");
        Thread tweetyThread = new Thread(tweetyObject, "Tweety");
        
        PlayerThread marvinObject = new PlayerThread("Marvin");
        Thread marvinThread = new Thread(marvinObject, "Marvin");
        
		bugsThread.start();
		tazDevilThread.start();
		tweetyThread.start();
		marvinThread.start();
		
        //while no winner
        //  .start() NEW player threads to carry out moving the player around the board.
        //  when each thread starts they lock the board data structure from other threads.
        //      each thread checks to see where they can move and moves there
        //      if they land on carrot it follows them now
        //      if have carrot and move to mountain their isWinner flag is set to true.
        //          Then they interrupt the other threads and then themself.
        //  Each thread unlocks the board after they are done and terminate themselves.
        //  
        //check to see which player has a winner flag.
        //return the winner's name.
        
        
		String nameOfWinner = "testing!";
		return nameOfWinner;
	}
}
