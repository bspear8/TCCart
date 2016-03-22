package edu.gatech.seclass.tccart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ddersch on 3/15/16.
 */
public class MemoryRepository implements Repository {

    ArrayList<Customer> customers;


    private static MemoryRepository instance = null;

    public static MemoryRepository getInstance() {
        if (instance == null) {
            instance = new MemoryRepository();
        }
        return instance;
    }

    private void seedCustomers() {
        this.customers = new ArrayList<Customer>();
        //customers.add(new Customer("7c86ffee", "Ralph Hapschatt", "rh@gmail.com"));
        //customers.add(new Customer("b59441af", "Betty Monroe", "bm@gmail.com"));
        //customers.add(new Customer("cd0f0e05", "Everett Scott", "ec@gmail.com"));
    }

    static final String AB = "0123456789abcdef";
    static Random rand = new Random();
    private String generateUniqueId() {

        StringBuilder builder = null;

        do {
            builder = new StringBuilder(8);
            for (int i = 0; i < 8; ++i) {
                builder.append(AB.charAt(rand.nextInt(AB.length())));
            }
        } while (!(this.getCustomerById(builder.toString()).equals(Customer.NotPresent)));

        System.out.println(builder.toString());
        return builder.toString();
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
