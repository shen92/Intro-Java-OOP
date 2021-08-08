//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Badgers Settle Down
// Files: Badger.java, BadgersSettleDown.java, Sett.java, P9Tests.java
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
//
// Title: Badgers Settle Down
// Files: Badger.java, BadgersSettleDown.java, Sett.java, P9Tests.java
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
import java.util.NoSuchElementException;

/**
 * This class is the test class for the program.
 * 
 * @author Yingjie Shen
 */
public class P9Tests {
  /**
   * This method tests the constructor of the Badger object
   * 
   * @return true when the Badger object is created correctly
   */
  public static boolean testBadger() {
    boolean pass = true;
    int testBadgerSize = 10;// size of the testBadger object
    Badger testBadger = new Badger(testBadgerSize);// create a new Badger object
    if (testBadger.getSize() != testBadgerSize) {// test if the badger has the correct size
      pass = false;
      // print the error information
      System.out.println("Failed: the size of testBadger should be " + testBadgerSize
          + ", but the size " + testBadger.getSize() + " is returned.");
    }
    if (testBadger.getLeftLowerNeighbor() != null) {// test if the badger has a left child
      pass = false;
      // print the error information
      System.out.println("Failed: the left child of the testBadger should be null.");
    }
    if (testBadger.getRightLowerNeighbor() != null) {// test if the badger has a right child
      pass = false;
      // print the error information
      System.out.println("Failed: the right child of the testBadger should be null.");
    }
    if (pass)
      System.out.println("Passed: testBadger()!!!");
    return pass;
  }

  /**
   * This method tests getLeftLowerNeighbor method from Badger class
   * 
   * @return true when getLeftLowerNeighbor returns the correct Badger
   */
  public static boolean testGetLeftLowerNeighbor() {
    boolean pass = true;
    int b1Size = 5;// size of Badger b1
    Badger b1 = new Badger(b1Size);// create the b1 object
    int b2Size = 10;// size of Badger b2
    Badger b2 = new Badger(b2Size);// create the b2 object
    int b3Size = 15;// size of the Badger b3
    Badger b3 = new Badger(b3Size);// create the b3 object
    b2.setLeftLowerNeighbor(b1);// set b1 as the left child of b2
    b2.setRightLowerNeighbor(b3);// set b3 as the right child of b3
    if (!(b2.getLeftLowerNeighbor() == b1)) {
      pass = false;
      // print the error information
      System.out.println("Failed: The left child of b2 is not returned correctly.");
    }
    if (pass)
      System.out.println("Passed: testGetLeftLowerNeighbor()!!!");
    return pass;
  }

  /**
   * This method tests getRightLowerNeighbor method from Badger class
   * 
   * @return true when getRightLowerNeighbor returns the correct Badger
   */
  public static boolean testGetRightLowerNeighbor() {
    boolean pass = true;
    int b1Size = 5;// size of Badger b1
    Badger b1 = new Badger(b1Size);// create the b1 object
    int b2Size = 10;// size of Badger b2
    Badger b2 = new Badger(b2Size);// create the b2 object
    int b3Size = 15;// size of the Badger b3
    Badger b3 = new Badger(b3Size);// create the b3 object
    b2.setLeftLowerNeighbor(b1);// set b1 as the left child of b2
    b2.setRightLowerNeighbor(b3);// set b3 as the right child of b3
    if (!(b2.getRightLowerNeighbor() == b3)) {
      pass = false;
      // print the error information
      System.out.println("Failed: The right child of b2 is not returned correctly.");
    }
    if (pass)
      System.out.println("Passed: testGetRightLowerNeighbor()!!!");
    return pass;
  }

