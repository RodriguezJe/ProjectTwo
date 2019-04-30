/*
 * CreateThreads.java
 */

import java.util.Random;

public class CreateThreads implements Runnable {

    //fields
    private String threadName;
    private Thread t;
    private boolean isWinner;
    private int previousRow;
    private int previousColumn;

    //constructor 
    public CreateThreads(String name) {
        threadName = name;

    }

    //override run() method
    public void run() {
        try {

            Random nums = new Random();
            previousRow = nums.nextInt(9);
            previousColumn = nums.nextInt(9);

            System.out.println(threadName + " moves to Row: " + previousRow + " Column: " + previousColumn);

            System.out.println("Thread " + threadName + " exiting");

        } catch (Exception e) {
            System.out.print(e.toString());

        }

    }
    //override start() method 

    public void start() {
        System.out.println("Starting " + threadName + " thread");

        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }

    }

    //setter method
    public void setPlayerAsWinner() {

        isWinner = true;

    }
    //getter method

    public boolean getIsWinner() {

        return isWinner;
    }
    //these could be combined into a single method 

    public void setPreviousRow(int row) {
        previousRow = row;

    }

    public void setPreviousColumn(int column) {
        previousColumn = column;

    }

    //these could also be combined into a single method 
    public int getPreviousRow() {

        return previousRow;
    }

    public int getPreviousColumn() {
        return previousColumn;

    }

}
