package edu.gatech.seclass.tccart;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

        Log.v("CustomerActivity", String.format("customerId from intent: %s", customerId));

        customer = CartManager.getCustomerById(customerId);

        editCustomerIdText.setText(customer.getId());
        editCustomerNameText.setText(customer.getName());
        editCustomerEmailText.setText(customer.getEmail());
    }

    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.updateCustomerButton:
                if(editCustomerIdText.toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "ID cannot be blank", Toast.LENGTH_SHORT).show();
                    break;
                }
                if(editCustomerNameText.toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Name cannot be blank", Toast.LENGTH_SHORT).show();
                    break;
                }
                if(editCustomerEmailText.toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Email cannot be blank", Toast.LENGTH_SHORT).show();
                    break;
                }
                customer = MemoryRepository.getInstance().updateCustomer(
                        customer.getId(),
                        editCustomerNameText.getText().toString(),
                        editCustomerEmailText.getText().toString());

                Toast.makeText(getApplicationContext(), "Customer Updated", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(EditCustomerActivity.this, CustomerActivity.class);
                intent.putExtra("customerId", customer.getId());
                startActivity(intent);
                break;
            case R.id.cancelUpdateCustomer:
                Intent homeIntent = new Intent(EditCustomerActivity.this, HomeActivity.class);
                Toast.makeText(getApplicationContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                startActivity(homeIntent);
                break;
            case R.id.removeCustomerButton:
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:

                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
                break;
        }
    }

    public void onBackPressed() {
        Intent homeIntent = new Intent(EditCustomerActivity.this, HomeActivity.class);
        startActivity(homeIntent);
    }


}
