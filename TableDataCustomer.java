package CKPTDv5;
public class TableDataCustomer implements Comparable<TableDataCustomer>{
	private int custId;
	private String arrivalTime;
	private String waitTime;
	private String serviceTime;
	private String satisfaction;
	private String line;
	private String leaveTime;
	private String turnaroundTime;
	
	public TableDataCustomer() {
		super();
	}

	public TableDataCustomer(int custId, String arrivalTime, String waitTime, String serviceTime, String satisfaction,
			String line, String leaveTime, String turnaroundTime) {
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

	
	

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(String waitTime) {
		this.waitTime = waitTime;
	}

	public String getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}

	public String getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}

	public String getTurnaroundTime() {
		return turnaroundTime;
	}

	public void setTurnaroundTime(String turnaroundTime) {
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