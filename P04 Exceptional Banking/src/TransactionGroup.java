//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Exceptional Banking
// Files: TransactionGroup.java
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
import java.util.zip.DataFormatException;

public class TransactionGroup {

  private enum EncodingType {// three different types if encodings
    BINARY_AMOUNT, INTEGER_AMOUNT, QUICK_WITHDRAW
  };

  private EncodingType type;// type object from Encoding class
  private int[] values;

  /**
   * this method converts the user's input and add them
   */
  public TransactionGroup(int[] groupEncoding) throws DataFormatException {
    // constructor for a TransactionGroup class object
    if (groupEncoding == null) {
      throw new DataFormatException("transaction group encoding cannot be null or empty");
    }
    if (!((groupEncoding[0] == 0) || (groupEncoding[0] == 1) || (groupEncoding[0] == 2))) {
      throw new DataFormatException(
          "the first element within a transaction group must be 0, 1, or 2");
    }
    for (int i = 0; i < groupEncoding.length; i++) {
      if (groupEncoding[0] == 0) {
        if (!((groupEncoding[i] == 0) || (groupEncoding[i] == 1))) {
          throw new DataFormatException(
              "binary amount transaction groups may only contain 0s and 1s");
        }
      } else if (groupEncoding[0] == 1) {
        if (groupEncoding[i] == 0) {
          throw new DataFormatException("integer amount transaction groups may not contain 0s");
        }
      } else if (groupEncoding[0] == 2) {
        if (groupEncoding.length != 5) {
          throw new DataFormatException(
              "quick withdraw transaction groups must contain 5 elements");
        }
        if (groupEncoding[i] < 0) {
          throw new DataFormatException(
              "quick withdraw transaction groups may not contain negative numbers");
        }
      }
    }
    this.type = EncodingType.values()[groupEncoding[0]];// initialize default encoding type
    this.values = new int[groupEncoding.length - 1];// initialize default value
    for (int i = 0; i < values.length; i++) {// initialize the values array
      this.values[i] = groupEncoding[i + 1];
    }
  }


  /**
   * this method gets the number of transaction groups
   * 
   * @return int the number of transaction groups
   */
  public int getTransactionCount() {// collect the user's input of transaction group
    int transactionCount = 0;
    switch (this.type) {
      case BINARY_AMOUNT:
        int lastAmount = -1;
        for (int i = 0; i < this.values.length; i++) {
          if (this.values[i] != lastAmount) {
            transactionCount++;
            lastAmount = this.values[i];
          }
        }
        break;
      case INTEGER_AMOUNT:
        transactionCount = values.length;
        break;
      case QUICK_WITHDRAW:
        for (int i = 0; i < this.values.length; i++)
          transactionCount += this.values[i];
    }
    return transactionCount;
  }

  /**
   * this method gets the transaction amount
   * 
   * @return the transaction amount
   */
  public int getTransactionAmount(int transactionIndex) throws IndexOutOfBoundsException {
    // get the amount of transaction of a specific transaction group
    int transactionCount = 0;
    if (transactionIndex > values.length) {
      throw new IndexOutOfBoundsException(transactionIndex + " is greater than " + values.length);
    }
    switch (this.type) {
      case BINARY_AMOUNT:
        int lastAmount = -1;
        int amountCount = 0;
        for (int i = 0; i <= this.values.length; i++) {
          if (i == this.values.length || this.values[i] != lastAmount) {
            if (transactionCount - 1 == transactionIndex) {
              if (lastAmount == 0)
                return -1 * amountCount;
              else
                return +1 * amountCount;
            }
            transactionCount++;
            lastAmount = this.values[i];
            amountCount = 1;
          } else
            amountCount++;
          lastAmount = this.values[i];
        }
        break;
      case INTEGER_AMOUNT:
        return this.values[transactionIndex];
      case QUICK_WITHDRAW:
        final int[] QW_AMOUNTS = new int[] {-20, -40, -80, -100};
        for (int i = 0; i < this.values.length; i++)
          for (int j = 0; j < this.values[i]; j++)
            if (transactionCount == transactionIndex)
              return QW_AMOUNTS[i];
            else
              transactionCount++;
    }
    return -1;
  }
}
