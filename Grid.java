/*
 * Grid.java
 * 
 * 
 */

public class Grid {
    //fields

    private String[][] board;
    private boolean winner = false;
    private final int ROWS = 9;
    private final int COLUMNS = 9;

    //method uses a 2-D array to creat grid 
    public void createGrid() {
        board = new String[ROWS][COLUMNS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[j][i] = "-";

            }

        }

    }
    //call to see current content of grid 

    public void printGrid() {

        for (int i = 0; i < ROWS; i++) {

            String line = "";
            for (int j = 0; j < COLUMNS; j++) {

                line += "[" + board[j][i] + "]";
            }

            System.out.println(line);
        }

    }
    //call to place or move players in grid 

    public void markGrid(int row, int column, String name) {
        board[row][column] = name;

        //nested for loops look for leters that repeat and deletes them 
        // This still needs work
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j].equals(name)) {
                    if (i != row) {
                        if (j != column) {
                            removeMark(i, j);
                        }
                    }

                }

            }
        }
    }

    //will be needed when we move player to remove previous mark 
    public void removeMark(int row, int column) {

        board[row][column] = "-";

    }
}
