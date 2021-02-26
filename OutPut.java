package CKPTDv2;

public class OutPut {
	
	private  String outPut = "";

	
	
	public OutPut() {
		super();
	}



	public OutPut(String outPut) {
		super();
		this.outPut = outPut;
	}
	
	
	
	public void constructDepartSelf(Customer c) {
		outPut = outPut +"	Customer "+c.getId()+" has departed and left line "+c.getLine()+"\n";
		
		
		
	}
	public void constructDepartFull(Customer c) {
		outPut = outPut +"	Customer "+c.getId()+" has has departed line "+c.getLine()+"\n";
		
		
	}
	public void constructFullArrive(Customer c) {
		outPut = outPut +"	Customer "+c.getId()+" has arrived and has entered line "+c.getLine()+"\n";
		
		
	}
	public void constructSelfArrive(Customer c) {
		if(c.getLine()==null) {
			outPut = outPut +"	Customer "+c.getId()+" has arrived and has entered the selfcheckout queue\n";
		}
		else {
			outPut = outPut +"	Customer "+c.getId()+" has arrived and has entered line "+c.getLine()+"\n";
		}
	}
	public void addTime(int time) {
		outPut= outPut+time/60+"hrs "+time%60+"mins\n";
	}
	public void addEmpty(String lineNum) {
		outPut=outPut+"	Line "+lineNum+" is empty\n";
		
	}
	public void constructSelfQArrive(Customer c) {
		outPut = outPut +"	Customer "+c.getId()+" has moved from the queue to line "+c.getLine()+" Wait time: "+c.getWaitTime()/60+""
				+ "hrs "+c.getWaitTime()%60+"mins \n";
		
	}
	



	public String getOutPut() {
		return outPut;
	}



	public void setOutPut(String outPut) {
		this.outPut = outPut;
	}



	
	



	
	
	
	
	

}
