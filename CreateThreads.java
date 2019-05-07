/*
 * CreateThreads.java
 */

import java.util.Random;

public class CreateThreads implements Runnable {

    //fields
    private String threadName;
    private Thread t;
    private boolean isWinner;
    private boolean hasCarrot;

    //constructor 
    public CreateThreads(String name) {
        threadName = name;

    }

    //override run() method
    public void run() {
        try {

            Random nums = new Random();

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

    public void setHasCarrot() {

        hasCarrot = true;
    }

    public void getHasCarrot() {

    }

}