  /**
   * This method tests setLeftLowerNeighbor method from Badger class
   * 
   * @return true when seteftLowerNeighbor sets the correct Badger
   */
  public static boolean testSetLeftLowerNeighbor() {
    boolean pass = true;
    int b1Size = 5;// size of Badger b1
    Badger b1 = new Badger(b1Size);// create the b1 object
    int b2Size = 10;// size of Badger b2
    Badger b2 = new Badger(b2Size);// create the b2 object
    int b3Size = 15;// size of the Badger b3
    Badger b3 = new Badger(b3Size);// create the b3 object
    b2.setLeftLowerNeighbor(b1);// set b1 as the left child of b2
    b2.setRightLowerNeighbor(b3);// set b3 as the right child of b3
    if (!(b2.getLeftLowerNeighbor() == b1)) {
      pass = false;
      // print the error information
      System.out.println("The left child of b2 is not set correctly.");
    }
    if (pass)
      System.out.println("Passed: testSetLeftLowerNeighbor()!!!");
    return pass;
  }

  /**
   * This method tests setRightLowerNeighbor method from Badger class
   * 
   * @return true when setRightLowerNeighbor sets the correct Badger
   */
  public static boolean testSetRightLowerNeighbor() {
    boolean pass = true;
    int b1Size = 5;// size of Badger b1
    Badger b1 = new Badger(b1Size);// create the b1 object
    int b2Size = 10;// size of Badger b2
    Badger b2 = new Badger(b2Size);// create the b2 object
    int b3Size = 15;// size of the Badger b3
    Badger b3 = new Badger(b3Size);// create the b3 object
    b2.setLeftLowerNeighbor(b1);// set b1 as the left child of b2
    b2.setRightLowerNeighbor(b3);// set b3 as the right child of b3
    if (!(b2.getRightLowerNeighbor() == b3)) {
      pass = false;
      // print the error information
      System.out.println("The right child of b2 is not set correctly.");
    }
    if (pass)
      System.out.println("Passed: testSetRightLowerNeighbor()!!!");
    return pass;
  }

  /**
   * This method tests getSize method from Badger class
   * 
   * @return true when getSize gets the correct size of the Badger
   */
  public static boolean testGetSize() {
    boolean pass = true;
    int b1Size = 5;// size of Badger b1
    Badger b1 = new Badger(b1Size);// create the b1 object
    if (b1.getSize() != b1Size) {// test if the badger has the correct size
      pass = false;
      // print the error information
      System.out.println("Failed: the size of testBadger should be " + b1Size + ", but the size "
          + b1.getSize() + " is returned.");
    }
    int b2Size = 10;// size of Badger b2
    Badger b2 = new Badger(b2Size);// create the b2 object
    if (b2.getSize() != b2Size) {// test if the badger has the correct size
      pass = false;
      // print the error information
      System.out.println("Failed: the size of testBadger should be " + b2Size + ", but the size "
          + b2.getSize() + " is returned.");
    }
    int b3Size = 15;// size of the Badger b3
    Badger b3 = new Badger(b3Size);// create the b3 object
    if (b3.getSize() != b3Size) {// test if the badger has the correct size
      pass = false;
      // print the error information
      System.out.println("Failed: the size of testBadger should be " + b3Size + ", but the size "
          + b3.getSize() + " is returned.");
    }
    if (pass)
      System.out.println("Passed: testGetSize()!!!");
    return pass;
  }


  /**
   * This method tests the public methods from the Badger.class
   * 
   * @return true when all Badger tests pass
   */
  public static boolean runAllBadgerTests() {
    int pass = 6;
    if (!testBadger()) {// run the test
      // print the error information
      System.out.println("Failed: testBadger()!!!");
      pass--;
    }
    if (!testGetLeftLowerNeighbor()) {// run the test
      // print the error information
      System.out.println("Failed: testGetLeftLowerNeighbor()!!!");
      pass--;
    }
    if (!testGetRightLowerNeighbor()) {// run the test
      // print the error information
      System.out.println("Failed: testGetRightLowerNeighbor()!!!");
      pass--;
    }
    if (!testSetLeftLowerNeighbor()) {// run the test
      // print the error information
      System.out.println("Failed: testSetLeftLowerNeighbor()!!!");
      pass--;
    }
    if (!testSetRightLowerNeighbor()) {// run the test
      // print the error information
      System.out.println("Failed: testSetRightLowerNeighbor()!!!");
      pass--;
    }
    if (!testGetSize()) {// run the test
      // print the error information
      System.out.println("Failed: testGetSize()!!!");
      pass--;
    }
    if (pass != 6) {// check if all test from Badger is passed
      System.out.println("Failed: Some tests from Badger.class not pass!!!");
      return false;
    } else {
      System.out.println("Passed: All tests from Badger.class!!!");
      return true;
    }
  }

