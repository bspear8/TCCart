package edu.gatech.seclass.tccart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomerTransactionsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView transactionsListView;
    private Customer customer;
    private ArrayList<CartTransaction> transactions;
    private TextView customerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_transactions);
        Intent intent = getIntent();
        String customerId = intent.getStringExtra("customerId");
        customer = SugarRepository.getInstance().getCustomerById(customerId);
        transactions = (ArrayList)customer.getTransactions();


        transactionsListView = (ListView)findViewById(R.id.customerTransactionsListView);
        customerText = (TextView)findViewById(R.id.customerTransactionsCustomerText);

        ArrayAdapter<CartTransaction> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, transactions);
        customerText.setText(customer.getName());
        transactionsListView.setAdapter(arrayAdapter);
        transactionsListView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
