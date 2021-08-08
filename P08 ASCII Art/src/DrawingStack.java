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
 * This class is the stack which stores the user's changes to the canvas This class implements the
 * StackADT interface
 * 
 * @author Yingjie Shen
 */
public class DrawingStack implements StackADT<DrawingChange> {
  private Node<DrawingChange> head;// the first node of the linked list
  private int stackSize;// the size of the stack

  /**
   * Constructor of the DrawingStack class
   */
  public DrawingStack() {
    this.head = null;// initialize the head field
    this.stackSize = 0;// Initialize the stackSize field
  }

  /**
   * Add an element to this stack
   * 
   * @param element an element to be added
   * @throws IllegalArgumentException if the input element is null
   */
  @Override
  public void push(DrawingChange element) throws IllegalArgumentException {
    if (element == null) {// check the input
      throw new IllegalArgumentException();
    }
    if (head == null) {// if there's no elements in the stack
      head = new Node<DrawingChange>(element, null);// set the first node
      this.stackSize++;// Incremental step
    } else {
      head = new Node<DrawingChange>(element, head);// add a node to the stack
      this.stackSize++;// Incremental step
    }
  }

  /**
   * Remove the element on the stack top and return it
   * 
   * @return the element removed from the stack top
   */
  @Override
  public DrawingChange pop() {
    if (this.isEmpty()) {// check if the stack is empty
      return null;
    }
    DrawingChange result = head.getData();// get the data from the head(top) of the stack
    head = head.getNext();// set the new top
    this.stackSize--;// once removed, update the stack size
    return result;// return the data
  }

  /**
   * Get the element on the stack top
   * 
   * @return the element on the stack top
   */
  @Override
  public DrawingChange peek() {
    if (this.isEmpty()) {// check if the stack is empty
      return null;
    }
    DrawingChange result = head.getData();// get the data stored on top of the stack
    return result;
  }

  /**
   * Returns true if this stack contains no elements.
   * 
   * @return true if this stack contains no elements, otherwise false
   */
  @Override
  public boolean isEmpty() {
    return stackSize == 0;// check the size of the stack
  }

  /**
   * Get the number of elements in the stack
   * 
   * @return the size of the stack
   */
  @Override
  public int size() {
    return this.stackSize;// getter of the stackSize
  }

  /**
   * 
   * Iterator of the stack
   * 
   * @return iterator of the stack
   */
  @Override
  public Iterator<DrawingChange> iterator() {
    return new DrawingStackIterator(head);// return iterator of the stack
  }

}
