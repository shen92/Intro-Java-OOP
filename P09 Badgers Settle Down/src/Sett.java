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
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class represents a Sett, where a group of Badgers live together. Each Sett is organized as a
 * BST of Badger nodes.
 * 
 * @author Yingjie Shen
 */
public class Sett {
  private Badger topBadger;// the top badger

  /*
   ** Constructs an empty Sett.
   */
  public Sett() {
    this.topBadger = null;// initialize the topBadger field
  }

  /**
   * Retrieve the top Badger within this Sett (the one that was settled first).
   * 
   * @return The Badger living on the top of the current Sett.
   */
  public Badger getTopBadger() {
    return this.topBadger;
  }

  /**
   * Checks whether this Sett is empty.
   * 
   * @return true if this Sett is empty, false otherwise.
   */
  public boolean isEmpty() {
    return this.topBadger == null;
  }

  /**
   * Creates a new Badger object with the specified size, and inserts them into this Sett (BST). You
   * must implement the naive insert algorithm discussed in zybooks and lecture: which only
   * preserves the order property of each node, and is not guaranteed to result in balance.
   * 
   * @param size The size of the new Badger that will be settled.
   * 
   * @throws java.lang.IllegalArgumentException - When a Badger with the specified size already
   *         exists within this Sett. The message in this exception must read: "WARNING: failed to
   *         settle the badger with size {size}, as there is already a badger with the same size in
   *         this sett", where {size} needs to be replaced with the specified size parameter.
   */
  public void settleBadger(int size) throws java.lang.IllegalArgumentException {
    if (isEmpty()) {// check if the BST is empty
      this.topBadger = new Badger(size);
    } else {// else add a new Badger to the BST
      settleHelper(topBadger, new Badger(size));// recursive call
    }
  }

  /**
   * This recursive helper method is used to help settle a new Badger within this Sett.
   * 
   * @param current The current Badger (previously settled within this Sett) that we are considering
   *        settling the newBadger beneath (either to its left or right).
   * @param newBadger The new Badger that needs to be settled within this Sett.
   * 
   * @throws java.lang.IllegalArgumentException - When a Badger with the specified size already
   *         exists within this Sett. The message in this exception must read: "WARNING: failed to
   *         settle the badger with size {size}, as there is already a badger with the same size in
   *         this sett", where {size} needs to be replaced with the specified size parameter.
   */
  private void settleHelper(Badger current, Badger newBadger)
      throws java.lang.IllegalArgumentException {
    if (newBadger.getSize() < current.getSize()) {
      // add newBadger to the left subtree
      if (current.getLeftLowerNeighbor() == null) // no left lower Badger
        current.setLeftLowerNeighbor(newBadger); // add newBadger at the left lower of current
      else // recur on the left lower Badger of the current
        settleHelper(current.getLeftLowerNeighbor(), newBadger);
    } else if (newBadger.getSize() > current.getSize()) {
      if (current.getRightLowerNeighbor() == null) // no right lower Badger
        current.setRightLowerNeighbor(newBadger); // add newBadger at the right lower of current
      else // recur on the right lower Badger of the current
        settleHelper(current.getRightLowerNeighbor(), newBadger);
    } else {// the badger has already existed
      throw new IllegalArgumentException(
          "WARNING: failed to settle the badger with size " + newBadger.getSize()
              + ", as there is already a badger with the same size in this sett.");
    }
  }

  /**
   * Finds a Badger of a specified size in this Sett.
   * 
   * @param size The size of the Badger object to search for and return.
   * @return Badger The Badger found with the specified size.
   * 
   * @throws java.util.NoSuchElementException - When there is no Badger in this Sett with the
   *         specified size. The message within this exception must read "WARNING: failed to find a
   *         badger with size {size} in the sett", where {size} needs to be replaced with the
   *         specified size parameter.
   */
  public Badger findBadger(int size) throws java.util.NoSuchElementException {
    if (isEmpty()) {// check if the BST is empty
      throw new NoSuchElementException(
          "WARNING: failed to find a badger with size " + size + " in the sett.");
    } else {
      return findHelper(topBadger, size);// recursive call
    }
  }

