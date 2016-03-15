package edu.gatech.seclass.tccart;

import edu.gatech.seclass.services.QRCodeService;

/**
 * Created by ddersch on 3/15/16.
 */
public class CartManager {

    public static final MemoryRepository repository = new MemoryRepository();

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