  /**
   * This method tests the constructor of the Sett class
   * 
   * @return true when Sett object is created correctly
   */
  public static boolean testSett() {
    boolean pass = true;
    Sett test = new Sett();// create a new Sett object
    if (!(test.getTopBadger() == null)) {// test if the TopBadger field is initialized
      pass = false;
      // print the error information
      System.out.println("Failed: the topBadger of the Sett should be null.");
    }
    if (pass)
      System.out.println("Passed: testSett()!!!");
    return pass;
  }

  /**
   * This method tests the clear method from Sett class
   * 
   * @return true when the BST tree is cleared
   */
  public static boolean testClear() {
    boolean pass = true;
    Sett test = new Sett();// create a new Sett object
    test.settleBadger(10);// add the first badger
    test.settleBadger(20);// add the second badger
    test.settleBadger(40);// add the third badger
    test.clear();// clear the tree
    if (!test.isEmpty()) {// test if the BST is cleared
      pass = false;
      // print the error information
      System.out.println("Failed: the Sett should be empty after call the clear method.");
    }
    if (pass)
      System.out.println("Passed: testClear()!!!");
    return pass;
  }

  /**
   * This method tests countBadger method from Sett class
   * 
   * @return true when correct number of badgers is returned
   */
  public static boolean testCountBadger() {
    boolean pass = true;
    Sett test = new Sett();// create a new Sett object
    if (test.countBadger() != 0) {// test the number of Badgers in the BST tree
      pass = false;
      // print the error information
      System.out.println("Failed: the number of Badgers in the Sett should be 0, but "
          + test.countBadger() + " is returned.");
    }
    test.settleBadger(10);// add the first badger
    if (test.countBadger() != 1) {// test the number of Badgers in the BST tree
      pass = false;
      // print the error information
      System.out.println("Failed: the number of Badgers in the Sett should be 1, but "
          + test.countBadger() + " is returned.");
    }
    test.settleBadger(20);// add the second badger
    if (test.countBadger() != 2) {// test the number of Badgers in the BST tree
      pass = false;
      // print the error information
      System.out.println("Failed: the number of Badgers in the Sett should be 2, but "
          + test.countBadger() + " is returned.");
    }
    test.settleBadger(40);// add the third badger
    if (test.countBadger() != 3) {// test the number of Badgers in the BST tree
      pass = false;
      // print the error information
      System.out.println("Failed: the number of Badgers in the Sett should be 3, but "
          + test.countBadger() + " is returned.");
    }
    if (pass)
      System.out.println("Passed: testCountBadger()!!!");
    return pass;
  }

