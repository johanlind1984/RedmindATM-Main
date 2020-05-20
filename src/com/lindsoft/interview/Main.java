package com.lindsoft.interview;
import java.util.Arrays;

public class Main {
    private static int thounsandBills = 2;
    private static int fivhundredBills = 3;
    private static int onehundredBills = 5;

    public static void main(String[] args) {
        int[] withdrawals = new int[]{1500, 700, 400, 1100, 1000, 700, 300};
        Arrays.stream(withdrawals).forEach(sum ->
                System.out.println("Withdrawing: " + sum + ", " + withdraw(sum, thounsandBills, fivhundredBills, onehundredBills)));
    }

    public static boolean withdraw(int amountToWithdrawLeft, int thousandBillsLeft, int fivehundredBillsLeft, int onehundredBillsLeft) {
        if (amountToWithdrawLeft == 0) {
            thounsandBills = thousandBillsLeft;
            fivhundredBills = fivehundredBillsLeft;
            onehundredBills = onehundredBillsLeft;
            return true;
        }

        if (amountToWithdrawLeft >= 1000 && thousandBillsLeft > 0) {
            return withdraw(amountToWithdrawLeft - 1000, thousandBillsLeft - 1, fivehundredBillsLeft, onehundredBillsLeft);
        } else if (amountToWithdrawLeft >= 500 && fivehundredBillsLeft > 0) {
            return withdraw(amountToWithdrawLeft - 500, thousandBillsLeft, fivehundredBillsLeft - 1, onehundredBillsLeft);
        } else if (amountToWithdrawLeft >= 100 && onehundredBillsLeft > 0) {
            return withdraw(amountToWithdrawLeft - 100, thousandBillsLeft, fivehundredBillsLeft, onehundredBillsLeft - 1);
        }
        return false;
    }
}
