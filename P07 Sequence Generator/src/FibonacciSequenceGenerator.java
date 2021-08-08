//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Sequence Generator
// Files: ArithmeticSequenceGenerator.java, DigitProductSequenceGenerator.java,
// FibonacciSequenceGenerator.java, GeometricSequenceGenerator.java, Sequence.java,
// SequenceGeneratorTests.java
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
import javax.imageio.spi.ServiceRegistry;

/**
 * This class represents a generator for a Fibonacci progression This class implements the
 * Iterator<Integer> interface
 * 
 * @author Yingjie Shen
 *
 */
public class FibonacciSequenceGenerator implements Iterator<Integer> {
  private final int SIZE; // number of elements in this sequence
  private int prev; // previous item in the sequence with respect to the current iteration
  private int next; // next item in the sequence with respect to the current iteration
  private int generatedCount; // number of items generated so far


  /**
   * Generates an Fibonacci progression
   * 
   * @param size number of elements in the sequence
   */
  public FibonacciSequenceGenerator(int size) throws IllegalArgumentException {
    // check for the precondition: size > 0, throws an IllegalArgumentException if this precondition
    // is not satisfied
    if (size <= 0) {
      throw new IllegalArgumentException("WARNING: CANNOT create a sequence with size <= zero.");
    }
    this.SIZE = size; // number of elements in this sequence
    this.prev = 0; // previous item in the sequence with respect to the current iteration
    next = 1; // next item in the sequence with respect to the current iteration
    this.generatedCount = 0; // number of items generated so far
  }


  /**
   * Checks if the iteration has a next element in this sequence
   * 
   * @return true if the current element in the iteration has a next element in this sequence, false
   *         otherwise
   */
  @Override
  public boolean hasNext() {
    // time complexity: O(1)
    return generatedCount < SIZE;
  }

  /**
   * Returns the next element in this Fibonacci sequence iteration with respect to the numbers
   * generated so far
   * 
   * @return the next element in this iteration
   */
  @Override
  public Integer next() {
    // time complexity: O(1)
    if (!hasNext()) // check if the current element has a next element in this sequence
      return null;
    int current = 0;
    current = prev;// print the first number in the list
    generatedCount++;// increment the number of generated elements so far
    prev += next - current; // set the first number to the current
    next = prev + current;// set the third number(next)
    return current;
  }

  /**
   * This method returns the SIZE field
   * 
   * @return SIZE of the sequence
   */
  public int getSize() {
    return this.SIZE;
  }

  /**
   * This method returns the generatedCount field
   * 
   * @return generatedCount of the sequence
   */
  public int getGeneratedCount() {
    return this.generatedCount;
  }

}
