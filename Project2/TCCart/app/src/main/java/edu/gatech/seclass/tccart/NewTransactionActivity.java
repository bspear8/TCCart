package edu.gatech.seclass.tccart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class NewTransactionActivity extends AppCompatActivity {

    private Customer customer;
    private CartTransaction transaction;
    private CreditDiscount discount;

    private TextView newTransactionCustomerIdText;
    private TextView newTransactionAmountText;
    private TextView newTransactionCreditDiscountText;
    private TextView newTransactionVipDiscountText;
    private TextView newTransactionTotalText;

    private void updateFields() {
        BigDecimal amount = new BigDecimal("0.00");
        BigDecimal creditDiscountAmount = new BigDecimal("0.00");
        BigDecimal vipDiscount = new BigDecimal("0.00");
        BigDecimal finalAmount = new BigDecimal("0.00");

        String textAmount = newTransactionAmountText.getText().toString();
        Log.v("Text Amount: ", textAmount);

        if (!textAmount.equals("")) {
            try {
                amount = new BigDecimal(textAmount);
                ComputationResult result = CartManager.computeTotal(customer, amount);

                creditDiscountAmount = result.getCreditDiscountAmount();
                vipDiscount = result.getVipDiscountAmount();
                finalAmount = result.getFinalAmount();


            } catch (Exception e) {
                return;
            }
        } else {
            newTransactionVipDiscountText.setText("");
            newTransactionCreditDiscountText.setText("");
            newTransactionTotalText.setText("");
        }


        newTransactionVipDiscountText.setText(vipDiscount.toString());
        newTransactionCreditDiscountText.setText(creditDiscountAmount.toString());
        newTransactionTotalText.setText(finalAmount.toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_transaction);

        Intent intent = getIntent();
        String customerId = intent.getStringExtra("customerId");

        customer = SugarRepository.getInstance().getCustomerById(customerId);
        transaction = new CartTransaction();

        discount = customer.getActiveCredit();

        Log.v("CustomerActivity", String.format("customerIdentifier from intent: %s", customerId));

        newTransactionCreditDiscountText = (TextView)findViewById(R.id.newTransactionCreditDiscountText);
        newTransactionVipDiscountText = (TextView)findViewById(R.id.newTransactionVipDiscountText);
        newTransactionAmountText = (TextView)findViewById(R.id.newTransactionAmountText);
        newTransactionCustomerIdText = (TextView)findViewById(R.id.newTransactionCustomerIdText);
        newTransactionTotalText = (TextView)findViewById(R.id.newTransactionTotalText);

        newTransactionCustomerIdText.setText(customer.getName());

        newTransactionAmountText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateFields();
            }
        });

    }


    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.processPaymentButton:

                BigDecimal amount = new BigDecimal("0.0");
                try {
                    amount = new BigDecimal(newTransactionAmountText.getText().toString());
                } catch (Exception e) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Error reading dollar amount. Please try again.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                try {
                    CartManager.processTransaction(customer, transaction, amount, discount);
                } catch (ReadCreditCardException e) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Error reading credit card. Please try again.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                Intent intent = new Intent(NewTransactionActivity.this, TransactionConfirmationActivity.class);
                intent.putExtra("customerId", customer.getCustomerId());
                intent.putExtra("transactionId", transaction.getId());
                startActivity(intent);


                break;
        }
    }
}
