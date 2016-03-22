package edu.gatech.seclass.tccart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

                if(nameText.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Name Cannot Be Blank", Toast.LENGTH_SHORT).show();
                    break;
                }
                if(emailText.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Email Cannot Be Blank", Toast.LENGTH_SHORT).show();
                    break;
                }
                SugarRepository repo = SugarRepository.getInstance();
                Log.v(tag, "Name Text: " + nameText.getText().toString());
                Log.v(tag, "Email Text: " + emailText.getText().toString());

                Customer customer = repo.createCustomer(nameText.getText().toString(), emailText.getText().toString());

                Toast.makeText(getApplicationContext(), "Customer Added", Toast.LENGTH_SHORT).show();

                Intent customerIntent = new Intent(AddCustomerActivity.this, CustomerActivity.class);
                customerIntent.putExtra("customerId", customer.getCustomerId());
                startActivity(customerIntent);
                break;
            case R.id.cancelAddCustomer:
                Intent homeIntent = new Intent(AddCustomerActivity.this, HomeActivity.class);
                Toast.makeText(getApplicationContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                startActivity(homeIntent);
                break;
        }
    }
}
