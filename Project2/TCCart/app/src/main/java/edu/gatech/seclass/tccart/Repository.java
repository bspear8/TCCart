package edu.gatech.seclass.tccart;

import java.util.List;

/**
 * Created by ddersch on 3/15/16.
 */
public interface Repository {

    List<Customer> getAllCustomers();

    Customer createCustomer(String name, String email);

    Customer updateCustomer(String id, String name, String email);

    Customer getCustomerById(String customerId);

    List<Transaction> getCustomerTransactions(String customerId);

    List<Discount> getCustomerDiscounts(String customerId);

    List<Discount> getTransactionDiscounts(String transactionId);

}
