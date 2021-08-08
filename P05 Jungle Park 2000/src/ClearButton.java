//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Jungle Park 2000
// Files: AddAnimalButton.java, Animal.java, Button.java, ClearButton.java, Deer.java,
// JunglePark.java, JungleParkTests.java, ParkGUI.java, Tiger.java
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
 * This class removes animals in the Jungle Park application. It extends the Button class and
 * implements the interface ParkGUI.
 * 
 * @author Yingjie Shen
 */
public class ClearButton extends Button implements ParkGUI {

  /**
   * Constructor of AddAnimalButton
   * 
   * @param x x-coordinate of the button
   * @param y y-coordinate of the button
   * @param park JunglePark instance
   */
  public ClearButton(float x, float y, JunglePark park) {
    super(x, y, park);// initialize with super constructor
    this.label = "Clear Park ";// initialize the label field
  }

  /**
   * Called each time the mouse is Pressed
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      for (int i = processing.listGUI.size() - 1; i >= 0; i--) {
        if (processing.listGUI.get(i) instanceof Animal) {// check if it is animal instance
          processing.listGUI.remove(i); // remove the last animal instance in the jungle park
        }
      }
    }
  }

}
