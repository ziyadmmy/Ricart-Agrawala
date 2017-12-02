package distributedSystems;

import java.util.LinkedList;

public class Processing {

	private Values value;
	private static LinkedList<Values> list = new LinkedList<Values>();
	private static LinkedList<Values> queue = new LinkedList<Values>();
	private static int size;

	// Creates and adds a new Values object to the linked list
	public void addLink() {
		value = new Values();
		list.add(value);
	}

	// Sets the request field in the Values object to true.
	public void sendRequest(int index) {
		value = list.get(index);
		value.setRequest(true);
	}

	// Checks if a request was sent
	public boolean checkRequest() {
		size = list.size();
		boolean hasRequest = false;

		for (int i = 0; i < size; i++) {
			value = list.get(i);
			if (value.getRequest()) {
				hasRequest = true;
			}
		}
		return hasRequest;
	}

	// Sends a reply by setting reply = true for the index called
	public void sendReply(int index) {
		value = list.get(index);
		value.setReply(true);
	}

	// Returns true if all replies are set to true
	public boolean checkReplys() {
		boolean allTrue = true;
		size = list.size();
		for (int i = 0; i < size; i++) {
			value = list.get(i);
			if (!value.getReply()) {
				allTrue = false;
			}
		}
		return allTrue;
	}

	// Adds a value object to the back of the queue
	public void enque(int index) {
		value = list.get(index);
		queue.addLast(value);
	}

	// Removes the first values object from the queue
	public void deque() {
		if (!queue.isEmpty()) {
			queue.removeFirst();
		}
	}

	// Checks if the values object that corresponds with the index passed in is
	// the first in the queue.
	public boolean checkFirst(int index) {
		boolean reply = false;
		value = list.get(index);
		if (value == queue.getFirst()) {
			reply = true;
		}
		return reply;
	}

	// Helped in testing.
	public void Print() {
		/*
		 * value = list.get(1); value.setDate(); date = value.getDate();
		 * System.out.println(date);
		 */
		System.out.println(list.size());
	}

}
