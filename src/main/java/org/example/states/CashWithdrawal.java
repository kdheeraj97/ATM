package org.example.states;

import lombok.AllArgsConstructor;
import org.example.ATM;
import org.example.cashwithdrawal.CashWithdrawalProcessor;
import org.example.cashwithdrawal.FiveHundredCashWithdrawal;
import org.example.cashwithdrawal.OneHundredCashWithdrawal;
import org.example.cashwithdrawal.TwoHundredCashWithdrawal;
import org.example.model.AtmCard;
import org.example.model.Cash;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class CashWithdrawal extends State {
    private final ATM atm;
    private final AtmCard card;

    @Override
    public void withdraw(int amount) {
        Map<Cash, Integer> cashList = new HashMap<>();
        if (amount > card.getCustomer().getAccount().getBalance()) {
            System.out.println("Insufficient balance in your account");
            exit();
            return;
        }
        if (amount > atm.getBalance()) {
            System.out.println("Insufficient cash");
            exit();
            return;
        }
        CashWithdrawalProcessor withdrawalProcessor = new FiveHundredCashWithdrawal(
                new TwoHundredCashWithdrawal(new OneHundredCashWithdrawal()));
        try {
            withdrawalProcessor.withdrawCash(amount, atm, cashList);
            atm.updateCashAndBalance(cashList);

            System.out.println("Please Collect cash");
            for (Map.Entry<Cash, Integer> enumIntegerMap : cashList.entrySet()) {
                System.out.println(enumIntegerMap.getKey().name() + ": " + enumIntegerMap.getValue());
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
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
