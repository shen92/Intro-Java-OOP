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
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is the driver of the application
 */
public class AsciiArt {
  public static Canvas canvas;// The canvas Object

  /**
   * This is the main method of the application
   * 
   * @param args
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);// the Scanner object
    boolean over = false;// the boolean of the driver
    while (!over) {
      // the prompt for the UI
      System.out.println("======== MENU ========");
      System.out.println("[1] Create a new canvas");
      System.out.println("[2] Draw a character");
      System.out.println("[3] Undo drawing");
      System.out.println("[4] Redo drawing");
      System.out.println("[5] Show current canvas");
      System.out.println("[6] Exit");
      // Collect the data
      System.out.print("> ");// prompt of input
      String command = sc.next().trim();
      if (command.equals("1")) {// Create a new canvas
        try {
          System.out.print("Width > ");// prompt for user
          int width = sc.nextInt();// get the width of the canvas
          System.out.print("Height > ");// prompt for user
          int height = sc.nextInt();// get the height of the canvas
          newCanvas(width, height);// create a new canvas
        } catch (InputMismatchException e) {
          System.out.println("WARNING: Please Input the Correct Command!");// handle the exception
        }
      } else if (command.equals("2")) {// Draw a character
        try {
          System.out.print("Row > ");// prompt for user
          int row = sc.nextInt();// get the row of the char
          System.out.print("Col > ");// prompt for user
          int col = sc.nextInt();// get the col of the char
          System.out.print("Character > ");// prompt for user
          char newChar = sc.next().trim().charAt(0);// get the user's char of input
          try {
            drawCharacter(row, col, newChar);// draw the char on the canvas
          } catch (NullPointerException e) {// handle the exception
            System.out.println("WARNING: Draw Failed, Please Create a New Canvas!");
          } catch (IllegalArgumentException e) {// handle the exception
            System.out.println("WARNING: Please Input the Coordinates In the Canvas!");
          }
        } catch (InputMismatchException e) {// handle the exception
          System.out.println("WARNING: Please Input the Correct Command!");
        }
      } else if (command.equals("3")) {// Undo drawing
        try {
          if (canvas.undo()) {// if undo successful
            System.out.println("Undo Successfully!");
          } else {
            System.out.println("Undo Failed!");
          }
        } catch (NullPointerException e) {// handle the exception
          System.out.println("WARNING: Undo Failed, Please Create a New Canvas!");
        }
      } else if (command.equals("4")) {// Redo drawing
        try {
          if (canvas.redo()) {// if redo successful
            System.out.println("Redo Successfully!");
          } else {
            System.out.println("Redo Failed!");
          }
        } catch (NullPointerException e) {// handle the exception
          System.out.println("WARNING: Undo Failed, Please Create a New Canvas!");
        }
      } else if (command.equals("5")) {// Show current canvas
        try {
          System.out.print(canvas.toString());// print the canvas
        } catch (NullPointerException e) {// handle the exception
          System.out.println("WARNING: Show Canvas Failed, Please Create a New Canvas!");
        }
      } else if (command.equals("6")) {// Exit
        System.out.println("Bye!");
        over = true;// terminate the loop
        sc.close();
      } else {// handle the exception
        System.out.println("Warning: Please input a number between 1 and 6!");
      }
    }
  }

  /**
   * This method creates a new canvas
   * 
   * @param width of the canvas
   * @param heigth of the canvas
   */
  public static void newCanvas(int width, int height) {
    canvas = new Canvas(width, height);// create a new canvas
  }

  /**
   * This method draws a new character
   * 
   * @param row of the char
   * @param col of the col
   * @param c of the char
   */
  public static void drawCharacter(int row, int col, char c) {
    canvas.draw(row, col, c);// draw a new character
  }
}
