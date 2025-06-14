package org.example.cashwithdrawal;

import lombok.AllArgsConstructor;
import org.example.ATM;
import org.example.model.Cash;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
public abstract class CashWithdrawalProcessor {
    private CashWithdrawalProcessor next;

    public void withdrawCash(int amount, ATM atm, Map<Cash, Integer> cashList) {
        if (next != null) {
            next.withdrawCash(amount, atm, cashList);
        }
    }

}
