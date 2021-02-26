package CKPTDv2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;


//////////////////////////////////////////////
//FX
import javafx.scene.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;

import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/////////////////////////////////////////////////////

public class JavaMarketCKPTD extends Application {
	private static Scanner scan = new Scanner(System.in);
	//////////////////////////////////////////////////////////////
	// FX
	Stage window;
	protected static ObservableList<Customer> customers;
	static Values values;
	public TableView<TableDataCustomer> table;
	private Scene scene2;
	private Scene summScene;
	private Text textForSumm;
	private String summarize;
	private StringBuilder buildSumm;

	///////////////////////////////////////////////////////////////
	@Override
	public void start(Stage primaryStage) throws Exception {

		window = primaryStage;

		window.setTitle("The Java Market");

		// GridPane with 10px padding around edge

		GridPane grid = new GridPane();

		grid.setPadding(new Insets(30, 30, 30, 30));

		grid.setVgap(8);

		grid.setHgap(10);
		grid.setMinSize(400, 400);

		// Name Label - constrains use (child, column, row)

		Label numCust = new Label("Enter the number of customers");

		GridPane.setConstraints(numCust, 0, 0);

		TextField numInput = new TextField();

		GridPane.setConstraints(numInput, 1, 0);

		Label minArBtwCust = new Label("Enter minimum Arrival time between customers");

		GridPane.setConstraints(minArBtwCust, 0, 1);

		TextField minArBtwCustInput = new TextField();

		GridPane.setConstraints(minArBtwCustInput, 1, 1);

		////////////////////////////////////////////////////////////
		Label maxArBtwCust = new Label("Enter maximum Arrival time between customers");

		GridPane.setConstraints(maxArBtwCust, 0, 2);

		TextField maxArBtwCustInput = new TextField();

		GridPane.setConstraints(maxArBtwCustInput, 1, 2);
		////////////////////////////////////////////////////////////////////////
		Label minSTime = new Label("Enter minimal service time");

		GridPane.setConstraints(minSTime, 0, 3);

		TextField minSTimeInput = new TextField();

		GridPane.setConstraints(minSTimeInput, 1, 3);
		// \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		Label maxSTime = new Label("Enter maximum service time");

		GridPane.setConstraints(maxSTime, 0, 4);

		TextField maxSTimeInput = new TextField();

		GridPane.setConstraints(maxSTimeInput, 1, 4);
		//////////////////////////////////////////////////////////
		Label slowerForSelf = new Label("Enter percentage slower for self");

		GridPane.setConstraints(slowerForSelf, 0, 5);

		TextField slowInput = new TextField();

		GridPane.setConstraints(slowInput, 1, 5);

		Label fullLineNum = new Label("How many Full Service Lines");
		GridPane.setConstraints(fullLineNum, 0, 6);
		TextField fullInput = new TextField();
		GridPane.setConstraints(fullInput, 1, 6);
		Label selfLineNum = new Label("How many Self Service Lines");
		GridPane.setConstraints(selfLineNum, 0, 7);
		TextField selfInput = new TextField();
		GridPane.setConstraints(selfInput, 1, 7);

		Label opt = new Label("More Important satisfaction(1) or optimization(2)?");
		GridPane.setConstraints(opt, 0, 8);
		TextField optInput = new TextField();
		GridPane.setConstraints(optInput, 1, 8);
		Label fullGoal = new Label("Min. Acceptable % of Satisfied Full Serv. Customers");
		GridPane.setConstraints(fullGoal, 0, 9);
		TextField fullGoalInput = new TextField();
		GridPane.setConstraints(fullGoalInput, 1, 9);

		Label selfGoal = new Label("Min. Acceptable % of Satisfied Self Serv. Customers");
		GridPane.setConstraints(selfGoal, 0, 10);
		TextField selfGoalInput = new TextField();
		GridPane.setConstraints(selfGoalInput, 1, 10);
		Label downTime = new Label("Maximum Acceptable % of Register Down Time?");
		GridPane.setConstraints(downTime, 0, 11);
		TextField downInput = new TextField();
		GridPane.setConstraints(downInput, 1, 11);

		Button loginButton = new Button("Enter");

		GridPane.setConstraints(loginButton, 0, 12);
		Button end = new Button("Calculate");
		GridPane.setConstraints(end, 0, 13);
		StackPane layout2 = new StackPane();

		Scene scene = new Scene(grid, 500, 500);
		TableColumn<TableDataCustomer, Integer> custId = new TableColumn<>("CustId");

		custId.setMinWidth(100);

		custId.setCellValueFactory(new PropertyValueFactory<>("custId"));

		TableColumn<TableDataCustomer, Integer> arrivalTime = new TableColumn<>("ArrivalTime");

		arrivalTime.setMinWidth(100);

		arrivalTime.setCellValueFactory(new PropertyValueFactory<>("ArrivalTime"));

		TableColumn<TableDataCustomer, Integer> serviceTime = new TableColumn<>("Service Time");

		serviceTime.setMinWidth(100);

		serviceTime.setCellValueFactory(new PropertyValueFactory<>("ServiceTime"));

		TableColumn<TableDataCustomer, Integer> waitTime = new TableColumn<>("WaitTime");

		waitTime.setMinWidth(100);

		waitTime.setCellValueFactory(new PropertyValueFactory<>("WaitTime"));

		TableColumn<TableDataCustomer, Integer> taTime = new TableColumn<>("TurnaroundTime");

		taTime.setMinWidth(100);

		taTime.setCellValueFactory(new PropertyValueFactory<>("turnaroundTime"));

		TableColumn<TableDataCustomer, String> satisf = new TableColumn<>("Satisfaction");

		satisf.setMinWidth(100);

		satisf.setCellValueFactory(new PropertyValueFactory<>("Satisfaction"));
		TableColumn<TableDataCustomer, String> line = new TableColumn<>("Line");

		line.setMinWidth(100);

		line.setCellValueFactory(new PropertyValueFactory<>("Line"));
		TableColumn<TableDataCustomer, String> leaveTime = new TableColumn<>("LeaveTime");

		leaveTime.setMinWidth(100);

		leaveTime.setCellValueFactory(new PropertyValueFactory<>("LeaveTime"));

		table = new TableView<>();

		table.getColumns().addAll(arrivalTime, serviceTime, leaveTime, waitTime, taTime, satisf, line, custId);
		VBox vBox = new VBox();

		vBox.getChildren().addAll(table);

		HBox hBox = new HBox();

		hBox.setPadding(new Insets(10, 10, 10, 10));

		hBox.setSpacing(10);

		Button goTSumm = new Button("Go to Summary");
		BorderPane bp = new BorderPane();

		goTSumm.setOnAction(e -> window.setScene(summScene));
		hBox.getChildren().addAll(goTSumm);
		vBox.getChildren().addAll(hBox);
		scene2 = new Scene(vBox);

		// Add everything to grid

		grid.getChildren().addAll(numCust, numInput, minArBtwCust, minArBtwCustInput, loginButton, slowInput,
				slowerForSelf, maxArBtwCust, maxArBtwCustInput, minSTime, minSTimeInput, maxSTime, maxSTimeInput, end,
				fullLineNum, fullInput, selfLineNum, selfInput, opt, optInput, fullGoal, fullGoalInput, selfGoal,
				selfGoalInput, downTime, downInput);

		loginButton.setOnAction(e -> dataStore(numInput, minArBtwCustInput, maxArBtwCustInput, minSTimeInput,
				maxSTimeInput, slowInput, fullInput, selfInput, optInput, fullGoalInput, selfGoalInput, downInput));
		end.setOnAction(e -> runProgram());

		window.setScene(scene);

		window.show();
	}

