package CKPTDv2;
public class TableDataCustomer implements Comparable<TableDataCustomer>{
	private int custId;
	private int arrivalTime;
	private int waitTime;
	private int serviceTime;
	private String satisfaction;
	private String line;
	private int leaveTime;
	private int turnaroundTime;
	
	public TableDataCustomer() {
		super();
	}

	public TableDataCustomer(int custId, int arrivalTime, int waitTime, int serviceTime, String satisfaction,
			String line, int leaveTime, int turnaroundTime) {
		super();
		this.custId = custId;
		this.arrivalTime = arrivalTime;
		this.waitTime = waitTime;
		this.serviceTime = serviceTime;
		this.satisfaction = satisfaction;
		this.line = line;
		this.leaveTime = leaveTime;
		this.turnaroundTime = turnaroundTime;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}

	public String getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(String satisfaction) {
		this.satisfaction = satisfaction;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public int getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(int leaveTime) {
		this.leaveTime = leaveTime;
	}

	public int getTurnaroundTime() {
		return turnaroundTime;
	}

	public void setTurnaroundTime(int turnaroundTime) {
		this.turnaroundTime = turnaroundTime;
	}

	public int compareTo(TableDataCustomer o) {
		if (o.getCustId()<getCustId()) {
			return 1;
		
		}
		
			
		else if (o.getCustId()>getCustId())
			return -1;
		else {
			return 0;
			
		}
		
		
	}

	
	

	
	
	
}