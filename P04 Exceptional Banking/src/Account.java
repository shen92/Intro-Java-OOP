//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Exceptional Banking
// Files: Acount.java
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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Account {

  private static final int MAX_GROUPS = 10000;
  private static int nextUniqueId = 1000;

  private String name;// account name
  private final int UNIQUE_ID;// the unique identity number of the account
  private TransactionGroup[] transactionGroups;// the transaction group to submit
  private int transactionGroupsCount;// number of transaction groups

  /**
   * this method initialize the account with name by input
   */
  public Account(String name) {// initialize the account class object
    this.name = name;// initialize the name of the account
    this.UNIQUE_ID = Account.nextUniqueId;
    // initialize the unique id by import the unique id
    Account.nextUniqueId++;
    // once the unique id initialized, next unique id will be the current unique id + 1
    this.transactionGroups = new TransactionGroup[MAX_GROUPS];
    // initialize the max number of transaction groups
    this.transactionGroupsCount = 0;
    // initialize the number of the transaction groups of the account
  }

  /**
   * this method initialize the account with name by file
   */
  public Account(File file) throws DataFormatException, FileNotFoundException {
    // initialize the account from a specific file
    // NOTE: THIS METHOD SHOULD NOT BE CALLED MORE THAN ONCE, BECAUSE THE
    // RESULTING BEHAVIOR IS NOT DEFINED WITHIN THE JAVA SPECIFICATION ...
    if (!file.exists()) {
      throw new FileNotFoundException(file + "was unable to be opened");
    }
    Scanner in = new Scanner(file);
    // ... THIS WILL BE UPDATED TO READ FROM A FILE INSTEAD OF SYSTEM.IN.

    this.name = in.nextLine();
    // get the account name from the user
    this.UNIQUE_ID = Integer.parseInt(in.nextLine());
    // get the unique id from the user
    Account.nextUniqueId = this.UNIQUE_ID + 1;
    // once the unique id initialized from the file,
    // next unique id will be the current unique id + 1
    this.transactionGroups = new TransactionGroup[MAX_GROUPS];
    // initialize the max number of transaction groups
    this.transactionGroupsCount = 0;
    // initialize the number of the transaction groups of the account
    String nextLine = "";// final steps in the scanner initialization
    while (in.hasNextLine())
      try {
        this.addTransactionGroup(in.nextLine());
      } catch (DataFormatException e) {
        System.out.println("DataFormatException occured " + e.getMessage());
        e.printStackTrace();
      }
    in.close();
  }

  /**
   * this method gets the account's unique id
   * 
   * @return int user's unique id
   */
  public int getId() {
    return this.UNIQUE_ID;// get the unique id of an account
  }

  /**
   * this method adds a TransactionGroup
   */
  public void addTransactionGroup(String command) throws DataFormatException {
    if (!command.contains(" ")) {
      throw new DataFormatException(
          "addTransactionGroup requires string commands that contain only space separated integer values");
    }
    String[] parts = command.split(" ");
    for (int i = 0; i < parts.length; ++i) {
      try {
        Integer.parseInt(parts[i]);
      } catch (NumberFormatException e) {
        throw new DataFormatException(
            "addTransactionGroup requires string commands that contain only space separated integer values");
      }
    }
    int[] newTransactions = new int[parts.length];
    for (int i = 0; i < parts.length; i++)
      newTransactions[i] = Integer.parseInt(parts[i]);
    TransactionGroup t = new TransactionGroup(newTransactions);
    this.transactionGroups[this.transactionGroupsCount] = t;
    if (this.transactionGroups.length > MAX_GROUPS) {
      throw new OutOfMemoryError();
    }
  }

  /**
   * this method gets the number of transaction groups
   * 
   * @return int the number of transaction groups
   */
  public int getTransactionCount() {
    // get the number of transaction groups of an account
    int transactionCount = 0;
    for (int i = 0; i < this.transactionGroupsCount; i++)
      transactionCount += this.transactionGroups[i].getTransactionCount();
    return transactionCount;
  }

  /**
   * this method gets the transaction amount
   * 
   * @return the transaction amount
   */
  public int getTransactionAmount(int index) throws IndexOutOfBoundsException {
    // get the amount in a specific transaction group(group index)
    int transactionCount = 0;
    if (index >= transactionGroups.length) {
      throw new IndexOutOfBoundsException(index + " is greater than " + transactionGroups.length);
    }
    for (int i = 0; i < this.transactionGroupsCount; i++) {
      // search from the all transaction groups of an account
      int prevTransactionCount = transactionCount;
      // record the number of previous transaction groups
      transactionCount += this.transactionGroups[i].getTransactionCount();
      // get the number of transaction groups of an account
      if (transactionCount > index) {
        index -= prevTransactionCount;
        return this.transactionGroups[i].getTransactionAmount(index);
      }
    }
    return -1;
  }

  /**
   * this method gets the current balance
   * 
   * @return int current balance
   */
  public int getCurrentBalance() {
    // get the current balance of an account
    int balance = 0;
    int size = this.getTransactionCount();
    for (int i = 0; i < size; i++)
      balance += this.getTransactionAmount(i);
    return balance;
  }

  /**
   * this method
   */
  public int getNumberOfOverdrafts() {
    // get the number of overdrafts of an account
    int balance = 0;
    int overdraftCount = 0;
    int size = this.getTransactionCount();
    for (int i = 0; i < size; i++) {
      int amount = this.getTransactionAmount(i);
      balance += amount;
      if (balance < 0 && amount < 0)
        overdraftCount++;
    }
    return overdraftCount;
  }

}
