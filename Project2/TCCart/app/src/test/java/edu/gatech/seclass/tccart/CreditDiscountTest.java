package edu.gatech.seclass.tccart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import static org.junit.Assert.*;
/**
 * Created by Ben on 3/21/2016.
 */
public class CreditDiscountTest {

    private CreditDiscount testDiscount;

    @Before
    public void setUp() {
        Date date = new Date();
        testDiscount = new CreditDiscount(date);
    }

    @After
    public void tearDown() {
        testDiscount = null;
    }

    @Test
    public void getAmountRemainingTest() {
        assertEquals(testDiscount.getAmountRemaining().doubleValue(), 3, 0.001);
    }

    @Test
    public void initialValueTest() {
        BigDecimal ini_val = new BigDecimal("10.00");
        double savings = testDiscount.computeSavings(ini_val).doubleValue();
        assertEquals(7.00, savings, 0.001);
    }

    @Test
    public void lessThanValueTest() {
        BigDecimal ini_val = new BigDecimal("2.00");
        double savings = testDiscount.computeSavings(ini_val).doubleValue();
        double remaining = testDiscount.getAmountRemaining().doubleValue();
        assertEquals(0.00, savings, 0.001);
        assertEquals(1.00, remaining, 0.001);
    }
}
