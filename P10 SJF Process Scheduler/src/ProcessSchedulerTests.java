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
 * This class is the test class for the SJF Process Scheduler
 * 
 * @author Yingjie Shen
 */
public class ProcessSchedulerTests {

  /**
   * This method tests if a correct CustomProcess Object is created
   * 
   * @return true if a correct CustomProcess Object is created
   */
  public static boolean testCustomProcess() {
    boolean pass = true;
    CustomProcess t1 = new CustomProcess(3);// create a new CustomProcess t1
    if (t1.getBurstTime() != 3) {// check the burst time of the CustomProcess
      // print the error information
      System.out.println("Failed: t1's burst time is 3, but " + t1.getBurstTime() + "is returned.");
      pass = false;
    }
    if (t1.getProcessId() != 1) {// check the process ID of the CustomProcess
      // print the error information
      System.out.println("Failed: t1's process ID is 1, but " + t1.getProcessId() + "is returned.");
      pass = false;
    }
    try {// check if IllegalArgumentException is thrown if the burst time is less than 1
      CustomProcess t2 = new CustomProcess(0);
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("WARNING: burst time MUST be greater than 0!")) {
        pass = false;
        // print the error information
        System.out.println(
            "Failed: IllegalArgumentException \"WARNING: burst time MUST be greater than 0!\" "
                + "should display, but \"" + e.getMessage() + "\" is displayed.");
      }
    }
    return pass;
  }

  /**
   * This method checks the correctness of the compareTo method implemented in the CustomProcess
   * class
   * 
   * @return true if compareTo method works properly
   */
  public static boolean testCompareTo() {
    boolean pass = true;
    CustomProcess t1 = new CustomProcess(1);// create a new CustomProcess t1
    CustomProcess t2 = new CustomProcess(3);// create a new CustomProcess t2
    if (t1.compareTo(t2) > 0) {// check if t1 has priority than t2
      pass = false;
      // print the error information
      System.out
          .println("Failed: a negative number should return, but a positive number returned.");
    }
    return pass;
  }

  /**
   * This method checks the correctness of the enqueue operation implemented in the
   * CustomProcessQueue class
   * 
   * @return true if enqueue method works properly
   */
  public static boolean testEnqueueCustomProcessQueue() {
    boolean pass = true;
    CustomProcessQueue test = new CustomProcessQueue();
    CustomProcess t1 = new CustomProcess(3);// create a new CustomProcess t1
    CustomProcess t2 = new CustomProcess(5);// create a new CustomProcess t2
    CustomProcess t3 = new CustomProcess(2);// create a new CustomProcess t3
    CustomProcess t4 = new CustomProcess(4);// create a new CustomProcess t4
    test.enqueue(t1);// insert t1 to the queue
    if (test.peek().getBurstTime() != 3) {// check the top
      pass = false;
      // print the error information
      System.out.println("Failed: the index of 1 in the heap should be 3, but "
          + test.peek().getBurstTime() + " is returned.");
    }
    test.enqueue(t2);// insert t2 to the queue
    if (test.peek().getBurstTime() != 3) {// check the top
      pass = false;
      // print the error information
      System.out.println("Failed: the index of 1 in the heap should be 3, but "
          + test.peek().getBurstTime() + " is returned.");
    }
    test.enqueue(t3);// insert t3 to the queue
    if (test.peek().getBurstTime() != 2) {// check the top
      pass = false;
      // print the error information
      System.out.println("Failed: the index of 1 in the heap should be 2, but "
          + test.peek().getBurstTime() + " is returned.");
    }
    test.enqueue(t4);// insert t3 to the queue
    if (test.peek().getBurstTime() != 2) {// check the top
      pass = false;
      // print the error information
      System.out.println("Failed: the index of 1 in the heap should be 2, but "
          + test.peek().getBurstTime() + " is returned.");
    }
    return pass;
  }

  /**
   * This method checks the correctness of the dequeue operation implemented in the
   * CustomProcessQueue class
   * 
   * @return true if dequeue method works properly
   */
  public static boolean testDequeueCustomProcessQueue() {
    boolean pass = true;
    CustomProcessQueue test = new CustomProcessQueue();
    CustomProcess t1 = new CustomProcess(3);// create a new CustomProcess t1
    CustomProcess t2 = new CustomProcess(5);// create a new CustomProcess t2
    CustomProcess t3 = new CustomProcess(2);// create a new CustomProcess t3
    CustomProcess t4 = new CustomProcess(4);// create a new CustomProcess t4
    test.enqueue(t1);// insert t1 to the queue
    test.enqueue(t2);// insert t2 to the queue
    test.enqueue(t3);// insert t3 to the queue
    test.enqueue(t4);// insert t4 to the queue
    test.dequeue();// removes the top of the priority queue
    if (test.peek().getBurstTime() != 4) {// check the top
      pass = false;
      // print the error information
      System.out.println("Failed: the root of the heap after dequeue should be 4, but "
          + test.peek().getBurstTime() + " is returned.");
    }
    test.dequeue();// removes the top of the priority queue
    if (test.peek().getBurstTime() != 3) {// check the top
      pass = false;
      // print the error information
      System.out.println("Failed: the root of the heap after dequeue should be 3, but "
          + test.peek().getBurstTime() + " is returned.");
    }
    test.dequeue();// removes the top of the priority queue
    if (test.peek().getBurstTime() != 5) {// check the top
      pass = false;
      // print the error information
      System.out.println("Failed: the root of the heap after dequeue should be 5, but "
          + test.peek().getBurstTime() + " is returned.");
    }
    test.dequeue();// removes the top of the priority queue
    if (test.peek() != null) {// check the top
      pass = false;
      // print the error information
      System.out.println("Failed: the root of the heap after dequeue should be null, but "
          + test.peek().getBurstTime() + " is returned.");
    }
    return pass;
  }

  /**
   * This method is the main method of the ProcessSchedulerTests class
   * 
   * @param String[] args
   */
  public static void main(String[] args) {
    int pass = 4;
    if (!testCustomProcess()) {
      // print the error information
      System.out.println("Failed: testCustomProcess()!!!");
      pass--;
    }
    if (!testCompareTo()) {
      // print the error information
      System.out.println("Failed: testCompareTo()!!!");
      pass--;
    }
    if (!testEnqueueCustomProcessQueue()) {
      // print the error information
      System.out.println("Failed: testEnqueueCustomProcessQueue()!!!");
      pass--;
    }
    if (!testDequeueCustomProcessQueue()) {
      // print the error information
      System.out.println("Failed: testDequeueCustomProcessQueue()!!!");
      pass--;
    }
    if (pass == 4) {
      System.out.println("All tests passed!!!");
    }
  }
}
