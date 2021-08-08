//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: SJF Process Scheduler
// Files: CustomProcess.java, CustomProcessQueue.java, ProcessScheduler.java,
// ProcessSchedulerTests.java, WaitingQueueADT.java
// Course: CS 300 Fall 2018 002
//
// Author: Yingjie Shen
// Email: shen92@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: N/A
// Partner Email: N/A
// Partner Lecturer's Name: N/A
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Scanner;

/**
 * This class is the driver class of the program
 * 
 * @author Yingjie Shen
 */
public class ProcessScheduler {
  private int currentTime; // stores the current time after the last run
  private int numProcessesRun; // stores the number of processes run so far
  private CustomProcessQueue queue; // this processing unit's custom process queue

  /**
   * Constructor of the ProcessScheduler
   */
  public ProcessScheduler() {
    this.currentTime = 0;// initialize the currentTime field
    this.numProcessesRun = 0;// initialize the numProcessesRun field
    queue = new CustomProcessQueue();// initialize the queue field
  }

  /**
   * This method inserts a CustomProcess to the CustomProcessQueue
   * 
   * @param CustomProcess process to insert
   */
  public void scheduleProcess(CustomProcess process) {
    queue.enqueue(process);// insert the CustomProcess
    System.out.println("Process ID " + process.getProcessId() + " scheduled. Burst Time = "
        + process.getBurstTime());// prompt of an insertion
  }

  /**
   * This method runs the schedule process
   * 
   * @return String of the schedule process log
   */
  public String run() {
    int size = queue.size();// size of the CustomProcesses to schedule
    String output = "Starting " + size;// the log to return
    if (numProcessesRun == 1) {// check the plural to display
      output += " process\n\n";// update the log
    } else {
      output += " processes\n\n";// update the log
    }
    for (int i = 1; i < size + 1; i++) {// the loop of schedule process
      int id = queue.peek().getProcessId();// the process ID of the process to schedule
      int time = queue.peek().getBurstTime();;// burst time of the process to schedule
      output += "Time " + this.currentTime + " : ProcessID " + id + " Starting.\n";// update the log
      queue.dequeue();// removes the first
      this.currentTime += time;// time of the process added
      output += "Time " + this.currentTime + " : ProcessID " + id + " Completed.\n";// update the
                                                                                    // log
      this.numProcessesRun++;// update after the process
    }
    output += "\nTime " + this.currentTime + ": All scheduled processes completed.";// update the
                                                                                    // log
    return output;// return String of the schedule process log
  }

  /**
   * This method implements the quit process
   * 
   * @retuen true if the user ends the program
   */
  public boolean quit() {
    System.out.println(
        this.numProcessesRun + " processes run in " + this.currentTime + " units of time!");// info
    System.out.println("Thank you for using our scheduler!");// prompt
    System.out.println("Goodbye!");// prompt
    return true;
  }

  /**
   * This method is the main method of the class
   * 
   * @param String[] args
   */
  public static void main(String[] args) {
    System.out.println("==========   Welcome to the SJF Process Scheduler App   ========");// prompt
    System.out.println();
    boolean done = false;
    String command = "";// command of the user
    Scanner sc = new Scanner(System.in);// Scanner instance
    ProcessScheduler scheduler = new ProcessScheduler();
    while (!done) {
      System.out.println("Enter command:");// prompt
      System.out.println("[schedule <burstTime>] or [s <burstTime>]");// prompt
      System.out.println("[run] or [r]");// prompt
      System.out.println("[quit] or [q]");// prompt
      System.out.println();
      if (sc.hasNext()) {
        command = sc.nextLine();// collect the user input
      }
      String[] input = command.split(" ");// process the user's input
      if (input[0].trim().equals("s") || input[0].trim().equals("schedule")) {// insert the process
        int time = Integer.parseInt(input[1]);// get the burst time
        try {
          CustomProcess process = new CustomProcess(time);// create a new CustomProcess
          scheduler.scheduleProcess(process);// insertion of a process
        } catch (IllegalArgumentException e) {// if the burst time is 0
          System.out.println(e.getMessage());// display the warning
        }
      } else if (input[0].trim().equals("r") || input[0].trim().equals("run")) {// run the scheduler
        System.out.println(scheduler.run());// do the process and show the log
      } else if (input[0].trim().equals("q") || input[0].trim().equals("quit")) {// quit the program
        done = scheduler.quit();// run the quit process
        sc.close();// closure of the Scanner
      } else {
        System.out.println("WARNING: Please enter a valid command!");// prompt
      }
      System.out.println();
    }
  }
}
