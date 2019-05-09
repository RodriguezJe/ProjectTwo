/*
 * MountainRace.java
 */


//a "turn" should be a thread waiting for 1 second after it has finished its main loop?
//Maybe wait 1 second +- random miliseconds. That way the threads won't always execute in the same order.

//Will be able to tell if a thread has won by checking for a custom exception
//  It will extend the InterruptedException class. If it causes winner to be returned, or something,
//  it will kill all other running threads and set the main while loop to (isWinner == true)
//  or something like that to make it stop.

//NEVER USE THREAD.stop()
//  https://www.javaspecialists.eu/archive/Issue056.html

import java.util.Random;

public class MountainRace {

    public static void main(String[] args) throws InterruptedException {

    String nameOfTheWinner = Play();
        
    //System.out.println( nameOfTheWinner);
    
    //print grid state
                
            
    }
    
    
    public static String Play() {
        System.out.println("B-Bugs Bunny D-Taz Devil T-Tweety M-Marvin F-Mountain C-Carrot");
        
        //Create Game Board
        //Currently infinite looping
        Board gameBoard = new Board();
        gameBoard.mtLocation();
        

        PlayerThread bugsBunnyObject = new PlayerThread("Bugs", gameBoard);
        Thread bugsThread = new Thread(bugsBunnyObject,"Bugs");
        
        PlayerThread tazDevilObject = new PlayerThread("TazDevil", gameBoard);
        Thread tazDevilThread = new Thread(tazDevilObject, "TazDevil");
        
        PlayerThread tweetyObject = new PlayerThread("Tweety", gameBoard);
        Thread tweetyThread = new Thread(tweetyObject, "Tweety");
        
        PlayerThread marvinObject = new MarvinThread("Marvin", gameBoard);//note need MarvinThread here.
        Thread marvinThread = new Thread(marvinObject, "Marvin");
        
        //print the board
        gameBoard.printBoard();
        
        
        bugsThread.start();
        tazDevilThread.start();
        tweetyThread.start();
        marvinThread.start();
        
        //wait for threads to complete
        
        
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
        
        //System.out.println("Final State of board:");
        //gameBoard.printBoard();
        //System.out.println("The winner is: ");
        
        String nameOfWinner = "testing!";
        return nameOfWinner;
    }
}
