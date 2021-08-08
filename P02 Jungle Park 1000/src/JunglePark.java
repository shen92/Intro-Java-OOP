
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Jungle Park 1000
// Files: JunglePark.java
// Course: CS 300 Fall 2018 002
//
// Author: Yingjie Shen
// Email: shen92@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
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

public class JunglePark {

  private static PApplet processing; // PApplet object that represents the graphic
                                     // interface of the JunglePark application
  private static PImage backgroundImage; // PImage object that represents the
                                         // background image
  private static Tiger[] tigers; // array storing the current tigers present
                                 // in the Jungle Park

  private static Random randGen; // Generator of random numbers

  /**
   * Defines the initial environment properties of the application
   * 
   * @param processingObj represents a reference to the graphical interface of the application
   */
  public static void setup(PApplet processingObj) {
    randGen = new Random(); // create a Random object and store its reference in randGen
    processing = processingObj; // initialize the processing field to the one passed into the input
                                // argument parameter
    // Set the color used for the background of the Processing window width [resp.
    // height]: System
    // variable of the processing library that stores the width [resp. height] of
    // the display
    // window.
    processing.background(245, 255, 250); // Mint cream color
    // initialize and load the image of the background
    backgroundImage = processing.loadImage("images/background.png");
    // Draw the background image at the center of the screen
    processing.image(backgroundImage, processing.width / 2, processing.height / 2);
    tigers = new Tiger[8];
    tigers[0] = new Tiger(processing, (float) randGen.nextInt(processing.width),
        (float) randGen.nextInt(processing.height));
    for (int i = 0; i < tigers.length; i++) {
      if (tigers[i] != null) {
        tigers[i].draw();
      }
    }
  }

  /**
   * Updates and draw the tigers of the application
   * 
   */
  public static void update() {
    processing.background(245, 255, 250); // Mint cream color
    // initialize and load the image of the background
    backgroundImage = processing.loadImage("images/background.png");
    // Draw the background image at the center of the screen
    processing.image(backgroundImage, processing.width / 2, processing.height / 2);
    processing.image(backgroundImage, processing.width / 2, processing.height / 2);
    for (int i = 0; i < tigers.length; i++) {
      if (tigers[i] != null) {
        tigers[i].draw();
      }
    }
  }

  /*
   * This method return true if the mouse is over the image of the Tiger object passed to it as
   * input parameter, and false otherwise.
   * 
   * @param tiger The tiger object that the mouse is over it
   */
  public static boolean isMouseOver(Tiger tiger) {
    if ((processing.mouseX >= tiger.getPositionX() - (tiger.getImage().width) / 2)
        && (processing.mouseX <= tiger.getPositionX() + (tiger.getImage().width) / 2)
        && (processing.mouseY >= tiger.getPositionY() - (tiger.getImage().height) / 2)
        && (processing.mouseY <= tiger.getPositionY() + (tiger.getImage().height) / 2)) {
      return true;

    }
    return false;
  }

  /*
   * This method checks if the mouse is over one of the tiger objects stored in the tigers array and
   * sets the isDragging field defined this tiger object if any to true.
   */
  public static void mouseDown() {
    for (int i = 0; i < tigers.length; i++) {
      if (tigers[i] != null) {
        if (isMouseOver(tigers[i]) == true) {
          tigers[i].setDragging(true);
          break;
        } else {
          tigers[i].setDragging(false);
        }
      }
    }
  }

  /*
   * This method sets isDragging field of every tiger object stored in the tigers array to false. No
   * tiger is being dragged when the mouse is released.
   */
  public static void mouseUp() {
    for (int i = 0; i < tigers.length; i++) {
      if (tigers[i] != null) {
        tigers[i].setDragging(false);
      }
    }
  }

  /*
   * This method adds tigers to the jungle park by pressing T key and removes tigers from the jungle
   * park by pressing r key
   */
  public static void keyPressed() {
    randGen = new Random();
    if (processing.key == 't' || processing.key == 'T') {
      for (int i = 0; i < tigers.length; i++) {
        if (tigers[i] == null) {
          tigers[i] = new Tiger(processing, (float) randGen.nextInt(processing.width),
              (float) randGen.nextInt(processing.height));
          break;
        }
      }
    } else if (processing.key == 'r' || processing.key == 'R') {
      for (int i = 0; i < tigers.length; i++) {
        if (tigers[i] != null) {
          tigers[i] = null;
          break;
        }
      }
    }
  }

  /* This is the main of the program, which starts the program */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Utility.startApplication();
  }
}
