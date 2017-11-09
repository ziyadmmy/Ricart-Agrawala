public class ThreadTesting {

	   public static void main(String args[]) {
	      Threading R1 = new Threading("Thread-1");
	      R1.start();
	      
	      Threading R2 = new Threading("Thread-2");
	      R2.start();
	      
	      Threading R3 = new Threading("Thread-3");
	      R3.start();
	   }   
	}
