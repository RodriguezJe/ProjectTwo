/*
 * MarvinThread.java
 * 
 * Gives marvin more abilities.
 * 
 */

import java.util.Random;
import java.util.ArrayList;

public class MarvinThread extends PlayerThread {

    public MarvinThread(String name, Board referenceToBoard) {
        super(name, referenceToBoard);
    }
    
    //override run() method
    public void run() {
        
        while ( !isWinner ) {
            try {
                this.movePlayer(); // needs to throw an interrupt exception. based on a flag on board.
                //Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                System.out.println(threadName + " has been interrupted!");
                break;
            } catch (Exception e) {
                System.out.print(e.toString() + "A weird exception happened.");
            }
        }
    }
    
    //marvin has a special movePlayer method that will allow stepping on other players.
    private void movePlayer() throws InterruptedException {
        synchronized (board) {
            
            if ( board.getIsThereAWinner() ) { //don't forget to set this in board!!!!!!!!!!!!!!!!!!!!!!
                throw new InterruptedException ("Game over");
            }
            
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
            if ( board.canMarvinMoveHere(currentLocation[0] - 1, currentLocation[1], hasCarrot) ) { //up
                possibleMoves.add( new int[] { currentLocation[0] - 1, currentLocation[1]} );
            }
            if ( board.canMarvinMoveHere(currentLocation[0] + 1, currentLocation[1], hasCarrot) ) { //down
                possibleMoves.add( new int[] { currentLocation[0] + 1, currentLocation[1]} );
            }
            if ( board.canMarvinMoveHere(currentLocation[0], currentLocation[1] - 1, hasCarrot) ) { //left
                possibleMoves.add( new int[] { currentLocation[0], currentLocation[1] - 1} );
            }
            if ( board.canMarvinMoveHere(currentLocation[0], currentLocation[1] + 1, hasCarrot) ) { //right
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
            
            
            moveMarvinToThatSpace( currentLocation, possibleMoves.get(wayToPick));
            
            System.out.println(threadName + ": Has moved!");
            System.out.println("From: " + currentLocation[0] + "," + currentLocation[1] + "   to: " + possibleMoves.get(wayToPick)[0] + "," + possibleMoves.get(wayToPick)[1]);
            board.printBoard();
            
            //increase counter for mt
            Board.mtCounter++;
            System.out.println ("increasing counter "+ Board.mtCounter);
            
            
            if((Board.mtCounter) %3==0 ){
                System.out.println("Mountain needs to move");
                updateMountain();
                board.mtLocation();
                
            }
            
           
            
            //press enter to continue
            System.out.println("Press enter to continue");
            try{
                System.in.read();
            }
            catch(Exception e) {
                //do nothing
            }
            System.out.println("Press enter to continue");
            
            //if on carrot, set hasCarot!
            if ( isPlayerOnCarrot( possibleMoves.get(wayToPick)[0], possibleMoves.get(wayToPick)[1] ) ) {
                setHasCarrot();
            }
            
            //if have carrot and on mountain, set this player as winner
            System.out.println("Checking if "+threadName+ " is the winner...");
            if ( hasCarrot && isPlayerOnMountain( possibleMoves.get(wayToPick)[0], possibleMoves.get(wayToPick)[1] ) ) {
                
                System.out.println(threadName + " is the winner! WOW!");
                setPlayerAsWinner();
                board.setWinner(threadName);
                
            }
            
            
        }
    
    }
    

    
    
    //Used when marvin steps on another player's square.
    private void killOtherPlayer(int row, int col) throws InterruptedException {
        //removes any other players from the space
        if ( board.board[row][col].getIsBugsHere() ) {
            System.out.println("Marvin killed Bugs!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            board.board[row][col].removeOccupant("Bugs");
            Thread.currentThread().sleep(5000);
        }
        if ( board.board[row][col].getIsTweetyHere() ) {
            System.out.println("Marvin killed Tweety!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            board.board[row][col].removeOccupant("Tweety");
            Thread.currentThread().sleep(5000);
        }
        if ( board.board[row][col].getIsBugsHere() ) {
            System.out.println("Marvin killed TazDevil!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            board.board[row][col].removeOccupant("TazDevil");
            Thread.currentThread().sleep(5000);
        }
    }
    
    //Allows marvin to move the mountain to a random open square.
    public void moveMountain() {
        
        
    }
    
    
    //Method that handles moving players around
    private void moveMarvinToThatSpace(int[] currentSpace, int[] wayToGo) throws InterruptedException {
        //  If have carrot, also move carrot.
        if ( hasCarrot ) {
            board.board[ currentSpace[0] ][ currentSpace[1] ].removeOccupant( "Carrot" );
            board.board[ wayToGo[0] ][ wayToGo[1] ].setOccupant( "Carrot" );
        }
        
        //set marvin as being in new space
        board.board[ wayToGo[0] ][ wayToGo[1] ].setOccupant( threadName );
        
        //remove marvin from old space
        board.board[ currentSpace[0] ][ currentSpace[1] ].removeOccupant( threadName );
        
        //remove any other players
        killOtherPlayer( wayToGo[0], wayToGo[1] );
    }
    
}

