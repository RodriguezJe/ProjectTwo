/*
 * MountainRace.java
 */

import java.util.Random;

public class MountainRace {

    public static void main(String[] args) throws InterruptedException {

    String nameOfTheWinner = Play();
        
    System.out.println( nameOfTheWinner + "WINS!!!!!!!!!!!!!!!!!" );
    
    }
    
    
    public static String Play() throws InterruptedException {
        System.out.println("B-Bugs Bunny D-Taz Devil T-Tweety M-Marvin F-Mountain C-Carrot");
        
        //Create Game Board
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
        
        //print the starting board
        gameBoard.printBoard();
        
        //Start the race!
        bugsThread.start();
        tazDevilThread.start();
        tweetyThread.start();
        marvinThread.start();
        
        //wait for threads to complete
        bugsThread.join();
        tazDevilThread.join();
        tweetyThread.join();
        marvinThread.join();
        
        String nameOfWinner = gameBoard.getNameOfWinner();
        return nameOfWinner;
    }
}
