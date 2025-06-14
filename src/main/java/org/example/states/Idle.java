package org.example.states;

import lombok.AllArgsConstructor;
import org.example.ATM;
import org.example.model.AtmCard;

@AllArgsConstructor
public class Idle extends State {
    private final ATM atm;
    @Override
    public void insertCard(AtmCard card) {
        atm.setState(new Authenticate(atm, card));
    }
}
