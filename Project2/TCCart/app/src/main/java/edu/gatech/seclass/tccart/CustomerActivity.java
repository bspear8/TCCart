package edu.gatech.seclass.tccart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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


        Intent intent = getIntent();
        String customerId = intent.getStringExtra("customerId");

        Log.v("CustomerActivity", String.format("customerId from intent: %s", customerId));

        if (customerId == null) {
            customer = CartManager.getCustomerFromCard();
        } else {
            customer = CartManager.getCustomerById(customerId);
        }

        customerIdTextView.setText(customer.getId());
        customerNameTextView.setText(customer.getName());
        customerEmailTextView.setText(customer.getEmail());
    }


    public void onButtonClick(View view) {

            switch (view.getId()) {
                case R.id.editCustomerButton:
                    Intent customerIntent = new Intent(CustomerActivity.this, EditCustomerActivity.class);
                    customerIntent.putExtra("customerId", customer.getId());
                    startActivity(customerIntent);
                    break;
            }
    }
}
