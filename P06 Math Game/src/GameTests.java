//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Math Game
// Files: GameApplication.java, GameList.java, GameNode.java, GameOperator.java, GameTests.java
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
import java.util.Random;

/**
 * This class is the tests for the game nodes and game lists
 * 
 * @author Yingjie Shen
 */

public class GameTests {

  private static final int SEED = 123;// the seed used in the tests, yields 6,9,6....

  /**
   * This method tests applyOperator method
   * 
   * @return if the test is passed
   */
  private static boolean testApplyOperator1() {
    Random rng = new Random(SEED);// set the random generator
    GameNode node = new GameNode(rng);// create a new game node
    node.setNext(new GameNode(rng));// set the next game node
    if (node.getNext() != null) {// check if the next game node is added
      return true;
    }
    System.out
        .println("Failed: testApplyOperator1!!! Method should yeild true, but this yeilds false.");
    return false;// wrong info.
  }

  /**
   * This method tests applyOperator method
   * 
   * @return if the test is passed
   */
  private static boolean testApplyOperator2() {
    Random rng = new Random(SEED);// set the random generator
    GameNode node = new GameNode(rng);// create a new game node
    node.setNext(new GameNode(rng));// set the next game node
    if (node.getNext() != null) {// check if the next game node is added
      return true;
    }
    System.out
        .println("Failed: testApplyOperator2!!! Method should yeild true, but this yeilds false.");
    return false;// wrong info.
  }

  /**
   * This method tests addNode method
   * 
   * @return if the test is passed
   */
  private static boolean testAddNode() {
    Random rng = new Random(SEED);// set the random generator
    GameList testList = new GameList();// create a new game list
    GameNode node1 = new GameNode(rng);// create game node 1
    GameNode node2 = new GameNode(rng);// create game node 2
    GameNode node3 = new GameNode(rng);// create game node 3
    testList.addNode(node1);// add game node 1 to the test list
    testList.addNode(node2);// add game node 2 to the test list
    testList.addNode(node3);// add game node 3 to the test list
    GameNode check = node1;// set the check game node
    int nodes = 0;
    while (check != null) {// check until the last GameNode
      nodes++;
      check = check.getNext();// Incremental for next node
    }
    if (nodes == 3) {// check the number of game nodes added
      return true;
    } else {
      System.out.println("Failed: testAddNode!!! Method should yeild true, but this yeilds false.");
    } // wrong info.
    return false;
  }

  /**
   * This method tests contains method
   * 
   * @return if the test is passed
   */
  private static boolean testContains() {
    Random rng = new Random(SEED);// set the random generator
    GameList testList = new GameList();// create a new game list
    GameNode node1 = new GameNode(rng);// create game node 1
    GameNode node2 = new GameNode(rng);// create game node 2
    GameNode node3 = new GameNode(rng);// create game node 3
    testList.addNode(node1);// add game node 1 to the test list
    testList.addNode(node2);// add game node 2 to the test list
    testList.addNode(node3);// add game node 3 to the test list
    if (testList.contains(6) & testList.contains(9)) {// check if the game list contains the numbers
      return true;
    } else {
      System.out
          .println("Failed: testContains!!! Method should yeild true, but this yeilds false.");
    } // wrong info.
    return false;
  }

  /**
   * This method is the main of the test program
   */
  public static void main(String[] args) {
    int pass = 0;
    if (testApplyOperator1()) {// implements the testApplyOperator1
      pass++;
    } else {
      System.out.println("Failed: testApplyOperator1!!!");
    }
    if (testApplyOperator2()) {// implements the testApplyOperator2
      pass++;
    } else {
      System.out.println("Failed: testApplyOperator2!!!");
    }
    if (!testAddNode()) {// implements the testAddNode
      pass++;
      System.out.println("Failed: testAddNode!!!");
    }
    if (!testContains()) {// implements the contains
      pass++;
      System.out.println("Failed: testContains!!!");
    }
    if (pass == 2) {
      System.out.println("All tests passed!!!");
    }
  }
}
