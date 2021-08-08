import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.zip.DataFormatException;

//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Exceptional Banking
// Files: ExceptionalBanking.java
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
public class ExceptionalBankingTests {
  /**
   * This method tests how and if the method getCurrentBalance works
   * 
   * @return if getCurrentBalance works
   */
  public static boolean testAccountBalance() {
    Account MyAccount = new Account("MyAccount");
    String[] transactions = new String[] {"1 10 -20 30 -20 -20",
        // +2 overdrafts (ending balance: -20)
        "0 1 1 1 0 0 1 1 1 1", // +2 overdrafts (ending balance: -15)
        "1 115", // +0 overdrafts (ending balance: +100)
        "2 3 1 0 1" // +1 overdrafts (ending balance: -100)
    };
    try {// this tries if a transaction group can be added
      for (int i = 0; i < transactions.length; i++) {
        MyAccount.addTransactionGroup(transactions[i]);
      }
    } catch (DataFormatException e) {
      System.out.println("DataFormatException occured " + e.getMessage());
    }
    if (MyAccount.getCurrentBalance() == 0) {// test if getCurrentBalance works
      return true;
    } else {
      System.out.println("FAILURE: getCurrentBalance did not return -100 ");
    }
    return false;
  }

  /**
   * This method tests how and if the method getNumberOfOverdrafts works
   * 
   * @return if getNumberOfOverdrafts works
   */
  public static boolean testOverdraftCount() {
    Account MyAccount = new Account("MyAccount");
    String[] transactions = new String[] {"1 10 -20 30 -20 -20",
        // +2 overdrafts (ending balance: -20)
        "0 1 1 1 0 0 1 1 1 1", // +2 overdrafts (ending balance: -15)
        "1 115", // +0 overdrafts (ending balance: +100)
        "2 3 1 0 1" // +1 overdrafts (ending balance: -100)
    };
    try {// this tries if a transaction group can be added
      for (int i = 0; i < transactions.length; i++) {
        MyAccount.addTransactionGroup(transactions[i]);
      }
    } catch (DataFormatException e) {
      System.out.println("DataFormatException occured " + e.getMessage());
    }
    if (MyAccount.getNumberOfOverdrafts() == 0) {// test if getNumberOfOverdraft works
      return true;
    } else {
      System.out.println("FAILURE: getNumberOfOverdrafts did not return 5 ");
    }
    return false;
  }

  /**
   * This method checks whether the TransactionGroup constructor throws an exception with an
   * appropriate message, when it is passed an empty int[].
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   * @throws DataFormatException
   */
  public static boolean testTransactionGroupEmpty() {
    try {
      int[] a = null;
      TransactionGroup test = new TransactionGroup(a);// adds a null transaction group
    } catch (DataFormatException e) {
      // checks whether the TransactionGroup constructor throws an exception if the transaction
      // group is null
      return true;
    }
    return false;
  }

