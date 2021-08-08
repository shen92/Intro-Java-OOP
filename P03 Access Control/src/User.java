//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Access Control
// Files: User.java
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
public class User {
  private final String USERNAME; // The user's name
  private String password; // The user's password
  private boolean isAdmin; // Whether or not the user has Admin powers

  /**
   * This constructor initialize user object with username, password and admin status
   * 
   * @param username The user's name
   * @param passeword The user's password
   * @param isAdmin Whether or not the user has Admin powers
   * 
   */
  public User(String username, String password, boolean isAdmin) {
    // Creates a new user with the given password and admin status
    this.USERNAME = username;
    this.password = password;
    this.isAdmin = isAdmin;
  }

  /**
   * This method report whether the password is correct
   * 
   * @param password a user's password
   * 
   * @return if the user is valid login
   */
  public boolean isValidLogin(String password) {
    if (this.password.equals(password)) {// Report whether the password is correct
      return true;
    } else {
      return false;
    }
  }

  /**
   * This method gets the user's name
   */
  public String getUsername() {
    return this.USERNAME;// Return the user's name
  }

  /**
   * This method gets the user's admin status
   */
  public boolean getIsAdmin() {
    return this.isAdmin;// Report whether the user is an admin
  }

  /**
   * This method sets the user's password
   * 
   * @param password a user's password
   */
  public void setPassword(String password) {
    this.password = password;// Set the new password
  }

  /**
   * This method sets the user's admin status
   * 
   * @param isAdmin a user's admin status
   */
  public void setIsAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;// Set the new admin status
  }

}