  /**
   * This recursive helper method is used to help find a Badger within this Sett.
   * 
   * @param current The current Badger that is the root of a (sub) tree that we are searching for a
   *        Badger with the specified size within.
   * @param size The size of the Badger object to search for and return.
   * @return Badger The Badger found with the specified size.
   * 
   * @throws java.util.NoSuchElementException - When there is no Badger in this Sett with the
   *         specified size. The message within this exception must read "WARNING: failed to find a
   *         badger with size {size} in the sett", where {size} needs to be replaced with the
   *         specified size parameter.
   */
  private Badger findHelper(Badger current, int size) throws java.util.NoSuchElementException {
    if (current == null) // reach a leaf or binary search tree empty
      throw new NoSuchElementException(
          "WARNING: failed to find a badger with size " + size + " in the sett.");
    // unsuccessful search
    if (size == current.getSize()) // successful search
      return current;
    if (size < current.getSize())
      // recur on the left child (left sub-tree)
      return findHelper(current.getLeftLowerNeighbor(), size);// find the left side
    return findHelper(current.getRightLowerNeighbor(), size);// find the right side
  }

  /**
   * Counts how many Badgers live in this Sett.
   * 
   * @return int The number of Badgers living in this Sett.
   */
  public int countBadger() {
    if (isEmpty()) {// check if the BST is empty
      return 0;
    } else {
      return countHelper(this.topBadger);// recursive call
    }
  }

  /**
   * This recursive helper method is used to help count the number of Badgers in this Sett.
   * 
   * @param current The current Badger that is the root of a (sub) tree that we are counting the
   *        number of Badgers within.
   * @return int the number of Badgers living in the Sett rooted at the current Badger.
   */
  private int countHelper(Badger current) {
    Badger rightBadger = current.getRightLowerNeighbor();// count the left side
    Badger leftBadger = current.getLeftLowerNeighbor();// count the right side
    int badgerCount = 1;
    if (rightBadger != null)
      badgerCount += countHelper(rightBadger);// incremental step
    if (leftBadger != null)
      badgerCount += countHelper(leftBadger);// incremental step
    return badgerCount;
  }

  /**
   * Gets all Badgers living in the Sett as a list in ascending order of their size: smallest one in
   * the front (at index zero), through the largest one at the end (at index size-1).
   * 
   * @return ArrayList<Badger> A list of all Badgers living in the Sett in ascending order by size.
   */
  public java.util.List<Badger> getAllBadgers() {
    List<Badger> badgers = new ArrayList<Badger>();// create a list to return
    getAllHelper(this.topBadger, badgers);// recursive call of getAllHelper
    return badgers;
  }

  /**
   * This recursive helper method is used to help collect the Badgers within this Sett into a List.
   * 
   * @param allBadgers The list of all Badgers living in the Sett that is rooted at the current
   *        Badger node. The contents of this list should be in ascending order by Badger size.
   * @param current The current Badger that is the root of a (sub) tree that we are collecting all
   *        contained Badgers within, into the allBadgers List.
   * 
   * 
   */
  private void getAllHelper(Badger current, java.util.List allBadgers) {
    if (current == null)
      return;
    getAllHelper(current.getLeftLowerNeighbor(), allBadgers);// get Badger from left
    allBadgers.add(current);// add Badger from the BST tree
    getAllHelper(current.getRightLowerNeighbor(), allBadgers);// get Badger from right
  }

  /**
   * Computes the height of the Sett, as the number of nodes from root to the deepest leaf Badger
   * node.
   * 
   * @return The depth of this Sett.
   */
  public int getHeight() {
    if (isEmpty()) {/// check if the BST is empty
      return 0;
    } else {
      return getHeightHelper(topBadger);// recursive call
    }
  }

  /**
   * This recursive helper method is used to help compute the height of this Sett.
   * 
   * @param current The current Badger that is the root of a (sub) tree that we are calculating the
   *        height of.
   * @return int The height of the (sub) tree that we are calculating.
   */
  private int getHeightHelper(Badger current) {
    int left = 0;// number of left nodes
    int right = 0;// number of right nodes
    if (current.getLeftLowerNeighbor() != null)// check the left sides
      left = getHeightHelper(current.getLeftLowerNeighbor());
    if (current.getRightLowerNeighbor() != null)// check the right sides
      right = getHeightHelper(current.getRightLowerNeighbor());
    if (left > right) {// return the larger number
      return left + 1;// if left is larger
    } else {
      return right + 1;// is right is larger
    }
  }

  /**
   * Retrieves the largest Badger living in this Sett.
   * 
   * @return Badger The largest Badger living in this Sett.
   */
  public Badger getLargestBadger() {
    if (isEmpty()) {// check if the BST is empty
      return null;
    } else {
      Badger largestBadger = topBadger;
      // search the only the right nodes
      while (largestBadger.getRightLowerNeighbor() != null) {
        // set the next right node for checking
        largestBadger = largestBadger.getRightLowerNeighbor();
      }
      return largestBadger;
    }
  }

  /**
   * Empties this Sett, to no longer contain any Badgers.
   */
  public void clear() {
    this.topBadger = null;// clear the BST tree
  }

}
