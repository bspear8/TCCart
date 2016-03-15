package edu.gatech.seclass.tccart;

/**
 * Created by ddersch on 3/15/16.
 */
public class Customer {


    private final String id;
    private String name;
    private String email;

    public static final Customer NotPresent = new Customer("","","");

    public Customer(String id, String name, String email)
    {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("ID: %s Name: %s Email: %s", this.id, this.name, this.email);
    }

    public String getId() {
        return this.id;
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

}

