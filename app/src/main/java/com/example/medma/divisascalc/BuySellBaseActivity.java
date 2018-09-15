package com.example.medma.divisascalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuySellBaseActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_TRANSACTION_TYPE = "EXTRA_TRANSACTION_TYPE";
    protected EditText etInputFirst;
    protected EditText etInputSecond;
    protected TextView title;
    private int mTransactionType = TransactionType.BUY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_sell);

        title = findViewById(R.id.our_rate_is);
        etInputFirst = findViewById(R.id.et_input_first);
        etInputSecond = findViewById(R.id.et_input_second);
        findViewById(R.id.btn_calculate).setOnClickListener(this);

        Intent intent = getIntent();
        mTransactionType = intent.getIntExtra(EXTRA_TRANSACTION_TYPE, TransactionType.BUY);
        title.setText(mTransactionType == TransactionType.BUY ? "Vendemos dolares" : "Compramos dolares");
    }

    @Override
    public void onClick(View v) {
        double input = Double.parseDouble(etInputFirst.getText().toString());
        try {
            computeExchangeRate(input);
        } catch (InvalidCurrencyException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    protected void computeExchangeRate(double value) throws InvalidCurrencyException {
        Currency usd = new Currency("USD", value);
        double rate = mTransactionType == TransactionType.BUY ? 50 : 49;
        ExchangeRate exRate = new ExchangeRate("USD", "DOP", rate);
        Currency dop = CurrencyCalculator.computeExchange(usd, exRate);

        UpdateUI(Double.toString(dop.getAmount()));
    }

    private void UpdateUI(String output) {
        etInputSecond.setText(output);
    }

    public class TransactionType {
        public static final int BUY = 100;
        public static final int SELL = 200;
    }
}
