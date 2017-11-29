package distributedSystems;

class Threading implements Runnable {
	private Thread t;
	private String threadName;
	private static int count = 0;
	private int num;
	private int runTime;
	private Processing test = new Processing();

	Threading(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
		count++;
		num = count - 1;
		runTime = count * 10;
		test.addLink();
		test.Print();
	}

	public void run() {
		System.out.println("Running " + threadName);
		try {
			for (int i = runTime; i > 0; i--) {
				System.out.println("Thread: " + threadName + ", " + i);
				Thread.sleep(50);
				// check for requests
				if (test.checkRequest()) {
					test.sendReply(num);
					// test this, also implement a queue using timestamps?
				}
			}
		} catch (Exception e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		test.sendRequest(num);
		test.enque(num);
		while (!test.checkReplys()) {
			if (test.checkRequest()) {
				test.sendReply(num);
				// test this, also implement a queue using timestamps?
			}
		}
		while(!test.checkFirst(num)){
			System.out.println("waiting");
		}
		enterCS();
		test.deque();
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

	public void enterCS() {
		try {
			System.out.println("Thread " + threadName + " is entering the critical section");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
