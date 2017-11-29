package distributedSystems;

import java.util.LinkedList;

public class Processing {

	private Values value;
	private static LinkedList<Values> list = new LinkedList<Values>();
	private static LinkedList<Values> queue = new LinkedList<Values>();
	private static int size;

	public void addLink() {
		value = new Values();
		list.add(value);
	}

	public void sendRequest(int index) {
		value = list.get(index);
		value.setRequest(true);
		value.setDate();
	}

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

	public void sendReply(int index) {
		value = list.get(index);
		value.setReply(true);
	}

	public boolean checkReplys() {
		boolean allTrue = true;
		size = list.size();
		value = list.getFirst();
		for (int i = 0; i < size; i++) {
			if (!value.getReply()) {
				allTrue = false;
			}
		}

		return allTrue;
	}

	public void enque(int index) {
		value = list.get(index);
		queue.addLast(value);
	}

	public void deque() {
		queue.removeFirst();
	}

	public boolean checkFirst(int index){
		boolean reply = false;
		value = list.get(index);
		if(value==queue.getFirst()){
			reply = true;
		}
		return reply;
	}

	public void Print() {
		/*
		 * value = list.get(1); value.setDate(); date = value.getDate();
		 * System.out.println(date);
		 */
		System.out.println(list.size());
	}

}
