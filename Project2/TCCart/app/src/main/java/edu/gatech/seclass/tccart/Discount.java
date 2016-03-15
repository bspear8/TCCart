package edu.gatech.seclass.tccart;

import java.math.BigDecimal;

/**
 * Created by ddersch on 3/15/16.
 */
public interface Discount {
    BigDecimal computeSavings (BigDecimal amount);
}
