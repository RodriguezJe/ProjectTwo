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
    
    public void setRow(int newRow) {
        
        row = newRow;
    }


    public int getColumn() {

        return column;
    }
    
    public void setColumn(int newColumn) {
        column = newColumn;
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
    public void setIsBugsHere(boolean b) {
        isBugsHere = b;
    }
    
    
    public boolean getIsTweetyHere() {
        return isTweetyHere;
    }
    public void setIsTweetyHere(boolean b) {
        isTweetyHere = b;
    }
    
    
    public boolean getIsTazDevilHere() {
        return isTazDevilHere;
    }
    public void setIsTazDevilHere(boolean b) {
        isTazDevilHere = b;
    }
    
    
    public boolean getIsMarvinHere() {
        return isMarvinHere;
    }
    public void setIsMarvinHere(boolean b) {
        isMarvinHere = b;
    }
    
    
    public boolean getIsMountainHere() {
        return isMountainHere;
    }
    public void setIsMountainHere(boolean b) {
        isMountainHere = b;
    }
    
    
    public boolean getIsCarrotHere() {
        return isCarrotHere;
    }
    public void setIsCarrotHere(boolean b) {
        isCarrotHere = b;
    }
    
    
    
    //check if "name" is here
    public boolean isThisPlayerHere(String nameToCheck) {
        if ( nameToCheck.equals("Bugs") ) {
            
            return isBugsHere;
        }
        else if ( nameToCheck.equals("Tweety") ) {
            
            return isTweetyHere;
        }
        else if ( nameToCheck.equals("TazDevil")  ) {
            
            return isTazDevilHere;
        }
        else if ( nameToCheck.equals("Marvin")  ) {
            
            return isMarvinHere;
        }
        else {
            System.out.println("Incorrect input in Space.isThisPlayerHere() !");
            
            return false; // Hopefully this never runs!
        }
        
        //~ return false;
    }

}
