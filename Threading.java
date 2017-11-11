package distributedSystems;

class Threading implements Runnable {
	   private Thread t;
	   private String threadName;
	   private static int count=0;
	   private static int priority=1, replies=0;
	   private int num;
	   private Processing test = new Processing();
	   
	   Threading (String name) {
	      threadName = name;
	      System.out.println("Creating " +  threadName);
	      count ++;
	      num = count;
		  test.addLink();
	   }
	   
	   public void run() {
	      System.out.println("Running " +  threadName);
	      try {
	         for(int i = 100; i > 0; i--) {
	            System.out.println("Thread: " + threadName + ", " + i);
	            //check for requests
	            if(test.checkRequest()){
	            	//reply();
	            }
	         }
	      } catch (Exception e) {
	         System.out.println("Thread " +  threadName + " interrupted.");
	      }
	      test.sendReply(num);
	      System.out.println("Thread " +  threadName + " exiting.");
	   }
	   
	   public void start () {
	      System.out.println("Starting " +  threadName );
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	         if(count <5){
	        	 t.setPriority(10 - (2*count));}
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
