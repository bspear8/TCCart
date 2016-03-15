package edu.gatech.seclass.tccart;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onButtonClick(View view) {
        Context context = getApplicationContext();
        Toast toast;

        switch (view.getId()) {
            case R.id.scanCustomerCardButton:
                toast = Toast.makeText(context, "Scanning Customer Card", Toast.LENGTH_SHORT);
                toast.show();
                break;
            case R.id.viewAllCustomersButton:
                toast = Toast.makeText(context, "View all customers", Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
    }

}
