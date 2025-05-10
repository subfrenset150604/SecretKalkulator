package com.praktikum.kalkulator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText angka1, angka2;
    ImageView secretImage;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angka1 = findViewById(R.id.Angka1);
        angka2 = findViewById(R.id.Angka2);
        secretImage = findViewById(R.id.secretImage);
        hasil = findViewById(R.id.hasil);

        Button tambah = findViewById(R.id.tambah);
        Button kurang = findViewById(R.id.kurang);
        Button kali = findViewById(R.id.kali);
        Button bagi = findViewById(R.id.bagi);

        tambah.setOnClickListener(v -> calculate('+'));
        kurang.setOnClickListener(v -> calculate('-'));
        kali.setOnClickListener(v -> calculate('*'));
        bagi.setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char operator) {
        String text1 = angka1.getText().toString();
        String text2 = angka2.getText().toString();

        if (text1.isEmpty() || text2.isEmpty()) {
            Toast.makeText(this, "Masukkan angka pertama dan angka kedua", Toast.LENGTH_SHORT).show();
            return;
        }

        double a = Double.parseDouble(text1);
        double b = Double.parseDouble(text2);
        double result = 0;
        String displayText = "";

        switch (operator) {
            case '+':
                result = a + b;
                displayText = " = " + result;
                break;
            case '-':
                result = a - b;
                displayText = " = " + result;
                break;
            case '*':
                result = a * b;
                displayText = " = " + result;
                break;
            case '/':
                if (b != 0) result = a / b;
                else Toast.makeText(this, "Tidak bisa dibagi 0", Toast.LENGTH_SHORT).show();
                displayText = " = " + result;
                break;
        }

        hasil.setText(displayText);

        if (result == 3.0) {
            secretImage.setVisibility(View.VISIBLE);
        } else {
            secretImage.setVisibility(View.GONE);
        }
    }
}