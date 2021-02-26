package CKPTDv2;



public class Customer {
	   private int arrivalTime;
	    private int serviceTime;
	    private int id;
	    public static int num = 1;
	    private int waitTime;
	    private int leaveTime;
	    private int turnAroundTime;
	    private String checkoutType;
	    private String line;
	    private String satisfaction;
	    
	    public Customer() {
	        
	    }
	    public Customer(int arrivalTime, int serviceTime, int waitTime, String checkoutType) {
	        super();
	        this.arrivalTime = arrivalTime;
	        this.serviceTime = serviceTime;
	        this.waitTime = waitTime;
	        turnAroundTime = waitTime+serviceTime;
	        this.checkoutType = checkoutType;
	        id = num;
	        num++;
	    }
	    
	    
	    public static int getNum() {
			return num;
		}
		public static void setNum(int num) {
			Customer.num = num;
		}
		
		public String toString()
	    {
		
	     String cust =" "+id+"		 "+arrivalTime/60+"h" +arrivalTime%60+"min " +
	    "	 "+serviceTime+"		 "+leaveTime/60+"h" +leaveTime%60+"min  "+
	    		 "	 "+waitTime+"		 "+turnAroundTime+
	    		 "		  	";
	     
	     
	     //String cust = "Customer #" + id + " arrived at "
	        //+ getArrivalTime() + " minutes and was served for " + getServiceTime()+" minutes. Customer left at: "
	        //+ leaveTime + ". Customer waited for " + waitTime + " minutes" ;
	        if(isSatisfied()==true) {
	        	cust=cust+" True";
	        	setSatisfaction("True");
	        }
	            
	        else {
	        	cust=cust+" False";
		        setSatisfaction("False");
	        }
	        cust=cust+"		 "+line;
	        
	        
	        return cust;
	    }
		
		
		
		public void turnAroundTimef() {
			turnAroundTime = waitTime+serviceTime;
		}
		
		public void depTime() {
			leaveTime = arrivalTime+serviceTime+waitTime;
			turnAroundTimef();
		}
		
	    public boolean isSatisfied() {
	        if(getWaitTime()<5)
	            return true;
	        else
	            return false;
	    }
	    public int getArrivalTime() {
	        return arrivalTime;
	    }
	    public void setArrivalTime(int arrivalTime) {
	        this.arrivalTime = arrivalTime;
	    }
	    public int getServiceTime() {
	        return serviceTime;
	    }
	    public void setServiceTime(int serviceTime) {
	        this.serviceTime = serviceTime;
	    }
	    
	    public int getId() {
	        return id;
	    }
	    
	    public void setId(int id) {
	        this.id = id;
	    }
	    public int getLeaveTime() {
	        return leaveTime;
	    }
	    public void setLeaveTime(int leaveTime) {
	        this.leaveTime = leaveTime;
	    }
	    
	    public int getWaitTime() {
	        return waitTime;
	    }
	    public void setWaitTime(int waitTime) {
	        this.waitTime = waitTime;
	    }
	    public int getTurnAroundTime() {
			return turnAroundTime;
		}
		public void setTurnAroundTime(int turnAroundTime) {
			this.turnAroundTime = turnAroundTime;
		}
		public String getCheckoutType() {
			return checkoutType;
		}
		public void setCheckoutType(String checkoutType) {
			this.checkoutType = checkoutType;
		}
		public String getLine() {
			return line;
		}
		public void setLine(String line) {
			this.line = line;
		}
		
		public String getSatisfaction() {
			return satisfaction;
		}
		public void setSatisfaction(String satisfaction) {
			this.satisfaction = satisfaction;
		}
	    
		
		
		
		
	}

