package CKPTDv5;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteFile {

	private static ArrayList<String> full = new ArrayList<>(); 
	private static ArrayList<String> self = new ArrayList<>(); 
	
	
	public WriteFile() {
		super();
		
			full.add("");
		
			self.add("");
	
	}


	public WriteFile(ArrayList<String> full, ArrayList<String> self) {
		super();
		this.full = full;
		this.self = self;
	}
	
	
	public static PrintWriter openWrite() {
		Frame f = new Frame();
		// decide from where to read the file
		FileDialog foBox = new FileDialog(f, "Pick location for writing your file", FileDialog.SAVE);
		System.out.println("The dialog box will appear behind Eclipse.  " + 
			      "\n   Choose where you would like to write your data.");
		foBox.setVisible(true);
		// get the absolute path to the file
		String foName = foBox.getFile();
		String dirPath = foBox.getDirectory();

		// create a file instance for the absolute path
		File outFile = new File(dirPath + foName);
		PrintWriter out = null;

		try {
			out = new PrintWriter(outFile);
		} catch (IOException e) {
			System.out.println("You threw an exception");
		}
		return out;
	}
	
	
	public static void writeData() {
		ArrayList<String> f = full;
		ArrayList<String> s = self;
 		
		PrintWriter jMFile = openWrite();
		
		
	
			jMFile.println("-Full Service Registers "+"-");
			jMFile.println("CustID,arrivalTime,serviceTime,departuretime,waittime,Turn Around Time,Satisfaction,Line");
			jMFile.println(f.get(0));
			jMFile.println();
		
		
		
			
			jMFile.println("-SelfRegisters"+"-");
			
			
			jMFile.println("CustID,arrivalTime,serviceTime,departuretime,waittime,Turn Around Time,Satisfaction,Line");
			jMFile.println(s.get(0));
			jMFile.println();
		
		
		jMFile.close();

		System.out.println("The data was saved to a file");
	}

	
	public void picky(Customer c)
	{
		String temp = "";
		boolean lineCheck=true;
		Character  charCheck =c.getLine().charAt(0);
		
		if(Character.isDigit(charCheck)) {
			temp = full.get(0);
			temp = temp + c.getId() + ",";
			temp = temp + c.getArrivalTime() + ",";
			temp = temp + c.getServiceTime() + ",";
			temp = temp + c.getLeaveTime() + ",";
			temp = temp + c.getWaitTime() + ",";
			temp = temp + c.getTurnAroundTime() + ",";
			temp = temp + c.isSatisfied() + ",";
			temp = temp + c.getLine() + "\n";
			full.set(0, temp);
			
		}
		else {
			temp = self.get(0);
			temp = temp + c.getId() + ",";
			temp = temp + c.getArrivalTime() + ",";
			temp = temp + c.getServiceTime() + ",";
			temp = temp + c.getLeaveTime() + ",";
			temp = temp + c.getWaitTime() + ",";
			temp = temp + c.getTurnAroundTime() + ",";
			temp = temp + c.isSatisfied() + ",";
			temp = temp + c.getLine() + "\n";
			self.set(0, temp);
			
		}
		
	}
	
	
	public ArrayList<String> getFull() {
		return full;
	}


	public void setFull(ArrayList<String> full) {
		this.full = full;
	}


	public ArrayList<String> getSelf() {
		return self;
	}


	public void setSelf(ArrayList<String> self) {
		this.self = self;
	}
	
}
