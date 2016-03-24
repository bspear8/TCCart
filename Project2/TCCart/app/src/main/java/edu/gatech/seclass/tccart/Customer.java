package edu.gatech.seclass.tccart;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ddersch on 3/18/16.
 */



public class Customer extends SugarRecord{

    public static final Customer NotPresent = new Customer("","","");

    @Unique
    String customerId;
    String name;
    String email;

    public Customer() {

    }

    public Customer(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("ID: %s Name: %s Email: %s", this.customerId, this.name, this.email);
    }


    public List<CartTransaction> getTransactions() {
        return CartTransaction.find(CartTransaction.class, "customer = ?", this.getId().toString());
    }

    public List<CreditDiscount> getAllCredits() {
        return CreditDiscount.find(CreditDiscount.class, "customer = ?", this.getId().toString());
    }

    public CreditDiscount getActiveCredit() {
        List<CreditDiscount> credits = this.getAllCredits();


        for (CreditDiscount credit : credits) {
            if (credit.isExpired() || credit.getAmountRemaining().equals(new BigDecimal("0.0"))) {
                credit.delete();
            } else {
                return credit;
            }
        }
        return CreditDiscount.NoCreditDiscount;

    }

    public List<VIPDiscount> getAllVIPDiscounts() {
        return VIPDiscount.find(VIPDiscount.class, "customer = ?", this.getId().toString());
    }


    public VIPDiscount getActiveVIP() {
        List<VIPDiscount> discounts = this.getAllVIPDiscounts();


        for (VIPDiscount vip : discounts) {
            if (vip.isExpired()) {
                vip.delete();
            } else if (vip.isCurrent()) {
                return vip;
            }
        }
        return VIPDiscount.NoVIPStatus;
    }
}
