//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Access Control
// Files: AccessControlTest.java
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
public class AccessControlTest {

  /**
   * This test tries to log in a user that doesn't exist
   * 
   * @param boolean test passed
   */
  public static boolean testLogin1() {
    AccessControl ac = new AccessControl(); // It doesn't look like we use ac, but we need users
                                            // initialized
    String user = "probablyNotInTheSystem1234";
    String pw = "password";
    return !AccessControl.isValidLogin(user, pw); // isValidLogin should return false
  }

  /**
   * This test tries to log in a user that doesn't exist
   * 
   * @param return boolean test passed
   */
  public static boolean testLogin2() {
    AccessControl ac = new AccessControl(); // It doesn't look like we use ac, but we need users
                                            // initialized
    String user = "admin";
    String pw = "root";
    return !AccessControl.isValidLogin(user, pw); // isValidLogin should return false
  }

  /**
   * This test tries to log in a user that doesn't exist
   * 
   * @return boolean test passed
   */
  public static boolean testLogin3() {
    AccessControl ac = new AccessControl();
    String user = "probablyNotInTheSystem1234";
    String pw = "password";
    return !AccessControl.isValidLogin(user, pw);
  }// isValidLogin should return false


  /**
   * Create a new AccessControl and do not log in an admin. Verify that addUser(String username)
   * returns false and that the new user is not added.
   * 
   * @return boolean test passed
   */
  public static boolean testAddUser1() {
    AccessControl ac = new AccessControl();
    String user = "alexi";
    boolean addUserReport = ac.addUser(user, true);
    if (addUserReport)
      return false; // addUserReport should be false
    // Make sure user wasn't added anyway
    return !AccessControl.isValidLogin(user, "changeme");
  }



  /**
   * Testing main. Runs each test and prints which (if any) failed.
   */
  public static void main(String[] args) {
    int fails = 0;
    if (!testLogin1()) {
      System.out.println("testLogin1 [bad username] failed");
      fails++;
    }
    if (!testAddUser1()) {
      System.out.println("testAddUser2 [good login] failed");
      fails++;
    }
    if (!testAddUser1()) {
      System.out.println("testLogin1 [bad username with default password] failed");
      fails++;
    }
    if (fails == 0)
      System.out.println("All tests passed!");
  }

}
