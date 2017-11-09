package distributedSystems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Threading implements Runnable {
	   private Thread t;
	   private String threadName;
	   private static int count=0;
	   private static int priority=1;
	   private int threadPriority;
	   private BufferedWriter file;
	   
	   Threading (String name) {
	      threadName = name;
	      System.out.println("Creating " +  threadName );
	      count ++;
	   }
	   
	   public void run() {
	      System.out.println("Running " +  threadName );
	      try {
	         for(int i = 100; i > 0; i--) {
	            System.out.println("Thread: " + threadName + ", " + i);
	            //check for requests
	            //send reply  
	         }
	      } catch (Exception e) {
	         System.out.println("Thread " +  threadName + " interrupted.");
	      }
	      //"send" request
	      request();
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
	   
	   public void request(){
		   threadPriority = priority;
		   priority ++;
		   try {
				file = new BufferedWriter(new FileWriter("Request.dat", true));
				file.append("TRUE");
				file.newLine();
				file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("File did not exist" + e);
			}
	   }
	   public void enterCS(){
		   //Thread enters the critical section, 
		   //reads the data, 
		   //waits 50 ms Thread.sleep(50);
		   //exits
	   }
	}
