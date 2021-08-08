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
 * Stack Abstract Data Type<br>
 * CS 300 P8 Assignment
 * 
 * @author Mingi
 *
 * @param <T> the type of objects to be stored in this stack
 */
public interface StackADT<T> {
  /**
   * Add an element to this stack
   * 
   * @param element an element to be added
   * @throws IllegalArgumentException if the input element is null
   */
  public void push(T element) throws IllegalArgumentException;

  /**
   * Remove the element on the stack top and return it
   * 
   * @return the element removed from the stack top
   */
  public T pop();

  /**
   * Get the element on the stack top
   * 
   * @return the element on the stack top
   */
  public T peek();

  /**
   * Returns true if this stack contains no elements.
   * 
   * @return true if this stack contains no elements, otherwise false
   */
  public boolean isEmpty();

  /**
   * Get the number of elements in the stack
   * 
   * @return the size of the stack
   */
  public int size();

  /**
   * 
   * @return iterator of the stack
   */
  public Iterator<T> iterator();
}
