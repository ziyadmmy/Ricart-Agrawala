package distributedSystems;

class Threading implements Runnable {
	   private Thread t;
	   private String threadName;
	   private static int count=0;
	   private int num;
	   private int runTime;
	   private Processing test = new Processing();
	   
	   Threading (String name) {
	      threadName = name;
	      System.out.println("Creating " +  threadName);
	      count ++;
	      num = count;
	      runTime = count *10;
	   }
	   
	   public void run() {
	      System.out.println("Running " +  threadName);
	      try {
	         for(int i = 0; i < runTime; i++) {
	            System.out.println("Thread: " + threadName + ", " + i);
	            Thread.sleep(50);
	            //check for requests
	            if(test.checkRequest()){
	            	test.sendReply(num);
	            	//test this, also implement a queue using timestamps?
	            }
	         }
	      } catch (Exception e) {
	         System.out.println("Thread " +  threadName + " interrupted.");
	      }
	      //test.sendRequest(num);
	      System.out.println("Thread " +  threadName + " exiting.");
	   }
	   
	   public void start () {
	      System.out.println("Starting " +  threadName );
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	         }
	   }
	   
	   public void enterCS(){
		   //Checks for all replies
		   //Thread enters the critical section, 
		   //reads the data, 
		   //waits 50 ms Thread.sleep(50);
		   //exits
	   }
	}
