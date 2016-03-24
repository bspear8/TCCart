package edu.gatech.seclass.tccart;

import com.orm.SugarRecord;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ddersch on 3/15/16.
 */
public class VIPDiscount extends SugarRecord implements Discount {


    private Date yearOfDiscount;

    private Customer customer;

    public static final VIPDiscount NoVIPStatus = new VIPDiscount(new Date(0));


    private static final BigDecimal discountPercentage = new BigDecimal("0.10");

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public VIPDiscount(Date yearOfDiscount) {
        this.yearOfDiscount = yearOfDiscount;
    }

    public VIPDiscount() {

    }

    @Override
    public BigDecimal computeSavings(BigDecimal amount) {
        return amount.multiply(this.discountPercentage);
    }

    public boolean isExpired() {

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        Calendar cal = Calendar.getInstance();
        cal.setTime(this.yearOfDiscount);

        int vipYear = cal.get(Calendar.YEAR);

        if (currentYear > vipYear) {
            return true;
        }
        return false;

    }

    public boolean isCurrent() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        Calendar cal = Calendar.getInstance();
        cal.setTime(this.yearOfDiscount);

        int vipYear = cal.get(Calendar.YEAR);

        if (currentYear == vipYear) {
            return true;
        }
        return false;
    }
}
