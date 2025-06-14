package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BankAccount {
    private final int accountNo;
    private int balance;

    public void doDebit(int debit) {
        balance = balance - debit;
    }

    public void doCredit(int credit) {
        balance = balance + credit;
    }

}
