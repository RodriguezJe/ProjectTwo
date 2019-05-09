/*
 * Grid.java
 * 
 * 
 */

import java.util.Random;

public class Board {

    //fields
    public Space[][] board; //Do not make private.
    public static int mtCounter = 0; //move mountain every three moves
    private boolean isThereAWinner = false;
    private String nameOfWinner = "";
    
    //Only make squares for now!
    private final int ROWS = 10;
    private final int COLUMNS = ROWS;

    private int mtRow;
    private int mtColumn;

    private int carrotRow;
    private int carrotColumn;

    //method uses a 2-D array to creat grid 
    public Board() {
        board = new Space[ROWS][COLUMNS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = new Space(i, j);
            }
        }
        
        
        //place one mountain on the board. Board is empty so any random space will do.
        int[] mountainCoordinates = getRandomEmptySpaceCoordinates();
        mtRow=mountainCoordinates[0];
        mtColumn=mountainCoordinates[1];
        board[ mountainCoordinates[0] ][ mountainCoordinates[1] ].setOccupant("Mountain");
        
        //Place two carrots on the board. Checking if something is in that space already.
        int[] carrotCoordinates1 = getRandomEmptySpaceCoordinates();
        board[carrotCoordinates1[0]][carrotCoordinates1[1]].setOccupant("Carrot");
        
        int[] carrotCoordinates2 = getRandomEmptySpaceCoordinates();
        board[carrotCoordinates2[0]][carrotCoordinates2[1]].setOccupant("Carrot");
        
        
        ///Place the players on the board.
        //Place Bugs on the board
        int[] bugsCoordinates = getRandomEmptySpaceCoordinates();
        board[bugsCoordinates[0] ][bugsCoordinates[1] ].setOccupant("Bugs");
        
        //place tweety
        int[] tweetyCoordinates = getRandomEmptySpaceCoordinates();
        board[tweetyCoordinates[0] ][tweetyCoordinates[1] ].setOccupant("Tweety");
        
        //place TazDevil
        int[] tazDevilCoordinates = getRandomEmptySpaceCoordinates();
        board[tazDevilCoordinates[0] ][tazDevilCoordinates[1] ].setOccupant("TazDevil");
        
        //place Marvin
        int[] marvinCoordinates = getRandomEmptySpaceCoordinates();
        board[marvinCoordinates[0] ][marvinCoordinates[1] ].setOccupant("Marvin");
        
    }
    
    
    //Returns the row/column numbers for an empty square in the grid.
    private int[] getRandomEmptySpaceCoordinates() {
        
        Random randObj = new Random();
        int tempRow;
        int tempColumn;
        
        do {
            tempRow = randObj.nextInt(ROWS);
            tempColumn = randObj.nextInt(COLUMNS);
        } while ( board[tempRow][tempColumn].isThisSpaceOccupiedByAnything() );
        
        return new int[] {tempRow, tempColumn};
    }


    public void mtLocation() {
        System.out.println("The mountain starts at row " + mtColumn + " column " + mtRow);
    }
    
    
    public void newMt(int row, int column){
        mtRow=row;
        mtColumn=column;
        System.out.println("\nThe mountain has moved to row " + mtColumn + " column " + mtRow);
    }
    

    public void setCarrot(int row, int column) {
        carrotRow = row;
        carrotColumn = column;
    }


    public void setWinner(String winnerName) {
        isThereAWinner = true;
        nameOfWinner = winnerName;
    }

    
    public boolean isGameOver() {
        return isThereAWinner;
    }
    
    
    public boolean getIsThereAWinner() {
        return isThereAWinner;
    }
    
    
    public void setIsThereAWinner(boolean b) {
        isThereAWinner = b;
    }

    
    //call to see current content of board 
    public void printBoard() {

        for (int i = 0; i < ROWS; i++) {
            String line = "";

            for (int j = 0; j < COLUMNS; j++) {

                line += "[" + board[j][i].printOccupants() + "]";
            }

            System.out.println(line);
        }

    }
    
    
    public int getROWS() {
        return ROWS;
    }
    
    
    public int getCOLUMNS() {
        return COLUMNS;
    }
    
    
    //Checks if a move is valid
    public boolean canPlayerMoveHere (int proposedRow, int proposedCol, boolean doIHaveCarrot) {
        
        if ( (proposedRow < 0) || (proposedCol < 0) ) {
            
            return false;
        }
        if ( (proposedRow >= ROWS) || (proposedCol >= COLUMNS)  ) {
            
            return false;
        }
        if ( board[proposedRow][proposedCol].isThisSpaceOccupiedByPlayer() ) {
            
            return false;
        }
        else if ( board[proposedRow][proposedCol].getIsMountainHere() && doIHaveCarrot ) {
            
            return true;
        }
        else if ( board[proposedRow][proposedCol].getIsMountainHere() ) {
            
            return false;
        }
        else {
            
            return true; //no players and no mountain. hasCarrot disregarded.
        }
    }
    
    
    //Marvin version of canPlayerMoveHere
    public boolean canMarvinMoveHere (int proposedRow, int proposedCol, boolean doIHaveCarrot) {
        
        if ( (proposedRow < 0) || (proposedCol < 0) ) {
            
            return false;
        }
        else if ( (proposedRow >= ROWS) || (proposedCol >= COLUMNS)  ) {
            
            return false;
        }
        else if ( board[proposedRow][proposedCol].getIsMountainHere() && doIHaveCarrot ) {
            
            return true;
        }
        else if ( board[proposedRow][proposedCol].getIsMountainHere() ) {
            
            return false;
        }
        else {
            
            return true; //no mountain. hasCarrot disregarded.
        }
    }


    //will be needed when we move player to remove previous mark 
     public void removeMt() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j].getIsMountainHere()) {
                    board[i][j].removeOccupant("Mountain");
                }
           }
       }
   }
   
   
   public String getNameOfWinner() {
       return nameOfWinner;
   }
}
