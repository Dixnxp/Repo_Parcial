package com.example.calculadorapropinas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText monto;
    EditText personas;
    Button total;
    TextView result;
    RadioGroup radioGroup;
    RadioButton rb5, rb10, rb15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monto = findViewById(R.id.monto);
        personas = findViewById(R.id.personas);
        total = findViewById(R.id.total);
        result = findViewById(R.id.result);
        radioGroup = findViewById(R.id.radioGroup);
        rb5 = findViewById(R.id.rb5);
        rb10 = findViewById(R.id.rb10);
        rb15 = findViewById(R.id.rb15);

        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!monto.getText().toString().isEmpty() && !personas.getText().toString().isEmpty()) {
                    double totalMonto = Double.parseDouble(monto.getText().toString());
                    int totalPersonas = Integer.parseInt(personas.getText().toString());
                    double porcentaje = 0;

                    if (rb5.isChecked()) {
                        porcentaje = 0.05;
                    } else if (rb10.isChecked()) {
                        porcentaje = 0.10;
                    } else if (rb15.isChecked()) {
                        porcentaje = 0.15;
                    }

                    double propinaTotal = totalMonto * porcentaje;
                    double pagoPorPersona = (totalMonto + propinaTotal) / totalPersonas;

                    result.setText(String.format("Cada persona paga: $%.2f", pagoPorPersona));
                } else {
                    result.setText("Ingresa todos los datos");
                }
            }
        });
    }
}