	public void runProgram() {
		Queue self = new Queue();
		

		int numCust = values.getNumCust();
		int minArrival = values.getMinArTime();
		int maxArrival = values.getMaxArTime();
		int minServiceR = values.getMinSTime();
		int maxServiceR = values.getMaxSTime();
		double percentSlower = (values.getPercentSlow()) / 100.0;
		int numQueues = values.getFullService();
		int numSelfService = values.getSelfService();
		int priority = values.getSatOrOP();

		
		double perFullSatGoal =values.getFullGoal();
		
		double perSelfSatGoal = values.getSelfGoal();
		
		double perDownGoal = values.getDownGoal();

		ArrayList<Queue> checkoutsFull = new ArrayList<Queue>();

		// full service registers
		for (int i = 0; i < numQueues; i++) {
			checkoutsFull.add(new Queue());

		}

		// creates self service registers
		ArrayList<Customer> checkoutsSelf = new ArrayList<Customer>();
		for (int i = 0; i < numSelfService; i++) {
			checkoutsSelf.add(null);
		}

		// creates minute by minute output
		OutPut timeOut = new OutPut();
		CreateCustomer maker = new CreateCustomer(minServiceR, maxServiceR, 1); // full service
		CreateCustomer makerSC = new CreateCustomer(minServiceR, maxServiceR, 2); // self checkout

		WriteFile wf = new WriteFile();

		// used to set customer arrival times
		int arrival = 0;

		boolean moreCust = true;
		// system timer
		int timer = 0;

		// number of Full Service Customers
		int numCustFull = 0;
		// number of Self Service Customers
		int numCustSelf = 0;
		// Total time full service registers are empty
		int totalRegDownTime = 0;
		// Used to set Self Service Line IDs
		char lineSelf = 'A';
		// number of satisfied customers
		int satisfied = 0;
		// number of dissatisfied customers
		int disSatisfied = 0;
		// Processes Arriving Customers

		CustomerArrival newCust = new CustomerArrival(checkoutsFull, checkoutsSelf, self);
		// Processes and removes Self-Checkout Customers
		SelfProcessor selfCheckout = new SelfProcessor(numSelfService);
		// Processes and removes Full-Service Customers
		FullProcessor fullCheckout = new FullProcessor(checkoutsFull);

		while (moreCust == true) {// adds and processes customers
			timeOut.addTime(timer);
			if (arrival == timer && numCust > 0) {
				arrival = generateRandomNum(minArrival, maxArrival);
				arrival = arrival + timer;
				Customer c = null;

				if (generateRandomNum(1, 2) == 1 || numSelfService <= 0) { // decides whether self or full service
					c = maker.makeCust(timer, percentSlower);
				} else {
					c = makerSC.makeCust(timer, percentSlower);
				}

				if (c.getCheckoutType().equalsIgnoreCase("Full")) {
					int numCheckout = smallest(checkoutsFull);

					// adds a Customer to the Full Service Queues
					newCust.newCustFull(c, timer, numCheckout);

					numCustFull++;

				} else if (c.getCheckoutType().equalsIgnoreCase("Self")) {

					newCust.newCustSelf(c, timer);

					timeOut.constructSelfArrive(c);

					numCustSelf++;
				}
				numCust--;
			}

			// removes serviced people

			fullCheckout.process(timer, timeOut, wf);

			for (int i = 0; i < checkoutsSelf.size(); i++) {
				Customer temp = selfCheckout.processSelf(checkoutsSelf.get(i), self, timer, i, timeOut, wf);
				checkoutsSelf.set(i, temp);
			}

			// keeps track of empty register time
			int numFilled = 0;
			for (int i = 0; i < checkoutsFull.size(); i++) {
				if (checkoutsFull.get(i).isEmpty()) {
					totalRegDownTime++;
					timeOut.addEmpty(String.valueOf(i + 1));
				} else {
					numFilled++;

				}
			}

			for (int i = 0; i < checkoutsSelf.size(); i++) {
				if (isNull(checkoutsSelf.get(i))) {
					lineSelf = (char) ('A' + i);
					timeOut.addEmpty(String.valueOf(lineSelf));
				} else {
					numFilled++;
				}

			}

			if (numCust == 0 && numFilled == 0) {
				moreCust = false;
			} else
				timer++;

		}
		///////////////////////////////////////////////////////////////
		// FX
		ObservableList<TableDataCustomer> oBCustsAll = FXCollections.observableArrayList();
		ObservableList<TableDataCustomer> oBCustsFull = FXCollections.observableArrayList();
		oBCustsFull=fullCheckout.getoBCust();
		ObservableList<TableDataCustomer> oBCustsSelf = FXCollections.observableArrayList();
		oBCustsSelf=selfCheckout.getoBCust();
		for(int i =0;i<oBCustsFull.size();i++) {
			oBCustsAll.add(oBCustsFull.get(i));
		}
		for(int j =0;j<oBCustsSelf.size();j++) {
			oBCustsAll.add(oBCustsSelf.get(j));
		}
		ArrayList<TableDataCustomer> sortingForFX= new ArrayList<>();
		for(int k =0;k<oBCustsAll.size();k++) {
			sortingForFX.add(oBCustsAll.get(k));
		}
		Collections.sort(sortingForFX);
		oBCustsAll.clear();
		for(int y=0;y<sortingForFX.size();y++) {
			oBCustsAll.add(sortingForFX.get(y));
			
		}
		
		
		
		table.setItems(oBCustsAll);

		//////////////////////////////////////////////////////////////////////////////

	
		

		// outputs results of each register
		

		
		satisfied = newCust.getSatisfiedF() + newCust.getSatisfiedS() + selfCheckout.getSatisfied();
		disSatisfied = newCust.getDisSatisfied() + selfCheckout.getDisSatisfied();
		////////////////////////////////////////////////////////////////////////
		//FX
		BorderPane bp = new BorderPane();
		Button filePrint = new Button("Print To a File");
		HBox topMenu = new HBox();
		topMenu.setPadding(new Insets(10, 10, 10, 10));
		Button exit = new Button("EXIT");
		Button goBack = new Button("Go back to table");
		filePrint.setOnAction(e -> wf.writeData());
		goBack.setOnAction(e -> window.setScene(scene2));
		exit.setOnAction(e -> window.close());
		goBack.setStyle("-fx-text-fill: blue");
		exit.setStyle("-fx-text-fill: red");
		filePrint.setStyle("-fx-text-fill: green");

		topMenu.setSpacing(10);
		String summ = timeOut.getOutPut();

		
		
		
		

		////////////////////////////////////////////
		//System.out.println(timeOut.getOutPut());
		summ=summ+("");
		summ=summ+(timer / 60 + "h" + timer % 60 + "mins is the final time\n");

		summ=summ+("------------------------------\n");
		summ=summ+("Time Full service registers were not in use : " + totalRegDownTime / 60 + "h"
				+ totalRegDownTime % 60 + "mins\n");
		summ=summ+("-----------------------------\n");
		summ=summ+("Time Self service registers were not in use : " + selfCheckout.getRegDownTime() / 60 + "h"
				+ selfCheckout.getRegDownTime() % 60 + "mins\n");
		summ=summ+("-----------------------------\n");

		summ=summ+("Full Service: ");
		summ=summ+avgWaitTime(newCust.getTotalWaitFull(), numCustFull);
		summ=summ+("Self Service: ");
		summ=summ+avgWaitTime(selfCheckout.getTotalWait(), numCustSelf);
		summ=summ+("Total Satisfied: " + satisfied + "\nTotal dis-satisfied: " + disSatisfied+"\n");
		summ=summ+("Total Time of Simulation : " + timer / 60 + "h" + timer % 60 + "mins\n");

		String perFSat = percentSatisfied(numQueues, numCustFull, "Full", newCust.getSatisfiedF(), perFullSatGoal);
		String perSSat = percentSatisfied(numSelfService, numCustSelf, "Self",
				newCust.getSatisfiedS() + selfCheckout.getSatisfied(), perSelfSatGoal);
		String perFDown = percentDownTime(totalRegDownTime, timer, "Full", numQueues, perDownGoal);
		String perSDown = percentDownTime(selfCheckout.getRegDownTime(), timer, "Self", numSelfService, perDownGoal);
		
		System.out.println();
		if (!perFSat.isEmpty() && !perFDown.isEmpty()) {
			if (priority == 1 ) {
				summ=summ+(perFSat+"\n");
			} else {
				summ=summ+(perFDown+"\n");
			}
		} else {
			summ=summ+(perFSat + perFDown+"\n");
		}
		if (!perSSat.isEmpty() && !perSDown.isEmpty()) {
			if (priority == 1 ) {
				summ=summ+(perSSat+"\n");
			} else {
				summ=summ+(perSDown+"\n");
			}
		} else {
			summ=summ+(perSSat + perSDown+"\n");
		}
		//////////////////////////////////////////////////////
		textForSumm = new Text(summ);
		StackPane root = new StackPane();
		root.getChildren().addAll(textForSumm);
		VBox scrollBar = new VBox();
		topMenu.getChildren().addAll(filePrint, goBack, exit);
		ScrollPane scrollPane = new ScrollPane(scrollBar);
		scrollPane.setFitToHeight(true);
		scrollPane.setFitToWidth(true);
		scrollPane.setContent(root);

		bp.setTop(topMenu);
		bp.setCenter(root);

		bp.setRight(scrollPane);

		summScene = new Scene(bp, 400, 400);
		window.setScene(scene2);
	    window.show();

	} // end main

