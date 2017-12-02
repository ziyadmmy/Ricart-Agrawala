package distributedSystems;

import java.util.NoSuchElementException;

class Threading implements Runnable {
	private Thread t;
	private String threadName;
	private static int count = 0;
	private int num;
	private int runTime;
	private Processing test = new Processing();

	// The constructor, determines how long the "process" will run for
	Threading(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
		count++;
		num = count - 1;
		runTime = count * 10;
		test.addLink();
		test.Print();
	}

	//
	public void run() {
		System.out.println("Running " + threadName);
		try {
			for (int i = runTime; i > 0; i--) {
				System.out.println("Thread: " + threadName + ", " + i);
				Thread.sleep(50);
				// Check for requests
				if (test.checkRequest()) {
					// Sends a reply for the the current thread
					test.sendReply(num);
				}
			}
		} catch (Exception e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		// Sends a request after the task is finished
		test.sendRequest(num);
		// Adds the current Thread to the back of the queue
		test.enque(num);
		// Waits until all replies are in, also checks for new requests
		while (!test.checkReplys()) {
			if (test.checkRequest()) {
				test.sendReply(num);
			}
		}
		// Wait until it is the first Thread in the queue
		try {
			while (!test.checkFirst(num)) {
				System.out.println("waiting");
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (NoSuchElementException e) {
			test.enque(num);
		}
		// Enters the CS
		enterCS();
		// Leaves the Queue
		try {
			test.deque();
		} catch (NoSuchElementException e) {
			System.out.println("The queue is empty");
		}
		test.sendReply(num);
		// The Thread exits
		System.out.println("Thread " + threadName + " exiting.");
	}

	// Calls the run function
	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

	// Models entering a Critical Section
	public void enterCS() {
		try {
			System.out.println("Thread " + threadName + " is entering the critical section");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
