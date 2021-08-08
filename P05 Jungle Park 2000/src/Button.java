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

// This a super class for any Button that can be added to a PApplet application
// This class implements the ParkGUI interface

/**
 * This a super class for any Button that can be added to a PApplet application. This class
 * implements the ParkGUI interface.
 * 
 * @author Mouna Kacem, Yingjie Shen
 */
public class Button implements ParkGUI {
  private static final int WIDTH = 85; // Width of the Button
  private static final int HEIGHT = 32; // Height of the Button
  protected JunglePark processing; // PApplet object where the button will be displayed
  private float[] position; // array storing x and y positions of the Button with respect to
                            // the display window
  protected String label; // text/label that represents the button

  /**
   * Constructor of Button
   * 
   * @param x x-coordinate of the button
   * @param y y-coordinate of the button
   * @param park JunglePark instance
   */
  public Button(float x, float y, JunglePark processing) {
    this.processing = processing;// initialize the processing field
    this.position = new float[2];// initialize the position field
    this.position[0] = x;// initialize the position field with x coordinate
    this.position[1] = y;// initialize the position field with y coordinate
    this.label = "Button";// initialize the label field
  }

  /**
   * This method draws a ParkGUI object (either an animal or a button) to the display window
   */
  @Override
  public void draw() {
    this.processing.stroke(0);// set line value to black
    if (isMouseOver())
      processing.fill(100); // set the fill color to dark gray if the mouse is over the button
    else
      processing.fill(200); // set the fill color to light gray otherwise

    // draw the button (rectangle with a centered text)
    processing.rect(position[0] - WIDTH / 2.0f, position[1] - HEIGHT / 2.0f,
        position[0] + WIDTH / 2.0f, position[1] + HEIGHT / 2.0f);
    processing.fill(0); // set the fill color to black
    processing.text(label, position[0], position[1]); // display the text of the current button
  }

  /**
   * Called each time the mouse is Pressed
   */
  @Override
  public void mousePressed() {
    if (isMouseOver())
      System.out.println("A button was pressed.");
  }

  /**
   * Called each time the mouse is released
   */
  @Override
  public void mouseReleased() {}

  /**
   * This method checks if the mouse is over an object passed to it as input parameter, and false
   * otherwise.
   * 
   * @return if the mouse is over an object
   */
  @Override
  public boolean isMouseOver() {
    if (this.processing.mouseX > this.position[0] - WIDTH / 2// left boundary
        && this.processing.mouseX < this.position[0] + WIDTH / 2// right boundary
        && this.processing.mouseY > this.position[1] - HEIGHT / 2// bottom boundary
        && this.processing.mouseY < this.position[1] + HEIGHT / 2)// top boundary
      return true;// return true if the mouse is over an object
    return false;
  }

}
