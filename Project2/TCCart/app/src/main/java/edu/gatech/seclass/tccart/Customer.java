package edu.gatech.seclass.tccart;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by ddersch on 3/18/16.
 */



public class Customer extends SugarRecord{

    public static final Customer NotPresent = new Customer("","","");

    String customerId;
    String name;
    String email;

    public Customer() {

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

    public Customer(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    List<TransactionRecord> getTransactions() {
        return TransactionRecord.find(TransactionRecord.class, "customer = ?", getId().toString());
    }




}
