package distributedSystems;

import java.util.Date;
import java.util.LinkedList;

public class Processing {
	
	private Values value;
	private LinkedList<Values> list = new LinkedList<Values>();
	private Date date;
	private int size;
	
	public void addLink(){
		value = new Values();
		list.add(value);
	}
	public void sendRequest(int index){
		value = list.get(index);
		value.setRequest(true);
		value.setDate();
	}
	public boolean checkRequest(){
		size = list.size();
		boolean hasRequest=false;
		
		for(int i =0;i<size;i++){
			value = list.get(i);
			if(value.getRequest()){
				hasRequest=true;
			}
		}
		return hasRequest;
	}
	
	public void sendReply(int index){
		value = list.get(index);
		value.setReply(true);
	}
	
	public void Print(){
		value = list.get(1);
		value.setDate();
		date = value.getDate();
		System.out.println(date);
	}

}
