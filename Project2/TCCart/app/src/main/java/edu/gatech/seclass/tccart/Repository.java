package edu.gatech.seclass.tccart;

import java.util.List;

/**
 * Created by ddersch on 3/15/16.
 */
public interface Repository {

    Customer getCustomerByID(String id);

    List<Transaction> getCustomerTransaction(String id);

    

}
