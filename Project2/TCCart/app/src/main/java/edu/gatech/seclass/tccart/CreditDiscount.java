package edu.gatech.seclass.tccart;

import com.orm.SugarRecord;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ddersch on 3/15/16.
 */
public class CreditDiscount  extends SugarRecord implements Discount {

    private Date expirationDate;
    private BigDecimal amountRemaining;


    private Customer customer;

    public BigDecimal getAmountRemaining() { return this.amountRemaining; }

    public CreditDiscount(Date expirationDate) {
        this.amountRemaining = new BigDecimal("3.00");
        this.expirationDate = expirationDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
