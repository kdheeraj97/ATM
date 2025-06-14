package org.example;


import org.example.model.*;
import org.example.states.Idle;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(123, 36000);
        Customer customer = new Customer("DK", account);
        AtmCard card = new AtmCard(123, 2222, customer);

        ATM atm = new ATM();
        atm.addCash(Cash.FIVE_HUNDRED, 20);
        atm.addCash(Cash.TWO_HUNDRED, 50);
        atm.addCash(Cash.ONE_HUNDRED, 100);

        atm.setState(new Idle(atm));

        atm.getState().insertCard(card);
        atm.getState().authenticatePin(2222);
        atm.getState().selectOperation(TransactionType.CASH_WITHDRAWAL);
        atm.getState().withdraw(36000);

        atm.displayBalance();
    }
}