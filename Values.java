package CKPTDv2;

public class Values {
	private int numCust;
	private int minArTime;
	private int maxArTime;
	private int minSTime;
	private int maxSTime;
	private int percentSlow;
	private int fullService;
	private int selfService;
	private int satOrOP;
	private double fullGoal;
	private double selfGoal;
	private double downGoal;
	public Values() {
		super();
	}

	
	

	public Values(int numCust, int minArTime, int maxArTime, int minSTime, int maxSTime, int percentSlow,
			int fullService, int selfService, int satOrOP, double fullGoal, double selfGoal, double downGoal) {
		super();
		this.numCust = numCust;
		this.minArTime = minArTime;
		this.maxArTime = maxArTime;
		this.minSTime = minSTime;
		this.maxSTime = maxSTime;
		this.percentSlow = percentSlow;
		this.fullService = fullService;
		this.selfService = selfService;
		this.satOrOP = satOrOP;
		this.fullGoal = fullGoal;
		this.selfGoal = selfGoal;
		this.downGoal = downGoal;
	}




	public double getFullGoal() {
		return fullGoal;
	}




	public void setFullGoal(double fullGoal) {
		this.fullGoal = fullGoal;
	}




	public double getSelfGoal() {
		return selfGoal;
	}




	public void setSelfGoal(double selfGoal) {
		this.selfGoal = selfGoal;
	}




	public double getDownGoal() {
		return downGoal;
	}




	public void setDownGoal(double downGoal) {
		this.downGoal = downGoal;
	}




	public int getFullService() {
		return fullService;
	}


	public void setFullService(int fullService) {
		this.fullService = fullService;
	}


	public int getSelfService() {
		return selfService;
	}


	public void setSelfService(int selfService) {
		this.selfService = selfService;
	}


	public int getSatOrOP() {
		return satOrOP;
	}


	public void setSatOrOP(int satOrOP) {
		this.satOrOP = satOrOP;
	}


	public String toString() {
		return numCust+" "+minArTime+" "+maxArTime+" "+minSTime+" "+maxSTime+" "+percentSlow;
	}

	public int getNumCust() {
		return numCust;
	}

	public void setNumCust(int numCust) {
		this.numCust = numCust;
	}

	public int getMinArTime() {
		return minArTime;
	}

	public void setMinArTime(int minArTime) {
		this.minArTime = minArTime;
	}

	public int getMaxArTime() {
		return maxArTime;
	}

	public void setMaxArTime(int maxArTime) {
		this.maxArTime = maxArTime;
	}

	public int getMinSTime() {
		return minSTime;
	}

	public void setMinSTime(int minSTime) {
		this.minSTime = minSTime;
	}

	public int getMaxSTime() {
		return maxSTime;
	}

	public void setMaxSTime(int maxSTime) {
		this.maxSTime = maxSTime;
	}

	public int getPercentSlow() {
		return percentSlow;
	}

	public void setPercentSlow(int percentSlow) {
		this.percentSlow = percentSlow;
	}
	
	
	

}
