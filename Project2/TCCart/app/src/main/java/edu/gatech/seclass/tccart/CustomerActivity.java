package edu.gatech.seclass.tccart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CustomerActivity extends AppCompatActivity {


    private TextView customerIdTextView;
    private TextView customerNameTextView;
    private TextView customerEmailTextView;
    private Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        customerIdTextView = (TextView)findViewById(R.id.customerIdText);
        customerNameTextView = (TextView)findViewById(R.id.customerNameText);
        customerEmailTextView = (TextView)findViewById(R.id.customerEmailText);

        customer = CartManager.getCustomerFromCard();

        customerIdTextView.setText(customer.getId());
        customerNameTextView.setText(customer.getName());
        customerEmailTextView.setText(customer.getEmail());

    }
}
