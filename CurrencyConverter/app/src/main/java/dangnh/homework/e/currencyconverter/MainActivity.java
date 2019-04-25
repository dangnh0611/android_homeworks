package dangnh.homework.e.currencyconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnPoint;
    Button btnC;
    Spinner spn1;
    Spinner spn2;
    TextView txt1;
    TextView txt2;
    MyArrayAdapter adapter;
    int cur1 = 0, cur2 = 0;
    //array define 1 currency unit /1 usd
    double[] currency_scale = {1, 23200, 0.8894, 111.1705, 6.7216, 0.7682, 1.008, 8585, 70.0115, 1133.9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnPoint = (Button) findViewById(R.id.btnPoint);
        btnC = (Button) findViewById(R.id.btnC);
        spn1 = (Spinner) findViewById(R.id.spn1);
        spn2 = (Spinner) findViewById(R.id.spn2);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnC.setOnClickListener(this);
        //add items to currency list
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(R.drawable.usd, "USD Đô la Mỹ"));
        items.add(new Item(R.drawable.vnd, "VND Việt Nam đồng"));
        items.add(new Item(R.drawable.eur, "EUR Euro"));
        items.add(new Item(R.drawable.jpy, "JPY Yên Nhật"));
        items.add(new Item(R.drawable.cny, "CNY Nhân dân tệ"));
        items.add(new Item(R.drawable.gbp, "GBP Bảng Anh"));
        items.add(new Item(R.drawable.chf, "CHF Franc Thụy Sĩ"));
        items.add(new Item(R.drawable.lak, "LAK Kíp Lào"));
        items.add(new Item(R.drawable.inr, "INR Rupi Ấn Độ"));
        items.add(new Item(R.drawable.krw, "KRW Won Hàn Quốc"));
        adapter = new MyArrayAdapter(this, items);
        spn1.setAdapter(adapter);
        spn2.setAdapter(adapter);
        spn1.setOnItemSelectedListener(this);
        spn2.setOnItemSelectedListener(this);
        //auto select currency when start application
        spn1.setSelection(0);
        spn2.setSelection(1);
        //Listen to the change of EditText and calculate the result
        txt1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Do nothing
            }

            @Override
            public void afterTextChanged(Editable s) {
                reCalculate();
            }
        });

    }

    @Override
    public void onClick(View v) {
        //Settup onclick listenner for each button
        if (v.getId() == btn0.getId()) {
            if (txt1.getText().toString().equals("0")) ;
            else txt1.append("0");
        } else if (v.getId() == btn1.getId()) {
            if (txt1.getText().toString().equals("0")) txt1.setText("1");
            else txt1.append("1");
        } else if (v.getId() == btn2.getId()) {
            if (txt1.getText().toString().equals("0")) txt1.setText("2");
            else txt1.append("2");
        } else if (v.getId() == btn3.getId()) {
            if (txt1.getText().toString().equals("0")) txt1.setText("3");
            else txt1.append("3");
        } else if (v.getId() == btn4.getId()) {
            if (txt1.getText().toString().equals("0")) txt1.setText("4");
            else txt1.append("4");
        } else if (v.getId() == btn5.getId()) {
            if (txt1.getText().toString().equals("0")) txt1.setText("5");
            else txt1.append("5");
        } else if (v.getId() == btn6.getId()) {
            if (txt1.getText().toString().equals("0")) txt1.setText("6");
            else txt1.append("6");
        } else if (v.getId() == btn7.getId()) {
            if (txt1.getText().toString().equals("0")) txt1.setText("7");
            else txt1.append("7");
        } else if (v.getId() == btn8.getId()) {
            if (txt1.getText().toString().equals("0")) txt1.setText("8");
            else txt1.append("8");
        } else if (v.getId() == btn9.getId()) {
            if (txt1.getText().toString().equals("0")) txt1.setText("9");
            else txt1.append("9");
        } else if (v.getId() == btnPoint.getId()) {
            if (txt1.getText().toString().contains(".")) ;
            else txt1.append(".");
        } else if (v.getId() == btnC.getId()) {
            txt1.setText("0");
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        if (parent.getId() == spn1.getId())
            cur1 = position;
        else if (parent.getId() == spn2.getId())
            cur2 = position;
        reCalculate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Do nothing
    }

    //Calculate result base on type of currencies and value
    public void reCalculate() {
        double f = 0;
        try {
            f = Double.parseDouble(txt1.getText().toString());
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
            return;
        }
        double result = f * currency_scale[cur2] / currency_scale[cur1];
        txt2.setText(String.format("%.2f", result));
    }
}