  /**
   * This method tests findBadger method from Sett class
   * 
   * @return true when badger with proper size is returned and NoSuchElementException is thrown
   */
  public static boolean testFindBadger() {
    boolean pass = true;
    Sett test = new Sett();// create a new Sett object
    test.settleBadger(10);// add the first badger
    test.settleBadger(20);// add the second badger
    test.settleBadger(40);// add the third badger
    // test.findBadger(10);
    try {
      if (test.findBadger(10).getSize() != 10) {// test if the badger of size 10 is in the BST tree
        pass = false;
        // print the error information
        System.out.println("Failed: the Badger with size 10 should be found in the Sett");
      }
    } catch (IllegalArgumentException e) {
      pass = false;
      // print the error information
      System.out.println("Failed: IllegalArgumentException ocurred: " + e.getMessage());
    } catch (NoSuchElementException e) {
      pass = false;
      // print the error information
      System.out.println("Failed: NoSuchElementException: " + e.getMessage());
    }
    try {
      if (test.findBadger(20).getSize() != 20) {// test if the badger of size 10 is in the BST tree
        pass = false;
        // print the error information
        System.out.println("Failed: the Badger with size 20 should be found in the Sett");
      }
    } catch (IllegalArgumentException e) {
      pass = false;
      // print the error information
      System.out.println("Failed: IllegalArgumentException ocurred: " + e.getMessage());
    } catch (NoSuchElementException e) {
      pass = false;
      // print the error information
      System.out.println("Failed: NoSuchElementException: " + e.getMessage());
    }
    try {
      if (test.findBadger(40).getSize() != 40) {// test if the badger of size 10 is in the BST tree
        pass = false;
        // print the error information
        System.out.println("Failed: the Badger with size 40 should be found in the Sett");
      }
    } catch (IllegalArgumentException e) {
      pass = false;
      // print the error information
      System.out.println("Failed: IllegalArgumentException ocurred: " + e.getMessage());
    } catch (NoSuchElementException e) {
      pass = false;
      // print the error information
      System.out.println("Failed: NoSuchElementException: " + e.getMessage());
    }
    try {
      test.findBadger(30);// exception test
    } catch (IllegalArgumentException e) {
      pass = false;
      System.out.println("Failed: IllegalArgumentException ocurred: " + e.getMessage());
    } catch (NoSuchElementException e) {
      if (!e.getMessage().equals("WARNING: failed to find a badger with size 30 in the sett.")) {
        pass = false;
        // print the error information
        System.out.println(
            "Failed: NoSuchElementException: \"WARNING: failed to find a badger with size 30 "
                + "in the sett. \"should display, but " + e.getMessage() + " is displayed.");
      }
    }
    if (pass)
      System.out.println("Passed: testFindBadger()!!!");
    return pass;
  }

  /**
   * This method tests getAllBadgers method from Sett class
   * 
   * @return true when the BST tree is converted to ArrayList correctly
   */
  public static boolean testGetAllBadgers() {
    boolean pass = true;
    Sett test = new Sett();// create a new Sett object
    test.settleBadger(10);// add the first badger
    test.settleBadger(20);// add the second badger
    test.settleBadger(40);// add the third badger
    ArrayList<Badger> allBadgers = (ArrayList<Badger>) test.getAllBadgers();
    if (allBadgers == null) {// check the ArrayList
      pass = false;
      // print the error information
      System.out.println("Failed: allBadgers is null.");
    }
    if (!(allBadgers.get(0).getSize() == 10)) {// check the data in the ArrayList
      pass = false;
      // print the error information
      System.out.println("Failed: the size of the first Badger in allBadgers should be 10, "
          + "but the size returned is " + allBadgers.get(0).getSize() + ".");
    }
    if (!(allBadgers.get(1).getSize() == 20)) {// check the data in the ArrayList
      pass = false;
      // print the error information
      System.out.println("Failed: the size of  the second Badger in allBadgers should be 10, "
          + "but the size returned is " + allBadgers.get(1).getSize() + ".");
    }
    if (!(allBadgers.get(2).getSize() == 40)) {// check the data in the ArrayList
      pass = false;
      // print the error information
      System.out.println("Failed: the size of  the third Badger in allBadgers should be 10, "
          + "but the size returned is " + allBadgers.get(2).getSize() + ".");
    }
    if (pass)
      System.out.println("Passed: testGetAllBadgers()!!!");
    return pass;
  }

