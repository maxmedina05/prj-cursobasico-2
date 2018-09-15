package com.example.medma.divisascalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_buy).setOnClickListener(this);
        findViewById(R.id.btn_sell).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_buy:
                goToActivity(BuyActivity.class, BuySellBaseActivity.TransactionType.BUY);
                break;
            case R.id.btn_sell:
                goToActivity(SellActivity.class, BuySellBaseActivity.TransactionType.SELL);
                break;
        }
    }

    private void goToActivity(Class activity, int type) {
        Intent intent = new Intent(this, BuySellBaseActivity.class);
        intent.putExtra(BuySellBaseActivity.EXTRA_TRANSACTION_TYPE, type);
        startActivity(intent);
    }
}
