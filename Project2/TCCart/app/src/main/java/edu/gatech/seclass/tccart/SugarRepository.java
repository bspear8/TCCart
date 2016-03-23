package edu.gatech.seclass.tccart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ddersch on 3/19/16.
 */
public class SugarRepository implements Repository {

    private static SugarRepository instance = null;

    public static SugarRepository getInstance() {
        if (instance == null) {
            instance = new SugarRepository();
        }
        return instance;
    }

    private void seedCustomers() {
        Customer ralph = this.getCustomerById("7c86ffee");
        if (ralph == Customer.NotPresent) {
            new Customer("7c86ffee", "Ralph Hapschatt", "rh@gmail.com").save();
        }

        Customer betty = this.getCustomerById("b59441af");
        if (betty == Customer.NotPresent) {
            new Customer("b59441af", "Betty Monroe", "bm@gmail.com").save();
        }

        Customer everett = this.getCustomerById("cd0f0e05");
        if (everett == Customer.NotPresent) {
            new Customer("cd0f0e05", "Everett Scott", "ec@gmail.com").save();
        }


    }

    private SugarRepository() {
        seedCustomers();
    }

    @Override
    public List<Customer> getAllCustomers() {

        List<Customer> customers = Customer.listAll(Customer.class);

        List<Customer> customers2 = new ArrayList<>();

        for (Customer customer : customers) {
            customers2.add(customer);
        }

        return customers2;
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


        return builder.toString();
    }

    @Override
    public Customer createCustomer(String name, String email) {
        Customer customer = new Customer(generateUniqueId(), name, email);
        customer.save();
        return customer;
    }

    @Override
    public Customer updateCustomer(String id, String name, String email) {
        Customer customer = this.getCustomerById(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.save();

        return customer;
    }

    @Override
    public Customer getCustomerById(String customerId) {

        List<Customer> customers = Customer.find(Customer.class, "CUSTOMER_ID = ?", customerId);

        if (customers.size() == 1) {
            return customers.get(0);
        }

        return Customer.NotPresent;
    }

    @Override
    public void removeCustomer(String customerId){
        Customer toRemove = getCustomerById(customerId);
        toRemove.delete();
    }

    @Override
    public List<CartTransaction> getCustomerTransactions(String customerId) {
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