  /**
   * This method tests getHeight method from Sett class
   * 
   * @return true when the height of the Sett is returned correctly
   */
  public static boolean testGetHeight() {
    boolean pass = true;
    Sett test = new Sett();// create a new Sett object
    if (test.getHeight() != 0) {// check the height of the BST tree
      pass = false;
      // print the error information
      System.out.println("Failed: the height of the Sett should be 0, but the returned value is "
          + test.getHeight() + ".");
    }
    test.settleBadger(10);// add the first badger
    if (test.getHeight() != 1) {// check the height of the BST tree
      pass = false;
      // print the error information
      System.out.println("Failed: the height of the Sett should be 1, but the returned value is "
          + test.getHeight() + ".");
    }
    test.settleBadger(20);// add the second badger
    if (test.getHeight() != 2) {// check the height of the BST tree
      pass = false;
      // print the error information
      System.out.println("Failed: the height of the Sett should be 2, but the returned value is "
          + test.getHeight() + ".");
    }
    test.settleBadger(40);// add the third badger
    if (test.getHeight() != 3) {// check the height of the BST tree
      pass = false;
      // print the error information
      System.out.println("Failed: the height of the Sett should be 3, but the returned value is "
          + test.getHeight() + ".");
    }

    test.clear();// try another set of data
    test.settleBadger(20);// add the first badger
    if (test.getHeight() != 1) {// check the height of the BST tree
      pass = false;
      // print the error information
      System.out.println("Failed: the height of the Sett should be 1, but the returned value is "
          + test.getHeight() + ".");
    }
    test.settleBadger(10);// add the second badger
    if (test.getHeight() != 2) {// check the height of the BST tree
      pass = false;
      // print the error information
      System.out.println("Failed: the height of the Sett should be 2, but the returned value is "
          + test.getHeight() + ".");
    }
    test.settleBadger(40);// add the third badger
    if (test.getHeight() != 2) {// check the height of the BST tree
      pass = false;
      // print the error information
      System.out.println("Failed: the height of the Sett should be 2, but the returned value is "
          + test.getHeight() + ".");
    }
    if (pass)
      System.out.println("Passed: testGetHeight()!!!");
    return pass;
  }

  /**
   * This method tests getLargestBadger method from Sett class
   * 
   * @return true when the largest badger is returned correctly
   */
  public static boolean testGetLargestBadger() {
    boolean pass = true;
    Sett test = new Sett();// create a new Sett object
    if (test.getLargestBadger() != null) {// check the largest Badger
      pass = false;
      // print the error information
      System.out.println("Failed: null should be returned.");
    }
    test.settleBadger(10);// add the first badger
    if (test.getLargestBadger().getSize() != 10) {// check the largest Badger
      pass = false;
      // print the error information
      System.out.println("Failed: the size of the largest Badger in the Sett should be 10, "
          + "but the returned value is " + test.getLargestBadger().getSize() + ".");
    }
    test.settleBadger(20);// add the second badger
    if (test.getLargestBadger().getSize() != 20) {// check the largest Badger
      pass = false;
      // print the error information
      System.out.println("Failed: the size of the largest Badger in the Sett should be 20, "
          + "but the returned value is " + test.getLargestBadger().getSize() + ".");
    }
    test.settleBadger(40);// add the third badger
    if (test.getLargestBadger().getSize() != 40) {// check the largest Badger
      pass = false;
      // print the error information
      System.out.println("Failed: the size of the largest Badger in the Sett should be 40, "
          + "but the returned value is " + test.getLargestBadger().getSize() + ".");
    }

    test.clear();// try another set of data
    test.settleBadger(20);// add the first badger
    if (test.getLargestBadger().getSize() != 20) {// check the largest Badger
      pass = false;
      // print the error information
      System.out.println("Failed: the size of the largest Badger in the Sett should be 20, "
          + "but the returned value is " + test.getLargestBadger().getSize() + ".");
    }
    test.settleBadger(10);// add the second badger
    if (test.getLargestBadger().getSize() != 20) {// check the largest Badger
      pass = false;
      // print the error information
      System.out.println("Failed: the size of the largest Badger in the Sett should be 20, "
          + "but the returned value is " + test.getLargestBadger().getSize() + ".");
    }
    test.settleBadger(40);// add the third badger
    if (test.getLargestBadger().getSize() != 40) {// check the largest Badger
      pass = false;
      // print the error information
      System.out.println("Failed: the size of the largest Badger in the Sett should be 40, "
          + "but the returned value is " + test.getLargestBadger().getSize() + ".");
    }
    if (pass)
      System.out.println("Passed: testGetLargestBadger()!!!");
    return pass;
  }

