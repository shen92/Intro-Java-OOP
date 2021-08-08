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
import java.util.Arrays;
import java.util.Iterator;

/**
 * This class is the canvas of the ASCII Arts
 * 
 * @author Yingjie Shen
 */
public class Canvas {
  private final int width; // width of the canvas
  private final int height; // height of the canvas

  private char[][] drawingArray; // 2D character array to store the drawing

  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo

  /**
   * Constructor. Throws IllegalArgumentException if width or height is 0 or negative A Canvas is
   * initially blank (use the space ' ' character)
   * 
   * @param width of the canvas
   * @param height of the canvas
   * @throws IllegalArgumentException if width or height is 0 or negative A Canvas is initially
   *         blank (use the space ' ' character)
   * 
   */
  public Canvas(int width, int height) throws IllegalArgumentException {
    if (width <= 0 || height <= 0) {// check the input
      throw new IllegalArgumentException();
    }
    this.width = width;// initialize the width field
    this.height = height;// initialize the height field
    this.drawingArray = new char[height][width];// initialize the drawArary field
    for (int i = 0; i < drawingArray.length; i++) {// initialize the "canvas"
      for (int j = 0; j < drawingArray[0].length; j++) {
        this.drawingArray[i][j] = ' ';// update the canvas
      }
    }
    this.undoStack = new DrawingStack();// initialize the undoStack field
    this.redoStack = new DrawingStack();// initialize the redoStack field
  }

  /**
   * This method should throw an IllegalArgumentException if the drawing position is outside the
   * canvas If that position is already marked with a different character, overwrite it. After
   * making a new change, add a matching DrawingChange to the undoStack so that we can undo if
   * needed. After making a new change, the redoStack should be empty.
   * 
   * @param row position of the char
   * @param col position of the char
   * @param char the char to draw
   * @throws IllegalArgumentException if the drawing position is outside the canvas
   */
  public void draw(int row, int col, char c) throws IllegalArgumentException {
    if (row >= this.width || col >= this.height || row < 0 || col < 0) {// check the input
      throw new IllegalArgumentException();
    }
    char oldChar = this.drawingArray[row][col];// get the previous char at the input position
    char newChar = c;// get the previous char at the input position
    this.drawingArray[row][col] = c;// Draw a character at the given position
    this.undoStack.push(new DrawingChange(col, row, oldChar, newChar));
    if (!this.redoStack.isEmpty()) {
      redoStack.pop();// empty the redoStack
    }
  }

  /**
   * Undo the most recent drawing change. Return true if successful. False otherwise. An undone
   * DrawingChange should be added to the redoStack so that we can redo if needed.
   */
  public boolean undo() {
    if (this.undoStack.peek() != null) {// check the top of the undostack
      DrawingChange undo = undoStack.pop();// pop the top of undostack
      this.redoStack
          .push(new DrawingChange(undo.y, undo.x, drawingArray[undo.y][undo.x], undo.prevChar));
      // add the redo drawingChange to the redoStack
      this.drawingArray[undo.y][undo.x] = undo.prevChar;
      return true;// undo successful
    }
    return false;// undo failed
  }

  /**
   * Redo the most recent undone drawing change. Return true if successful. False otherwise. A
   * redone DrawingChange should be added (back) to the undoStack so that we can undo again if
   * needed.
   */
  public boolean redo() {
    if (this.redoStack.peek() != null) {// check the top of the redostack
      DrawingChange redo = redoStack.pop();// pop the top of redostack
      this.undoStack
          .push(new DrawingChange(redo.x, redo.x, drawingArray[redo.y][redo.x], redo.prevChar));
      // add the undo drawingChange to the redoStack
      this.drawingArray[redo.y][redo.x] = redo.prevChar;
      return true;// redo successful
    }
    return false;// redo failed
  }

  /**
   * Return a printable string version of the Canvas.
   * 
   * @return String of the canvas
   */
  public String toString() {
    String separator = System.lineSeparator();// create a String separator
    StringBuilder builder = new StringBuilder();// create a new string builder
    for (char[] row : drawingArray) {
      builder.append(Arrays.toString(row).replace(",", "").replace("[", "").replace("]", ""))
          .append(separator);// build the string from the canvas
    }
    String string = builder.toString();// create a new string
    return string;
  }

}
