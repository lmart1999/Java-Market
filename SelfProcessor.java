package CKPTDv2;

import java.util.ArrayList;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
public class SelfProcessor {

	/*
	 * The purpose of this class is to process and keep track of all data involved
	 * with self Checkout lines except for total number of checked out
	 */
	private TableView<TableDataCustomer> tables;
	private ObservableList<TableDataCustomer> oBCust=FXCollections.observableArrayList();
	private static int totalWait;
	private static int satisfied;
	private static int disSatisfied;
	private static int regDownTime;
	//private static String outSelfA;
	//private static String outSelfB;
	private static ArrayList<String> outSelf = new ArrayList<String>();
	private static StringBuilder sB = new StringBuilder();

	public SelfProcessor() {
		super();
	}
	public SelfProcessor(int size) {
		super();
		
		for (int i =0; i<size;i++) {
			outSelf.add("");
		}
	}

	public SelfProcessor(int totalWait, int satisfied, int dissatisfied, int regDownTime) {
		super();
		this.totalWait = totalWait;
		this.satisfied = satisfied;
		this.disSatisfied = dissatisfied;
		this.regDownTime = regDownTime;
		this.oBCust = oBCust;

	}

	public Customer processSelf(Customer c, Queue self, int timer, int line, OutPut timeout, WriteFile wf) {
		char lineID = 'A';
		for (int i = 0; i < outSelf.size(); i++) {
			if(i == line) {
				lineID = (char) ('A' + i);
			}
		}
		String lineS = String.valueOf(lineID);

		if (!isNull(c)) {
			if (c.getLeaveTime() == timer && timer != 0) {
				for (int i = 0; i < outSelf.size(); i++) {
					if (i == line) {
						c.setLine(String.valueOf(lineID));
						wf.picky(c);

						timeout.constructDepartSelf(c);
						String temp = outSelf.get(i);
						outSelf.set(i, temp + c.toString() + "\n");
						TableDataCustomer cd= new TableDataCustomer(c.getId(),c.getArrivalTime(),c.getWaitTime(),c.getServiceTime(),c.getSatisfaction(),c.getLine(),c.getLeaveTime(),c.getTurnAroundTime());
						 oBCust.add(cd); 

					}
				}

				c = null;
			}
		}
		if (isNull(c)) {
			if (!self.isEmpty()) {

				c = (Customer) self.dequeue();
				c.setLine(lineS);
				c.setWaitTime(timer - c.getArrivalTime());
				timeout.constructSelfQArrive(c);
				totalWait = totalWait + c.getWaitTime();
				c.depTime();
				if (c.isSatisfied()) {
					satisfied++;
				} else
					disSatisfied++;
			} else {
				regDownTime++;

			}
		}

		return c;
	}

	public static boolean isNull(Customer c) {
		if (c == null) {
			return true;
		} else {
			return false;
		}
	}

	public TableView<TableDataCustomer> getTables() {
		return tables;
	}
	public void setTables(TableView<TableDataCustomer> tables) {
		this.tables = tables;
	}
	public ObservableList<TableDataCustomer> getoBCust() {
		return oBCust;
	}
	public void setoBCust(ObservableList<TableDataCustomer> oBCust) {
		this.oBCust = oBCust;
	}
	public static ArrayList<String> getOutSelf() {
		return outSelf;
	}
	public static void setOutSelf(ArrayList<String> outSelf) {
		SelfProcessor.outSelf = outSelf;
	}
	public static StringBuilder getsB() {
		return sB;
	}
	public static void setsB(StringBuilder sB) {
		SelfProcessor.sB = sB;
	}
	public String toString() {
		String out = "";
		for (int i = 0; i<outSelf.size();i++) {
			out = out+outSelf.get(i) + "\n";
		}
		

		return out;
	}

	public void toConsole() {

		for (int i = 0; i < outSelf.size(); i++) {
			System.out.println("\nFor Self Checkout Register " + String.valueOf((char)('A' + i)));

			System.out.println(
					"_______________________________________________________________________________________________________________________________");
			System.out.println(
					"|CustID|	|arrivalTime|	|serviceTime|	|departuretime|	|waittime|	|Turn Around Time|	|Satisfaction|	|Line|");
			System.out.println(outSelf.get(i));
			System.out.println(
					"_______________________________________________________________________________________________________________________________");

			}
		}

	public static int getTotalWait() {
		return totalWait;
	}

	public static void setTotalWait(int totalWait) {
		SelfProcessor.totalWait = totalWait;
	}

	public static int getSatisfied() {
		return satisfied;
	}

	public static void setSatisfied(int satisfied) {
		SelfProcessor.satisfied = satisfied;
	}

	public static int getDisSatisfied() {
		return disSatisfied;
	}

	public static void setDisSatisfied(int disSatisfied) {
		SelfProcessor.disSatisfied = disSatisfied;
	}

	public static int getRegDownTime() {
		return regDownTime;
	}

	public static void setRegDownTime(int regDownTime) {
		SelfProcessor.regDownTime = regDownTime;
	}

	/*public static String getOutSelfA() {
		return outSelfA;
	}

	public static void setOutSelfA(String outSelfA) {
		SelfProcessor.outSelfA = outSelfA;
	}

	public static String getOutSelfB() {
		return outSelfB;
	}

	public static void setOutSelfB(String outSelfB) {
		SelfProcessor.outSelfB = outSelfB;
	}*/

}
