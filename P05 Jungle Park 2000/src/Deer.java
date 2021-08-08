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
 * This class represents a Tiger in the JunglePark application. This class extends the Animal class
 * 
 * @author Yingjie Shen
 *
 */
public class Deer extends Animal {


  private static final int SCAN_RANGE = 175; // scan range area to check for a threat in the
                                             // neighborhood
  private static final String IMAGE_FILE_NAME = "images/deer.png";
  private static int nextID = 1; // class variable that represents the identifier of the next deer
                                 // to be created

  private static final String TYPE = "DR"; // A String that represents the deer type
  private final int id; // Deer's id: positive number that represents the order of the deer


  /**
   * Constructor that creates a new Deer object positioned at a random position of the display
   * window
   * 
   * @param processing the JunglePark instance
   */
  public Deer(JunglePark processing) {// Set Tiger drawing parameters
    super(processing, IMAGE_FILE_NAME);

    // Set Tiger identification fields
    id = nextID;
    this.label = TYPE + id; // String that identifies the current tiger
    nextID++;
  }

  /**
   * Checks if there is a threat (a Tiger for instance) at the neighborhood scanRange is an integer
   * that represents the range of the area to be scanned around the animal
   * 
   * @param scanRange range to scan
   * @return if the tiger is nearby
   */
  public boolean scanForThreat(int scanRange) {
    for (int i = 0; i < processing.listGUI.size(); i++) {// check for threat
      if (processing.listGUI.get(i) instanceof Tiger) {
        if (this.isClose((Animal) processing.listGUI.get(i), scanRange)) {
          // scans if the tiger is nearby
          return true;
        }
      }
    }
    return false;
  }


  /**
   * Defines the behavior of a Deer object in the Jungle park
   */
  @Override
  public void action() {
    if (this.scanForThreat(SCAN_RANGE)) {// if threat is nearby, implement the deer's action
      this.processing.fill(0); // specify font color: black
      this.processing.text("THREAT!", this.getPositionX(), // show threat text
          this.getPositionY() - this.image.height / 2 - 4);
    }
  }

}
