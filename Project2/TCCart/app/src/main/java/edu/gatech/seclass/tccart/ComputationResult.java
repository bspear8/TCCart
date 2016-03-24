package edu.gatech.seclass.tccart;

import java.math.BigDecimal;

/**
 * Created by ddersch on 3/23/16.
 */
public class ComputationResult {

    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    private BigDecimal originalAmount;

    public BigDecimal getVipDiscountAmount() {
        return vipDiscountAmount;
    }

    public BigDecimal getCreditDiscountAmount() {
        return creditDiscountAmount;
    }

    private BigDecimal vipDiscountAmount;
    private BigDecimal creditDiscountAmount;

    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    private BigDecimal finalAmount;

    public ComputationResult(BigDecimal originalAmount, BigDecimal vipDiscountAmount, BigDecimal creditDiscountAmount, BigDecimal finalAmount) {
        this.originalAmount = originalAmount;
        this.vipDiscountAmount = vipDiscountAmount;
        this.creditDiscountAmount = creditDiscountAmount;
        this.finalAmount = finalAmount;
    }


}
