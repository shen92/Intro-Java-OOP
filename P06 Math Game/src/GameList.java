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
/**
 * This class is for the game list object
 * 
 * @author Yingjie Shen
 */
public class GameList {
  private GameNode list; // reference to the first GameNode in this list

  /**
   * This method initialize the game list
   */
  public GameList() {
    this.list = null; // initializes list to start out empty
  }

  /**
   * This method adds a node to a game list
   * 
   * @param newNode new node to add
   */
  public void addNode(GameNode newNode) {
    if (this.list == null) {// set the first GameNode
      this.list = newNode;
    } else {
      GameNode last = this.list; // set the current GameNode
      while (last.getNext() != null) {// looking for the last GameNode
        last = last.getNext();// update until the last GameNode
      }
      last.setNext(newNode);// add the new GameNode to the last GameNode
    }
  }

  /**
   * This method check if the game list contains a specific number
   * 
   * @param number the number to check
   * @returns if the game list contains the number
   */
  public boolean contains(int number) {
    GameNode check = this.list;// set the first GameNode
    while (check != null) {// check until the last GameNode
      if (check.getNumber() == number) {
        return true;// only returns true when this list contains a node with the specified number
      }
      check = check.getNext();// Incremental for next node
    }
    return false;
  }

  /**
   * This method prints the linked list to a formatted string
   * 
   * @return the formatted string of the game list
   */
  public String toString() {
    String output = "";// the output string
    GameNode display = this.list;// set the first GameNode
    while (display != null) {// check until the last GameNode
      output += display.getNumber() + " -> ";// update the output String
      display = display.getNext();// set the next GameNode to display
    }
    return output + "END";// returns a string with each number in the list separated by " -> "s,
                          // and ending with " -> END"
  }

  /**
   * This method applies an operator to a node in a gamelist
   * 
   * @param number to operator
   * @param operator the operator to conduct
   * @throws NullPointerException
   */
  public void applyOperatorToNumber(int number, GameOperator operator) throws NullPointerException {
    GameNode op = this.list;// set the first GameNode
    while (op != null) {// check until the last GameNode
      if (op.getNumber() == number) {
        op.applyOperator(operator);// do operation to the number
        break;
      }
      op = op.getNext();// get the next GameNode to operate
    }
  }
}
