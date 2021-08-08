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
 * Interface of CustomProcessQueue and generic type T which extends Comparable class with generic
 * type T
 * 
 * @author Yingjie Shen
 */
public interface WaitingQueueADT<T extends Comparable<T>> {
  /**
   * This method inserts a newObject in the priority queue
   * 
   * @param T newObject to insert
   */
  public void enqueue(T newObject);

  /**
   * This method removes and returns the item with the highest priority
   * 
   * @return T the top of and the removed object of the priority queue
   */
  public T dequeue();

  /**
   * This method returns without removing the item with the highest priority
   * 
   * @return T the top of the priority queue
   */
  public T peek();

  /**
   * This method returns size of the waiting queue
   * 
   * @return int the size of the waiting queue
   */
  public int size();


  /**
   * This method checks if the waiting queue is empty
   * 
   * @return true if the waiting queue is empty
   */
  public boolean isEmpty();
}