	public static String percentSatisfied(int numLine, int totCust, String line, int sat, double perSatGoal) {
		double percentSatisfied;
		DecimalFormat df = new DecimalFormat("##.##");
		if (numLine > 0) {
			percentSatisfied = (1.0 * sat / totCust) * 100;
			//System.out.println(
				//	"Percent of " + line + " service Customers satisfied: " + df.format(percentSatisfied) + "%");
			
			if (percentSatisfied < perSatGoal) {
				return ("You should add more " + line + " service lines");
			} else {
				return "";
			}

		} else {
			return "";
		}

	}

	public static void main(String[] args) {
		launch(args);

	}

	public static String percentDownTime(int regdownTime, int timer, String line, int numLines, double perDownGoal) {
		double perDown = (1.0 * regdownTime / numLines) / timer * 100;
		DecimalFormat df = new DecimalFormat("##.##");
		//System.out.println(line + " Service Percent Down Time: " + df.format(perDown) + "%");
		
		if (perDown > perDownGoal) {
			return ("You should remove " + line + " service lines");
		} else {
			return "";
		}

	}

	public static int generateRandomNum(int min, int max) {
		int span = max - min + 1;
		int rand = (int) (Math.random() * span);
		rand = rand + min;
		return rand;
	}

	public static String avgWaitTime(double totalWait, int numCust) {
		DecimalFormat df = new DecimalFormat("#.##");
		double avWaitTimeCalc = (double) (totalWait / numCust);
		// later instead of three for lines we can use a counter of lines

		return "The average wait time was: " + df.format(avWaitTimeCalc) + " mins\n";
	}

