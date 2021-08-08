
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Auditable Banking
// Files: AuditableBanking.java
// Course: CS 300 Fall 2018 001
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
import java.util.Scanner;

public class AuditableBanking {
  /**
   * Adds a transaction group to an array of transaction groups. If the allTransactions array is
   * already full then this method will do nothing other than return allTransactionCount.
   * 
   * @param newTransactions is the new transaction group being added (perfect size).
   * @param allTransactions is the collection that newTransactions is being added to (oversize).
   * @param allTransactionsCount is the number of transaction groups within allTransactions (before
   *        newTransactions is added.
   * @return the number of transaction groups within allTransactions after newTransactions is added.
   */
  public static int submitTransactions(int[] newTransactions, int[][] allTransactions,
      int allTransactionsCount) {
    if (allTransactionsCount < allTransactions.length) { // if a user's number of transactions do
                                                         // not reach limit
      allTransactions[allTransactionsCount] = newTransactions; // insert the latest transaction
      allTransactionsCount++; // total transaction numbers increased by 1
      return allTransactionsCount;// return the number of transactions groups after the submission
    } else {
      return allTransactionsCount;// if the number of the transaction group if full, return the
                                  // number of the full transaction group.
    }
  }

  /**
   * This method detects the initial of the command of a user's input then process the command. If
   * the initial of the command is an integer such as 0, 1, 2, will submit a transaction group, If
   * the initial is 'b' or 'B', will calculate the balance, If the initial is 'o' or O', will
   * calculate the overdrafts. If the initial is 'q' or 'Q', will return -1 in main to end the
   * program.
   * 
   * @param command is the user's input to be processed on the method
   * @param allTransactions is the collection that newTransactions is being added to (oversize).
   * @param allTransactionsCount is the number of transaction groups within allTransactions (before
   *        newTransactions is added.
   * @return the number of allTransactionsCount
   */
  public static int processCommand(String command, int[][] allTransactions,
      int allTransactionsCount) {
    // TODO: Implement this method
    if (command.toUpperCase().charAt(0) == 'B') {// detect if the initial of command is B
      System.out.println( // if the initial is B, calculate the balance and print it out
          "Current Balance: " + calculateCurrentBalance(allTransactions, allTransactionsCount));
      System.out.println();
    } else if (command.toUpperCase().charAt(0) == 'O') {// detect if the initial of command is O
      System.out.println("Number of Overdrafts: "// if the initial is O, calculate the number of
                                                 // overdrafts and
                                                 // print it out
          + calculateNumberOfOverdrafts(allTransactions, allTransactionsCount));
      System.out.println();
    } else if (command.toUpperCase().charAt(0) == 'Q') {// detect if the initial of command is Q
      return -1;// if the initial is O, assign allTransactionsCount with -1 to quit the process
    } else if (command.toUpperCase().charAt(0) == '0' || command.toUpperCase().charAt(0) == '1'
        || command.toUpperCase().charAt(0) == '2') {// detect if the initial of command is 0 or 1 or
                                                    // 2
      String[] input = command.trim().split(" ");// Split the command to a string array
      int[] newTransactions = new int[input.length];// create an integer array with the same size of
                                                    // the string
                                                    // array
      for (int i = 0; i < input.length; i++) { // this loop converts a string array to an int
                                               // array
        newTransactions[i] = Integer.parseInt(input[i]);
      }
      System.out.println();
      return submitTransactions(newTransactions, allTransactions, allTransactionsCount);
      // return the number of transactions after submitting the transaction
    }
    return allTransactionsCount;
  }

  /**
   * This method calculates the current balance of all transaction groups.
   * 
   * @param allTransactions is the collection that newTransactions is being added to (oversize).
   * @param allTransactionsCount is the number of transaction groups within allTransactions (before
   *        newTransactions is added.
   * @return the number of allTransactionsCount
   */
  public static int calculateCurrentBalance(int[][] allTransactions, int allTransactionsCount) {
    // TODO: Implement this method
    int balance = 0;// the initial balance is 0
    int[] qucikWithdraw = new int[] {20, 40, 80, 100};// integer array for quick withdraw
    for (int i = 0; i < allTransactionsCount; i++) {// this loop detects every elements in a
                                                    // transaction group
      if (allTransactions[i][0] == 0) {// calculate the balance in a Binary Amount Transactions
        for (int j = 1; j < allTransactions[i].length; j++) {
          if (allTransactions[i][j] == 1) {// if the number of the is 1, add 1 dollar
            balance++;
          } else if (allTransactions[i][j] == 0) {// if the number of the is 0, minus 1 dollar
            balance--;
          }
        }
      } else if (allTransactions[i][0] == 1) {// calculate the balance in a Integer Amount
                                              // Transactions
        for (int j = 1; j < allTransactions[i].length; j++) {
          balance = balance + allTransactions[i][j];// add the number from index of 1 to the last
                                                    // one
        }
      } else if (allTransactions[i][0] == 2) {// calculate the balance in a Quick Withdraw
                                              // Transactions
        for (int j = 1; j < allTransactions[i].length; j++) {
          balance = balance - allTransactions[i][j] * qucikWithdraw[j - 1];// use the amount stored
                                                                           // in the
                                                                           // quick withdraw array
                                                                           // to
                                                                           // calculate the balance
        }
      }
    }
    return balance;
  }

