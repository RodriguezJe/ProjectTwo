/*
 * PlayerThread.java
 */

//Grid display updates should be handled by the threads during play.
//  Should update every time they make a move.



/*
    * try{
    * starting all of them}
    * catch( interrupted exception ){ kill this thread}
    *       Will be thrown when one thread wins or this thread is stepped on by marvin.
    *       Marvin CAN always win; so we don't need to worry about all players dying.
    * 
    * After making a move and unlocking the board for others, sleep for 
    * 1 second +- some random miliseconds.
    * 
    */

import java.util.Random;

public class PlayerThread implements Runnable {

    //fields
    private String threadName;
    private Thread t;
    private boolean isWinner;
    private boolean hasCarrot;

    //constructor 
    public PlayerThread(String name) {
        threadName = name;

    }

    //override run() method
    public void run() {
        
        //LOCK THE BOARD
        
        int x = 5;
        try {
            System.out.println("Thread " +threadName+" is starting...");
            while(x > 0) {
                System.out.println( threadName + ": Hello World!");
                x--;
            }
            Random rando = new Random();
            
            int sleepyTime = rando.nextInt(5);
            System.out.println(threadName + ": I'm going to sleep for " + sleepyTime + " seconds!");
            
            Thread.sleep(sleepyTime * 1000);
            
            System.out.println( "oficcial val of Id:" + Thread.currentThread().getId() + "  givin by me is:" + threadName);
            System.out.println(threadName + ": is exiting...thanks for waiting!");
            
            
            //UNLOCK THE BOARD
            
        } catch (Exception e) {
            System.out.print(e.toString());

        }

    }
    
    
    
    //moves player to random spot
    // We can make this more elegant later. For looping through the whole grid is silly.
    private void movePlayer() {
        //get current location
        
        int[] currentLocation = new int[2];
        
        for (int i = 0; i < Board.getROWS(); i++) {
            for (int j = 0; j < Board.getCOLUMNS(); j++) {
                //~ if ( jjhgjhhj ) {
                    
                //~ }
            }
        }
        
        
        //check how many squares I can move to. numPossibleMoves  (if zero don't move. print a message)
        //  use    canIMoveToHere()  for loop increment counter
        //add each coordinate to a multidimensional array
        //      int[][] moves = new [numPossibleMoves][2]
        //      go through again and add each coordinate pair to the array
        //          maybe use an arraylist?
        //
        
        
        //roll a random number between 0 and numPossibleMoves.
        //  Move to that Space.
        //      (deleting self from current space + adding self to new space)
        
    }

    //setter method
    private void setPlayerAsWinner() {

        isWinner = true;

    }
    //getter method

    public boolean getIsWinner() {

        return isWinner;
    }

    public void setHasCarrot() {

        hasCarrot = true;
    }

    public void getHasCarrot() {

    }

}
