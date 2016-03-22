package edu.gatech.seclass.tccart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

public class NewTransactionIntent extends AppCompatActivity {

    private Customer customer;
    private Transaction transaction;

    private TextView newTransactionCustomerIdText;
    private TextView newTransactionAmountText;
    private TextView newTransactionCreditDiscountText;
    private TextView newTransactionVipDiscountText;
    private TextView newTransactionTotalText;

    private void updateFields() {
        BigDecimal amount = new BigDecimal("0.00");
        BigDecimal creditDiscount = new BigDecimal("0.00");
        BigDecimal vipDiscount = new BigDecimal("0.00");

        String textAmount = newTransactionAmountText.getText().toString();
        Log.v("Text Amount: ", textAmount);

        if (!textAmount.equals("")) {
            try {
                amount = new BigDecimal(textAmount);
                Log.v("Tag", amount.toString());
            } catch (Exception e) {
                return;
            }
        } else {
            newTransactionVipDiscountText.setText("");

            newTransactionCreditDiscountText.setText("");

            newTransactionTotalText.setText("");
        }

//
//        if (customer.hasCreditDiscount()) {
//
//        }
//
//        if (customer.hasActiveVipStatus()) {
//
//        }
//
//        newTransactionAmountText.setText(amount.toString());
//
        newTransactionVipDiscountText.setText(vipDiscount.toString());
//
        newTransactionCreditDiscountText.setText(creditDiscount.toString());
//
        newTransactionTotalText.setText(amount.subtract(creditDiscount).subtract(vipDiscount).toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_transaction_intent);

        Intent intent = getIntent();
        String customerId = intent.getStringExtra("customerIdentifier");

        customer = SugarRepository.getInstance().getCustomerById(customerId);
        transaction = new Transaction();

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



                break;
        }
    }
}
