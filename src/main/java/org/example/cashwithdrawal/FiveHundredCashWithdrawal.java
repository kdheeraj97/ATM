package org.example.cashwithdrawal;

import org.example.ATM;
import org.example.model.Cash;

import java.util.Map;

public class FiveHundredCashWithdrawal extends CashWithdrawalProcessor{
    public FiveHundredCashWithdrawal(CashWithdrawalProcessor next) {
        super(next);
    }

    @Override
    public void withdrawCash(int amount, ATM atm, Map<Cash, Integer> cashList) {
        int available = atm.getCashBalance().getOrDefault(Cash.FIVE_HUNDRED, 0);
        int required = (amount / 500);
        int taken = Math.min(required, available);

        cashList.put(Cash.FIVE_HUNDRED, taken);
        int balance = amount - (taken * 500);

        if (balance != 0) {
            super.withdrawCash(balance, atm, cashList);
        }
    }
}
