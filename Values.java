package distributedSystems;

import java.util.Date;

public class Values {
	private boolean request=false,reply=false;
	private Date date;
	
	public void setReply(boolean reply){
		this.reply = reply;
	}
	
	public boolean getReply(){
		return reply;
	}
	
	public void setRequest(boolean request){
		this.request = request;
	}
	
	public boolean getRequest(){
		return request;
	}
	
	public void setDate(){
		date = new Date();
	}
	
	public Date getDate(){
		return date;
	}

}
