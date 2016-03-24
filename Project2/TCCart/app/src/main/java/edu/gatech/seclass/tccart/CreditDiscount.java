package edu.gatech.seclass.tccart;

import com.orm.SugarRecord;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ddersch on 3/15/16.
 */
public class CreditDiscount  extends SugarRecord implements Discount {

    private Date expirationDate;
    private BigDecimal amountRemaining;

    public static final CreditDiscount NoCreditDiscount = new CreditDiscount(new Date(0));

    private Customer customer;

    public BigDecimal getAmountRemaining() { return this.amountRemaining; }

    public CreditDiscount(Date expirationDate) {
        this.amountRemaining = new BigDecimal("3.00");
        this.expirationDate = expirationDate;
    }

    public CreditDiscount (){

    }



    public void setAmountRemaining(BigDecimal newAmount) {
        this.amountRemaining = newAmount;
    }

    public void subtractAmountRemaining(BigDecimal subtrahend) {
        this.amountRemaining = this.amountRemaining.subtract(subtrahend);
        if (this.amountRemaining.compareTo(new BigDecimal("0")) == 0) {
            this.amountRemaining = new BigDecimal("0");
        }

    }

    public boolean isOut() {
        int comparison = this.amountRemaining.compareTo(new BigDecimal("0"));
        if (comparison <= 0) {
            return true;
        }
        return false;
    }

    public boolean isExpired() {

        int dateComparison = this.expirationDate.compareTo(Calendar.getInstance().getTime());
        if (dateComparison <= 0) {
            return true;
        }
        return false;

    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public BigDecimal computeSavings(BigDecimal amountBeforeDiscount) {
        if (amountBeforeDiscount.compareTo(this.amountRemaining) == 1 || amountBeforeDiscount.compareTo(this.amountRemaining) == 0) {
            return this.amountRemaining;
        } else {
             return amountBeforeDiscount;
        }
    }
}
