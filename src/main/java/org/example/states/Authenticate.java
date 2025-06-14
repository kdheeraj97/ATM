package org.example.states;

import lombok.AllArgsConstructor;
import org.example.ATM;
import org.example.model.AtmCard;

@AllArgsConstructor
public class Authenticate extends State {
    private final ATM atm;
    private final AtmCard card;

    @Override
    public void authenticatePin(int pin) {
        if (card.getPin() == pin) {
            atm.setState(new operationSelection(atm, card));
        } else {
            System.out.println("Invalid Pin");
            exit();
        }
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
