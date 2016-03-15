package edu.gatech.seclass.tccart;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ddersch on 3/15/16.
 */
public class VIPDiscount implements Discount {


    private Date yearOfDiscount;

    private BigDecimal discountPercentage;


    public VIPDiscount(Date yearOfDiscount) {
        this.yearOfDiscount = yearOfDiscount;
        this.discountPercentage = new BigDecimal("0.10");
    }

    @Override
    public BigDecimal computeSavings(BigDecimal amount) {
        return amount.subtract(amount.multiply(this.discountPercentage));
    }
}
