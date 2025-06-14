package org.example.cashwithdrawal;

import org.example.ATM;
import org.example.model.Cash;

import java.util.Map;

public class TwoHundredCashWithdrawal extends CashWithdrawalProcessor {
    public TwoHundredCashWithdrawal(CashWithdrawalProcessor next) {
        super(next);
    }

    @Override
    public void withdrawCash(int amount, ATM atm, Map<Cash, Integer> cashList) {
        int available = atm.getCashBalance().getOrDefault(Cash.TWO_HUNDRED, 0);
        int required = (amount / 200);
        int taken = Math.min(required, available);

        cashList.put(Cash.TWO_HUNDRED, taken);
        int balance = amount - (taken * 200);

        if (balance != 0) {
            super.withdrawCash(balance, atm, cashList);
        }
    }
}
