package com.example.admin.items;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txt_input;
    private EditText txt_unit;

    private RadioButton novat, vat;

    private EditText totalNoVat;
    private EditText justVat;
    private EditText totalWithVat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_input = findViewById(R.id.txt_item);
        txt_unit = findViewById(R.id.txt_pcs);
        novat = findViewById(R.id.novat);
        vat = findViewById(R.id.vat);
        totalNoVat = findViewById(R.id.exclvat);
        justVat = findViewById(R.id.vatonly);
        totalWithVat = findViewById(R.id.withvat);

        totalWithVat.setKeyListener(null);
        justVat.setKeyListener(null);
        totalNoVat.setKeyListener(null);

    }


    //First checkbox
    public static double totalNoVat(double item, double pcs) {
        return (item * pcs);
    }

    public static double exclVatfirst(double item, double pcs) {
        return (item * pcs) * 0.2;
    }

    public static double total(double item, double pcs) {
        return (item * pcs) + ((item * pcs) * 0.2);
    }

    //second
    public static double totalSubVat(double item, double pcs) {
        return (item * pcs) - ((item * pcs) * 0.2);
    }



    public void onClick(View view) {
        if(view.getId() == R.id.clr){
            txt_input.setText("");
            txt_unit.setText("");
            totalNoVat.setText("");
            justVat.setText("");
            totalWithVat.setText("");
        } else if (view.getId() == R.id.ok){
            if(txt_input.getText().length() == 0){
                Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
                return;
                }

            double item = Double.parseDouble(txt_input.getText().toString());
            double units = Double.parseDouble(txt_unit.getText().toString());

            if(novat.isChecked()) {
                totalNoVat.setText(String.valueOf(totalNoVat(item, units)));
                justVat.setText(String.valueOf(exclVatfirst(item, units)));
                totalWithVat.setText(String.valueOf(total(item, units)));
            }
            else {
                totalNoVat.setText(String.valueOf(totalSubVat(item, units)));
                justVat.setText(String.valueOf(exclVatfirst(item, units)));
                totalWithVat.setText(String.valueOf(totalNoVat(item, units)));
            }
        }
    }
}
