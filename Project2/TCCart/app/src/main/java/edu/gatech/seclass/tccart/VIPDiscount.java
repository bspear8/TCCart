package edu.gatech.seclass.tccart;

import com.orm.SugarRecord;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ddersch on 3/15/16.
 */
public class VIPDiscount extends SugarRecord implements Discount {


    private Date yearOfDiscount;

    private Customer customer;


    private static final BigDecimal discountPercentage = new BigDecimal("0.10");

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public VIPDiscount(Date yearOfDiscount) {
        this.yearOfDiscount = yearOfDiscount;
    }

    @Override
    public BigDecimal computeSavings(BigDecimal amount) {
        return amount.subtract(amount.multiply(this.discountPercentage));
    }
}