  /**
   * This method checks whether the TransactionGroup constructor throws an exception with an
   * appropriate message, when then first int in the provided array is not 0, 1, or 2.
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testTransactionGroupInvalidEncoding() {
    try {
      String a = "8 36 222";// add a transaction group start with non 0, 1 or 2
      Account test = new Account("test");
      test.addTransactionGroup(a);;
    } catch (DataFormatException e) {
      // checks whether the TransactionGroup constructor throws an exception of a transaction group
      // start with non 0, 1 or 2
      return true;
    }
    return false;
  }

  /**
   * This method checks whether the Account.addTransactionGroup method throws an exception with an
   * appropriate message, when it is passed a quick withdraw encoded group that contains negative
   * numbers of withdraws.
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testAccountAddNegativeQuickWithdraw() {
    try {
      String a = "2 1 0 -1 0";// add a transaction group with invalid quick withdraw encoded
      Account test = new Account("test");
      test.addTransactionGroup(a);
    } catch (DataFormatException e) {
      // checks whether the Account.addTransactionGroup method throws an exception of a transaction
      // group with invalid quick withdraw encode
      return true;
    }
    return false;
  }

  /**
   * This method checks whether the Account.addTransactionGroup method throws an exception with an
   * appropriate message, when it is passed a string with space separated English words (non-int).
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testAccountBadTransactionGroup() {
    try {
      String a = "as 23d 222";// add a transaction group with words
      Account test = new Account("test");
      test.addTransactionGroup(a);
    } catch (DataFormatException e) {
      // checks whether the Account.addTransactionGroup method throws an exception of a transaction
      // group with words
      return true;
    }
    return false;
  }

  /**
   * This method checks whether the Account.getTransactionAmount method throws an exception with an
   * appropriate message, when it is passed an index that is out of bounds.
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testAccountIndexOutOfBounds() {
    try {
      int[] a = new int[] {1, 200, 300, 400};
      TransactionGroup test = new TransactionGroup(a);
      test.getTransactionAmount(3);
      // get the transaction amount whose index is not in the transaction group
    } catch (IndexOutOfBoundsException e) {
      // checks whether the Account.getTransactionAmount method throws an exception when it is
      // passed an index that is out of bounds
      return true;
    } catch (DataFormatException e) {
    }
    return false;
  }

  /**
   * This method checks whether the Account constructor that takes a File parameter throws an
   * exception with an appropriate message, when it is passed a File object that does not correspond
   * to an actual file within the file system.
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   * @throws DataFormatException
   */
  public static boolean testAccountMissingFile() {
    try {
      File test = new File("test.txt");// creates a file the does not exist
      Account a = new Account(test);
    } catch (FileNotFoundException e) {
      // checks whether the Account constructor that takes a File parameter throws an exception when
      // it is passed a File object that does not correspond to an actual file within the file
      // system
      return true;
    } catch (DataFormatException e) {

    }
    return false;
  }

  /**
   * This method implements the test program
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int problems = 0;
    if (!testAccountBalance()) {
      System.out.println("FAILED TEST testAccountBalance!!!");
      problems++;
    } else {
      System.out.println("PASSED TEST testAccountBalance!!!");
    }
    if (!testOverdraftCount()) {
      System.out.println("FAILED TEST testOverdraftCount!!!");
      problems++;
    } else {
      System.out.println("PASSED TEST testOverdraftCount!!!");
    }
    if (!testTransactionGroupEmpty()) {
      System.out.println("FAILED TEST testTransactionGroupEmpty!!!");
      problems++;
    } else {
      System.out.println("PASSED TEST testTransactionGroupEmpty!!!");
    }
    if (!testTransactionGroupInvalidEncoding()) {
      System.out.println("FAILED TEST testTransactionGroupInvalidEncoding!!!");
      problems++;
    } else {
      System.out.println("PASSED TEST testTransactionGroupInvalidEncoding!!!");
    }
    if (!testAccountAddNegativeQuickWithdraw()) {
      System.out.println("FAILED TEST testAccountAddNegativeQuickWithdraw!!!");
      problems++;
    } else {
      System.out.println("PASSED TEST testAccountAddNegativeQuickWithdraw!!!");
    }
    if (!testAccountBadTransactionGroup()) {
      System.out.println("FAILED TEST testAccountBadTransactionGroup!!!");
      problems++;
    } else {
      System.out.println("PASSED TEST testAccountBadTransactionGroup!!!");
    }
    if (!testAccountIndexOutOfBounds()) {
      System.out.println("FAILED TEST testAccountIndexOutOfBounds!!!");
      problems++;
    } else {
      System.out.println("PASSED TEST testAccountIndexOutOfBounds!!!");
    }
    if (!testAccountMissingFile()) {
      System.out.println("FAILED TEST testAccountMissingFile!!!");
      problems++;
    } else {
      System.out.println("PASSED TEST testAccountMissingFile!!!");
    }
    if (problems == 0)
      System.out.println("No problems found!!!");
  }

}
