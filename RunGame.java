/*
 * RunGame.java
 */

import java.util.Random;

public class RunGame {

    public static void main(String[] args) {

        Grid x = new Grid();
        x.createGrid();

        //CreateThreads T1 = new CreateThreads("B");
        //CreateThreads T2 = new CreateThreads("D");
        //CreateThreads T3 = new CreateThreads("T");
        //CreateThreads T4 = new CreateThreads("M");
        //T1.start();
        //T2.start();
        //T3.start();
        //T4.start();
        int i = 5;
        Random num = new Random();
        //need to find a way to sync main with threads
        //x.markGrid(T1.getPreviousRow(), T1.getPreviousColumn(), "B");

        //testing the markGrid and removeMark methods
        while (i > 0) {
            int row = num.nextInt(9);
            int column = num.nextInt(9);
            x.markGrid(row, column, "B");

            row = num.nextInt(9);
            column = num.nextInt(9);
            x.markGrid(row, column, "D");

            row = num.nextInt(9);
            column = num.nextInt(9);
            x.markGrid(row, column, "T");

            row = num.nextInt(9);
            column = num.nextInt(9);
            x.markGrid(row, column, "M");
            i--;

        }
        x.printGrid();

    }
}
