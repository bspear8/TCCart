package edu.gatech.seclass.tccart;

import java.math.BigDecimal;
import java.util.List;

import edu.gatech.seclass.services.QRCodeService;

/**
 * Created by ddersch on 3/15/16.
 */
public class CartManager {

    public static final SugarRepository repository = SugarRepository.getInstance();


    public static List<Customer> getAllCustomers() {
        return repository.getAllCustomers();
    }

    public static Customer getCustomerById(String customerId) {
        return repository.getCustomerById(customerId);
    }


    public static ComputationResult computeTotal(Customer customer, BigDecimal amount) {

        BigDecimal originalAmount = amount;

        BigDecimal creditDiscountAmount = new BigDecimal("0.00");
        BigDecimal vipDiscountAmount = new BigDecimal("0.00");



        VIPDiscount vipDiscount = customer.getActiveVIP();

        if (vipDiscount != VIPDiscount.NoVIPStatus) {
            vipDiscountAmount = vipDiscount.computeSavings(originalAmount);
        }

        BigDecimal amountAfterVIPDiscount = originalAmount.subtract(vipDiscountAmount);

        CreditDiscount creditDiscount = customer.getActiveCredit();

        if (creditDiscount != CreditDiscount.NoCreditDiscount) {
            creditDiscountAmount = creditDiscount.computeSavings(amountAfterVIPDiscount);
        }

        BigDecimal amountAfterCreditDiscount = amountAfterVIPDiscount.subtract(creditDiscountAmount);

        return new ComputationResult(originalAmount, vipDiscountAmount, creditDiscountAmount, amountAfterCreditDiscount);


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
