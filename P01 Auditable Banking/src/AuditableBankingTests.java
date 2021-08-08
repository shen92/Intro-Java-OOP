import java.util.*;
////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title: Auditable Banking
//Files: AuditableBankingTests.java
//Course: CS 300 Fall 2018 001
//
//Author: Yingjie Shen
//Email: shen92@wisc.edu
//Lecturer's Name: Gary Dahl
//
////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//Partner Name: (name of your pair programming partner)
//Partner Email: (email address of your programming partner)
//Partner Lecturer's Name: (name of your partner's lecturer)
//
//VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//___ Write-up states that pair programming is allowed for this assignment.
//___ We have both read and understand the course Pair Programming Policy.
//___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
//Students who get help from sources other than their partner must fully
//acknowledge and credit those sources of help here. Instructors and TAs do
//not need to be credited here, but tutors, friends, relatives, room mates,
//strangers, and others do. If you received no outside help from either type
//of source, then please explicitly indicate NONE.
//
//Persons: (identify each person and describe their help in detail)
//Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

public class AuditableBankingTests {
	/**
	 * This method tests if the method processCommand works properly.
	 * 
	 * @param allTransactions      is the collection that newTransactions is being
	 *                             added to (oversize).
	 * @param allTransactionsCount is the number of transaction groups within
	 *                             allTransactions (before newTransactions is added.
	 * @return if there is no errors about this method
	 */
	public static boolean testProcessCommand() {
		boolean foundProblem = false;// boolean for the existence of problem
		int allTransactionsCount = 0;// initial number of transactions
		int[][] transactions = new int[4][];// initial size of all the transaction groups
		// test with a single transaction of the Integer Amount encoding
		allTransactionsCount = 0;
		allTransactionsCount = AuditableBanking.processCommand("2 3 1 0 1", transactions, allTransactionsCount);// check
																												// the
																												// if
																												// amount
																												// of
																												// all
																												// transactions
																												// is
																												// correct
		if (allTransactionsCount != 1) {// check if the outcome is correct
			System.out.println(
					"FAILURE: processCommand did not return 4 when command = \"2 3 1 0 1\", and transactions contained: "
							+ Arrays.deepToString(transactions));
			System.out.println(allTransactionsCount);
			foundProblem = true;
		} else
			System.out.println("PASSED TEST 1/2 of processCommand!!!");

		// test with four transactions: including one of each encoding
		allTransactionsCount = AuditableBanking.processCommand("q", transactions, allTransactionsCount);// check whether
																										// can the loop
																										// of whole
																										// program
		if (allTransactionsCount != -1) {// check if the outcome is correct
			System.out.println(
					"FAILURE: processCommand did not return -1 when tcommand = \"q\", and transactions contained: "
							+ Arrays.deepToString(transactions));
			foundProblem = true;
		} else
			System.out.println("PASSED TESTS 2/2 of processCommand!!!");

		return !foundProblem;
	}

	/**
	 * This method tests if the method calculateCurrentDraft works properly.
	 * 
	 * @param allTransactions      is the collection that newTransactions is being
	 *                             added to (oversize).
	 * @param allTransactionsCount is the number of transaction groups within
	 *                             allTransactions (before newTransactions is added.
	 * @return if there is no errors about this method
	 */
	public static boolean testCalculateCurrentBalance() {
		boolean foundProblem = false;// boolean for the existence of problem
		int[][] transactions = new int[][] { { 1, 10, -20, +30, -20, -20 }, // +2 overdrafts (ending balance: -20)
				{ 0, 1, 1, 1, 0, 0, 1, 1, 1, 1 }, // +2 overdrafts (ending balance: -15)
				{ 1, 115 }, // +0 overdrafts (ending balance: +100)
				{ 2, 3, 1, 0, 1 }, // +1 overdrafts (ending balance: -100)
		};

		// test with a single transaction of the Integer Amount encoding
		int transactionCount = 1;// initial number of transactions
		int balance = AuditableBanking.calculateCurrentBalance(transactions, transactionCount);// amount of balance by
																								// the
																								// calculateCurrentBalance
																								// method
		if (balance != -20) {// check if the outcome is correct
			System.out.println(
					"FAILURE: calculateCurrentBalance did not return -20 when transactionCount = 1, and transactions contained: "
							+ Arrays.deepToString(transactions));
			foundProblem = true;
		} else
			System.out.println("PASSED TEST 1/2 of TestCalculateCurrentBalance!!!");

		// test with four transactions: including one of each encoding
		transactionCount = 4;// new number of transactions in the second test
		balance = AuditableBanking.calculateCurrentBalance(transactions, transactionCount);// amount of balance by the
																							// calculateCurrentBalance
																							// method
		if (balance != -100) {// check if the outcome is correct
			System.out.println(
					"FAILURE: calculateCurrentBalance did not return -100 when transactionCount = 4, and transactions contained: "
							+ Arrays.deepToString(transactions));
			foundProblem = true;
		} else
			System.out.println("PASSED TESTS 2/2 of TalculateCurrentBalance!!!");

		return !foundProblem;
	}

	/**
	 * This method tests if the method calculateOverdraft works properly.
	 * 
	 * @param allTransactions      is the collection that newTransactions is being
	 *                             added to (oversize).
	 * @param allTransactionsCount is the number of transaction groups within
	 *                             allTransactions (before newTransactions is added.
	 * @return if there is no errors about this method
	 */
	public static boolean testCalculateNumberOfOverdrafts() {
		boolean foundProblem = false; // boolean for the existence of problem
		int[][] transactions = new int[][] { { 1, 10, -20, +30, -20, -20 }, // +2 overdrafts (ending balance: -20)
				{ 0, 1, 1, 1, 0, 0, 1, 1, 1, 1 }, // +2 overdrafts (ending balance: -15)
				{ 1, 115 }, // +0 overdrafts (ending balance: +100)
				{ 2, 3, 1, 0, 1 }, // +1 overdrafts (ending balance: -100)
		};

		// test with a single transaction of the Integer Amount encoding
		int transactionCount = 1;// initial number of transactions
		int overdrafts = AuditableBanking.calculateNumberOfOverdrafts(transactions, transactionCount);// amount of
																										// overdrafts by
																										// the
																										// calculateNumberOfOverdraftse
																										// method
		if (overdrafts != 2) {// check if the outcome is correct
			System.out.println(
					"FAILURE: calculateNumberOfOverdrafts did not return 2 when transactionCount = 1, and transactions contained: "
							+ Arrays.deepToString(transactions));
			foundProblem = true;
		} else
			System.out.println("PASSED TEST 1/2 of TestCalculateNumberOfOverdrafts!!!");

		// test with four transactions: including one of each encoding
		transactionCount = 4;// new number of transactions in the second test
		overdrafts = AuditableBanking.calculateNumberOfOverdrafts(transactions, transactionCount);// amount of
																									// overdrafts by the
																									// calculateNumberOfOverdraftse
																									// method
		if (overdrafts != 5) {// check if the outcome is correct
			System.out.println(
					"FAILURE: calculateNumberOfOverdrafts did not return 5 when transactionCount = 4, and transactions contained: "
							+ Arrays.deepToString(transactions));
			foundProblem = true;
		} else
			System.out.println("PASSED TESTS 2/2 of TestCalculateNumberOfOverdrafts!!!");

		return !foundProblem;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testProcessCommand();
		testCalculateNumberOfOverdrafts();
		testCalculateNumberOfOverdrafts();

	}

}
