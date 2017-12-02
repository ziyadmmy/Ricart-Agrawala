package distributedSystems;

import java.util.Scanner;

public class ThreadTesting {

	public static void main(String args[]) {
		String input;
		int number;
		boolean flag = false;
		Threading thread;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Hello! Enter the number of threads you would like to start");
// the loop forces a user to enter a number 
		do {
			input = scan.next();
			try {
				number = Integer.parseInt(input);
				for (int i = 1; i <= number; i++) {
					thread = new Threading("Thread-" + i);
					thread.start();
					}
			} catch (Exception e) {
				System.out.println("Please enter a number");
				flag = true;
			}
		} while (flag);
		scan.close();
	}
}
