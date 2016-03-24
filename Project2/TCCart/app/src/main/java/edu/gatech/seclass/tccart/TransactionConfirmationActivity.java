package edu.gatech.seclass.tccart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

public class TransactionConfirmationActivity extends AppCompatActivity {

    private CartTransaction transaction;
    private Customer customer;


    private TextView customerIdText;
    private TextView dateText;
    private TextView vipDiscountText;
    private TextView creditDiscountText;
    private TextView finalAmountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_confirmation);

        Intent intent = getIntent();
        String customerId = intent.getStringExtra("customerId");
        long transactionId = intent.getLongExtra("transactionId", -1);

        transaction = CartTransaction.findById(CartTransaction.class, transactionId);
        customer = SugarRepository.getInstance().getCustomerById(customerId);

        customerIdText = (TextView)findViewById(R.id.transactionConfirmationCustomerIdText);
        dateText = (TextView)findViewById(R.id.transactionConfirmationDateText);
        vipDiscountText= (TextView)findViewById(R.id.transactionConfirmationVipDiscountText);
        creditDiscountText = (TextView)findViewById(R.id.transactionConfirmationCreditDiscountText);
        finalAmountText =(TextView)findViewById(R.id.transactionConfirmationFinalAmountText);


        customerIdText.setText(customer.getName());
        dateText.setText(transaction.date.toString());


        vipDiscountText.setText(transaction.vipDiscount.toString());
        creditDiscountText.setText(transaction.creditDiscount.toString());

        finalAmountText.setText(transaction.amountBeforeDiscounts.toString());

    }

    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.transactionConfirmationHomeButton:
                Intent intent = new Intent(TransactionConfirmationActivity.this, HomeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
