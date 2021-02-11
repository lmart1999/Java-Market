package CKPTDv5;

import java.util.ArrayList;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class FullProcessor {
	
	private ArrayList<Queue> checkouts = new ArrayList<Queue>();
	private ArrayList<String> out = new ArrayList<String>();
	private TableView<TableDataCustomer> tables;
	private ObservableList<TableDataCustomer> oBCust=FXCollections.observableArrayList();
	private String summary;
	

	public FullProcessor() {
		super();
	}

	public FullProcessor(ArrayList<Queue> checkouts) {
		super();
		this.checkouts = checkouts;
		for (int i = 0; i < checkouts.size(); i++) {
			out.add("");
		}
		this.oBCust = oBCust;
		this.summary=summary;
	}

	public void process(int timer, OutPut timeOut, WriteFile wf) {
	
		for (int i = 0; i < checkouts.size(); i++) {
		
			if (!(checkouts.get(i).isEmpty())) {
				
				if(((Customer) checkouts.get(i).peek()).getArrivalTime()==timer) {
					 Customer c=((Customer) checkouts.get(i).peek());
					 timeOut.constructFullArrive(c);
				}
				if(((Customer) checkouts.get(i).peek()).getLeaveTime()==timer && timer!=0) {
					timeOut.constructDepartFull(((Customer) checkouts.get(i).peek()));
				}
				

				if (((Customer) checkouts.get(i).peek()).getLeaveTime() == timer) {
					String newOut = out.get(i) + checkouts.get(i).finalString();
					
					wf.picky((Customer) checkouts.get(i).peek());
					 Customer c = ((Customer) checkouts.get(i).peek());
					 String arTime = c.getArrivalTime()/60+" hrs "+c.getArrivalTime()%60+" mins";
					 String serVTime = c.getServiceTime()/60+" hrs "+c.getServiceTime()%60+" mins";
					 String leaveTime = c.getLeaveTime()/60+" hrs "+c.getLeaveTime()%60+" mins";
					 String waitTime = c.getWaitTime()/60+" hrs "+c.getWaitTime()%60+" mins";
					 String turnArTime = c.getTurnAroundTime()/60+" hrs "+c.getTurnAroundTime()%60+" mins";
					 TableDataCustomer cd= new TableDataCustomer(c.getId(),arTime,waitTime,serVTime,c.getSatisfaction(),c.getLine(),leaveTime,turnArTime);
					 oBCust.add(cd); 
					out.set(i, (newOut));
					checkouts.get(i).dequeue();

				}
			}
		}
	}
	
	public String toString() {
		String output = "";

		 for (int i = 0; i < checkouts.size(); i++) {
				output = output +("\nFor Register " + (i+1)+ "\n");

				output = output +(
						"_______________________________________________________________________________________________________________________________\n");
				output = output +(
						"|CustID|	|arrivalTime|	|serviceTime|	|departuretime|	|waittime|	|Turn Around Time|	|Satisfaction|	|Line|\n");
				output = output+(out.get(i));
				output = output+(
						"_______________________________________________________________________________________________________________________________\n");

			}
		 return output;
	}

	public ArrayList<Queue> getCheckouts() {
		return checkouts;
	}

	public void setCheckouts(ArrayList<Queue> checkouts) {
		this.checkouts = checkouts;
	}

	public ArrayList<String> getOut() {
		return out;
	}

	public void setOut(ArrayList<String> out) {
		this.out = out;
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	
	

	

}
