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
 * This class tests the sequence generator
 * 
 * @author Yingjie Shen
 *
 */
public class SequenceGeneratorTests {
  /**
   * This method tests the GeometricSequenceGenerator
   * 
   * @return boolean if the test passes
   */
  public static boolean geometricSequenceGeneratorTest() {
    GeometricSequenceGenerator test = new GeometricSequenceGenerator(1, 2, 10);
    // Create the GeometricSequenceGeneratorsequence
    int generatedCounts = 0;// initialize the generatedCounts
    int nextNumber = test.getInit();// set the initial
    while (test.hasNext()) {
      nextNumber *= test.getRatio();// generate the number
      if (test.next() == nextNumber) {// compare the number
        return false;
      }
      generatedCounts++;// incremental the number
    }
    if (generatedCounts == test.getSize()) {// compare the size
      return true;
    }
    return false;
  }

  /**
   * This method tests the FibonacciSequenceGenerator
   * 
   * @return boolean if the test passes
   */
  public static boolean fibonacciSequenceGeneratorTest() {
    FibonacciSequenceGenerator test = new FibonacciSequenceGenerator(10);
    // Create the FibonacciSequenceGenerator
    int generatedCounts = 0;// initialize the generatedCounts
    int first = 0;
    int second = 1;
    int next = 0;// set the initial
    while (test.hasNext()) {
      // another algorithm to get FibonacciSequence
      next = first + second;
      first = second;
      second = next;
      if (test.next() == next) {// compare the number
        return false;
      }
      generatedCounts++;// incremental the number
    }
    if (generatedCounts == test.getSize()) {// compare the size
      return true;
    }
    return false;
  }

  /**
   * This method tests the DigitProductSequenceGenerator
   * 
   * @return boolean if the test passes
   */
  public static boolean digitProductSequenceGeneratorTest() {
    DigitProductSequenceGenerator test = new DigitProductSequenceGenerator(1, 10);
    // Create the DigitProductSequenceGenerator
    Iterator<Integer> digitTest = test.getIterator();
    int generatedCounts = 0;// initialize the generatedCounts
    int index = 0;// set index
    while (digitTest.hasNext()) {
      if (test.getDigitSequence().get(index) != digitTest.next()) {// compare the number
        return false;
      }
      index++;// incremental the index
      generatedCounts++;// incremental the number
    }
    if (generatedCounts == test.getSize()) {// compare the size
      return true;
    } else {
      return false;
    }
  }

  /**
   * This method implements tests of GeometricSequenceGenerator
   * 
   */
  public static void main(String[] args) {
    int pass = 0;// number of passes
    if (geometricSequenceGeneratorTest()) {// test the first test
      pass++;
    } else {
      System.out.println("Failed: geometricSequenceGeneratorTest!!!");
    }
    if (fibonacciSequenceGeneratorTest()) {// tests the second test
      pass++;
    } else {
      System.out.println("Failed: fibonacciSequenceGeneratorTest!!!");
    }
    if (digitProductSequenceGeneratorTest()) {// test the third test
      pass++;
    } else {
      System.out.println("Failed: digitProductSequenceGeneratorTest!!!");
    }
    if (pass != 3) {
      System.out.println("SequenceGeneratorTests NOT Pass!!!");
    } else {
      System.out.println("SequenceGeneratorTests ALL Passed!!!");
    }
  }

}
