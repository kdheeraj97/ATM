package org.example.cashwithdrawal;

import org.example.ATM;
import org.example.model.Cash;

import java.util.Map;

public class OneHundredCashWithdrawal extends CashWithdrawalProcessor {
    public OneHundredCashWithdrawal() {
        super(null);
    }

    @Override
    public void withdrawCash(int amount, ATM atm, Map<Cash, Integer> cashList) {
        int available = atm.getCashBalance().getOrDefault(Cash.ONE_HUNDRED, 0);
        int required = (amount / 100);
        int taken = Math.min(required, available);

        cashList.put(Cash.ONE_HUNDRED, taken);
        int balance = amount - (taken * 100);

        if (balance != 0) {
            super.withdrawCash(balance, atm, cashList);
        }
    }
}
