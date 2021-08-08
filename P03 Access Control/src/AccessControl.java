//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Access Control
// Files: AccessControl.java
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
import java.util.ArrayList;
import java.util.Scanner;

public class AccessControl {

  private static ArrayList<User> users; // An ArrayList of valid users.
  private User currentUser; // Who is currently logged in, if anyone?
  private static final String DEFAULT_PASSWORD = "changeme";


  /**
   * 
   * constructor of the access control. Default password given to new users or when we reset a
   * user's password.
   */
  public AccessControl() {// A no-parameter constructor
    currentUser = null;
    users = new ArrayList<User>();// initialize a users array
    users.add(new User("admin", "root", true));
  }

  /**
   * 
   * Report whether a given username/password pair is a valid login
   * 
   * @param username user's login username
   * @param password user's login password
   * 
   * @return is a valid login
   *
   */
  public static boolean isValidLogin(String username, String password) {
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {// check if the user exists
        if (users.get(i).isValidLogin(password)) {// check if the password is correct
          return true;
        } else {
          System.out.println("WARNING: Wrong password!");// System prompt
        }
      }
    }
    System.out.println("WARNING: User not found!");// System prompt
    return false;
  }

  /**
   * 
   * This method Change the current user's password
   * 
   * @param newPassword new passward to set
   */
  public void changePassword(String newPassword) {
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(currentUser.getUsername())) {// check if the user exists
        // Change the current user's password
        users.get(i).setPassword(newPassword);
        // reset the password
        System.out.println("Password change successfully!");// System prompt
      }
    }
  }

  /**
   * This method Log out the current user
   */

  public void logout() {
    if (currentUser != null) {
      // Log out the current user
      currentUser = null;
      System.out.println("User log out successfully!");// System prompt
    }
  }

  /**
   * 
   * This method sets the current user A mutator you can use to write tests without simulating user
   * input
   * 
   * @param username user's login username
   * 
   */
  public void setCurrentUser(String username) {
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {// check if the user exists
        currentUser = users.get(i);// set the current user
      }
    }
  }

  /**
   * 
   * Create a new user // With the default password and isAdmin==false
   * 
   * @param username user's login username
   * 
   * @return is a user added
   * 
   */
  public boolean addUser(String username) {
    if (currentUser != null && currentUser.getIsAdmin()) {
      for (int i = 0; i < users.size(); i++) {
        if (users.get(i).getUsername().equals(username)) {// check if the user exists
          System.out.println("WARNING: User already existed!");// System prompt
          return false;
        }
      }
      if (users.add(new User(username, DEFAULT_PASSWORD, false))) {// add a new user
        System.out.println("New user added successfully!");// System prompt
      }
      return true;
    }
    return false;
  }

  /**
   * 
   * Create a new user and specify their admin status
   * 
   * @param username user's login username
   * @param password user's login password
   * @param isAdmin user's admin status
   * 
   * @return is a user added
   * 
   */
  public boolean addUser(String username, boolean isAdmin) {
    if (currentUser != null && currentUser.getIsAdmin()) {// check if the user is admin
      for (int i = 0; i < users.size(); i++) {
        if (users.get(i).getUsername().equals(username)) {// check if the user exists
          System.out.println("WARNING: User already existed!");// System prompt
          return false;
        }
      }
      if (isAdmin) {
        if (users.add(new User(username, DEFAULT_PASSWORD, true))) {// add a new admin
          System.out.println("New admin added successfully!");// System prompt
          return true;
        }
      } else {
        if (users.add(new User(username, DEFAULT_PASSWORD, false))) {// add a new user
          System.out.println("New user added successfully!");// System prompt
          return false;
        }
      }
    }
    return false;
  }

  /**
   * 
   * This method remove a user (names should be unique)
   * 
   * @param username user's login username
   * 
   * @return is a user removed
   */
  public boolean removeUser(String username) {
    if (currentUser != null && currentUser.getIsAdmin()) {// check if the user is admin
      for (int i = 0; i < users.size(); i++) {
        if (users.get(i).getUsername().equals(username)) {// check if the user exists
          users.remove(i);
          System.out.println("User: " + username + " removed successfully!");// System prompt
          return true;
        }
      }
      System.out.println("WARNING: User not found!");// System prompt
      return false;
    }
    System.out.println("WARNING: Admin required!");// System prompt
    return false;
  }


  /**
   * 
   * This method gives a user admin power
   * 
   * @param username user's login username
   * 
   * @return is a user given admin
   */
  public boolean giveAdmin(String username) {
    if (currentUser != null && currentUser.getIsAdmin()) {// check if the user is admin
      for (int i = 0; i < users.size(); i++) {
        if (users.get(i).getUsername().equals(username)) {// check if the user exists
          // Give a user admin power
          users.get(i).setIsAdmin(true);
          // set a admin
          System.out.println("User: " + username + "'s admin added successfully!");// System prompt
          return true;
        }
      }
      System.out.println("WARNING: User not found!");// System prompt
      return false;
    }
    System.out.println("WARNING: Admin required!");// System prompt
    return false;
  }

  /**
   * 
   * This method removes a user admin power
   * 
   * @param username user's login username
   * 
   * @return is admin's admin returned
   */
  public boolean takeAdmin(String username) {
    if (currentUser != null && currentUser.getIsAdmin()) {// check if the user is admin
      for (int i = 0; i < users.size(); i++) {
        if (users.get(i).getUsername().equals(username)) {// check if the user exists
          // Remove a user's admin power
          users.get(i).setIsAdmin(false);
          // remove a admin
          System.out.println("User: " + username + "'s admin removed successfully!");
          // System prompt
          return true;
        }
      }
      System.out.println("WARNING: User not found!");// System prompt
      return false;
    }
    System.out.println("WARNING: Admin required!");// System prompt
    return false;
  }

  /**
   * 
   * This method resets a user's password
   * 
   * @param username user's login username
   * 
   * @return is password reset
   */
  public boolean resetPassword(String username) {
    if (currentUser != null && currentUser.getIsAdmin()) {// check if the user is admin
      for (int i = 0; i < users.size(); i++) {
        if (users.get(i).getUsername().equals(username)) {// check if the user exists
          users.get(i).setPassword(DEFAULT_PASSWORD);
          // set one's password to default
          System.out.println("User: " + username + "'s password reset successfully!");
          // System prompt
          return true;
        }
      }
      System.out.println("WARNING: User not found!");// System prompt
      return false;
    }
    System.out.println("WARNING: Admin required!");// System prompt
    return false;
  } // Reset a user's password


  /**
   * Main driver loop. Prompt the user for login information calls the isValidLogin method If the
   * login is valid, call the sessionScreen method
   * 
   * @param uerInputScanner scanner to collect user input
   * 
   *
   **/
  public void loginScreen(Scanner userInputScanner) {
    boolean run = true;
    while (run) {
      System.out.println("============Access Control==============");
      System.out.print("Username: ");// get user's username
      String username = userInputScanner.nextLine().trim();
      System.out.print("Password: ");// get user's password
      String password = userInputScanner.nextLine().trim();
      if (isValidLogin(username, password)) {
        sessionScreen(username, userInputScanner);
      } else {
        System.out.println("WARNING: Login failed! ");
      }
    }

  }

  /**
   * Set the currentUser Allows them to changePassword or logout If they are an admin, gives access
   * to admin methods
   * 
   * @param uerInputScanner scanner to collect user input
   * @param username user's login username
   **/
  public void sessionScreen(String username, Scanner userInputScanner) {
    setCurrentUser(username);
    boolean run = true;
    while (run) {
      System.out.println("=============Session Menu===============");
      System.out.println("logout");
      System.out.println("newpw [newpassword]");
      System.out.println("adduser [username]");
      System.out.println("adduser [username] [true or false]");
      System.out.println("rmuser [username]");
      System.out.println("giveadmin [username]");
      System.out.println("rmadmin [username]");
      System.out.println("resetpw [username]");
      System.out.print("Command: ");
      String[] command = userInputScanner.nextLine().split(" ");
      if (command[0].toUpperCase().equals("LOGOUT")) {
        logout();
        break;
      } else if (command[0].toUpperCase().equals("NEWPW") && command[1] != null) {
        changePassword(command[1]);
      } else if (command[0].toUpperCase().equals("ADDUSER") && command[1] != null) {
        addUser(command[1]);
        System.out.println("Total users: " + users.size());
      } else if (command[0].toUpperCase().equals("ADDUSER") && command[1] != null
          && command[2].trim().toUpperCase().equals("TRUE")) {
        addUser(command[1], true);
        System.out.println("Total users: " + users.size());
      } else if (command[0].toUpperCase().equals("RMUSER") && command[1] != null) {
        removeUser(command[1]);
        System.out.println("Total users: " + users.size());
      } else if (command[0].toUpperCase().equals("GIVEADMIN") && command[1] != null) {
        giveAdmin(command[1]);
      } else if (command[0].toUpperCase().equals("RMADMIN") && command[1] != null) {
        takeAdmin(command[1]);
      } else if (command[0].toUpperCase().equals("RESETPW") && command[1] != null) {
        resetPassword(command[1]);
      } else {
        System.out.println("WARNING: Please enter correct command!");
      }
    }
    System.out.println("========Current Session Ended===========");
    System.out.println();
  }



  // Set the currentUser
  // Allows them to changePassword or logout
  // If they are an admin, gives access to admin methods

  /**
   * 
   * 
   * Launch an AccessControl instance
   */
  public static void main(String[] args) {
    AccessControl ac = new AccessControl();
    // If we have any persistent information to lead
    // this is where we load it.
    Scanner userIn = new Scanner(System.in);
    ac.loginScreen(userIn);
    // load out the interface of the program
  }

}
