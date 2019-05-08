/*
 * PlayerThread.java
 */

//Grid display updates should be handled by the threads during play.


/*
    * try{
    * starting all of them}
    * catch( interrupted exception ){ exit loop}
    * 		Will be thrown when one thread wins.
    * 		Marvin can always win. so we don't need to worry about all players dying.
    * 
    * 
    * if all complete this turn send signal to run again
    * 
    */



public class PlayerThread implements Runnable {

    //fields
    private String threadName;
    private Thread t;
    private boolean isWinner;
    private boolean hasCarrot;

    //constructor 
    public PlayerThread(String name) {
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
