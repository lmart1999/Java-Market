The project runs by having the user enter the number of customers, a minimum time between arrival, maximum
 time between arrival, minimum service time, maximum service time, and the percent slower for self checkout 
 service. It then generates a random number in these ranges and assigns that value to the customer. As the 
 simulation runs it has a system timer that keeps track of when a new customer arrives, creating the
object, putting it into a Queue, and setting all its statistics using the CustomerArrival class when the
timer is equal to the next customers arrival time. The timer also controls departure, removing the customer
whose departure time it is from whichever Queue and Checkout line they are in using the Self and Full 
Processor Classes which for self-checkout, contains all of their statistics to be used in averages at the
end and the registers to Strings are constructed at this point. The simulation ends once the final 
customer is served and begins when the first customer arrives at time 0. The data is formulated by 
register in order of customer arrival at the end and is all printed at once along with a minute by 
minute account of what’s happening. Futhermore in checkpoint D we also found the percent of register
down time for full and self service registers and the percent of customer satisfaction, we then used
those to suggest adding or removing lines from either Queue for later simulations. We also added the 
ability to write the output to a file in order to make our sample output easier to place in a word document.
Cameron, for Checkpoint C did formating making sure we could actually see our programs code. Also, did 
bugchecking and started learning how to do java FX for checkpoint D.
Cameron, for checkpoint D  wrote our Java FX code. He had to learn FX and implement it in to our code. 
Most of it runs on the application now not the console. Also, wrote a few classes.
runProgram() which was fused with the main method. The runProgram() method sets up most of the windows 
and inputs and table columns. He also wrote methods that input data and deal with exception handling if the user enters the wrong values.
Jeremiah created the classes to write to a file and helped with ensuring the program could handle a wide
variety of data, he also did some error handling and assisted Zerrilla with the output. He also made an external class for creating a
database and for storing all of our simulation data in to a table.
Luke wrote the Self and Full processor and Arrival classes as well as most of the main along with coordinating the meetings 
and efforts of the other group members. He also wrote the code for varrying the number of checkouts
and deciding what to recommend after the program finished executing.