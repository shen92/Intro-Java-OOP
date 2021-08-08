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
import java.util.Random;
import java.util.Scanner;

/**
 * This class is the application class for the program
 * 
 * @author Yingjie Shen
 */
public class GameApplication {
  private String[] prompts = new String[] {"Welcome to Math Game!", "Goal: ", "Moves Taken: ",
      "Puzzle: ", "Number and Operation " + GameOperator.ALL_OPERATORS + " to Apply: "};
  // String array for the prompts
  private int stepsCount;// steps the user take
  private boolean win;// check if the user wins
  private int goal;// auto-generated goal
  private Random rand;// random generator
  private Scanner sc;// scanner to get input
  private GameList gameList;// game list of the game
  private String[] opreand;// user's input
  private GameOperator op;// the operators

  private GameApplication() {
    this.sc = new Scanner(System.in);// initialize scanner
    this.rand = new Random();// initialize random
    this.stepsCount = 0;// initialized steps count to 0
    this.win = false;// //initialize win to false
    this.goal = rand.nextInt(90) + 10;// //initialize goal by random generator
    this.gameList = new GameList();
    for (int i = 0; i < 7; i++) {
      this.gameList.addNode(new GameNode(rand));// initialize new game list
    }
    this.opreand = new String[2];// initialize user's input string
    this.op = null;// initialize the operator objects
  }

  /**
   * This method prints the prompts for the application
   * 
   * @param i index of prompts
   */
  private void gamePrompt(int i) {
    System.out.print(prompts[i]);// print the string we need
  }

  /**
   * This method prints the gamelist
   */
  private void showGameList() {
    System.out.print(this.gameList.toString());// print the game list
    System.out.println();// end with a new line
  }

  /**
   * This method gets the user's input and store them to a operand list
   * 
   * @param sc the scanner
   * @return if needs to end the game
   */
  private boolean getInput(Scanner sc) {
    String input = "";
    if (sc.hasNextLine()) {
      input = sc.nextLine();// start input
      if (input.toUpperCase().equals("QUIT")) {// check if user inputs quit
        System.out.println("Thanks for playing!");// goodbye greetings
        return true;// game ends
      } else {
        this.opreand[0] = input.substring(0, (input.length() - 1));// get the numbers from the first
                                                                   // index to last
        this.opreand[1] = input.substring(input.length() - 1);// get the operator
      }
    }
    return false;
  }

  /**
   * This method sets the operator
   * 
   * @param input user's input
   */
  private void setOperator(char input) {
    this.op = GameOperator.getFromChar(input);// set the op with the operator
  }

  /**
   * This method let the user to take a step
   * 
   * @throws NullPointerException
   * @throws NumberFormatException
   * @throws IllegalStateException
   */
  private void takeStep()
      throws NullPointerException, NumberFormatException, IllegalStateException {
    if (gameList.contains(Integer.parseInt(this.opreand[0]))) {// check if the gamelist contains the
                                                               // number
      this.gameList.applyOperatorToNumber(Integer.parseInt(this.opreand[0]), this.op);
      // applies the operator to a game node
      this.gameList.addNode(new GameNode(rand));// add a game node to last
      this.stepsCount++;// incremental the game node
    } else {
      throw new NumberFormatException();// exception occurred
    }
  }

  /**
   * This method checks is the user wins the game
   * 
   * @return if the user wins the game
   */
  private boolean checkEnd() {
    if (this.gameList.contains(this.goal)) {// if the game list contains the goal
      System.out.println("Congratulations, you won in " + this.stepsCount + " moves.");
      // show the greetings
      System.out.print("Soluton: ");
      this.showGameList();// show the solution
      return true;
    }
    return false;
  }

  /**
   * This method shows the menu of the game
   */
  private void menu() {
    while (!this.win) {
      // Line 1 Game Prompts:
      this.gamePrompt(1);
      System.out.print(this.goal + " ");
      this.gamePrompt(2);
      System.out.println(this.stepsCount);
      // Line 2 Game List:
      this.gamePrompt(3);
      this.showGameList();
      // Line 3 User's input:
      this.gamePrompt(4);
      // check input and take steps
      try {
        this.win = this.getInput(sc);
        if (this.win == true) {// check if quit game is needed
          break;
        }
        this.setOperator(this.opreand[1].charAt(0));// set the operator for the step
        this.takeStep();// user takes a step
        System.out.println();
      } catch (IndexOutOfBoundsException e) {
        System.err.println("WARNING: Please enter command!");
      } catch (IllegalStateException e) {
        System.err.println(e.getMessage());
      } catch (NumberFormatException e) {
        System.err.println("WARNING: Number not exist!");
      } catch (NullPointerException e) {
        System.err.println("WARNING: This is the last number!");
      }
      // check end/win
      this.win = this.checkEnd();
    }
  }

  /**
   * This method is the main method of the game
   * 
   * @param args
   */
  public static void main(String[] args) {
    GameApplication game = new GameApplication();// initialize the application
    game.gamePrompt(0);// the welcome greetings
    System.out.println();
    game.menu();// show the game loop
  }
}
