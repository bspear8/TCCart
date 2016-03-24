package edu.gatech.seclass.tccart;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.gatech.seclass.services.QRCodeService;
import edu.gatech.seclass.services.CreditCardService;
import edu.gatech.seclass.services.PaymentService;

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

    public static void processTransaction(Customer customer, CartTransaction transaction, BigDecimal amount, CreditDiscount discount) {


        String ccStr = CreditCardService.readCreditCard();

        if (ccStr.equals("ERR")) {
            throw new ReadCreditCardException();
        }

        CreditCard cardInfo = CreditCard.Parse(ccStr);


        ComputationResult result = CartManager.computeTotal(customer, amount);

        transaction.setAmount(result.getOriginalAmount());
        transaction.setCustomer(customer);
        transaction.setCreditDiscount(result.getCreditDiscountAmount());
        transaction.setVipDiscount(result.getVipDiscountAmount());


        discount.subtractAmountRemaining(result.getCreditDiscountAmount());
        long id = transaction.save();
        discount.save();



        boolean success = false;
        while (!success) {
            success = PaymentService.processPayment(cardInfo.getFirstName(),
                    cardInfo.getLastName(),
                    cardInfo.getCcNumber(),
                    cardInfo.getExpirationDate(),
                    cardInfo.getSecurityCode(),
                    transaction.calculateFinalAmount().doubleValue());
        }

        if (discount.isOut()) {
            discount.delete();
        }

        int comparison = result.getFinalAmount().compareTo(new BigDecimal("30.0"));
        if (comparison >= 0) {

            addNewCreditDiscountToCustomer(customer);

        }
    }

    public static void addNewCreditDiscountToCustomer(Customer customer) {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH);
        cal.add(Calendar.MONTH, month + 1);
        CreditDiscount newDiscount = new CreditDiscount(cal.getTime());
        newDiscount.setCustomer(customer);
        newDiscount.save();
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
