//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: ASCII Art
// Files: AsciiArt.java, AsciiTest.java,
// Canvas.java, DrawingChange.java, DrawingStack.java,
// DrawingStackIterator.java, Node.java, StackADT.java
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
import java.util.Iterator;

/**
 * This class is the iterator of the Drawing stack, this class implements the Iterator interface
 * 
 * @author Yingjie Shen
 */
public class DrawingStackIterator implements Iterator<DrawingChange> {

  private Node<DrawingChange> next;// the next node

  /**
   * Constructor of the DrawingStackIterator
   * 
   * @param head of the linked list
   */
  public DrawingStackIterator(Node<DrawingChange> head) {
    this.next = head;// initialize the next field
  }

  /**
   * Checks if the iteration has a next element in this stack
   * 
   * @return true if the current element in the iteration has a next element in this stack, false
   *         otherwise
   */
  @Override
  public boolean hasNext() {
    return this.next != null;
  }

  /**
   * Returns the next element in this stack iteration with respect to the numbers generated so far
   * 
   * @return the next element in this iteration
   */
  @Override
  public DrawingChange next() {
    DrawingChange current = this.next.getData();// get the data of the next node
    this.next = this.next.getNext();// update the next node with the next node
    return current;
  }

}
