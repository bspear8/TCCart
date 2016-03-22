package edu.gatech.seclass.tccart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class EditCustomerActivity extends AppCompatActivity {


    private Customer customer;

    private TextView editCustomerIdText;
    private TextView editCustomerNameText;
    private TextView editCustomerEmailText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_customer);

        editCustomerIdText = (TextView)findViewById(R.id.editCustomerId);
        editCustomerNameText = (TextView)findViewById(R.id.editCustomerNameText);
        editCustomerEmailText = (TextView)findViewById(R.id.editCustomerEmailText);

        Intent intent = getIntent();
        String customerId = intent.getStringExtra("customerId");

        Log.v("CustomerActivity", String.format("customerIdentifier from intent: %s", customerId));

        customer = CartManager.getCustomerById(customerId);

        editCustomerIdText.setText(customer.getCustomerId());
        editCustomerNameText.setText(customer.getName());
        editCustomerEmailText.setText(customer.getEmail());


    }

    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.updateCustomerButton:

                customer = SugarRepository.getInstance().updateCustomer(
                        customer.getCustomerId(),
                        editCustomerNameText.getText().toString(),
                        editCustomerEmailText.getText().toString());

                Intent intent = new Intent(EditCustomerActivity.this, CustomerActivity.class);
                intent.putExtra("customerId", customer.getCustomerId());
                startActivity(intent);
                break;
        }
    }
}
