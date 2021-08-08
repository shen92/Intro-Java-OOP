//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: ASCII Art
// Files: AsciiArt.java, AsciiTest.java,
// Canvas.java, DrawingChange.java, DrawingStack.java,
// DrawingStackIterator.java, Node.java, StackADT.java
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
 * This class is the DrawingChange object
 * 
 * @author Yingjie Shen
 */
public class DrawingChange {

  public final int x; // x coordinate for a change
  public final int y; // y coordinate for a change
  public final char prevChar; // previous character in the (x,y)
  public final char newChar; // new character in the (x,y)

  /**
   * The constructor of the Drawing Change Class
   * 
   * @param x coordinate for a change
   * @param y coordinate for a change
   * @param prevChar previous character in the (x,y)
   * @param newChar new character in the (x,y)
   * 
   */
  public DrawingChange(int x, int y, char prevChar, char newChar) {
    this.x = x;// initialize the x field
    this.y = y;// initialize the y field
    this.prevChar = prevChar;// initialize the prevChar field
    this.newChar = newChar;// initialize the newChar field
  }
}
