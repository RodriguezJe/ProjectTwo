/*
 * MarvinThread.java
 * 
 * Gives marvin more abilities.
 * 
 */


public class MarvinThread extends PlayerThread {
    
    //marvin has a special movePlayer method that will allow stepping on other players.
    private void movePlayer() {
        
    }
    

    public MarvinThread(String name, Board referenceToBoard) {
        super(name, referenceToBoard);
    }
    
    
    //Used when marvin steps on another player's square.
    private void killOtherPlayer() {
        //"take" carrot if they have one
        //  Carrot will now be moved when marvin moves.
        //  also set the hasCarrot flag
        //"kill" other player thread by interrupting. there should be some sort
        //  of kill thread thing in the catch block.
        //  Remove them from the board. Don't remove carrot!
    }
    
    //Allows marvin to move the mountain to a random open square.
    private void moveMountain() {
        
    }
}