  /**
   * This method tests getTopBadger method from Sett class
   * 
   * @return true when the topBadger is returned correctly
   */
  public static boolean testGetTopBadger() {
    boolean pass = true;
    Sett test = new Sett();// create a new Sett object
    if (test.getTopBadger() != null) {// check the topBadger
      pass = false;
      // print the error information
      System.out.println("Failed: null should be returned.");
    }
    test.settleBadger(10);// add the first badger
    if (test.getTopBadger().getSize() != 10) {// check the topBadger
      pass = false;
      // print the error information
      System.out
          .println("Failed: the size of the top Badger should be 10, but the returned value is "
              + test.getTopBadger().getSize());
    }
    test.settleBadger(20);// add the second badger
    if (test.getTopBadger().getSize() != 10) {// check the topBadger
      pass = false;
      // print the error information
      System.out
          .println("Failed: the size of the top Badger should be 10, but the returned value is "
              + test.getTopBadger().getSize());
    }
    test.settleBadger(40);// add the third badger
    if (test.getTopBadger().getSize() != 10) {// check the topBadger
      pass = false;
      // print the error information
      System.out
          .println("Failed: the size of the top Badger should be 10, but the returned value is "
              + test.getTopBadger().getSize());
    }

    test.clear();// try another set of data
    test.settleBadger(20);// add the first badger
    if (test.getTopBadger().getSize() != 20) {// check the topBadger
      pass = false;
      // print the error information
      System.out
          .println("Failed: the size of the top Badger should be 20, but the returned value is "
              + test.getTopBadger().getSize());
    }
    test.settleBadger(10);// add the second badger
    if (test.getTopBadger().getSize() != 20) {// check the topBadger
      pass = false;
      // print the error information
      System.out
          .println("Failed: the size of the top Badger should be 20, but the returned value is "
              + test.getTopBadger().getSize());
    }
    test.settleBadger(40);// add the third badger
    if (test.getTopBadger().getSize() != 20) {// check the topBadger
      pass = false;
      // print the error information
      System.out
          .println("Failed: the size of the top Badger should be 20, but the returned value is "
              + test.getTopBadger().getSize());
    }
    if (pass)
      System.out.println("Passed: testGetTopBadger()!!!");
    return pass;
  }

  /**
   * This method tests isEmpty method from Sett class
   * 
   * @return true when Sett isEmpty correctly
   */
  public static boolean testIsEmpty() {
    boolean pass = true;
    Sett test = new Sett();// create a new Sett object
    if (test.isEmpty() != true) {// test if the BST tree is empty
      pass = false;
      // print the error information
      System.out.println("Failed: isEmpty method should return true, but the returned value is "
          + test.isEmpty() + ".");
    }
    test.settleBadger(10);// add the first badger
    if (test.isEmpty() != false) {// test if the BST tree is empty
      pass = false;
      // print the error information
      System.out.println("Failed: isEmpty method should return false, but the returned value is "
          + test.isEmpty() + ".");
    }
    test.settleBadger(20);// add the second badger
    if (test.isEmpty() != false) {// test if the BST tree is empty
      pass = false;
      // print the error information
      System.out.println("Failed: isEmpty method should return false, but the returned value is "
          + test.isEmpty() + ".");
    }
    test.settleBadger(40);// add the third badger
    if (test.isEmpty() != false) {// test if the BST tree is empty
      pass = false;
      // print the error information
      System.out.println("Failed: isEmpty method should return false, but the returned value is "
          + test.isEmpty() + ".");
    }
    if (pass)
      System.out.println("Passed: testIsEmpty()!!!");
    return pass;
  }

