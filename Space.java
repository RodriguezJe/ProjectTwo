/*
 * Space.java
 * 
 */

public class Space {

    private int row;
    private int column;
    
    private boolean isBugsHere;
    private boolean isTazDevilHere;
    private boolean isTweetyHere;
    private boolean isMarvinHere;
    
    private boolean isCarrotHere;
    private boolean isMountainHere;
    

    public Space(int row, int column) {
        this.row = row;
        this.column = column;

    }
    
    //pass the name of the new occupant to set as true.
    protected void setOccupant(String newOccupant) {
        if ( newOccupant.equals("Bugs") ){
            isBugsHere = true;
        }
        else if ( newOccupant.equals("TazDevil") ){
            isTazDevilHere = true;
        }
        else if ( newOccupant.equals("Tweety") ){
            isTweetyHere = true;
        }
        else if ( newOccupant.equals("Marvin") ){
            isMarvinHere = true;
        }
        else if ( newOccupant.equals("Carrot") ){
            isCarrotHere = true;
        }
        else if ( newOccupant.equals("Mountain") ){
            isMountainHere = true;
        }
        else{
            System.out.println("!INCORRECT INPUT STRING! IN Space.setOccupant() !");
        }
    }
    
    //pass the name of occupant to remove
    protected void removeOccupant(String occupantToRemove) {
        if ( occupantToRemove.equals("Bugs") ){
            isBugsHere = false;
        }
        else if ( occupantToRemove.equals("TazDevil") ){
            isTazDevilHere = false;
        }
        else if ( occupantToRemove.equals("Tweety") ){
            isTweetyHere = false;
        }
        else if ( occupantToRemove.equals("Marvin") ){
            isMarvinHere = false;
        }
        else if ( occupantToRemove.equals("Carrot") ){
            isCarrotHere = false;
        }
        else if ( occupantToRemove.equals("Mountain") ){
            isMountainHere = false;
        }
        else{
            System.out.println("!INCORRECT INPUT STRING! IN Space.removeOccupant() !");
        }
    }


    public int getRow() {

        return row;
    }


    public int getColumn() {

        return column;
    }
    
    public String printOccupants() {
        
        String outputString = "";
        if (isMountainHere){
            outputString += "F";
        }
        else{
            outputString += " ";
        }
        if (isCarrotHere){
            outputString += "C";
        }
        else{
            outputString += " ";
        }
        //Note not using elses so we can catch input bugs easier.
        if (isMarvinHere){
            outputString += "M";
        }
        if (isBugsHere){
            outputString += "B";
        }
        if (isTweetyHere){
            outputString += "T";
        }
        if (isTazDevilHere){
            outputString += "D";
        }
        if ( !isThisSpaceOccupiedByPlayer() ){
            outputString += " ";
        }
        
        
        return outputString;
    }
    
    public boolean isThisSpaceOccupiedByPlayer(){
        
        return isBugsHere || isTweetyHere || isTazDevilHere || isMarvinHere;
    }
    
    public boolean isThisSpaceOccupiedByAnything() {
        
        return isThisSpaceOccupiedByPlayer() || isCarrotHere || isMountainHere;
    }
    
    public boolean getIsBugsHere() {
        return isBugsHere;
    }
    public boolean getIsTweetyHere() {
        return isTweetyHere;
    }
    public boolean getIsTazDevilHere() {
        return isTazDevilHere;
    }
    public boolean getIsMarvinHere() {
        return isMarvinHere;
    }
    public boolean getIsMountainHere() {
        return isMountainHere;
    }
    public boolean getIsCarrotHere() {
        return isCarrotHere;
    }

}
