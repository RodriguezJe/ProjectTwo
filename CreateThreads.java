/*
 * CreateThreads.java
 */


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
		int x=5;
        try {
			System.out.println("Thread " +threadName+" is starting...");
			
			while(x>0){
				System.out.println("Hello World!");
				
				x--;
			}
			

            System.out.println("Thread " +threadName+" is exiting...thanks for waiting!");

        } catch (Exception e) {
            System.out.print(e.toString());

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
