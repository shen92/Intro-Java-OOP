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
 * This class is the priority queue which stores the CustomProcesses This class implements the
 * WaitingQueueADT interface
 * 
 * @author Yingjie Shen
 */
public class CustomProcessQueue implements WaitingQueueADT<CustomProcess> {
  private static final int INITIAL_CAPACITY = 20; // the initial capacity of the heap
  private CustomProcess[] heap; // array-based min heap storing the data. This is an oversize array
  private int size; // number of CustomProcesses present in this CustomProcessQueue

  /**
   * Constructor of the CustomProcessQueue class
   */
  public CustomProcessQueue() {
    heap = new CustomProcess[INITIAL_CAPACITY + 1];// initialize the heap field
    for (int i = 0; i < INITIAL_CAPACITY + 1; i++) {
      heap[i] = null;// set every index of the set to null
    }
    this.size = 0;// initialize the size field
  }

  /**
   * This method percolate up the heap
   * 
   * @param index the added index
   */
  private void minHeapPercolateUp(int index) {
    while (hasParent(index) && parentOf(index).compareTo(heap[index]) > 0) {
      // if the added index is smaller than the parent
      CustomProcess parent = heap[index / 2];// get the parent index of the added index
      heap[index / 2] = heap[index];// move the added index up
      heap[index] = parent;// move down the parent
      index /= 2;// update the added index after a Percolate-up
    }
  }

  /**
   * This method percolate down the heap
   * 
   * @param index the removed index
   */
  private void minHeapPercolateDown(int index) {
    while (hasLeftChild(index)) {// if the index has a left child
      CustomProcess smallerChild = leftOf(index);// get the left index
      if (hasRightChild(index) && leftOf(index).compareTo(rightOf(index)) > 0) {
        smallerChild = rightOf(index);// if the left is bigger
      }
      if (heap[index].compareTo(smallerChild) > 0) {
        CustomProcess parent = heap[index];// get the parent index of the removed index
        heap[index] = heap[index * 2];// move the removed index down
        heap[index * 2] = parent;// move down the parent
      } else {
        break;// Percolate-down process is done
      }
      index *= 2;// update the added index after a Percolate-down
    }
  }

  /**
   * This method returns size of the waiting queue
   * 
   * @return int the size of the waiting queue
   */
  @Override
  public int size() {
    return this.size;
  }

  /**
   * This method checks if the waiting queue is empty
   * 
   * @return true if the waiting queue is empty
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * This method inserts a newObject in the priority queue
   * 
   * @param CustomProcess newObject to insert
   */
  @Override
  public void enqueue(CustomProcess newObject) {
    this.size++;// increment the size
    int index = this.size;// the index of the added CustomProcess
    heap[index] = newObject;// insertion
    minHeapPercolateUp(index);// percolate up the heap
  }

  /**
   * This method removes and returns the item with the highest priority
   * 
   * @return CustomProcess the top of and the removed object of the priority queue
   */
  @Override
  public CustomProcess dequeue() {
    CustomProcess top = this.peek();// get the top
    heap[1] = heap[this.size];// get the last index to the first
    heap[this.size] = null;// remove the last index
    this.size--;// decrease the size
    minHeapPercolateDown(1);// percolate down the heap
    return top;
  }

  /**
   * This method returns without removing the item with the highest priority
   * 
   * @return CustomProcess the top of the priority queue
   */
  @Override
  public CustomProcess peek() {
    if (!isEmpty()) {
      return heap[1];// get the top
    }
    return null;
  }

  /**
   * This method returns the parent of an index
   * 
   * @param int the index to search
   * @return CustomProcess the parent of an index
   */
  private CustomProcess parentOf(int index) {
    return this.heap[index / 2];
  }

  /**
   * This method checks if an index has a parent
   * 
   * @param int the index to search
   * @return true if an index has a parent
   */
  private boolean hasParent(int index) {
    return index > 1;
  }

  /**
   * This method checks if an index has a left child
   * 
   * @param int the index to search
   * @return true if an index has a left child
   */
  private boolean hasLeftChild(int index) {
    return (index * 2) <= size;
  }

  /**
   * This method checks if an index has a right child
   * 
   * @param int the index to search
   * @return true if an index has a right child
   */
  private boolean hasRightChild(int index) {
    return (index * 2 + 1) <= size;
  }

  /**
   * This method returns the left of an index
   * 
   * @param int the index to search
   * @return CustomProcess the left of an index
   */
  private CustomProcess leftOf(int index) {
    return this.heap[2 * index];
  }

  /**
   * This method returns the right of an index
   * 
   * @param int the index to search
   * @return CustomProcess the right of an index
   */
  private CustomProcess rightOf(int index) {
    return this.heap[2 * index + 1];
  }

}
