package edu.gatech.seclass.tccart;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;
/**
 * Created by Ben on 3/21/2016.
 */
public class CustomerTest {

    private Customer testCustomer;

    @Before
    public void setUp() throws Exception {
        testCustomer = new Customer("1", "Test Customer", "tc@gmail.com");
    }

    @After
    public void tearDown() throws Exception {
        testCustomer = null;
    }

    @Test
    public void getCustomerIDTest() {
        assertEquals(testCustomer.getCustomerId(), "1");
    }

    @Test
    public void getNameTest() {
        assertEquals(testCustomer.getName(), "Test Customer");
    }

    @Test
    public void getEmailTest() {
        assertEquals(testCustomer.getEmail(), "tc@gmail.com");
    }

    @Test
    public void toStringTest() {
        String tcs = testCustomer.toString();
        assertThat(tcs, CoreMatchers.containsString("1"));
        assertThat(tcs, CoreMatchers.containsString("Test Customer"));
        assertThat(tcs, CoreMatchers.containsString("tc@gmail.com"));
    }

    @Test
    public void setNameTest() {
        String newName = "New Test Customer";
        testCustomer.setName(newName);
        assertEquals(testCustomer.getName(), newName);
    }

    @Test
    public void setEmailTest() {
        String newEmail = "newtc@gmail.com";
        testCustomer.setEmail(newEmail);
        assertEquals(testCustomer.getEmail(), newEmail);
    }

    @Test (expected=NullPointerException.class)
    public void getTransactionsTest() {
        List<TransactionRecord> transactions = testCustomer.getTransactions();
    }
}
