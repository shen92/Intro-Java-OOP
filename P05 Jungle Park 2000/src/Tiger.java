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
 * This class represents a Deer in the JunglePark application. This class extends the Animal class
 * 
 * @author Yingjie Shen
 *
 */
public class Tiger extends Animal {
  private static final int SCAN_RANGE = 100; // range dimension for scanning the neighborhood for
                                             // food
  private static final String IMAGE_FILE_NAME = "images/tiger.png";
  private static int nextID = 1; // class variable that represents the identifier of the next tiger
                                 // to be created
  // Tiger's identification fields
  private static final String TYPE = "TGR"; // A String that represents the tiger type
  private final int id; // Tiger's id: positive number that represents the order of the tiger
  private int deerEatenCount; // Number of Deers that the current tiger has eaten so far


  /**
   * Creates a new Tiger object positioned at a random position of the display window
   * 
   * @param processing PApplet object that represents the display window
   */
  public Tiger(JunglePark processing) {
    // Set Tiger drawing parameters
    super(processing, IMAGE_FILE_NAME);

    // Set Tiger identification fields
    id = nextID;
    this.label = TYPE + id; // String that identifies the current tiger
    this.deerEatenCount = 0;
    nextID++;
  }

  /**
   * To hop on the food Deer, the tiger moves forward the position of food, and eats it
   * 
   * @param food the deers nerby
   */
  public void hop(Deer food) {
    if (this.isClose(food, SCAN_RANGE)) {
      this.setPositionX(food.getPositionX());// get deer's x-coordinate for tiger
      this.setPositionY(food.getPositionY());// get deer's y-coordinate for tiger
      for (int i = 0; i < processing.listGUI.size(); i++) {
        if (processing.listGUI.get(i).equals(food)) {
          processing.listGUI.remove(i);// tiger eats deer
        }
      }
      this.deerEatenCount++;// update how many deers the tiger
    }
  }

  /**
   * Defines the Tiger's behavior in the Jungle Park
   * 
   */
  @Override
  public void action() {
    // scan for food (aka deer) and hop on it if any.
    for (int i = 0; i < processing.listGUI.size(); i++) {
      if (processing.listGUI.get(i) instanceof Deer) {
        this.hop((Deer) processing.listGUI.get(i));
      }
    }
    if (deerEatenCount > 0)
      displayDeerEatenCount(); // display deerEatenCount
  }


  /**
   * Displays the number of eaten deers if any on the top of the tiger image
   */
  public void displayDeerEatenCount() {
    this.processing.fill(0); // specify font color: black
    // display deerEatenCount on the top of the Tiger's image
    this.processing.text(deerEatenCount, this.getPositionX(),
        this.getPositionY() - this.image.height / 2 - 4);
  }

  /**
   * getter that gets deerEatenCount of a tiger
   */
  public int getDeerEatenCount() {
    return this.deerEatenCount;
  }

}
