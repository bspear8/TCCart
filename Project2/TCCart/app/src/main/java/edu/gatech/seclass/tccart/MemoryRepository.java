package edu.gatech.seclass.tccart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ddersch on 3/15/16.
 */
public class MemoryRepository implements Repository {

    List<Customer> customers;


    private static MemoryRepository instance = null;

    public static MemoryRepository getInstance() {
        if (instance == null) {
            instance = new MemoryRepository();
        }
        return instance;
    }

    private void seedCustomers() {
        this.customers = new ArrayList<Customer>();

        customers.add(new Customer("7c86ffee", "Ralph Hapschatt", "rh@gmail.com"));
        customers.add(new Customer("b59441af", "Betty Monroe", "bm@gmail.com"));
        customers.add(new Customer("cd0f0e05", "Everett Scott", "ec@gmail.com"));



    }

    private String generateUniqueId() {
        return "12345678";
    }

    private MemoryRepository() {
        seedCustomers();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customers;
    }

    @Override
    public Customer createCustomer(String name, String email) {

        Customer newCustomer = new Customer(this.generateUniqueId(), name, email);

        customers.add(newCustomer);

        return newCustomer;
    }

    @Override
    public Customer updateCustomer(String id, String name, String email) {
        Customer customer = this.getCustomerById(id);
        customer.setName(name);
        customer.setEmail(email);
        return customer;
    }

    @Override
    public Customer getCustomerById(String customerId) {
        if (customerId == null || customerId == "") {
            return Customer.NotPresent;
        }

        for (Customer customer :  this.customers) {
            if (customer.getId().equals(customerId)) {
                return customer;
            }
        }
        return Customer.NotPresent;
    }

    @Override
    public List<Transaction> getCustomerTransactions(String customerId) {
        return null;
    }

    @Override
    public List<Discount> getCustomerDiscounts(String customerId) {
        return null;
    }

    @Override
    public List<Discount> getTransactionDiscounts(String transactionId) {
        return null;
    }
}
