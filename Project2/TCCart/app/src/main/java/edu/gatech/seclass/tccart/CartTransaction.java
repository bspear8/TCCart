package edu.gatech.seclass.tccart;

import com.orm.SugarRecord;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.orm.SugarRecord;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ddersch on 3/19/16.
 */
public class CartTransaction extends SugarRecord {

    Date date;
    BigDecimal amountBeforeDiscounts;
    Customer customer;

    BigDecimal creditDiscount;
    BigDecimal vipDiscount;



    public CartTransaction() {
        this.date = Calendar.getInstance().getTime();
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setAmount(BigDecimal amountBeforeDiscounts) {
        this.amountBeforeDiscounts = amountBeforeDiscounts;
    }

    public CartTransaction(BigDecimal amountBeforeDiscounts, Date date) {
        this.amountBeforeDiscounts = amountBeforeDiscounts;
        this.date = date;

    }

    public CartTransaction(BigDecimal amountBeforeDiscounts) {
        this.amountBeforeDiscounts = amountBeforeDiscounts;
        this.date = Calendar.getInstance().getTime();
    }

    public void setCreditDiscount(BigDecimal creditDiscount) {
        this.creditDiscount = creditDiscount;
    }

    public void setVipDiscount(BigDecimal vipDiscount) {
        this.vipDiscount = vipDiscount;
    }




}

