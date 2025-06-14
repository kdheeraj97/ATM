package org.example.states;

import lombok.AllArgsConstructor;
import org.example.ATM;
import org.example.model.AtmCard;

@AllArgsConstructor
public class CheckBalance extends State {
    private final ATM atm;
    private final AtmCard card;

    @Override
    public void checkBalance() {
        System.out.println("Balance: " + card.getCustomer().getAccount().getBalance());
        exit();
    }

    @Override
    public void exit() {
        atm.setState(new Idle(atm));
        returnCard();
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