  /**
   * This method calculates the current balance of all transaction groups.
   * 
   * @param allTransactions is the collection that newTransactions is being added to (oversize).
   * @param allTransactionsCount is the number of transaction groups within allTransactions (before
   *        newTransactions is added.
   * @return the number of allTransactionsCount
   */
  public static int calculateNumberOfOverdrafts(int[][] allTransactions, int allTransactionsCount) {
    // TODO: Implement this method
    int overdrafts = 0;// the initial overdrafts is 0
    int currentBalance = 0;// the initial balance is 0
    int[] qucikWithdraw = new int[] {20, 40, 80, 100};// integer array for quick withdraw
    for (int i = 0; i < allTransactionsCount; i++) {// this loop detects every elements in a
                                                    // transaction group
      if (allTransactions[i][0] == 0) {// calculate the number of overdrafts in a Binary Amount
                                       // Transactions
        for (int j = 1; j < allTransactions[i].length; j++) {
          if (allTransactions[i][j] == 1) {// if the number of the is 1, add 1 dollar
            currentBalance++;
          } else if (allTransactions[i][j] == 0) {// if the number of the is 0, minus 1 dollar
            currentBalance--;
            if (currentBalance < 0) {// if the balance is less than zero, there will be a overdraft
              overdrafts++;
            }
          }
        }
      } else if (allTransactions[i][0] == 1) {
        {// calculate the overdrafts in a Integer Amount Transactions
          for (int j = 1; j < allTransactions[i].length; j++) {
            currentBalance = currentBalance + allTransactions[i][j];// add the number from index of
                                                                    // 1 to the
                                                                    // last one
            if ((allTransactions[i][j] < 0) && (currentBalance < 0)) {// if the number in the index
                                                                      // is less
                                                                      // than zero and the current
                                                                      // balance
                                                                      // is less than zero
              overdrafts++;// this can be an overdraft
            }
          }
        }
      } else if (allTransactions[i][0] == 2) {// calculate the overdrafts in a Quick Withdraw
                                              // Transactions
        for (int j = 1; j < allTransactions[i].length; j++) {
          currentBalance = currentBalance - allTransactions[i][j] * qucikWithdraw[j - 1];
          if ((currentBalance < 0) && (allTransactions[i][j] > 0)) {// if the number in the index is
                                                                    // greater
                                                                    // than zero and the current
                                                                    // balance is
                                                                    // less than zero
            overdrafts++;// this can be an overdraft
          }
        }

      }
    }
    return overdrafts;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);// create a scanner object
    String command = null;// create a String named command
    int[][] allTransactions = new int[50][50];// the integer array for all transaction groups
    int allTransactionsCount = 0;// the initial number of transactions
    System.out.println("========== Welcome to the Auditable Banking App ==========");// head of the
                                                                                     // program
    boolean done = false;// the boolean to control the loop
    while (!done) {
      System.out.println("COMMAND MENU:");// print out the menu
      System.out.println("  Submit a Transaction (enter sequence of integers separated by spaces)");
      System.out.println("  Show Current [B]alance");
      System.out.println("  Show Number of [O]verdrafts");
      System.out.println("  [Q]uit Program");
      System.out.print("ENTER COMMAND: ");
      if (sc.hasNextLine()) {// detect if there is input
        command = sc.nextLine();
      }
      allTransactionsCount = processCommand(command, allTransactions, allTransactionsCount);// process
                                                                                            // the
                                                                                            // command
      if (allTransactionsCount == -1) {// the boolean to determinate the loop
        done = true;
      }
    }
    System.out.println("============ Thank you for using this App!!!! ============");// end of the
                                                                                     // program
  }
}
