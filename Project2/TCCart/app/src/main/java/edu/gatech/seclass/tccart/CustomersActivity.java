package edu.gatech.seclass.tccart;

import android.app.LauncherActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CustomersActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private ListView customersListView;
    private List<Customer> customers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);
        customersListView = (ListView)findViewById(R.id.customersListView);
        customers = (ArrayList)CartManager.getAllCustomers();
        ArrayAdapter<Customer> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, customers);
        customersListView.setAdapter(arrayAdapter);
        customersListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent customerIntent = new Intent(CustomersActivity.this, CustomerActivity.class);
        customerIntent.putExtra("customerId", this.customers.get(position).getId());
        startActivity(customerIntent);
    }
}
