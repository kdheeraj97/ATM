package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.model.Cash;
import org.example.states.State;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ATM {
    private State state;
    private int balance;
    private final Map<Cash, Integer> cashBalance;

    public ATM() {
        balance = 0;
        cashBalance = new HashMap<>();
    }

    public void addCash(Cash cash, int count) {
        cashBalance.put(cash, cashBalance.getOrDefault(cash, 0) + count);
        balance = balance + (cash.getValue() * count);
    }

    public void updateCashAndBalance(Map<Cash, Integer> cashMap) {
        for (Map.Entry<Cash, Integer> entry : cashMap.entrySet()) {
            cashBalance.put(entry.getKey(), cashBalance.get(entry.getKey()) - entry.getValue());
            balance = balance - (entry.getKey().getValue() * entry.getValue());
        }
    }

    public void displayBalance() {
        System.out.println("Balance: " + balance);
        for (Cash entry : cashBalance.keySet()) {
            System.out.println(entry.name() + ": " + cashBalance.getOrDefault(entry, 0));
        }
    }
}
