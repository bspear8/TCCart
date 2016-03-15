package edu.gatech.seclass.tccart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddCustomerActivity extends AppCompatActivity {


    private TextView nameText;
    private TextView emailText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        nameText = (TextView)findViewById(R.id.addCustomerNameText);
        emailText = (TextView)findViewById(R.id.addCustomerEmailText);


    }

    public void onCustomerButtonClick(View view) {
        switch (view.getId()) {
            case R.id.addCustomerButton:
                String tag = "AddCustomerActivity";

                MemoryRepository repo = MemoryRepository.getInstance();
                Log.v(tag, "Name Text: " + nameText.getText().toString());
                Log.v(tag, "Email Text: " + emailText.getText().toString());

                Customer customer = repo.createCustomer(nameText.getText().toString(), emailText.getText().toString());

                Intent customerIntent = new Intent(AddCustomerActivity.this, CustomerActivity.class);
                customerIntent.putExtra("customerId", customer.getId());
                startActivity(customerIntent);
                break;
        }
    }
}
