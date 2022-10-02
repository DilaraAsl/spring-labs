package com.cydeo.loosely;

import com.cydeo.loosely.Balance;
import com.cydeo.loosely.BalanceManager;
import com.cydeo.loosely.CustomerBalance;
import com.cydeo.loosely.GiftCardBalance;

import java.math.BigDecimal;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        UUID user = UUID.randomUUID();

        Balance customerBalance = new CustomerBalance(user, BigDecimal.ZERO);
        System.out.println(customerBalance);
      Balance giftCardBalance = new GiftCardBalance(user, BigDecimal.ZERO);

        customerBalance.addBalance(new BigDecimal(150));
        giftCardBalance.addBalance(new BigDecimal(120));

        BalanceManager balanceService =
                new BalanceManager(customerBalance);
        System.out.println(balanceService.checkout(BigDecimal.valueOf(500)));

//        System.out.println(balanceService.checkoutFromCustomerBalance(new BigDecimal(80)));
//        System.out.println(balanceService.checkoutFromGiftBalance(new BigDecimal(80)));
    }

}
