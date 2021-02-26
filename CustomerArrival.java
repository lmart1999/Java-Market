package CKPTDv2;

import java.util.ArrayList;

public class CustomerArrival {
	
	private static ArrayList<Queue> checkoutsFull;
	private static int totalWaitFull = 0;
	private static int satisfiedF = 0;
	private static int satisfiedS = 0;
	private static int disSatisfied= 0;
	private static ArrayList<Customer> checkoutsSelf;
	private static Queue self;



	public CustomerArrival() {
		super();
	}

	public CustomerArrival(ArrayList<Queue> checkoutsFull, ArrayList<Customer> checkoutsSelf, Queue self) {
		super();
		this.checkoutsFull = checkoutsFull;
		this.checkoutsSelf = checkoutsSelf;
		this.self = self;

	}
	
	public static void newCustFull(Customer c, int timer, int line) {
		c.setLine(String.valueOf(line+1));
		int wait = 0;
		if(checkoutsFull.get(line).size()>0) {
			
			wait = checkoutsFull.get(line).waitTime(timer);
			c.setWaitTime(wait);
			totalWaitFull = totalWaitFull + wait;
		}
		c.depTime();
		if (c.isSatisfied()) {
			satisfiedF++;
		} else
			disSatisfied++;
		
		checkoutsFull.get(line).enqueue(c);
	
	}
	
	public static void newCustSelf(Customer c, int timer) {
		int wait = 0;
		for(int i = 0; i<checkoutsSelf.size(); i++) {
			if(checkoutsSelf.get(i)==null){
				c.setWaitTime(0);
				c.depTime();
				char cLine = (char) ('A'+i);
				c.setLine(String.valueOf(cLine));
				
				checkoutsSelf.set(i, c);
				if (c.isSatisfied()) {
					satisfiedS++;
				} else
					disSatisfied++;
				i = checkoutsSelf.size()+1;

			}else if( i == checkoutsSelf.size()-1){
				self.enqueue(c);
			}
		}
	
	}

	public static int getSatisfiedF() {
		return satisfiedF;
	}

	public static void setSatisfiedF(int satisfiedF) {
		CustomerArrival.satisfiedF = satisfiedF;
	}

	public static int getSatisfiedS() {
		return satisfiedS;
	}

	public static void setSatisfiedS(int satisfiedS) {
		CustomerArrival.satisfiedS = satisfiedS;
	}

	public static ArrayList<Customer> getCheckoutsSelf() {
		return checkoutsSelf;
	}

	public static void setCheckoutsSelf(ArrayList<Customer> checkoutsSelf) {
		CustomerArrival.checkoutsSelf = checkoutsSelf;
	}

	public static Queue getSelf() {
		return self;
	}

	public static void setSelf(Queue self) {
		CustomerArrival.self = self;
	}

	public static ArrayList<Queue> getCheckoutsFull() {
		return checkoutsFull;
	}

	public static void setCheckoutsFull(ArrayList<Queue> checkoutsFull) {
		CustomerArrival.checkoutsFull = checkoutsFull;
	}

	public static int getTotalWaitFull() {
		return totalWaitFull;
	}

	public static void setTotalWaitFull(int totalWaitFull) {
		CustomerArrival.totalWaitFull = totalWaitFull;
	}

	public static int getDisSatisfied() {
		return disSatisfied;
	}

	public static void setDisSatisfied(int disSatisfied) {
		CustomerArrival.disSatisfied = disSatisfied;
	}
	
	
	
	

}
