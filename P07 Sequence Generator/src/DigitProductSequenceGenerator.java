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
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents a generator for a Digit Product progression
 * 
 * @author Yingjie Shen
 *
 */
public class DigitProductSequenceGenerator {


  private final int INIT; // initial number
  private final int SIZE; // size of sequence
  private ArrayList<Integer> sequence; // ArrayList object storing the sequence

  /**
   * Generates an Digit Product progression
   * 
   * @param iNIT
   * @param sIZE
   * @param sequence
   */
  public DigitProductSequenceGenerator(int init, int size) throws IllegalArgumentException {
    // check for the precondition: size > 0, throws an IllegalArgumentException if this precondition
    // is not satisfied
    if (size <= 0)
      throw new IllegalArgumentException("WARNING: CANNOT create a sequence with size <= zero.");
    // check for the validity of init (>=0), throw an IllegalArgumentException
    // if these two parameters are not valid
    if (init <= 0) {
      throw new IllegalArgumentException("WARNING: The starting element for digit product sequence "
          + "cannot be less than or equal to zero.");
    }
    this.INIT = init;// initial number
    SIZE = size;// number of elements in this sequence
    this.sequence = new ArrayList<Integer>();// ArrayList object storing the sequence
    generateSequence();// call the generateSequence method
  }

  /**
   * This method generates the digit product sequence
   */
  public void generateSequence() {
    sequence.add(INIT);// add the first number
    int current = INIT;// set the current number for operation
    int next = INIT;// set the next number to add;
    for (int i = 1; i < SIZE; i++) {// for the next numbers before size, start from the second
      String[] cNum = Integer.toString(current).split("");// split the current number
      int tmp = Integer.parseInt(cNum[0]);
      // get the first digit of the current number(last of sequence)
      for (int j = 1; j < cNum.length; j++) {// multiply the digits by the sequence
        if (Integer.parseInt(cNum[j]) == 0) {// if contains zero
          next += 0;// do nothing to the next to add
        } else {
          tmp *= Integer.parseInt(cNum[j]);// else add the number
        }
      }
      next += tmp;// add the calculated next
      sequence.add(next);// add the next
      current = next;// set the new current
    }
  }

  /**
   * This moethod gets the getIterator
   * 
   * @return iterator the iterator of the sequence
   */
  public Iterator<Integer> getIterator() {
    Iterator<Integer> iterator = sequence.iterator();
    return iterator;
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
   * This method returns the sequence field
   * 
   * @return sequence of the object
   */
  public ArrayList<Integer> getDigitSequence() {
    return this.sequence;
  }

}
