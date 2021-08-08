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
/**
 * This class represents a Badger which is designed to live in a Sett. Each Badger object represents
 * a single node within a BST (known as a Sett).
 * 
 * @author Yingjie Shen
 */
public class Badger {
  private Badger leftLowerNeighbor;// the leftLowerNeighbor of the badger
  private Badger rightLowerNeighbor;// the rightLowerNeighbor of the badger
  private int size;// the size of the badger

  /**
   * Creates a new Badger with specified size.
   * 
   * @param size The size of the newly constructed Badger object.
   */
  public Badger(int size) {
    this.size = size;// initialize the size field
    this.leftLowerNeighbor = null;// initialize the leftLowerNeighbor field
    this.rightLowerNeighbor = null;// initialize the rightLowerNeighbor field
  }

  /**
   * Retrieves neighboring badger that is smaller than this one.
   * 
   * @return Badger The left lower neighbor of current badger.
   */
  public Badger getLeftLowerNeighbor() {
    return this.leftLowerNeighbor;
  }

  /**
   * Changes this badger's lower left neighbor.
   * 
   * @param Badger The new left lower neighbor of current badger.
   */
  public void setLeftLowerNeighbor(Badger badger) {
    this.leftLowerNeighbor = badger;
  }

  /**
   * Retrieves neighboring badger that is larger than this one.
   * 
   * @return Badger The right lower neighbor of current badger.
   */
  public Badger getRightLowerNeighbor() {
    return this.rightLowerNeighbor;
  }

  /**
   * Changes this badger's lower right neighbor.
   * 
   * @param The new right lower neighbor of current badger.
   */
  public void setRightLowerNeighbor(Badger badger) {
    this.rightLowerNeighbor = badger;
  }

  /**
   * Retrieves the size of this badger.
   * 
   * @return int The size of current badger.
   */
  public int getSize() {
    return this.size;
  }
}