	public static int[] inputData() {
		int[] data = new int[9];
		System.out.println("Enter number of Customers to be served: ");
		data[0] = scan.nextInt();
		System.out.println("Enter minimum time between arrival:");
		data[1] = scan.nextInt();
		System.out.println("Enter maximum time between arrival:");
		data[2] = scan.nextInt();
		System.out.println("Enter minimum service time:");
		data[3] = scan.nextInt();
		System.out.println("Enter maximum service time:");
		data[4] = scan.nextInt();
		System.out.println("Enter Percentage Slower for Self:");
		data[5] = scan.nextInt();

		System.out.println("Enter Number of Full Service Lines:");
		data[6] = scan.nextInt();
		System.out.println("Enter Number of Self Service Lines:");
		data[7] = scan.nextInt();
		System.out.println("Is Customer Satisfaction(1) or Register DownTime(2) optimization more important");
		data[8] = scan.nextInt();

		return data;
	}

	public static int smallest(ArrayList<Queue> checkouts) {
		int count = 0;
		for (int i = 0; i < checkouts.size() - 1; i++) {
			if (checkouts.get(i).size() > checkouts.get(i + 1).size()) {
				count = i + 1;
			}
		}
		return count;

	}

	public static boolean isNull(Customer c) {
		if (c == null) {
			return true;
		} else {
			return false;
		}
	}

	public static void dataStore(TextField numCust, TextField minArTime, TextField maxArTime, TextField minServT,
			TextField maxServT, TextField percentage, TextField fullLine, TextField selfLine, TextField option,
			TextField fullInput, TextField selfInput, TextField down) {
		int number = Integer.parseInt(numCust.getText());
		int minArTimeBtw = Integer.parseInt(minArTime.getText());
		int maxArTimeBtw = Integer.parseInt(maxArTime.getText());
		int minSerTime = Integer.parseInt(minServT.getText());
		int maxSerTime = Integer.parseInt(maxServT.getText());
		int slower = Integer.parseInt(percentage.getText());
		int fullLineV = Integer.parseInt(fullLine.getText());
		int selfLineV = Integer.parseInt(selfLine.getText());
		int options = Integer.parseInt(option.getText());
		double fullOpt = Double.parseDouble(fullInput.getText());
		double selfOpt = Double.parseDouble(selfInput.getText());
		double downTime = Double.parseDouble(down.getText());
		Values newValue = new Values(number, minArTimeBtw, maxArTimeBtw, minSerTime, maxSerTime, slower, fullLineV,
				selfLineV, options, fullOpt, selfOpt, downTime);
		values = newValue;
		

	}

}
