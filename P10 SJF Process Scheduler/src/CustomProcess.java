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
/**
 * This class represents the CustomProcess. This class implements the Comparable interface generic
 * type of CustomProcess
 * 
 * @author Yingjie Shen
 *
 */
public class CustomProcess implements Comparable<CustomProcess> {

  private static int nextProcessId = 1; // stores the id to be assigned to the next process
                                        // to be created
  private final int PROCESS_ID; // unique identifier for this process
  private int burstTime; // time required by this process for CPU execution

  /**
   * This is the constructor of CustomProcess
   * 
   * @param burstTime the burstTime of a CustomProcess
   * @throws IllegalArgumentException if burst not greater than 0
   */
  public CustomProcess(int burstTime) throws IllegalArgumentException {
    if (burstTime < 1) {// check the burstTime
      throw new IllegalArgumentException("WARNING: burst time MUST be greater than 0!");
    }
    this.PROCESS_ID = nextProcessId++;// initialize the PROCESS_ID field
    this.burstTime = burstTime;// initialize the burstTime field
  }

  /**
   * This method is used to compare this CustomProcess to another one
   * 
   * @param CustomProcess other CustomProces to compare
   * @return int represents CustomProces has higher priority
   */
  @Override
  public int compareTo(CustomProcess other) {
    if (this.getBurstTime() < other.getBurstTime()) {// if current process has less burst time
      return -1; // current process has higher priority
    } else if (this.getBurstTime() > other.getBurstTime()) {// if other process has less burst time
      return 1;// other process has higher priority
    } else {// if the burst time for both process are same
      if (this.getProcessId() < other.getProcessId()) {// if current CustomProces has lower process
                                                       // ID
        return -1;
      } else {
        return 1;
      }
    }
  }

  /**
   * This method gets the Process ID of a Custom Process
   * 
   * @return int PROCESS_ID of a Custom Process
   */
  public int getProcessId() {
    return this.PROCESS_ID;
  }

  /**
   * This method gets the burst time of a Custom Process
   * 
   * @return int burstTime of a Custom Process
   */
  public int getBurstTime() {
    return this.burstTime;
  }

}