  /**
   * This method tests settleBadgermethod from Sett class
   * 
   * @return true when badger is settled properly and IllegalArgumentException is thrown
   */
  public static boolean testSettleBadger() {
    boolean pass = true;
    Sett test = new Sett();// create a new Sett object
    try {
      test.settleBadger(10);// add the first badger
    } catch (IllegalArgumentException e) {
      pass = false;
      // print the error information
      System.out.println("Failed: IllegalArgumentException ocurred: " + e.getMessage());
    }
    if (test.isEmpty() != false) {// test if the badger is added
      pass = false;
      // print the error information
      System.out.println("Failed: isEmpty method should return false, but the returned value is "
          + test.isEmpty() + ".");
    }
    try {
      if (test.findBadger(10).getSize() != 10) {// test if the badger of size 10 is in the BST tree
        pass = false;
        // print the error information
        System.out.println("Failed: the Badger with size 10 should be found in the Sett");
      }
    } catch (IllegalArgumentException e) {
      pass = false;
      // print the error information
      System.out.println("Failed: IllegalArgumentException ocurred: " + e.getMessage());
    } catch (NoSuchElementException e) {
      pass = false;
      // print the error information
      System.out.println("Failed: NoSuchElementException: " + e.getMessage());
    }
    if (test.countBadger() != 1) {// test the number of Badgers in the BST tree
      pass = false;
      // print the error information
      System.out.println("Failed: the number of Badgers in the Sett should be 1, but "
          + test.countBadger() + " is returned.");
    }
    if (test.getHeight() != 1) {// test the height of the tree is correct
      pass = false;
      // print the error information
      System.out.println("Failed: the height of the Sett should be 1, but the returned value is "
          + test.getHeight() + ".");
    }
    try {
      test.settleBadger(20);// add the second badger
    } catch (IllegalArgumentException e) {
      pass = false;
      // print the error information
      System.out.println("Failed: IllegalArgumentException ocurred: " + e.getMessage());
    }
    if (test.isEmpty() != false) {// test if the badger is added
      pass = false;
      // print the error information
      System.out.println("Failed: isEmpty method should return false, but the returned value is "
          + test.isEmpty() + ".");
    }
    try {
      if (test.findBadger(20).getSize() != 20) {// test if the badger of size 20 is in the BST tree
        pass = false;
        // print the error information
        System.out.println("Failed: the Badger with size 20 should be found in the Sett");
      }
    } catch (IllegalArgumentException e) {
      pass = false;
      // print the error information
      System.out.println("Failed: IllegalArgumentException ocurred: " + e.getMessage());
    } catch (NoSuchElementException e) {
      pass = false;
      // print the error information
      System.out.println("Failed: NoSuchElementException: " + e.getMessage());
    }
    if (test.countBadger() != 2) {// test the number of Badgers in the BST tree
      pass = false;
      // print the error information
      System.out.println("Failed: the number of Badgers in the Sett should be 2, but "
          + test.countBadger() + " is returned.");
    }
    if (test.getHeight() != 2) {// test the height of the tree is correct
      pass = false;
      // print the error information
      System.out.println("Failed: the height of the Sett should be 2, but the returned value is "
          + test.getHeight() + ".");
    }
    try {
      test.settleBadger(40);// add the third badger
    } catch (IllegalArgumentException e) {
      pass = false;
      // print the error information
      System.out.println("Failed: IllegalArgumentException ocurred: " + e.getMessage());
    }
    if (test.isEmpty() != false) {// test if the badger is added
      pass = false;
      // print the error information
      System.out.println("Failed: isEmpty method should return false, but the returned value is "
          + test.isEmpty() + ".");
    }
    try {
      if (test.findBadger(40).getSize() != 40) {// test if the badger of size 10 is in the BST tree
        pass = false;
        // print the error information
        System.out.println("Failed: the Badger with size 40 should be found in the Sett");
      }
    } catch (IllegalArgumentException e) {
      pass = false;
      // print the error information
      System.out.println("Failed: IllegalArgumentException ocurred: " + e.getMessage());
    } catch (NoSuchElementException e) {
      pass = false;
      // print the error information
      System.out.println("Failed: NoSuchElementException: " + e.getMessage());
    }
    if (test.countBadger() != 3) {// test the number of Badgers in the BST tree
      pass = false;
      // print the error information
      System.out.println("Failed: the number of Badgers in the Sett should be 3, but "
          + test.countBadger() + " is returned.");
    }
    if (test.getHeight() != 3) {// test the height of the tree is correct
      pass = false;
      // print the error information
      System.out.println("Failed: the height of the Sett should be ., but the returned value is "
          + test.getHeight() + ".");
    }
    try {
      test.settleBadger(40);// exception test
    } catch (IllegalArgumentException e) {
      if (!e.getMessage().equals("WARNING: failed to settle the badger with size 40, "
          + "as there is already a badger with the same size in this sett.")) {
        pass = false;
        // print the error information
        System.out.println(
            "Failed: IllegalArgumentException: \"WARNING: failed to find a badger with size 30 "
                + "in the sett. \"should display, but " + e.getMessage() + " is displayed.");
      }
    }
    if (pass)
      System.out.println("Passed: testSettleBadger()!!!");
    return pass;
  }



