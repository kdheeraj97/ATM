package org.example.states;

import lombok.AllArgsConstructor;
import org.example.ATM;
import org.example.model.AtmCard;
import org.example.model.TransactionType;

@AllArgsConstructor
public class operationSelection extends State {
    private final ATM atm;
    private final AtmCard card;

    @Override
    public void selectOperation(TransactionType type) {
        switch (type) {
            case CHECK_BALANCE -> atm.setState(new CheckBalance(atm, card));
            case CASH_WITHDRAWAL -> atm.setState(new CashWithdrawal(atm, card));
            default -> {
                System.out.println("Invalid operation");
                exit();
            }
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
