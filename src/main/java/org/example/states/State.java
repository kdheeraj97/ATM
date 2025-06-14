package org.example.states;

import org.example.model.AtmCard;
import org.example.model.TransactionType;

import java.util.*;

public abstract class State {
    public void insertCard(AtmCard card) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void authenticatePin(int pin) {
        System.out.println("OOPS!! Something went wrong");

    }

    public void selectOperation(TransactionType type) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void exit() {
        System.out.println("OOPS!! Something went wrong");
    }

    public void returnCard() {
        System.out.println("OOPS!! Something went wrong");
    }

    public void checkBalance() {
        System.out.println("OOPS!! Something went wrong");
    }

    public void withdraw(int amount) {
        System.out.println("OOPS!! Something went wrong");
    }
}