  /**
   * This method tests the public methods from the Sett.class
   * 
   * @return true when all Sett tests pass
   */
  public static boolean runAllSettTests() {
    int pass = 10;
    if (!testSett()) {// run the test testSett
      // print the error information
      System.out.println("Failed: testSett()!!!");
      pass--;
    }
    if (!testClear()) {// run the test testClear
      // print the error information
      System.out.println("Failed: testClear()!!!");
      pass--;
    }
    if (!testCountBadger()) {// run the test testCountBadger
      // print the error information
      System.out.println("Failed: testCountBadger()!!!");
      pass--;
    }
    if (!testFindBadger()) {// run the test testFindBadger
      // print the error information
      System.out.println("Failed: testFindBadger()!!!");
      pass--;
    }
    if (!testGetAllBadgers()) {// run the test testGetAllBadgers
      // print the error information
      System.out.println("Failed: testGetAllBadgers()!!!");
      pass--;
    }
    if (!testGetHeight()) {// run the test testGetHeight
      // print the error information
      System.out.println("Failed: testGetHeight()!!!");
      pass--;
    }
    if (!testGetLargestBadger()) {// run the test testGetLargestBadger
      // print the error information
      System.out.println("Failed: testGetLargestBadger()!!!");
      pass--;
    }
    if (!testGetTopBadger()) {// run the test testGetTopBadger
      // print the error information
      System.out.println("Failed: testGetTopBadger()!!!");
      pass--;
    }
    if (!testIsEmpty()) {// run the test testIsEmpty
      // print the error information
      System.out.println("Failed: testIsEmpty()!!!");
      pass--;
    }
    if (!testSettleBadger()) {// run the test testSettleBadger
      // print the error information
      System.out.println("Failed: testSettleBadger()!!!");
      pass--;
    }
    if (pass != 10) {// check if all test from Sett is passed
      System.out.println("Failed: Some tests from Sett.class not pass!!!");
      return false;
    } else {
      System.out.println("Passed: All tests from Sett.class!!!");
      return true;
    }
  }

  /**
   * This method is the main method of the P9Test class
   * 
   * @param String[] args
   */
  public static void main(String[] args) {
    System.out.println("Tests: runAllBadgerTests and runAllSettTests are passed: "
        + (runAllBadgerTests() && runAllSettTests()) + ".");
  }
}
