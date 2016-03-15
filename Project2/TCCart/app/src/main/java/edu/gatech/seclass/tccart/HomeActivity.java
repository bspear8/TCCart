package edu.gatech.seclass.tccart;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.scanCustomerCardButton:
                Intent customerIntent = new Intent(HomeActivity.this, CustomerActivity.class);
                startActivity(customerIntent);
                break;
            case R.id.viewAllCustomersButton:
                Intent customersIntent = new Intent(HomeActivity.this, CustomersActivity.class);
                startActivity(customersIntent);
                break;
            case R.id.addHomeCustomerButton:
                Log.v("HomeActivity", "Add Customer Button Clicked...");
                Intent addCustomerIntent = new Intent(HomeActivity.this, AddCustomerActivity.class);
                startActivity(addCustomerIntent);
                break;
        }
    }

}
