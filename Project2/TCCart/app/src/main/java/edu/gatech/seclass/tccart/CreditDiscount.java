package edu.gatech.seclass.tccart;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ddersch on 3/15/16.
 */
public class CreditDiscount implements Discount {

    private Date expirationDate;
    private BigDecimal amountRemaining;

    public CreditDiscount(Date expirationDate) {
        this.amountRemaining = new BigDecimal("3.00");
        this.expirationDate = expirationDate;
    }

    @Override
    public BigDecimal computeSavings(BigDecimal amountBeforeDiscount) {
        if (amountBeforeDiscount.compareTo(this.amountRemaining) == 1 || amountBeforeDiscount.compareTo(this.amountRemaining) == 0) {
            BigDecimal amountAfterDiscount = amountBeforeDiscount.subtract(this.amountRemaining);
            this.amountRemaining = new BigDecimal("0");
            return amountAfterDiscount;
        } else {
            this.amountRemaining = this.amountRemaining.subtract(amountBeforeDiscount);
            BigDecimal amountAfterDiscount = new BigDecimal("0.0");
            return amountAfterDiscount;
        }
    }
}
