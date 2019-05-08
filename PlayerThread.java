/*
 * PlayerThread.java
 */

//Grid display updates should be handled by the threads during play.
//  Should update every time they make a move.

// https://docs.oracle.com/javase/tutorial/essential/concurrency/syncrgb.html
// https://www.javatpoint.com/synchronization-in-java

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
import java.util.ArrayList;

public class PlayerThread implements Runnable {

    //fields
    private String threadName;
    private Thread t;
    private boolean isWinner;
    private boolean hasCarrot;
    private Board board;

    //constructor 
    public PlayerThread(String name, Board referenceToBoard) {
        threadName = name;
        board = referenceToBoard;

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
                movePlayer();
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
    
    
    
    //moves player to random adjacent spot
    // We can make this more elegant later. For looping through the whole grid is silly.
    //Locks down board do that it can't change while this is being run.
    private void movePlayer() {
        synchronized (board) {
            
            //get current location
            
            int[] currentLocation = new int[2];
            
            //~ Space[][] boardCopy = board.getBoard();
            
            for (int i = 0; i < board.getROWS(); i++) {
                for (int j = 0; j < board.getCOLUMNS(); j++) {
                    
                    //~ if ( boardCopy[i][j].isThisPlayerHere( threadName ) ) {
                        //~ currentLocation[0] = i;
                        //~ currentLocation[1] = j;
                    if ( board.board[i][j].isThisPlayerHere( threadName ) ) {
                        currentLocation[0] = i;
                        currentLocation[1] = j;
                    }
                }
            }
            System.out.println(threadName + " is currently at:" + currentLocation[0] + "," + currentLocation[1]);
            
            ArrayList<int[]> possibleMoves = new ArrayList<int[]>();
            
            //                               row             col                       hasCarrot
            if ( board.canPlayerMoveHere(currentLocation[0] - 1, currentLocation[1], hasCarrot) ) { //up
                possibleMoves.add( new int[] { currentLocation[0] - 1, currentLocation[1]} );
            }
            if ( board.canPlayerMoveHere(currentLocation[0] + 1, currentLocation[1], hasCarrot) ) { //down
                possibleMoves.add( new int[] { currentLocation[0] + 1, currentLocation[1]} );
            }
            if ( board.canPlayerMoveHere(currentLocation[0], currentLocation[1] - 1, hasCarrot) ) { //left
                possibleMoves.add( new int[] { currentLocation[0], currentLocation[1] - 1} );
            }
            if ( board.canPlayerMoveHere(currentLocation[0], currentLocation[1] + 1, hasCarrot) ) { //right
                possibleMoves.add( new int[] { currentLocation[0], currentLocation[1] + 1} );
            }
            
            //Check how many moves can be made
            int numPossibleMoves = possibleMoves.size();
            
            if ( numPossibleMoves == 0 ) {
                System.out.println(threadName + " cannot move!  This message is from PlayerThread.movePlayer() ");
                return; //exits this method.
            }
            
            Random randomObject = new Random();
            
            int wayToPick = randomObject.nextInt( numPossibleMoves );
            
            //  Move to that Space.
            //      (deleting self from current space + adding self to new space)
            
            
            moveThisPlayerToThatSpace( currentLocation, possibleMoves.get(wayToPick));
            
            System.out.println(threadName + ": Has moved!");
            System.out.println("From: " + currentLocation[0] + "," + currentLocation[1] + "   to: " + possibleMoves.get(wayToPick)[0] + "," + possibleMoves.get(wayToPick)[1]);
            board.printBoard();
            
            
        }
    }
    
    
    //Method that handles moving players around
    private void moveThisPlayerToThatSpace(int[] currentSpace, int[] wayToGo) {
        //  If have carrot, also move carrot.
        if ( hasCarrot ) {
            board.board[ currentSpace[0] ][ currentSpace[1] ].removeOccupant( "Carrot" );
            board.board[ wayToGo[0] ][ wayToGo[1] ].setOccupant( "Carrot" );
        }
        
        //set player as being in new space
        board.board[ wayToGo[0] ][ wayToGo[1] ].setOccupant( threadName );
        
        //remove player from old space
        board.board[ currentSpace[0] ][ currentSpace[1] ].removeOccupant( threadName );
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

}
