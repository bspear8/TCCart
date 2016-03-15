package edu.gatech.seclass.tccart;

import java.util.List;

import edu.gatech.seclass.services.QRCodeService;

/**
 * Created by ddersch on 3/15/16.
 */
public class CartManager {

    public static final MemoryRepository repository = MemoryRepository.getInstance();


    public static List<Customer> getAllCustomers() {
        return repository.getAllCustomers();
    }

    public static Customer getCustomerById(String customerId) {
        return repository.getCustomerById(customerId);
    }

    public static Customer getCustomerFromCard() {
        String customerId = CartManager.scanQRCode();

        Customer customer = repository.getCustomerById(customerId);

        return customer;

    }

    private static String scanQRCode() {

        for (int i = 0; i < 5; ++i) {
            String customerId = QRCodeService.scanQRCode();
            if (!customerId.equals("ERR")) {
                return customerId;
            }
        }

        return null;

    }


}
