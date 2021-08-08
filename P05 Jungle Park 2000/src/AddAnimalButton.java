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
 * This class adds animals in the Jungle Park application. It extends the Button class and
 * implements the interface ParkGUI
 * 
 * @author Yingjie Shen
 */
public class AddAnimalButton extends Button implements ParkGUI {

  private String type; // type of the animal to add

  /**
   * Constructor of AddAnimalButton
   * 
   * @param type button type
   * @param x x-coordinate of the button
   * @param y y-coordinate of the button
   * @param park JunglePark instance
   */
  public AddAnimalButton(String type, float x, float y, JunglePark park) {
    super(x, y, park);// initialize with super constructor
    this.type = type.toLowerCase();// initialize the type field
    this.label = "Add " + type;// initialize the label field
  }

  /**
   * Called each time the mouse is Pressed
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {// check if mouse is pressed
      switch (type) {
        case "tiger":
          // create a new Tiger and add it to the JunglePark
          processing.listGUI.add(new Tiger(processing));
          break;
        case "deer":
          // create a new Deer and add it to the JunglePark
          processing.listGUI.add(new Deer(processing));
          break;
      }
    }
  }
}
