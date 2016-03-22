package edu.gatech.seclass.tccart;

import com.orm.SugarRecord;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ddersch on 3/19/16.
 */
public class TransactionRecord extends SugarRecord {

    Date date;
    BigDecimal amountBeforeDiscounts;


    Customer customer;


    public TransactionRecord () {

    }

    public TransactionRecord(BigDecimal amountBeforeDiscounts, Date date) {
        this.amountBeforeDiscounts = amountBeforeDiscounts;
        this.date = date;

    }

    public TransactionRecord(BigDecimal amountBeforeDiscounts) {
        this.amountBeforeDiscounts = amountBeforeDiscounts;
        this.date = Calendar.getInstance().getTime();
    }
}
