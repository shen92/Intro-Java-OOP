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
 * This class is for the game node object
 * 
 * @author Yingjie Shen
 */
public class GameNode {
  private int number; // the number held within this node
  private GameNode next; // the next GameNode in the list, or null for the last node

  /*
   * * Constructor of GameNode class
   */
  public GameNode(Random rng) {
    this.number = rng.nextInt(9) + 1; // initializes number to random 1-9 value,
    this.next = null; // initializes next to null
  }

  /**
   * accessor for the number field
   * 
   * @return the number stored in the node
   */
  public int getNumber() {
    return this.number; // return the number held within this node
  }

  /**
   * accessor for the next field
   * 
   * @return the next game node
   */
  public GameNode getNext() {
    return this.next; // the next GameNode in the list
  }

  /**
   * mutator for the next field
   */
  public void setNext(GameNode next) {
    this.next = next; // set the next GameNode in the list
  }

  /**
   * This method applies an operator to a game node
   * 
   * @param operator to operate to the game node
   * @throws NullPointerException
   */
  public void applyOperator(GameOperator operator) throws NullPointerException {
    if (this.getNext() == null) {// check if this is the last node
      throw new NullPointerException("WARNING: This is the last number!!!");
    }
    this.number = operator.apply(this.getNumber(), this.next.getNumber());// get the numbers
    this.setNext(this.getNext().getNext());// set next to the next of the second node
  }
}
