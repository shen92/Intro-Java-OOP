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

/**
 * This class represents a generator for a geometric progression This class implements the
 * Iterator<Integer> interface
 * 
 * @author Yingjie Shen
 *
 */
public class GeometricSequenceGenerator implements Iterator<Integer> {
  private final int SIZE; // The number of elements in this sequence
  private final int INIT; // The first term in this sequence
  private final int RATIO; // The common ratio for this sequence
  private int next; // The next term in the sequence

  private int generatedCount; // The number of terms generated so far in this sequence
  // It refers also to the order of the next number to be generated by next() method

  /**
   * Generates an geometric progression
   * 
   * @param init first term in this sequence
   * @param ratio common ratio for this sequence
   * @param size number of elements in this sequence
   * @throws IllegalArgumentException if the init, ratio, size is negative or zero
   * 
   */
  public GeometricSequenceGenerator(int init, int ratio, int size) throws IllegalArgumentException {
    // check for the validity of init (>=0) and ratio(>0), throw an IllegalArgumentException
    // if these two parameters are not valid
    if (init <= 0 || ratio <= 0) {
      throw new IllegalArgumentException(
          "WARNING: The starting element and the common ratio for a geometric progression should be STRICTLY POSITIVE.");
    }
    // check for the precondition: size > 0, throws an IllegalArgumentException if this precondition
    // is not satisfied
    if (size <= 0) {
      throw new IllegalArgumentException("WARNING: CANNOT create a sequence with size <= zero.");
    }
    this.INIT = init;// initialize the init field
    this.RATIO = ratio;// initialize the ration field
    this.SIZE = size;// initialize the size field
    this.next = init;// initializes next to the first element in this arithmetic progression
    this.generatedCount = 0;// initialize the generatedCount field to be zero
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
   * Returns the next element in this geometric sequence iteration with respect to the numbers
   * generated so far
   * 
   * @return the next element in this iteration
   */
  @Override
  public Integer next() {
    // time complexity: O(1)
    if (!hasNext()) // check if the current element has a next element in this sequence
      return null;
    int current = next; // set the current element to next
    generatedCount++; // increment the number of generated elements so far
    next *= RATIO; // set the next element (adds the common difference to the current number)
    return current; // return the current number as the generated one
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

  /**
   * This method returns the INIT field
   * 
   * @return INIT of the sequence
   */
  public int getInit() {
    return this.INIT;
  }

  /**
   * This method returns the RATIO field
   * 
   * @return RATIO of the sequence
   */
  public int getRatio() {
    return this.RATIO;
  }
}
